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
			<li class="list-group-item" ng-if="::checkVisibility('dictglobal')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobal.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('cabinsnumber')">
				<span class="list-group-item-caption"><spring:message code="label.cabinsNumber" /></span>
				<span class="pull-right">{{ ::selectedItem.cabinsnumber }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('childrencount')">
				<span class="list-group-item-caption"><spring:message code="label.childrenCount" /></span>
				<span class="pull-right">{{ ::selectedItem.childrencount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('cruisename')">
				<span class="list-group-item-caption"><spring:message code="label.cruiseName" /></span>
				<span class="pull-right">{{ ::selectedItem.cruisename }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('cruisedescr')">
				<span class="list-group-item-caption"><spring:message code="label.cruiseDescr" /></span>
				<span class="pull-right">{{ ::selectedItem.cruisedescr }}</span>
			</li>

		</ol>
	</div>
</div>