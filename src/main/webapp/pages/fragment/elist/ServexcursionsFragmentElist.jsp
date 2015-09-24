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
			<li class="list-group-item" ng-if="::checkVisibility('excdate')">
				<span class="list-group-item-caption"><spring:message code="label.excdate" /></span>
				<span class="pull-right">{{ ::selectedItem.excdate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcities')">
				<span class="list-group-item-caption"><spring:message code="label.locationCities" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcities.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('name')">
				<span class="list-group-item-caption"><spring:message code="label.name" /></span>
				<span class="pull-right">{{ ::selectedItem.name }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('place')">
				<span class="list-group-item-caption"><spring:message code="label.place" /></span>
				<span class="pull-right">{{ ::selectedItem.place }}</span>
			</li>

		</ol>
	</div>
</div>