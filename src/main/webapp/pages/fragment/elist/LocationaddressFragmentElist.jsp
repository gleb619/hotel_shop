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
			<li class="list-group-item" ng-if="::checkVisibility('gmappointx')">
				<span class="list-group-item-caption"><spring:message code="label.gmapPointX" /></span>
				<span class="pull-right">{{ ::selectedItem.gmappointx }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nameeng')">
				<span class="list-group-item-caption"><spring:message code="label.nameeng" /></span>
				<span class="pull-right">{{ ::selectedItem.nameeng }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('gmappointy')">
				<span class="list-group-item-caption"><spring:message code="label.gmapPointY" /></span>
				<span class="pull-right">{{ ::selectedItem.gmappointy }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('metro')">
				<span class="list-group-item-caption"><spring:message code="label.metro" /></span>
				<span class="pull-right">{{ ::selectedItem.metro }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('name')">
				<span class="list-group-item-caption"><spring:message code="label.name" /></span>
				<span class="pull-right">{{ ::selectedItem.name }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('yandexmappointx')">
				<span class="list-group-item-caption"><spring:message code="label.yandexMapPointX" /></span>
				<span class="pull-right">{{ ::selectedItem.yandexmappointx }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('roadmap')">
				<span class="list-group-item-caption"><spring:message code="label.roadMap" /></span>
				<span class="pull-right">{{ ::selectedItem.roadmap }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('yandexmappointy')">
				<span class="list-group-item-caption"><spring:message code="label.yandexMapPointY" /></span>
				<span class="pull-right">{{ ::selectedItem.yandexmappointy }}</span>
			</li>

		</ol>
	</div>
</div>