package org.test.shop.controller.data.types;

import java.io.Serializable;

public class ImageRequest implements Serializable {

	private static final long serialVersionUID = 6820185191740482407L;
	
	private String id;
	private String extension;
	private String path;
	private Integer h;
	private Integer w;
	private Integer size;
	private Integer scale;
	private Integer mw;
	private Integer thumbnail;

	public ImageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getH() {
		return h;
	}

	public void setH(Integer h) {
		this.h = h;
	}

	public Integer getW() {
		return w;
	}

	public void setW(Integer w) {
		this.w = w;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public Integer getMw() {
		return mw;
	}

	public void setMw(Integer mw) {
		this.mw = mw;
	}

	public Integer getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Integer thumbnail) {
		this.thumbnail = thumbnail;
	}

}
