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
						<th ng-if="::checkVisibility('race')">
							<div ng-click="sort('race')" >
								<a class="sortable-column-name"><span><spring:message code="label.race" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.race, 'fa-caret-up': !details.race }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('departure')">
							<div ng-click="sort('departure')" >
								<a class="sortable-column-name"><span><spring:message code="label.departure" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.departure, 'fa-caret-up': !details.departure }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyserviceid')">
							<div ng-click="sort('dictglobalbyserviceid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByServiceId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByServiceId, 'fa-caret-up': !details.dictGlobalByServiceId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyfeatureid')">
							<div ng-click="sort('dictglobalbyfeatureid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByFeatureId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByFeatureId, 'fa-caret-up': !details.dictGlobalByFeatureId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('pets')">
							<div ng-click="sort('pets')" >
								<a class="sortable-column-name"><span><spring:message code="label.pets" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.pets, 'fa-caret-up': !details.pets }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('childrenandextrabeds')">
							<div ng-click="sort('childrenandextrabeds')" >
								<a class="sortable-column-name"><span><spring:message code="label.childrenAndExtraBeds" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.childrenAndExtraBeds, 'fa-caret-up': !details.childrenAndExtraBeds }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('changeprepayment')">
							<div ng-click="sort('changeprepayment')" >
								<a class="sortable-column-name"><span><spring:message code="label.changePrepayment" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.changePrepayment, 'fa-caret-up': !details.changePrepayment }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('cancelprepayment')">
							<div ng-click="sort('cancelprepayment')" >
								<a class="sortable-column-name"><span><spring:message code="label.cancelPrepayment" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cancelPrepayment, 'fa-caret-up': !details.cancelPrepayment }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
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
						<tr ng-repeat="item in selectedItem.tmPolicieses track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('race')"><label>{{ ::item.race }}</label></td>
						<td ng-if="::checkVisibility('departure')"><label>{{ ::item.departure }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyserviceid')"><label>{{ ::item.dictglobalbyservice }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyfeatureid')"><label>{{ ::item.dictglobalbyfeature }}</label></td>
						<td ng-if="::checkVisibility('pets')"><label>{{ ::item.pets }}</label></td>
						<td ng-if="::checkVisibility('childrenandextrabeds')"><label>{{ ::item.childrenandextrabeds }}</label></td>
						<td ng-if="::checkVisibility('changeprepayment')"><label>{{ ::item.changeprepayment }}</label></td>
						<td ng-if="::checkVisibility('cancelprepayment')"><label>{{ ::item.cancelprepayment }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredTmPolicies.length }}/{{ selectedItem.tmPolicieses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>