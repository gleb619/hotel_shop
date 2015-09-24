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
			<li class="list-group-item" ng-if="::checkVisibility('lastpay')">
				<span class="list-group-item-caption"><spring:message code="label.lastpay" /></span>
				<span class="pull-right">{{ ::selectedItem.lastpay }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('accountid')">
				<span class="list-group-item-caption"><spring:message code="label.accountid" /></span>
				<span class="pull-right">{{ ::selectedItem.accountid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('mounthcount')">
				<span class="list-group-item-caption"><spring:message code="label.mounthcount" /></span>
				<span class="pull-right">{{ ::selectedItem.mounthcount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('active')">
				<span class="list-group-item-caption"><spring:message code="label.active" /></span>
				<span class="pull-right">{{ ::selectedItem.active }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('firmname')">
				<span class="list-group-item-caption"><spring:message code="label.firmName" /></span>
				<span class="pull-right">{{ ::selectedItem.firmname }}</span>
			</li>

		</ol>
	</div>
</div>