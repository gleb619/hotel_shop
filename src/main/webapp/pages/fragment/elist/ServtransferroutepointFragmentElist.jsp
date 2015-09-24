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
			<li class="list-group-item" ng-if="::checkVisibility('fixedallowance')">
				<span class="list-group-item-caption"><spring:message code="label.fixedAllowance" /></span>
				<span class="pull-right">{{ ::selectedItem.fixedallowance }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('percentageofallowances')">
				<span class="list-group-item-caption"><spring:message code="label.percentageOfAllowances" /></span>
				<span class="pull-right">{{ ::selectedItem.percentageofallowances }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('free')">
				<span class="list-group-item-caption"><spring:message code="label.free" /></span>
				<span class="pull-right">{{ ::selectedItem.free }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('starton')">
				<span class="list-group-item-caption"><spring:message code="label.startOn" /></span>
				<span class="pull-right">{{ ::selectedItem.starton }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servtransferroute')">
				<span class="list-group-item-caption"><spring:message code="label.servTransferRoute" /></span>
				<span class="pull-right">{{ ::selectedItem.servtransferroute.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('sum')">
				<span class="list-group-item-caption"><spring:message code="label.sum" /></span>
				<span class="pull-right">{{ ::selectedItem.sum }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('pointfrom')">
				<span class="list-group-item-caption"><spring:message code="label.pointFrom" /></span>
				<span class="pull-right">{{ ::selectedItem.pointfrom }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('pointto')">
				<span class="list-group-item-caption"><spring:message code="label.pointTo" /></span>
				<span class="pull-right">{{ ::selectedItem.pointto }}</span>
			</li>

		</ol>
	</div>
</div>