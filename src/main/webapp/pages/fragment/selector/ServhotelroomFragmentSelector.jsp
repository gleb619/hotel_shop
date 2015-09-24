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
				<spring:message code="default.listof" /> <spring:message code="label.ServHotelRoom" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/servhotelroomview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordServHotelRoom" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataServHotelRoom()">
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
							<tr ng-repeat="item in filteredServHotelRoom = ( dataServHotelRoom | filter:searchKeywordServHotelRoom ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('breakfast')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.breakfast, 'fa fa-lg fa-circle-o': !item.breakfast}"></i></td>
						<td ng-if="::checkVisibility('dictglobalbyfood')"><label>{{ ::item.dictglobalbyfood }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyroomtype')"><label>{{ ::item.dictglobalbyroomtype }}</label></td>
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
				  </div>
			</div>
			<div class="col-md-12 margin-bottom-10">
				<div class="btn-toolbar">
	  				<div class="btn-group">
						<button type="button" class="btn btn-default">
							<i class="fa fa-list-alt fa-lg"></i>
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredServHotelRoom.length }} / {{ dataServHotelRoom.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataServHotelRoom()">
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
