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
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.util.SObjectListner;
import org.test.shop.util.data.types.FilesSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class DocumentsController.
 */
@Controller
public class DocumentsController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5863527129201614208L;

	/** The files settings. */
	@Autowired
	private FilesSettings filesSettings;
	
	
	/** The servlet context. */
	@Autowired
	private ServletContext servletContext;
	
	/** The s object listner. */
	@Autowired
	private SObjectListner sObjectListner;
	
	/** The debug. */
	private Boolean debug = false;
	
	/*
	@RequestMapping(value = "/documents/{id}.{extension}" , method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	@ResponseBody
	public BufferedImage loadImage(
			  @PathVariable String id
			, @PathVariable String extension
			, @RequestParam(value = "path", required = false) String path
			, @RequestParam(value = "height", required = false) Integer height
			, @RequestParam(value = "width", required = false) Integer width
			, @RequestParam(value = "size", required = false) Integer size
			) {
		
		BufferedImage image = null;
		
		try {
			if (path == null) {
				path = documentsettings.getDefaultPath();
			}
			
			File imageFile = new File(path + "/" + id + "." + extension);
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
			
			if (size != null) {
				height = size;
				width = size;
			}
			
			if (height != null && width != null) {
				image = Scalr.resize(image, Scalr.Method.BALANCED, width, height);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
	
	@SuppressWarnings("unused")
	private BufferedImage loadPng(File imageFile) throws IOException {
		BufferedImage in = ImageIO.read(imageFile);
		BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(in, 0, 0, null);
		g.dispose();
		
		return newImage;
	}
	
	private BufferedImage loadPng(InputStream imageFile) throws IOException {
		BufferedImage in = ImageIO.read(imageFile);
		BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(in, 0, 0, null);
		g.dispose();
		
		return newImage;
	}
	
	@RequestMapping(value = "/documents/"
			, produces = { "image/jpeg", "image/jpg", "image/png", "image/gif" }
			, method = RequestMethod.GET)
	@ResponseBody
	public BufferedImage notFound() {
		try {
//			String imageFileName = "/resources/documents/wait.png";
			String imageFileName = "/resources/documents/wait2.png";
			InputStream imageFile = servletContext.getResourceAsStream(imageFileName);
			BufferedImage image = loadPng(imageFile); 
//			BufferedImage image = ImageIO.read(imageFile); 
			
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	 */
	/**
	 * Upload image.
	 *
	 * @param file the file
	 * @param principal the principal
	 * @return the map< string,? extends object>
	 */
	@RequestMapping(value = "/document/upload", method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> uploadImage(@RequestParam("file") CommonsMultipartFile file
			, Principal principal) {
		
		SasUser sasUser = JsonOutput.readSasUser(principal);
		
		if (!file.isEmpty()) {
			if (debug) {
				System.out.println(
						"file: " + file + 
						", name: " + file.getName() +
						", contentType: " + file.getContentType() +
						", originalFilename: " + file.getOriginalFilename() +
						", extension: " + FilenameUtils.getExtension(file.getOriginalFilename()) +
						", size: " + file.getSize() +
						", defaultpath: " + filesSettings.getDocumentsDefaultPath()
				);
			}

			try {
				byte[] bytes = file.getBytes();
				
				
				return JsonOutput.mapSuccess();
			} catch (Exception e) {
				return JsonOutput.mapError( "Failed to upload " + file.getOriginalFilename() + " => " + e.getMessage() );
			}
		} else {
			return JsonOutput.mapError( "You failed to upload " + file.getOriginalFilename() + " because the file was empty." );
		}
	}
	

}
