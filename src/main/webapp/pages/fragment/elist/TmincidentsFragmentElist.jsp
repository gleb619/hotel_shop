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
			<li class="list-group-item" ng-if="::checkVisibility('servtour')">
				<span class="list-group-item-caption"><spring:message code="label.servTour" /></span>
				<span class="pull-right">{{ ::selectedItem.servtour.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmcontact')">
				<span class="list-group-item-caption"><spring:message code="label.tmContact" /></span>
				<span class="pull-right">{{ ::selectedItem.tmcontact.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servvisas')">
				<span class="list-group-item-caption"><spring:message code="label.servVisas" /></span>
				<span class="pull-right">{{ ::selectedItem.servvisas.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servtransfer')">
				<span class="list-group-item-caption"><spring:message code="label.servTransfer" /></span>
				<span class="pull-right">{{ ::selectedItem.servtransfer.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotel')">
				<span class="list-group-item-caption"><spring:message code="label.servHotel" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotel.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('solution')">
				<span class="list-group-item-caption"><spring:message code="label.solution" /></span>
				<span class="pull-right">{{ ::selectedItem.solution }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('subject')">
				<span class="list-group-item-caption"><spring:message code="label.subject" /></span>
				<span class="pull-right">{{ ::selectedItem.subject }}</span>
			</li>

		</ol>
	</div>
</div>