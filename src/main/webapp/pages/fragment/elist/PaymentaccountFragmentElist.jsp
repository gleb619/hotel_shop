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
			<li class="list-group-item" ng-if="::checkVisibility('paymentenddate')">
				<span class="list-group-item-caption"><spring:message code="label.paymentEndDate" /></span>
				<span class="pull-right">{{ ::selectedItem.paymentenddate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('paymentstartdate')">
				<span class="list-group-item-caption"><spring:message code="label.paymentStartDate" /></span>
				<span class="pull-right">{{ ::selectedItem.paymentstartdate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbypaymentmethodid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByPaymentMethodId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbypaymentmethodid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmorder')">
				<span class="list-group-item-caption"><spring:message code="label.tmOrder" /></span>
				<span class="pull-right">{{ ::selectedItem.tmorder.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyservicetypeid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByServiceTypeId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyservicetypeid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('infoservices')">
				<span class="list-group-item-caption"><spring:message code="label.infoServices" /></span>
				<span class="pull-right">{{ ::selectedItem.infoservices.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('paymentcost')">
				<span class="list-group-item-caption"><spring:message code="label.paymentCost" /></span>
				<span class="pull-right">{{ ::selectedItem.paymentcost }}</span>
			</li>

		</ol>
	</div>
</div>