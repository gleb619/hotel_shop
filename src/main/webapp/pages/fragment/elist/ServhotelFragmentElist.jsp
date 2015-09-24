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
			<li class="list-group-item" ng-if="::checkVisibility('showonline')">
				<span class="list-group-item-caption"><spring:message code="label.showonline" /></span>
				<span class="pull-right">{{ ::selectedItem.showonline }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('problem')">
				<span class="list-group-item-caption"><spring:message code="label.problem" /></span>
				<span class="pull-right">{{ ::selectedItem.problem }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('credit')">
				<span class="list-group-item-caption"><spring:message code="label.credit" /></span>
				<span class="pull-right">{{ ::selectedItem.credit }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('workonprepayment')">
				<span class="list-group-item-caption"><spring:message code="label.workonprepayment" /></span>
				<span class="pull-right">{{ ::selectedItem.workonprepayment }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('blacklist')">
				<span class="list-group-item-caption"><spring:message code="label.blacklist" /></span>
				<span class="pull-right">{{ ::selectedItem.blacklist }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('freesale')">
				<span class="list-group-item-caption"><spring:message code="label.freesale" /></span>
				<span class="pull-right">{{ ::selectedItem.freesale }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('favorite')">
				<span class="list-group-item-caption"><spring:message code="label.favorite" /></span>
				<span class="pull-right">{{ ::selectedItem.favorite }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyqualityid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByQualityId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyqualityid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyserviceidid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByServiceidId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyserviceidid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyplacementid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByPlacementId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyplacementid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyreserveticketstypeid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByReserveticketstypeId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyreserveticketstypeid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbytypeid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByTypeId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbytypeid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbycategoryid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByCategoryId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbycategoryid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcities')">
				<span class="list-group-item-caption"><spring:message code="label.locationCities" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcities.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcountries')">
				<span class="list-group-item-caption"><spring:message code="label.locationCountries" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcountries.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationtypeplacement')">
				<span class="list-group-item-caption"><spring:message code="label.locationTypePlacement" /></span>
				<span class="pull-right">{{ ::selectedItem.locationtypeplacement.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('roomsnumber')">
				<span class="list-group-item-caption"><spring:message code="label.roomsnumber" /></span>
				<span class="pull-right">{{ ::selectedItem.roomsnumber }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('storeys')">
				<span class="list-group-item-caption"><spring:message code="label.storeys" /></span>
				<span class="pull-right">{{ ::selectedItem.storeys }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('whereroomsarebooked')">
				<span class="list-group-item-caption"><spring:message code="label.whereroomsarebooked" /></span>
				<span class="pull-right">{{ ::selectedItem.whereroomsarebooked }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nameeng')">
				<span class="list-group-item-caption"><spring:message code="label.nameeng" /></span>
				<span class="pull-right">{{ ::selectedItem.nameeng }}</span>
			</li>

		</ol>
	</div>
</div>