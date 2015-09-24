<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="main-layout">
	<tabset justified="true" class="tabset">
		<tab class="tab">
			<tab-heading>
				<spring:message code="label.TmOrder" />
			</tab-heading>
			
			<div ng-controller="TmOrderListCtrl" class="tab-body">
				<jsp:include page="../list/TmorderList.jsp"/>
			</div>
		</tab>
		<tab select="initTab('tmcontact', 'list')" class="tab">
			<tab-heading><spring:message code="label.TmContact" /></tab-heading>
			<div ng-if="templates.tmcontact.list.init" ng-controller="TmContactListCtrl" class="tab-body">
				<div ng-include="templates.tmcontact.list.url" onload="templates.tmcontact.list.loading = !templates.tmcontact.list.loading"></div>
			</div>
			<div ng-if="templates.tmcontact.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('tmaccount', 'list')" class="tab">
			<tab-heading><spring:message code="label.TmAccount" /></tab-heading>
			<div ng-if="templates.tmaccount.list.init" ng-controller="TmAccountListCtrl" class="tab-body">
				<div ng-include="templates.tmaccount.list.url" onload="templates.tmaccount.list.loading = !templates.tmaccount.list.loading"></div>
			</div>
			<div ng-if="templates.tmaccount.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servtour', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServTour" /></tab-heading>
			<div ng-if="templates.servtour.list.init" ng-controller="ServTourListCtrl" class="tab-body">
				<div ng-include="templates.servtour.list.url" onload="templates.servtour.list.loading = !templates.servtour.list.loading"></div>
			</div>
			<div ng-if="templates.servtour.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab class="tab">
			<tab-heading>
				<spring:message code="default.standart_payment" />
			</tab-heading>
			
			<div class="tab-body">
				<jsp:include page="../_sys/standart_payment.jsp"/>
			</div>
		</tab>
		<tab class="tab">
			<tab-heading>
				<spring:message code="default.standart_services" />
			</tab-heading>
			
			<div class="tab-body">
				<jsp:include page="../_sys/standart_services.jsp"/>
			</div>
		</tab>
		<tab select="initTab('tmincidents', 'list')" class="tab">
			<tab-heading><spring:message code="label.TmIncidents" /></tab-heading>
			<div ng-if="templates.tmincidents.list.init" ng-controller="TmIncidentsListCtrl" class="tab-body">
				<div ng-include="templates.tmincidents.list.url" onload="templates.tmincidents.list.loading = !templates.tmincidents.list.loading"></div>
			</div>
			<div ng-if="templates.tmincidents.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('docdocuments', 'list')" class="tab">
			<tab-heading><spring:message code="label.DocDocuments" /></tab-heading>
			<div ng-if="templates.docdocuments.list.init" ng-controller="DocDocumentsListCtrl" class="tab-body">
				<div ng-include="templates.docdocuments.list.url" onload="templates.docdocuments.list.loading = !templates.docdocuments.list.loading"></div>
			</div>
			<div ng-if="templates.docdocuments.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
	</tabset>
</div>