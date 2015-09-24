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
			<li class="list-group-item" ng-if="::checkVisibility('lastlogin')">
				<span class="list-group-item-caption"><spring:message code="label.lastLogin" /></span>
				<span class="pull-right">{{ ::selectedItem.lastlogin }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('proxycontent')">
				<span class="list-group-item-caption"><spring:message code="label.proxyContent" /></span>
				<span class="pull-right">{{ ::selectedItem.proxycontent }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('remotehost')">
				<span class="list-group-item-caption"><spring:message code="label.remoteHost" /></span>
				<span class="pull-right">{{ ::selectedItem.remotehost }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('browser')">
				<span class="list-group-item-caption"><spring:message code="label.browser" /></span>
				<span class="pull-right">{{ ::selectedItem.browser }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('browserversion')">
				<span class="list-group-item-caption"><spring:message code="label.browserVersion" /></span>
				<span class="pull-right">{{ ::selectedItem.browserversion }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('useripaddress')">
				<span class="list-group-item-caption"><spring:message code="label.userIpAddress" /></span>
				<span class="pull-right">{{ ::selectedItem.useripaddress }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('useragent')">
				<span class="list-group-item-caption"><spring:message code="label.userAgent" /></span>
				<span class="pull-right">{{ ::selectedItem.useragent }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('platformversion')">
				<span class="list-group-item-caption"><spring:message code="label.platformversion" /></span>
				<span class="pull-right">{{ ::selectedItem.platformversion }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('platform')">
				<span class="list-group-item-caption"><spring:message code="label.platform" /></span>
				<span class="pull-right">{{ ::selectedItem.platform }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('username')">
				<span class="list-group-item-caption"><spring:message code="label.username" /></span>
				<span class="pull-right">{{ ::selectedItem.username }}</span>
			</li>

		</ol>
	</div>
</div>