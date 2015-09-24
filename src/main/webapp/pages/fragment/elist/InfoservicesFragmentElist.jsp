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
			<li class="list-group-item" ng-if="::checkVisibility('servinsurances')">
				<span class="list-group-item-caption"><spring:message code="label.servInsurances" /></span>
				<span class="pull-right">{{ ::selectedItem.servinsurances.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servticketsrail')">
				<span class="list-group-item-caption"><spring:message code="label.servTicketsRail" /></span>
				<span class="pull-right">{{ ::selectedItem.servticketsrail.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobal')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobal.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servexcursions')">
				<span class="list-group-item-caption"><spring:message code="label.servExcursions" /></span>
				<span class="pull-right">{{ ::selectedItem.servexcursions.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servvisas')">
				<span class="list-group-item-caption"><spring:message code="label.servVisas" /></span>
				<span class="pull-right">{{ ::selectedItem.servvisas.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servtransfer')">
				<span class="list-group-item-caption"><spring:message code="label.servTransfer" /></span>
				<span class="pull-right">{{ ::selectedItem.servtransfer.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servgifts')">
				<span class="list-group-item-caption"><spring:message code="label.servGifts" /></span>
				<span class="pull-right">{{ ::selectedItem.servgifts.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servticketsair')">
				<span class="list-group-item-caption"><spring:message code="label.servTicketsAir" /></span>
				<span class="pull-right">{{ ::selectedItem.servticketsair.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servcruise')">
				<span class="list-group-item-caption"><spring:message code="label.servCruise" /></span>
				<span class="pull-right">{{ ::selectedItem.servcruise.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotel')">
				<span class="list-group-item-caption"><spring:message code="label.servHotel" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotel.label }}</span>
			</li>

		</ol>
	</div>
</div>