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
			<li class="list-group-item" ng-if="::checkVisibility('busystart')">
				<span class="list-group-item-caption"><spring:message code="label.busyStart" /></span>
				<span class="pull-right">{{ ::selectedItem.busystart }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('busyend')">
				<span class="list-group-item-caption"><spring:message code="label.busyEnd" /></span>
				<span class="pull-right">{{ ::selectedItem.busyend }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotelroom')">
				<span class="list-group-item-caption"><spring:message code="label.servHotelRoom" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotelroom.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobal')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobal.label }}</span>
			</li>

		</ol>
	</div>
</div>