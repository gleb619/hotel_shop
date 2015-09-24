<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="col-md-12">
	<button class="btn btn-default btn-currency" ng-click="priceFilter.value = 'dollar'" title="<spring:message code="default.dollar" />">
		<i class="fa-2x fa fa-usd"></i>
	</button>
	<button class="btn btn-default btn-currency" ng-click="priceFilter.value = 'tenge'" title="<spring:message code="default.tenge" />">
		<img src="../resources/images/tenge.png" class="img-responsive">
	</button>
</div>