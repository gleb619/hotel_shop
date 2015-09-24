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
						<th ng-if="::checkVisibility('busystart')">
							<div ng-click="sort('busystart')" >
								<a class="sortable-column-name"><span><spring:message code="label.busyStart" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.busyStart, 'fa-caret-up': !details.busyStart }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('busyend')">
							<div ng-click="sort('busyend')" >
								<a class="sortable-column-name"><span><spring:message code="label.busyEnd" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.busyEnd, 'fa-caret-up': !details.busyEnd }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotelroom')">
							<div ng-click="sort('servhotelroom')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotelRoom" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotelRoom, 'fa-caret-up': !details.servHotelRoom }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.reqServHotelRoomBusies track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('busystart')"><label>{{ ::item.busystart }}</label></td>
						<td ng-if="::checkVisibility('busyend')"><label>{{ ::item.busyend }}</label></td>
						<td ng-if="::checkVisibility('servhotelroom')"><label>{{ ::item.servhotelroom }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredReqServHotelRoomBusy.length }}/{{ selectedItem.reqServHotelRoomBusies.length }}
				</div>
			  </div>
		</div>
	</div>
</div>