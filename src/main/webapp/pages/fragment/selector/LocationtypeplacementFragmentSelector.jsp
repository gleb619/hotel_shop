<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-if="!loading">
		<div class="modal-header">
			<button type="button" class="close round-button" ng-click="cancel()">&times;</button>
			<h4 class="modal-title">
				<spring:message code="default.listof" /> <spring:message code="label.LocationTypePlacement" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/locationtypeplacementview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordLocationTypePlacement" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataLocationTypePlacement()">
					<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
						<thead>
							<tr>
								<th class="picker-th"></th>
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
							<tr ng-repeat="item in filteredLocationTypePlacement = ( dataLocationTypePlacement | filter:searchKeywordLocationTypePlacement ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						<td ng-if="::checkVisibility('numberofbuildings')"><label>{{ ::item.numberofbuildings }}</label></td>
						<td ng-if="::checkVisibility('numberofrooms')"><label>{{ ::item.numberofrooms }}</label></td>
						<td ng-if="::checkVisibility('availablenumberofrooms')"><label>{{ ::item.availablenumberofrooms }}</label></td>
						<td ng-if="::checkVisibility('availablenumberoflevels')"><label>{{ ::item.availablenumberoflevels }}</label></td>
						<td ng-if="::checkVisibility('numberoflevels')"><label>{{ ::item.numberoflevels }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('availablenumberofbuildings')"><label>{{ ::item.availablenumberofbuildings }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('value')"><label>{{ ::item.value }}</label></td>
						<td ng-if="::checkVisibility('valueeng')"><label>{{ ::item.valueeng }}</label></td>
							</tr>
						</tbody>
					</table>
				  </div>
			</div>
			<div class="col-md-12 margin-bottom-10">
				<div class="btn-toolbar">
	  				<div class="btn-group">
						<button type="button" class="btn btn-default">
							<i class="fa fa-list-alt fa-lg"></i>
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredLocationTypePlacement.length }} / {{ dataLocationTypePlacement.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataLocationTypePlacement()">
							<i class="fa fa-database fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
							<span><spring:message code="default.loadMore" /></span>
						</button>
	  				</div>
	  			</div>
			</div>
		</div>
		<div class="modal-footer">
			<div class="col-xs-6 col-md-6">
				<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
					<spring:message code="default.cancel" />
				</a>
			</div>
			<div class="col-xs-6 col-md-6">
				<a ng-click="submitFunc()"
					class="btn btn-success btn-block btn-lg"> <spring:message
						code="default.submit" />
				</a>
			</div>
		</div>
	</div>
	 <div ng-show="loading" class="loading-bar-holder border-none">
		<div class="loading-bar">
			<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
		</div>
	</div>
</div>
