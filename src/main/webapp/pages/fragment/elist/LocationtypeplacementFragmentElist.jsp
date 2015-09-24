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
			<li class="list-group-item" ng-if="::checkVisibility('dictglobal')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobal.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numberofbuildings')">
				<span class="list-group-item-caption"><spring:message code="label.numberOfBuildings" /></span>
				<span class="pull-right">{{ ::selectedItem.numberofbuildings }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numberofrooms')">
				<span class="list-group-item-caption"><spring:message code="label.numberOfRooms" /></span>
				<span class="pull-right">{{ ::selectedItem.numberofrooms }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('availablenumberofrooms')">
				<span class="list-group-item-caption"><spring:message code="label.availableNumberOfRooms" /></span>
				<span class="pull-right">{{ ::selectedItem.availablenumberofrooms }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('availablenumberoflevels')">
				<span class="list-group-item-caption"><spring:message code="label.availableNumberOfLevels" /></span>
				<span class="pull-right">{{ ::selectedItem.availablenumberoflevels }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numberoflevels')">
				<span class="list-group-item-caption"><spring:message code="label.numberOfLevels" /></span>
				<span class="pull-right">{{ ::selectedItem.numberoflevels }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotelid')">
				<span class="list-group-item-caption"><spring:message code="label.servHotelId" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotelid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('availablenumberofbuildings')">
				<span class="list-group-item-caption"><spring:message code="label.availableNumberOfBuildings" /></span>
				<span class="pull-right">{{ ::selectedItem.availablenumberofbuildings }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nameeng')">
				<span class="list-group-item-caption"><spring:message code="label.nameeng" /></span>
				<span class="pull-right">{{ ::selectedItem.nameeng }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('name')">
				<span class="list-group-item-caption"><spring:message code="label.name" /></span>
				<span class="pull-right">{{ ::selectedItem.name }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('value')">
				<span class="list-group-item-caption"><spring:message code="label.value" /></span>
				<span class="pull-right">{{ ::selectedItem.value }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('valueeng')">
				<span class="list-group-item-caption"><spring:message code="label.valueeng" /></span>
				<span class="pull-right">{{ ::selectedItem.valueeng }}</span>
			</li>

		</ol>
	</div>
</div>