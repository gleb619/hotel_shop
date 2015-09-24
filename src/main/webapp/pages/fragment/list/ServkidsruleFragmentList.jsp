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
						<th ng-if="::checkVisibility('startage')">
							<div ng-click="sort('startage')" >
								<a class="sortable-column-name"><span><spring:message code="label.startAge" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.startAge, 'fa-caret-up': !details.startAge }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('endage')">
							<div ng-click="sort('endage')" >
								<a class="sortable-column-name"><span><spring:message code="label.endAge" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.endAge, 'fa-caret-up': !details.endAge }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('synopsys')">
							<div ng-click="sort('synopsys')" >
								<a class="sortable-column-name"><span><spring:message code="label.synopsys" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.synopsys, 'fa-caret-up': !details.synopsys }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.servKidsRules track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('startage')"><label>{{ ::item.startage }}</label></td>
						<td ng-if="::checkVisibility('endage')"><label>{{ ::item.endage }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('synopsys')"><label>{{ ::item.synopsys }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredServKidsRule.length }}/{{ selectedItem.servKidsRules.length }}
				</div>
			  </div>
		</div>
	</div>
</div>