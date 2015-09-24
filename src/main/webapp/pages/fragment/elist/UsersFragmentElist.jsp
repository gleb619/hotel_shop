<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('enabled')">
				<span class="list-group-item-caption"><spring:message code="label.enabled" /></span>
				<span class="pull-right">{{ ::selectedItem.enabled }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('activated')">
				<span class="list-group-item-caption"><spring:message code="label.activated" /></span>
				<span class="pull-right">{{ ::selectedItem.activated }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmimage')">
				<span class="list-group-item-caption"><spring:message code="label.tmImage" /></span>
				<span class="pull-right">{{ ::selectedItem.tmimage.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('firstname')">
				<span class="list-group-item-caption"><spring:message code="label.firstname" /></span>
				<span class="pull-right">{{ ::selectedItem.firstname }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('landingpage')">
				<span class="list-group-item-caption"><spring:message code="label.landingpage" /></span>
				<span class="pull-right">{{ ::selectedItem.landingpage }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('activationkey')">
				<span class="list-group-item-caption"><spring:message code="label.activationkey" /></span>
				<span class="pull-right">{{ ::selectedItem.activationkey }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('lastname')">
				<span class="list-group-item-caption"><spring:message code="label.lastname" /></span>
				<span class="pull-right">{{ ::selectedItem.lastname }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('password')">
				<span class="list-group-item-caption"><spring:message code="label.password" /></span>
				<span class="pull-right">{{ ::selectedItem.password }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('langkey')">
				<span class="list-group-item-caption"><spring:message code="label.langkey" /></span>
				<span class="pull-right">{{ ::selectedItem.langkey }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('email')">
				<span class="list-group-item-caption"><spring:message code="label.email" /></span>
				<span class="pull-right">{{ ::selectedItem.email }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('username')">
				<span class="list-group-item-caption"><spring:message code="label.username" /></span>
				<span class="pull-right">{{ ::selectedItem.username }}</span>
			</li>

		</ol>
	</div>
</div>