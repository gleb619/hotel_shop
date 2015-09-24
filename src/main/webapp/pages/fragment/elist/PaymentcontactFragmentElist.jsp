<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('paymentcost')">
				<span class="list-group-item-caption"><spring:message code="label.paymentCost" /></span>
				<span class="pull-right">{{ ::selectedItem.paymentcost }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('costprice')">
				<span class="list-group-item-caption"><spring:message code="label.costPrice" /></span>
				<span class="pull-right">{{ ::selectedItem.costprice }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('paymentenddate')">
				<span class="list-group-item-caption"><spring:message code="label.paymentEndDate" /></span>
				<span class="pull-right">{{ ::selectedItem.paymentenddate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('paymentstartdate')">
				<span class="list-group-item-caption"><spring:message code="label.paymentStartDate" /></span>
				<span class="pull-right">{{ ::selectedItem.paymentstartdate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmorder')">
				<span class="list-group-item-caption"><spring:message code="label.tmOrder" /></span>
				<span class="pull-right">{{ ::selectedItem.tmorder.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmcontact')">
				<span class="list-group-item-caption"><spring:message code="label.tmContact" /></span>
				<span class="pull-right">{{ ::selectedItem.tmcontact.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobal')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobal.label }}</span>
			</li>

		</ol>
	</div>
</div>