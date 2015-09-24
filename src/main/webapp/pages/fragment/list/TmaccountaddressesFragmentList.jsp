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
						<th ng-if="::checkVisibility('isdetail')">
							<div ng-click="sort('isdetail')" >
								<a class="sortable-column-name"><span><spring:message code="label.isDetail" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.isDetail, 'fa-caret-up': !details.isDetail }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcities')">
							<div ng-click="sort('locationcities')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCities" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCities, 'fa-caret-up': !details.locationCities }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('zip')">
							<div ng-click="sort('zip')" >
								<a class="sortable-column-name"><span><spring:message code="label.zip" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.zip, 'fa-caret-up': !details.zip }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('address')">
							<div ng-click="sort('address')" >
								<a class="sortable-column-name"><span><spring:message code="label.address" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.address, 'fa-caret-up': !details.address }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('addressname')">
							<div ng-click="sort('addressname')" >
								<a class="sortable-column-name"><span><spring:message code="label.addressName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.addressName, 'fa-caret-up': !details.addressName }"></i>
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
						<tr ng-repeat="item in selectedItem.tmAccountAddresseses track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('isdetail')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.isDetail, 'fa fa-lg fa-circle-o': !item.isDetail}"></i></td>
						<td ng-if="::checkVisibility('locationcities')"><label>{{ ::item.locationcities }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('zip')"><label>{{ ::item.zip }}</label></td>
						<td ng-if="::checkVisibility('address')"><label>{{ ::item.address }}</label></td>
						<td ng-if="::checkVisibility('addressname')"><label>{{ ::item.addressname }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredTmAccountAddresses.length }}/{{ selectedItem.tmAccountAddresseses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>