<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="main-layout">
	<tabset justified="true" class="tabset">
		<tab class="tab">
			<tab-heading>
				<spring:message code="label.PaymentContact" />
			</tab-heading>
			
			<div ng-controller="PaymentContactListCtrl" class="tab-body">
				<jsp:include page="../list/PaymentcontactList.jsp"/>
			</div>
		</tab>
		<tab select="initTab('paymentaccount', 'list')" class="tab">
			<tab-heading><spring:message code="label.PaymentAccount" /></tab-heading>
			<div ng-if="templates.paymentaccount.list.init" ng-controller="PaymentAccountListCtrl" class="tab-body">
				<div ng-include="templates.paymentaccount.list.url" onload="templates.paymentaccount.list.loading = !templates.paymentaccount.list.loading"></div>
			</div>
			<div ng-if="templates.paymentaccount.list.loading" class="app-content-loading tab-body">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</tab>
	</tabset>
</div>