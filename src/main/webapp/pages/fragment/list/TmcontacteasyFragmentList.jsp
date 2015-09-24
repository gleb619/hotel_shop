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
						<th ng-if="::checkVisibility('manfoman')">
							<div ng-click="sort('manfoman')" >
								<a class="sortable-column-name"><span><spring:message code="label.manFoman" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.manFoman, 'fa-caret-up': !details.manFoman }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone')">
							<div ng-click="sort('phone')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone, 'fa-caret-up': !details.phone }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email')">
							<div ng-click="sort('email')" >
								<a class="sortable-column-name"><span><spring:message code="label.email" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email, 'fa-caret-up': !details.email }"></i>
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
						<tr ng-repeat="item in selectedItem.tmContactEasies track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('manfoman')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.manFoman, 'fa fa-lg fa-circle-o': !item.manFoman}"></i></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('phone')"><label>{{ ::item.phone }}</label></td>
						<td ng-if="::checkVisibility('email')"><label>{{ ::item.email }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredTmContactEasy.length }}/{{ selectedItem.tmContactEasies.length }}
				</div>
			  </div>
		</div>
	</div>
</div>