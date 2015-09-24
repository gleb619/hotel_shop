<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="main-layout">
	<tabset justified="true" class="tabbox">
		 <tab class="tab">
	    	<tab-heading>
	        	<spring:message code="label.ReqServHotel" />
	      	</tab-heading>
	      	<!-- 
	    	<div ng-if="templates.reqservhotel.list.init" ng-controller="ReqServHotelListCtrl" class="tab-body">
	    		<div ng-include="templates.reqservhotel.list.url"></div>
	    	</div>
	    	 -->
	    	<div ng-controller="ReqServHotelListCtrl" class="tab-body">
	    		<%@ include file="../list/ReqservhotelList.jsp"%>
	    	</div>
	    	
	    </tab>
	
	    <tab select="initTab('servhotel', 'list')" class="tab">
	    	<tab-heading>
	        	<spring:message code="label.ServHotel" />
	      	</tab-heading>
	      	<%-- 
	    	<div ng-controller="ServHotelListCtrl" class="tab-body">
	    		<%@ include file="../list/ServhotelList.jsp"%>
	    	</div>
	    	 --%>
	    	<div ng-if="templates.servhotel.list.init" ng-controller="ServHotelListCtrl" class="tab-body">
	    		<div ng-include="templates.servhotel.list.url" onload="clearLoading('servhotel')"></div>
	    	</div>
	    	<div ng-if="templates.servhotel.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
	    </tab>
	    <tab select="initTab('servhotelroom', 'list')" class="tab">
	    	<tab-heading><spring:message code="label.ServHotelRoom" /></tab-heading>
	    	<div ng-if="templates.servhotelroom.list.init" ng-controller="ServHotelRoomListCtrl" class="tab-body">
	    		<div ng-include="templates.servhotelroom.list.url" onload="templates.servhotelroom.list.loading = !templates.servhotelroom.list.loading"></div>
	    	</div>
	    	<div ng-if="templates.servhotelroom.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
	    </tab>
	    <tab select="initTab('servtransfer', 'list')" class="tab">
	    	<tab-heading>
	        	<spring:message code="label.ServTransfer" />
	      	</tab-heading>
	      	
	      	<div ng-if="templates.servtransfer.list.init" ng-controller="ServTransferListCtrl" class="tab-body">
	    		<div ng-include="templates.servtransfer.list.url" onload="templates.servtransfer.list.loading = !templates.servtransfer.list.loading"></div>
	    	</div>
	    	<div ng-if="templates.servtransfer.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
	    </tab>
	   
	    
	</tabset>
</div>