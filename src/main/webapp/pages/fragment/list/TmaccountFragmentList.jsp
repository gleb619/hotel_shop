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
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('accountname')">
							<div ng-click="sort('accountname')" >
								<a class="sortable-column-name"><span><spring:message code="label.accountName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.accountName, 'fa-caret-up': !details.accountName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('accountfullname')">
							<div ng-click="sort('accountfullname')" >
								<a class="sortable-column-name"><span><spring:message code="label.accountFullname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.accountFullname, 'fa-caret-up': !details.accountFullname }"></i>
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
						<tr ng-repeat="item in selectedItem.tmAccounts track by $index">
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('accountname')"><label>{{ ::item.accountname }}</label></td>
						<td ng-if="::checkVisibility('accountfullname')"><label>{{ ::item.accountfullname }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredTmAccount.length }}/{{ selectedItem.tmAccounts.length }}
				</div>
			  </div>
		</div>
	</div>
</div>