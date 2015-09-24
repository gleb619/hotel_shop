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
			<li class="list-group-item" ng-if="::checkVisibility('isbase')">
				<span class="list-group-item-caption"><spring:message code="label.isbase" /></span>
				<span class="pull-right">{{ ::selectedItem.isbase }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nameeng')">
				<span class="list-group-item-caption"><spring:message code="label.nameeng" /></span>
				<span class="pull-right">{{ ::selectedItem.nameeng }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currencyname')">
				<span class="list-group-item-caption"><spring:message code="label.currencyname" /></span>
				<span class="pull-right">{{ ::selectedItem.currencyname }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nameru')">
				<span class="list-group-item-caption"><spring:message code="label.nameru" /></span>
				<span class="pull-right">{{ ::selectedItem.nameru }}</span>
			</li>

		</ol>
	</div>
</div>