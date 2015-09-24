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
						<th ng-if="::checkVisibility('price')">
							<div ng-click="sort('price')" >
								<a class="sortable-column-name"><span><spring:message code="label.price" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.price, 'fa-caret-up': !details.price }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('cabinsnumber')">
							<div ng-click="sort('cabinsnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.cabinsNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cabinsNumber, 'fa-caret-up': !details.cabinsNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('childrencount')">
							<div ng-click="sort('childrencount')" >
								<a class="sortable-column-name"><span><spring:message code="label.childrenCount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.childrenCount, 'fa-caret-up': !details.childrenCount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('cruisename')">
							<div ng-click="sort('cruisename')" >
								<a class="sortable-column-name"><span><spring:message code="label.cruiseName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cruiseName, 'fa-caret-up': !details.cruiseName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('cruisedescr')">
							<div ng-click="sort('cruisedescr')" >
								<a class="sortable-column-name"><span><spring:message code="label.cruiseDescr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cruiseDescr, 'fa-caret-up': !details.cruiseDescr }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.servCruises track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('cabinsnumber')"><label>{{ ::item.cabinsnumber }}</label></td>
						<td ng-if="::checkVisibility('childrencount')"><label>{{ ::item.childrencount }}</label></td>
						<td ng-if="::checkVisibility('cruisename')"><label>{{ ::item.cruisename }}</label></td>
						<td ng-if="::checkVisibility('cruisedescr')"><label>{{ ::item.cruisedescr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredServCruise.length }}/{{ selectedItem.servCruises.length }}
				</div>
			  </div>
		</div>
	</div>
</div>