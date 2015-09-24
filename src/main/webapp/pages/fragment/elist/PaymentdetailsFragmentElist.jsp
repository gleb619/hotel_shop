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
			<li class="list-group-item" ng-if="::checkVisibility('bin')">
				<span class="list-group-item-caption"><spring:message code="label.bin" /></span>
				<span class="pull-right">{{ ::selectedItem.bin }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('phone2')">
				<span class="list-group-item-caption"><spring:message code="label.phone2" /></span>
				<span class="pull-right">{{ ::selectedItem.phone2 }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('fullname')">
				<span class="list-group-item-caption"><spring:message code="label.fullName" /></span>
				<span class="pull-right">{{ ::selectedItem.fullname }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nceo')">
				<span class="list-group-item-caption"><spring:message code="label.nceo" /></span>
				<span class="pull-right">{{ ::selectedItem.nceo }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('banklocation')">
				<span class="list-group-item-caption"><spring:message code="label.bankLocation" /></span>
				<span class="pull-right">{{ ::selectedItem.banklocation }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('legaladdress')">
				<span class="list-group-item-caption"><spring:message code="label.legalAddress" /></span>
				<span class="pull-right">{{ ::selectedItem.legaladdress }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('iin')">
				<span class="list-group-item-caption"><spring:message code="label.iin" /></span>
				<span class="pull-right">{{ ::selectedItem.iin }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('postaladdress')">
				<span class="list-group-item-caption"><spring:message code="label.postalAddress" /></span>
				<span class="pull-right">{{ ::selectedItem.postaladdress }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nameofthebank')">
				<span class="list-group-item-caption"><spring:message code="label.nameOfTheBank" /></span>
				<span class="pull-right">{{ ::selectedItem.nameofthebank }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('phone')">
				<span class="list-group-item-caption"><spring:message code="label.phone" /></span>
				<span class="pull-right">{{ ::selectedItem.phone }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('correspondentaccount')">
				<span class="list-group-item-caption"><spring:message code="label.correspondentAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.correspondentaccount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currentaccount')">
				<span class="list-group-item-caption"><spring:message code="label.currentAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.currentaccount }}</span>
			</li>

		</ol>
	</div>
</div>