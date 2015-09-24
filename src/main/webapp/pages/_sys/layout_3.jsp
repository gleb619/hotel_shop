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
	</tabset>
</div>