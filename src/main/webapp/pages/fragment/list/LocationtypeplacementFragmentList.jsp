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
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numberofbuildings')">
							<div ng-click="sort('numberofbuildings')" >
								<a class="sortable-column-name"><span><spring:message code="label.numberOfBuildings" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numberOfBuildings, 'fa-caret-up': !details.numberOfBuildings }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numberofrooms')">
							<div ng-click="sort('numberofrooms')" >
								<a class="sortable-column-name"><span><spring:message code="label.numberOfRooms" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numberOfRooms, 'fa-caret-up': !details.numberOfRooms }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('availablenumberofrooms')">
							<div ng-click="sort('availablenumberofrooms')" >
								<a class="sortable-column-name"><span><spring:message code="label.availableNumberOfRooms" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.availableNumberOfRooms, 'fa-caret-up': !details.availableNumberOfRooms }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('availablenumberoflevels')">
							<div ng-click="sort('availablenumberoflevels')" >
								<a class="sortable-column-name"><span><spring:message code="label.availableNumberOfLevels" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.availableNumberOfLevels, 'fa-caret-up': !details.availableNumberOfLevels }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numberoflevels')">
							<div ng-click="sort('numberoflevels')" >
								<a class="sortable-column-name"><span><spring:message code="label.numberOfLevels" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numberOfLevels, 'fa-caret-up': !details.numberOfLevels }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotelid')">
							<div ng-click="sort('servhotelid')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotelId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotelId, 'fa-caret-up': !details.servHotelId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('availablenumberofbuildings')">
							<div ng-click="sort('availablenumberofbuildings')" >
								<a class="sortable-column-name"><span><spring:message code="label.availableNumberOfBuildings" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.availableNumberOfBuildings, 'fa-caret-up': !details.availableNumberOfBuildings }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('value')">
							<div ng-click="sort('value')" >
								<a class="sortable-column-name"><span><spring:message code="label.value" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.value, 'fa-caret-up': !details.value }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('valueeng')">
							<div ng-click="sort('valueeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.valueeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.valueeng, 'fa-caret-up': !details.valueeng }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.locationTypePlacements track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						<td ng-if="::checkVisibility('numberofbuildings')"><label>{{ ::item.numberofbuildings }}</label></td>
						<td ng-if="::checkVisibility('numberofrooms')"><label>{{ ::item.numberofrooms }}</label></td>
						<td ng-if="::checkVisibility('availablenumberofrooms')"><label>{{ ::item.availablenumberofrooms }}</label></td>
						<td ng-if="::checkVisibility('availablenumberoflevels')"><label>{{ ::item.availablenumberoflevels }}</label></td>
						<td ng-if="::checkVisibility('numberoflevels')"><label>{{ ::item.numberoflevels }}</label></td>
						<td ng-if="::checkVisibility('servhotelid')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('availablenumberofbuildings')"><label>{{ ::item.availablenumberofbuildings }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('value')"><label>{{ ::item.value }}</label></td>
						<td ng-if="::checkVisibility('valueeng')"><label>{{ ::item.valueeng }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredLocationTypePlacement.length }}/{{ selectedItem.locationTypePlacements.length }}
				</div>
			  </div>
		</div>
	</div>
</div>