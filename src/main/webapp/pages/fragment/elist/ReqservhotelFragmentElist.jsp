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
			<li class="list-group-item" ng-if="::checkVisibility('accept')">
				<span class="list-group-item-caption"><spring:message code="label.accept" /></span>
				<span class="pull-right">{{ ::selectedItem.accept }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('decline')">
				<span class="list-group-item-caption"><spring:message code="label.decline" /></span>
				<span class="pull-right">{{ ::selectedItem.decline }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('race')">
				<span class="list-group-item-caption"><spring:message code="label.race" /></span>
				<span class="pull-right">{{ ::selectedItem.race }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('departure')">
				<span class="list-group-item-caption"><spring:message code="label.departure" /></span>
				<span class="pull-right">{{ ::selectedItem.departure }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbypaymenttypeid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByPaymentTypeId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbypaymenttypeid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('usersbyrequestuserid')">
				<span class="list-group-item-caption"><spring:message code="label.usersByRequestUserId" /></span>
				<span class="pull-right">{{ ::selectedItem.usersbyrequestuserid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('usersbyresponseuserid')">
				<span class="list-group-item-caption"><spring:message code="label.usersByResponseUserId" /></span>
				<span class="pull-right">{{ ::selectedItem.usersbyresponseuserid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('docdocumentsbydocumentforhotelid')">
				<span class="list-group-item-caption"><spring:message code="label.docDocumentsByDocumentForHotelId" /></span>
				<span class="pull-right">{{ ::selectedItem.docdocumentsbydocumentforhotelid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyplacementid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByPlacementId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyplacementid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotelroom')">
				<span class="list-group-item-caption"><spring:message code="label.servHotelRoom" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotelroom.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('docdocumentsbydocumentforuserid')">
				<span class="list-group-item-caption"><spring:message code="label.docDocumentsByDocumentForUserId" /></span>
				<span class="pull-right">{{ ::selectedItem.docdocumentsbydocumentforuserid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotel')">
				<span class="list-group-item-caption"><spring:message code="label.servHotel" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotel.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('roomcount')">
				<span class="list-group-item-caption"><spring:message code="label.roomCount" /></span>
				<span class="pull-right">{{ ::selectedItem.roomcount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('progress')">
				<span class="list-group-item-caption"><spring:message code="label.progress" /></span>
				<span class="pull-right">{{ ::selectedItem.progress }}</span>
			</li>

		</ol>
	</div>
</div>