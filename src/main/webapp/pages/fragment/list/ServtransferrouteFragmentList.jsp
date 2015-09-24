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
						<th ng-if="::checkVisibility('servtransfer')">
							<div ng-click="sort('servtransfer')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTransfer" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTransfer, 'fa-caret-up': !details.servTransfer }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('sum')">
							<div ng-click="sort('sum')" >
								<a class="sortable-column-name"><span><spring:message code="label.sum" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.sum, 'fa-caret-up': !details.sum }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('driver')">
							<div ng-click="sort('driver')" >
								<a class="sortable-column-name"><span><spring:message code="label.driver" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.driver, 'fa-caret-up': !details.driver }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('driverphone')">
							<div ng-click="sort('driverphone')" >
								<a class="sortable-column-name"><span><spring:message code="label.driverPhone" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.driverPhone, 'fa-caret-up': !details.driverPhone }"></i>
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
						<tr ng-repeat="item in selectedItem.servTransferRoutes track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('fixedallowance')"><label>{{ ::item.fixedallowance }}</label></td>
						<td ng-if="::checkVisibility('percentageofallowances')"><label>{{ ::item.percentageofallowances }}</label></td>
						<td ng-if="::checkVisibility('free')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.free, 'fa fa-lg fa-circle-o': !item.free}"></i></td>
						<td ng-if="::checkVisibility('servtransfer')"><label>{{ ::item.servtransfer }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('sum')"><label>{{ ::item.sum }}</label></td>
						<td ng-if="::checkVisibility('driver')"><label>{{ ::item.driver }}</label></td>
						<td ng-if="::checkVisibility('driverphone')"><label>{{ ::item.driverphone }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredServTransferRoute.length }}/{{ selectedItem.servTransferRoutes.length }}
				</div>
			  </div>
		</div>
	</div>
</div>