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
			<li class="list-group-item" ng-if="::checkVisibility('breakfast')">
				<span class="list-group-item-caption"><spring:message code="label.breakfast" /></span>
				<span class="pull-right">{{ ::selectedItem.breakfast }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyfoodid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByFoodId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyfoodid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobalbyroomtypeid')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobalByRoomTypeId" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobalbyroomtypeid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('groupglobal')">
				<span class="list-group-item-caption"><spring:message code="label.groupGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.groupglobal.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotel')">
				<span class="list-group-item-caption"><spring:message code="label.servHotel" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotel.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('roomnumber')">
				<span class="list-group-item-caption"><spring:message code="label.roomNumber" /></span>
				<span class="pull-right">{{ ::selectedItem.roomnumber }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('guestnumber')">
				<span class="list-group-item-caption"><spring:message code="label.guestNumber" /></span>
				<span class="pull-right">{{ ::selectedItem.guestnumber }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('category')">
				<span class="list-group-item-caption"><spring:message code="label.category" /></span>
				<span class="pull-right">{{ ::selectedItem.category }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('descriptioncollapsed')">
				<span class="list-group-item-caption"><spring:message code="label.descriptioncollapsed" /></span>
				<span class="pull-right">{{ ::selectedItem.descriptioncollapsed }}</span>
			</li>

		</ol>
	</div>
</div>