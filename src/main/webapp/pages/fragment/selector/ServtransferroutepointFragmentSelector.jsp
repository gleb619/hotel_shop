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
				<spring:message code="default.listof" /> <spring:message code="label.ServTransferRoutePoint" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/servtransferroutepointview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordServTransferRoutePoint" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataServTransferRoutePoint()">
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
						<th ng-if="::checkVisibility('fixedallowance')">
							<div ng-click="sort('fixedallowance')" >
								<a class="sortable-column-name"><span><spring:message code="label.fixedAllowance" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.fixedAllowance, 'fa-caret-up': !details.fixedAllowance }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('percentageofallowances')">
							<div ng-click="sort('percentageofallowances')" >
								<a class="sortable-column-name"><span><spring:message code="label.percentageOfAllowances" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.percentageOfAllowances, 'fa-caret-up': !details.percentageOfAllowances }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('free')">
							<div ng-click="sort('free')" >
								<a class="sortable-column-name"><span><spring:message code="label.free" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.free, 'fa-caret-up': !details.free }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('starton')">
							<div ng-click="sort('starton')" >
								<a class="sortable-column-name"><span><spring:message code="label.startOn" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.startOn, 'fa-caret-up': !details.startOn }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servtransferroute')">
							<div ng-click="sort('servtransferroute')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTransferRoute" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTransferRoute, 'fa-caret-up': !details.servTransferRoute }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('sum')">
							<div ng-click="sort('sum')" >
								<a class="sortable-column-name"><span><spring:message code="label.sum" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.sum, 'fa-caret-up': !details.sum }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('pointfrom')">
							<div ng-click="sort('pointfrom')" >
								<a class="sortable-column-name"><span><spring:message code="label.pointFrom" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.pointFrom, 'fa-caret-up': !details.pointFrom }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('pointto')">
							<div ng-click="sort('pointto')" >
								<a class="sortable-column-name"><span><spring:message code="label.pointTo" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.pointTo, 'fa-caret-up': !details.pointTo }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredServTransferRoutePoint = ( dataServTransferRoutePoint | filter:searchKeywordServTransferRoutePoint ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('fixedallowance')"><label>{{ ::item.fixedallowance }}</label></td>
						<td ng-if="::checkVisibility('percentageofallowances')"><label>{{ ::item.percentageofallowances }}</label></td>
						<td ng-if="::checkVisibility('free')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.free, 'fa fa-lg fa-circle-o': !item.free}"></i></td>
						<td ng-if="::checkVisibility('starton')"><label>{{ ::item.starton }}</label></td>
						<td ng-if="::checkVisibility('servtransferroute')"><label>{{ ::item.servtransferroute }}</label></td>
						<td ng-if="::checkVisibility('sum')"><label>{{ ::item.sum }}</label></td>
						<td ng-if="::checkVisibility('pointfrom')"><label>{{ ::item.pointfrom }}</label></td>
						<td ng-if="::checkVisibility('pointto')"><label>{{ ::item.pointto }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredServTransferRoutePoint.length }} / {{ dataServTransferRoutePoint.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataServTransferRoutePoint()">
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
