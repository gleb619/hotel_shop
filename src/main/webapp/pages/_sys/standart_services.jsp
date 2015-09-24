<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="main-layout">
	<tabset justified="true" class="tabset">
		<tab class="tab">
			<tab-heading>
				<spring:message code="label.ServInsurances" />
			</tab-heading>
			
			<div ng-controller="ServInsurancesListCtrl" class="tab-body">
				<jsp:include page="../list/ServinsurancesList.jsp"/>
			</div>
		</tab>
		<tab select="initTab('servhotel', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServHotel" /></tab-heading>
			<div ng-if="templates.servhotel.list.init" ng-controller="ServHotelListCtrl" class="tab-body">
				<div ng-include="templates.servhotel.list.url" onload="templates.servhotel.list.loading = !templates.servhotel.list.loading"></div>
			</div>
			<div ng-if="templates.servhotel.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servvisas', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServVisas" /></tab-heading>
			<div ng-if="templates.servvisas.list.init" ng-controller="ServVisasListCtrl" class="tab-body">
				<div ng-include="templates.servvisas.list.url" onload="templates.servvisas.list.loading = !templates.servvisas.list.loading"></div>
			</div>
			<div ng-if="templates.servvisas.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servexcursions', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServExcursions" /></tab-heading>
			<div ng-if="templates.servexcursions.list.init" ng-controller="ServExcursionsListCtrl" class="tab-body">
				<div ng-include="templates.servexcursions.list.url" onload="templates.servexcursions.list.loading = !templates.servexcursions.list.loading"></div>
			</div>
			<div ng-if="templates.servexcursions.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servtransfer', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServTransfer" /></tab-heading>
			<div ng-if="templates.servtransfer.list.init" ng-controller="ServTransferListCtrl" class="tab-body">
				<div ng-include="templates.servtransfer.list.url" onload="templates.servtransfer.list.loading = !templates.servtransfer.list.loading"></div>
			</div>
			<div ng-if="templates.servtransfer.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servticketsrail', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServTicketsRail" /></tab-heading>
			<div ng-if="templates.servticketsrail.list.init" ng-controller="ServTicketsRailListCtrl" class="tab-body">
				<div ng-include="templates.servticketsrail.list.url" onload="templates.servticketsrail.list.loading = !templates.servticketsrail.list.loading"></div>
			</div>
			<div ng-if="templates.servticketsrail.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servticketsair', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServTicketsAir" /></tab-heading>
			<div ng-if="templates.servticketsair.list.init" ng-controller="ServTicketsAirListCtrl" class="tab-body">
				<div ng-include="templates.servticketsair.list.url" onload="templates.servticketsair.list.loading = !templates.servticketsair.list.loading"></div>
			</div>
			<div ng-if="templates.servticketsair.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servcruise', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServCruise" /></tab-heading>
			<div ng-if="templates.servcruise.list.init" ng-controller="ServCruiseListCtrl" class="tab-body">
				<div ng-include="templates.servcruise.list.url" onload="templates.servcruise.list.loading = !templates.servcruise.list.loading"></div>
			</div>
			<div ng-if="templates.servcruise.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
		<tab select="initTab('servgifts', 'list')" class="tab">
			<tab-heading><spring:message code="label.ServGifts" /></tab-heading>
			<div ng-if="templates.servgifts.list.init" ng-controller="ServGiftsListCtrl" class="tab-body">
				<div ng-include="templates.servgifts.list.url" onload="templates.servgifts.list.loading = !templates.servgifts.list.loading"></div>
			</div>
			<div ng-if="templates.servgifts.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
	</tabset>
</div>