<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4 col-md-3">
			<h1><spring:message code="default.request" /></h1>
        	<hr class="separator">
	        <p><spring:message code="default.request-hint" /></p>
	        <c:if test="${debug}">
	        	<hr class="separator">
	        	<p><spring:message code="default.request-hint-debug" /></p>
	        	<button type="button" class="btn btn-default" ng-click="requestRandom()">
					<i class="fa fa-random"></i>
					<span><spring:message code="default.random.request2" /></span>
				</button>
	        </c:if>
        	<hr class="separator">
			<div class="list-group">
				<a class="list-group-item">
					<h4 class="list-group-item-heading">{{ ::item.label }}</h4>
					<p class="list-group-item-text"><spring:message code="default.hotel" /></p>
				</a>
				<a class="list-group-item">
					<h4 class="list-group-item-heading">{{ details.room.label }}</h4>
					<p class="list-group-item-text"><spring:message code="default.room" /></p>
				</a>
				<a class="list-group-item">
					<h4 class="list-group-item-heading">{{ details.tariff.corporateRateCost }}<small>{{ details.tariff.corporateRateCurrencyname }}</small>&nbsp;&nbsp;({{ details.tariff.corporateRateCostUsdCurrency }}<small>{{ details.tariff.corporateRateCostUsdcurrencysign }}</small>)</h4>
					<p class="list-group-item-text"><spring:message code="default.corporateRateCost" /></p>
				</a>
				<a class="list-group-item">
					<h4 class="list-group-item-heading">{{ details.tariff.originalRateCost }}<small>{{ details.tariff.originalRateCurrencyname }}</small>&nbsp;&nbsp;({{ details.tariff.originalRateCostUsdCurrency }}<small>{{ details.tariff.originalRateCostUsdcurrencysign }}</small>)</h4>
					<p class="list-group-item-text"><spring:message code="default.originalRateCost" /></p>
				</a>
				<a class="list-group-item">
					<h4 class="list-group-item-heading">{{ details.tariff.humannumber }}</h4>
					<p class="list-group-item-text"><spring:message code="default.human_s-short" /></p>
				</a>
			</div>
			<hr class="separator visible-xs">
	        
		</div>
		<div class="col-sm-8 col-md-9">
			<jsp:include page="../../../_public/landscape_request.jsp">
				<jsp:param name="submitType" value="true" />
			</jsp:include>
		</div>
	</div>
</div>