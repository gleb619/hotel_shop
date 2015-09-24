<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('label')">
				<span class="list-group-item-caption"><spring:message code="label.label" /></span>
				<span class="pull-right">{{ ::selectedItem.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('vat')">
				<span class="list-group-item-caption"><spring:message code="label.vat" /></span>
				<span class="pull-right">{{ ::selectedItem.vat }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('course')">
				<span class="list-group-item-caption"><spring:message code="label.course" /></span>
				<span class="pull-right">{{ ::selectedItem.course }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('value')">
				<span class="list-group-item-caption"><spring:message code="label.value" /></span>
				<span class="pull-right">{{ ::selectedItem.value }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('paymenttariff')">
				<span class="list-group-item-caption"><spring:message code="label.paymentTariff" /></span>
				<span class="pull-right">{{ ::selectedItem.paymenttariff.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('humannumber')">
				<span class="list-group-item-caption"><spring:message code="label.humannumber" /></span>
				<span class="pull-right">{{ ::selectedItem.humannumber }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('discount')">
				<span class="list-group-item-caption"><spring:message code="label.discount" /></span>
				<span class="pull-right">{{ ::selectedItem.discount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('commission')">
				<span class="list-group-item-caption"><spring:message code="label.commission" /></span>
				<span class="pull-right">{{ ::selectedItem.commission }}</span>
			</li>

		</ol>
	</div>
</div>