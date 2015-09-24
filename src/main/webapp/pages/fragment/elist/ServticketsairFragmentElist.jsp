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
			<li class="list-group-item" ng-if="::checkVisibility('datestartdep')">
				<span class="list-group-item-caption"><spring:message code="label.dateStartDep" /></span>
				<span class="pull-right">{{ ::selectedItem.datestartdep }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dateendarrival')">
				<span class="list-group-item-caption"><spring:message code="label.dateEndArrival" /></span>
				<span class="pull-right">{{ ::selectedItem.dateendarrival }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dateenddep')">
				<span class="list-group-item-caption"><spring:message code="label.dateEndDep" /></span>
				<span class="pull-right">{{ ::selectedItem.dateenddep }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('datestartarrival')">
				<span class="list-group-item-caption"><spring:message code="label.dateStartArrival" /></span>
				<span class="pull-right">{{ ::selectedItem.datestartarrival }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbytypeplanearrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByTypePlaneArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbytypeplanearrivalid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccountbyaircompanyarrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccountByAirCompanyArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccountbyaircompanyarrivalid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyairclassid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByAirclassId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyairclassid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbytypeplanedepid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByTypePlaneDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbytypeplanedepid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccountbyaccountid')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccountByAccountId" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccountbyaccountid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccountbyaircompanydepid')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccountByAirCompanyDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccountbyaircompanydepid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citybackarrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.cityBackArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.citybackarrivalid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citytherearrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.cityThereArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.citytherearrivalid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numflightdep')">
				<span class="list-group-item-caption"><spring:message code="label.numFlightDep" /></span>
				<span class="pull-right">{{ ::selectedItem.numflightdep }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numflightarrival')">
				<span class="list-group-item-caption"><spring:message code="label.numFlightArrival" /></span>
				<span class="pull-right">{{ ::selectedItem.numflightarrival }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citytheredepid')">
				<span class="list-group-item-caption"><spring:message code="label.cityThereDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.citytheredepid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citybackdepid')">
				<span class="list-group-item-caption"><spring:message code="label.cityBackDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.citybackdepid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('airname')">
				<span class="list-group-item-caption"><spring:message code="label.airName" /></span>
				<span class="pull-right">{{ ::selectedItem.airname }}</span>
			</li>

		</ol>
	</div>
</div>