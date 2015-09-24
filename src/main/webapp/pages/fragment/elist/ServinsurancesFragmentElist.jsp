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
			<li class="list-group-item" ng-if="::checkVisibility('dateto')">
				<span class="list-group-item-caption"><spring:message code="label.dateto" /></span>
				<span class="pull-right">{{ ::selectedItem.dateto }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('datefrom')">
				<span class="list-group-item-caption"><spring:message code="label.datefrom" /></span>
				<span class="pull-right">{{ ::selectedItem.datefrom }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccountbyaccountid')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccountByAccountId" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccountbyaccountid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccountbyinsaccountid')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccountByInsAccountId" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccountbyinsaccountid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcountries')">
				<span class="list-group-item-caption"><spring:message code="label.locationCountries" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcountries.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobal')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobal.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('insurancename')">
				<span class="list-group-item-caption"><spring:message code="label.insuranceName" /></span>
				<span class="pull-right">{{ ::selectedItem.insurancename }}</span>
			</li>

		</ol>
	</div>
</div>