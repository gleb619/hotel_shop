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
			<li class="list-group-item" ng-if="::checkVisibility('dateend')">
				<span class="list-group-item-caption"><spring:message code="label.dateEnd" /></span>
				<span class="pull-right">{{ ::selectedItem.dateend }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('createdon')">
				<span class="list-group-item-caption"><spring:message code="label.createdon" /></span>
				<span class="pull-right">{{ ::selectedItem.createdon }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('datestart')">
				<span class="list-group-item-caption"><spring:message code="label.dateStart" /></span>
				<span class="pull-right">{{ ::selectedItem.datestart }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcities')">
				<span class="list-group-item-caption"><spring:message code="label.locationCities" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcities.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcountries')">
				<span class="list-group-item-caption"><spring:message code="label.locationCountries" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcountries.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('groupglobal')">
				<span class="list-group-item-caption"><spring:message code="label.groupGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.groupglobal.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numberofnights')">
				<span class="list-group-item-caption"><spring:message code="label.numberOfNights" /></span>
				<span class="pull-right">{{ ::selectedItem.numberofnights }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tourname')">
				<span class="list-group-item-caption"><spring:message code="label.tourName" /></span>
				<span class="pull-right">{{ ::selectedItem.tourname }}</span>
			</li>

		</ol>
	</div>
</div>