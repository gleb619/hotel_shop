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
				<spring:message code="default.listof" /> <spring:message code="label.LocationAddress" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/locationaddressview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordLocationAddress" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataLocationAddress()">
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
						<th ng-if="::checkVisibility('gmappointx')">
							<div ng-click="sort('gmappointx')" >
								<a class="sortable-column-name"><span><spring:message code="label.gmapPointX" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.gmapPointX, 'fa-caret-up': !details.gmapPointX }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('gmappointy')">
							<div ng-click="sort('gmappointy')" >
								<a class="sortable-column-name"><span><spring:message code="label.gmapPointY" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.gmapPointY, 'fa-caret-up': !details.gmapPointY }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('metro')">
							<div ng-click="sort('metro')" >
								<a class="sortable-column-name"><span><spring:message code="label.metro" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.metro, 'fa-caret-up': !details.metro }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('yandexmappointx')">
							<div ng-click="sort('yandexmappointx')" >
								<a class="sortable-column-name"><span><spring:message code="label.yandexMapPointX" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.yandexMapPointX, 'fa-caret-up': !details.yandexMapPointX }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roadmap')">
							<div ng-click="sort('roadmap')" >
								<a class="sortable-column-name"><span><spring:message code="label.roadMap" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roadMap, 'fa-caret-up': !details.roadMap }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('yandexmappointy')">
							<div ng-click="sort('yandexmappointy')" >
								<a class="sortable-column-name"><span><spring:message code="label.yandexMapPointY" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.yandexMapPointY, 'fa-caret-up': !details.yandexMapPointY }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredLocationAddress = ( dataLocationAddress | filter:searchKeywordLocationAddress ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('gmappointx')"><label>{{ ::item.gmappointx }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('gmappointy')"><label>{{ ::item.gmappointy }}</label></td>
						<td ng-if="::checkVisibility('metro')"><label>{{ ::item.metro }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('yandexmappointx')"><label>{{ ::item.yandexmappointx }}</label></td>
						<td ng-if="::checkVisibility('roadmap')"><label>{{ ::item.roadmap }}</label></td>
						<td ng-if="::checkVisibility('yandexmappointy')"><label>{{ ::item.yandexmappointy }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredLocationAddress.length }} / {{ dataLocationAddress.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataLocationAddress()">
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
