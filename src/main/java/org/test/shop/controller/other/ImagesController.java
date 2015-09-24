/*
 * 
 */
package org.test.shop.controller.other;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.collections.set.CompositeSet.SetMutator;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.test.shop.controller.data.types.ImageRequest;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.util.SObjectListner;
import org.test.shop.util.data.types.FilesSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class ImagesController.
 */
@Controller
public class ImagesController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5863527129201614208L;

	/** The image settings. */
	@Autowired
	private FilesSettings imageSettings;
	
	/** The image service. */
//	@Autowired
//	private TmImageService imageService;  
	
	/** The servlet context. */
	@Autowired
	private ServletContext servletContext;
	
	/** The s object listner. */
	@Autowired
	private SObjectListner sObjectListner;
	
	/** The debug. */
	private Boolean debug = false;
	
	
//	, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif"
	/**
 * Load image.
 *
 * @param id the id
 * @param extension the extension
 * @param path the path
 * @param height the height
 * @param width the width
 * @param size the size
 * @return the buffered image
 */
@RequestMapping(value = "/images/{id}.{extension}"
			, method = RequestMethod.GET
			, produces = { "image/jpeg", "image/jpg", "image/png", "image/gif" }
//			, produces = "image/png"
//			, produces = MediaType.ALL_VALUE
	)
	@ResponseBody
	public BufferedImage loadImage(
			  @PathVariable String id
			, @PathVariable String extension
			, ImageRequest imageRequest 
			
//			, @RequestParam(value = "path", required = false) String path
//			, @RequestParam(value = "height", required = false) Integer height
//			, @RequestParam(value = "width", required = false) Integer width
//			, @RequestParam(value = "size", required = false) Integer size
//			, @RequestParam(value = "scale", required = false) Integer scale
			) {
		
		BufferedImage image = null;
		
		if (id.startsWith("static_")) {
			String name = (id + "." + extension).replaceAll("static_", "");
			image = staticImage(name, imageRequest);
		}
		else {
			try {
				image = realImage(id, extension, imageRequest);
				
			} catch (IOException e) {
				System.err.println("ImagesController.staticImage()#ERROR: " + e.getMessage());
				return notFound();
			}
		}

		return image;
	}

	/**
	 * Static image.
	 *
	 * @param name the name
	 * @return the buffered image
	 */
	private BufferedImage staticImage(String name, ImageRequest imageRequest) {
		BufferedImage image = null;
		
		try {
			String imageFileName = "/resources/images/" + name;
			InputStream imageFile = servletContext.getResourceAsStream(imageFileName);
			image = ImageIO.read(imageFile);
			
			if (imageRequest.getThumbnail() != null) {
				if (imageRequest.getThumbnail() == 1) {
					imageRequest.setMw(150);
				}
				else if (imageRequest.getThumbnail() == 2) {
					imageRequest.setMw(300);
				}
				else if (imageRequest.getThumbnail() == 3) {
					imageRequest.setMw(300);
				}
			}
			
			if (imageRequest.getMw() != null) {
				if (image.getWidth() < imageRequest.getMw()) {
					image = Scalr.resize(image, imageRequest.getMw());
				}
				if(imageRequest.getThumbnail() != null){
					image = Scalr.resize(image, imageRequest.getMw());
				}
			}
			
			if (imageRequest.getScale() != null) {
				Integer currentWidth = image.getWidth();
				Integer currentHeight = image.getHeight();
				
				image = Scalr.resize(image, Scalr.Method.BALANCED, currentWidth * imageRequest.getScale(), currentHeight * imageRequest.getScale());
			}
			
//					loadPng(imageFile); 
			
		} catch (IOException e) {
			System.err.println("ImagesController.staticImage()#ERROR: " + e.getMessage());
		}
		
		return image;
	}

	/**
	 * Real image.
	 *
	 * @param id the id
	 * @param extension the extension
	 * @param path the path
	 * @param height the height
	 * @param width the width
	 * @param size the size
	 * @return the buffered image
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
//	private BufferedImage realImage(String id, String extension, String path,
//			Integer height, Integer width, Integer size, Integer scale) throws IOException {
	private BufferedImage realImage(String id, String extension, ImageRequest imageRequest) throws IOException {
		BufferedImage image;
		if (imageRequest.getPath() == null) {
			imageRequest.setPath(imageSettings.getImageDefaultPath());
		}
		
		File imageFile = new File(imageRequest.getPath() + "/" + id + "." + extension);
		if (debug) {
			System.out.println(
					"id: " + id +
					", extension: " + extension +
					", path: " + imageFile.getAbsolutePath()
			);
		}
		
		try {
			image = ImageIO.read(imageFile);
		} catch (IIOException e) {
			System.err.println("ERROR: " + " file: " + imageFile.getAbsolutePath() + ", " + e.getLocalizedMessage());
			image = notFound();
		}
		
		if (imageRequest.getThumbnail() != null) {
			if (imageRequest.getThumbnail() == 1) {
				imageRequest.setMw(150);
			}
			else if (imageRequest.getThumbnail() == 2) {
				imageRequest.setMw(300);
			}
			else if (imageRequest.getThumbnail() == 3) {
				imageRequest.setMw(500);
			}
		}
		
		if (imageRequest.getMw() != null) {
			if (image.getWidth() < imageRequest.getMw()) {
				image = Scalr.resize(image, imageRequest.getMw());
			}
			if(imageRequest.getThumbnail() != null){
				image = Scalr.resize(image, imageRequest.getMw());
			}
		}
		
		if (imageRequest.getScale() != null) {
			Integer currentWidth = image.getWidth();
			Integer currentHeight = image.getHeight();
			
			image = Scalr.resize(image, Scalr.Method.BALANCED, currentWidth * imageRequest.getScale(), currentHeight * imageRequest.getScale());
		}
		
		if (imageRequest.getSize() != null) {
			imageRequest.setH(imageRequest.getSize());
			imageRequest.setW(imageRequest.getSize());
		}
		
		if (imageRequest.getH() != null && imageRequest.getW() != null) {
			image = Scalr.resize(image, Scalr.Method.BALANCED, imageRequest.getW(), imageRequest.getH());
		}
		
		return image;
	}
	
	
	
	/**
	 * Load png.
	 *
	 * @param imageFile the image file
	 * @return the buffered image
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unused")
	private BufferedImage loadPng(File imageFile) throws IOException {
		BufferedImage in = ImageIO.read(imageFile);
		BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(in, 0, 0, null);
		g.dispose();
		
		return newImage;
	}
	
	/**
	 * Load png.
	 *
	 * @param imageFile the image file
	 * @return the buffered image
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private BufferedImage loadPng(InputStream imageFile) throws IOException {
		BufferedImage in = ImageIO.read(imageFile);
		BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(in, 0, 0, null);
		g.dispose();
		
		return newImage;
	}
	
	/**
	 * Not found.
	 *
	 * @return the buffered image
	 */
	@RequestMapping(value = "/images/" , produces = "image/jpg" , method = RequestMethod.GET)
	@ResponseBody
	public BufferedImage notFound() {
		return staticImage("wait.jpg", new ImageRequest());
	}

}
