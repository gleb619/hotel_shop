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
			<li class="list-group-item" ng-if="::checkVisibility('race')">
				<span class="list-group-item-caption"><spring:message code="label.race" /></span>
				<span class="pull-right">{{ ::selectedItem.race }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('departure')">
				<span class="list-group-item-caption"><spring:message code="label.departure" /></span>
				<span class="pull-right">{{ ::selectedItem.departure }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyserviceid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByServiceId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyserviceid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyfeatureid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByFeatureId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyfeatureid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('pets')">
				<span class="list-group-item-caption"><spring:message code="label.pets" /></span>
				<span class="pull-right">{{ ::selectedItem.pets }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('childrenandextrabeds')">
				<span class="list-group-item-caption"><spring:message code="label.childrenAndExtraBeds" /></span>
				<span class="pull-right">{{ ::selectedItem.childrenandextrabeds }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('changeprepayment')">
				<span class="list-group-item-caption"><spring:message code="label.changePrepayment" /></span>
				<span class="pull-right">{{ ::selectedItem.changeprepayment }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('cancelprepayment')">
				<span class="list-group-item-caption"><spring:message code="label.cancelPrepayment" /></span>
				<span class="pull-right">{{ ::selectedItem.cancelprepayment }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('name')">
				<span class="list-group-item-caption"><spring:message code="label.name" /></span>
				<span class="pull-right">{{ ::selectedItem.name }}</span>
			</li>

		</ol>
	</div>
</div>