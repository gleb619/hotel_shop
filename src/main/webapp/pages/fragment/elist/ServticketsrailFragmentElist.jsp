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
			<li class="list-group-item" ng-if="::checkVisibility('datestartdep')">
				<span class="list-group-item-caption"><spring:message code="label.dateStartDep" /></span>
				<span class="pull-right">{{ ::selectedItem.datestartdep }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dateendarrival')">
				<span class="list-group-item-caption"><spring:message code="label.dateEndArrival" /></span>
				<span class="pull-right">{{ ::selectedItem.dateendarrival }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dateenddep')">
				<span class="list-group-item-caption"><spring:message code="label.dateEndDep" /></span>
				<span class="pull-right">{{ ::selectedItem.dateenddep }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('datestartarrival')">
				<span class="list-group-item-caption"><spring:message code="label.dateStartArrival" /></span>
				<span class="pull-right">{{ ::selectedItem.datestartarrival }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrency')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrency" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('railcompanydepid')">
				<span class="list-group-item-caption"><spring:message code="label.railCompanyDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.railcompanydepid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citybackarrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.cityBackArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.citybackarrivalid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citytherearrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.cityThereArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.citytherearrivalid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('railcompanyarrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.railCompanyArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.railcompanyarrivalid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numtraindep')">
				<span class="list-group-item-caption"><spring:message code="label.numTrainDep" /></span>
				<span class="pull-right">{{ ::selectedItem.numtraindep }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('classtrainarrivalid')">
				<span class="list-group-item-caption"><spring:message code="label.classTrainArrivalId" /></span>
				<span class="pull-right">{{ ::selectedItem.classtrainarrivalid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citytheredepid')">
				<span class="list-group-item-caption"><spring:message code="label.cityThereDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.citytheredepid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('classtraindepid')">
				<span class="list-group-item-caption"><spring:message code="label.classTrainDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.classtraindepid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('citybackdepid')">
				<span class="list-group-item-caption"><spring:message code="label.cityBackDepId" /></span>
				<span class="pull-right">{{ ::selectedItem.citybackdepid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('numtrainarrival')">
				<span class="list-group-item-caption"><spring:message code="label.numTrainArrival" /></span>
				<span class="pull-right">{{ ::selectedItem.numtrainarrival }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('railname')">
				<span class="list-group-item-caption"><spring:message code="label.railName" /></span>
				<span class="pull-right">{{ ::selectedItem.railname }}</span>
			</li>

		</ol>
	</div>
</div>