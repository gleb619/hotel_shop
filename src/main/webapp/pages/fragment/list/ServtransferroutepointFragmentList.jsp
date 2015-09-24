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
						<tr ng-repeat="item in selectedItem.servTransferRoutePoints track by $index">
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
				<div>
					<spring:message code="default.total" />: {{ filteredServTransferRoutePoint.length }}/{{ selectedItem.servTransferRoutePoints.length }}
				</div>
			  </div>
		</div>
	</div>
</div>