package org.test.shop.controller.data.types;

import java.io.Serializable;

public class DocumentViewerRequest implements Serializable {

	private static final long serialVersionUID = 340109250424391293L;
	private Integer documentId;
	private Integer requestServHotelId;

	public DocumentViewerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentViewerRequest(Integer documentId, Integer requestServHotelId) {
		super();
		this.documentId = documentId;
		this.requestServHotelId = requestServHotelId;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public Integer getRequestServHotelId() {
		return requestServHotelId;
	}

	public void setRequestServHotelId(Integer requestServHotelId) {
		this.requestServHotelId = requestServHotelId;
	}

}
