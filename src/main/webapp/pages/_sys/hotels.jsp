<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>    

<div>
     
   <tabset justified="true">
	    <tab>
	    	<tab-heading>
	        	<spring:message code="label.ServHotel" />
	      	</tab-heading>
	      	
	    	<div ng-controller="ServHotelListCtrl">
	    		<%@ include file="../list/ServhotelList.jsp"%>
	    	</div>
	    </tab>
	    <tab>
	    	<tab-heading>
	        	<spring:message code="label.ServTransfer" />
	      	</tab-heading>
	      	
	    	<div ng-controller="ServTransferListCtrl">
	    		<%@ include file="../list/ServtransferList.jsp"%>
	    	</div>
	    </tab>
    	
  </tabset>
     
</div>