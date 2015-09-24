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
			<li class="list-group-item" ng-if="::checkVisibility('price')">
				<span class="list-group-item-caption"><spring:message code="label.price" /></span>
				<span class="pull-right">{{ ::selectedItem.price }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('datefrom')">
				<span class="list-group-item-caption"><spring:message code="label.dateFrom" /></span>
				<span class="pull-right">{{ ::selectedItem.datefrom }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dateto')">
				<span class="list-group-item-caption"><spring:message code="label.dateTo" /></span>
				<span class="pull-right">{{ ::selectedItem.dateto }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbypaymenttypeid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByPaymentTypeId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbypaymenttypeid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcities')">
				<span class="list-group-item-caption"><spring:message code="label.locationCities" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcities.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbytransportid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByTransportId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbytransportid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcountries')">
				<span class="list-group-item-caption"><spring:message code="label.locationCountries" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcountries.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbytypetransferid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByTypeTransferId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbytypetransferid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('passengersphones')">
				<span class="list-group-item-caption"><spring:message code="label.passengersPhones" /></span>
				<span class="pull-right">{{ ::selectedItem.passengersphones }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('visittable')">
				<span class="list-group-item-caption"><spring:message code="label.visitTable" /></span>
				<span class="pull-right">{{ ::selectedItem.visittable }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('transfername')">
				<span class="list-group-item-caption"><spring:message code="label.transferName" /></span>
				<span class="pull-right">{{ ::selectedItem.transfername }}</span>
			</li>

		</ol>
	</div>
</div>