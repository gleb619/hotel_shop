<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="padding-top-10">
	<div class="row">
			<div class="col-md-12">
			  <div class="table-responsive">
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr>
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('breakfast')">
							<div ng-click="sort('breakfast')" >
								<a class="sortable-column-name"><span><spring:message code="label.breakfast" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.breakfast, 'fa-caret-up': !details.breakfast }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyfoodid')">
							<div ng-click="sort('dictglobalbyfoodid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByFoodId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByFoodId, 'fa-caret-up': !details.dictGlobalByFoodId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyroomtypeid')">
							<div ng-click="sort('dictglobalbyroomtypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByRoomTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByRoomTypeId, 'fa-caret-up': !details.dictGlobalByRoomTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('groupglobal')">
							<div ng-click="sort('groupglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.groupGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.groupGlobal, 'fa-caret-up': !details.groupGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roomnumber')">
							<div ng-click="sort('roomnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.roomNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roomNumber, 'fa-caret-up': !details.roomNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('guestnumber')">
							<div ng-click="sort('guestnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.guestNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.guestNumber, 'fa-caret-up': !details.guestNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('category')">
							<div ng-click="sort('category')" >
								<a class="sortable-column-name"><span><spring:message code="label.category" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.category, 'fa-caret-up': !details.category }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descriptioncollapsed')">
							<div ng-click="sort('descriptioncollapsed')" >
								<a class="sortable-column-name"><span><spring:message code="label.descriptioncollapsed" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descriptioncollapsed, 'fa-caret-up': !details.descriptioncollapsed }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.servHotelRooms track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('breakfast')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.breakfast, 'fa fa-lg fa-circle-o': !item.breakfast}"></i></td>
						<td ng-if="::checkVisibility('dictglobalbyfoodid')"><label>{{ ::item.dictglobalbyfood }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyroomtypeid')"><label>{{ ::item.dictglobalbyroomtype }}</label></td>
						<td ng-if="::checkVisibility('groupglobal')"><label>{{ ::item.groupglobal }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('roomnumber')"><label>{{ ::item.roomnumber }}</label></td>
						<td ng-if="::checkVisibility('guestnumber')"><label>{{ ::item.guestnumber }}</label></td>
						<td ng-if="::checkVisibility('category')"><label>{{ ::item.category }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						<td ng-if="::checkVisibility('descriptioncollapsed')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.descriptioncollapsed, 'fa fa-lg fa-circle-o': !item.descriptioncollapsed}"></i></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredServHotelRoom.length }}/{{ selectedItem.servHotelRooms.length }}
				</div>
			  </div>
		</div>
	</div>
</div>