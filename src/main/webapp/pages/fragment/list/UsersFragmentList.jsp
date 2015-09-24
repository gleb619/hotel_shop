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
						<th ng-if="::checkVisibility('enabled')">
							<div ng-click="sort('enabled')" >
								<a class="sortable-column-name"><span><spring:message code="label.enabled" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.enabled, 'fa-caret-up': !details.enabled }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('activated')">
							<div ng-click="sort('activated')" >
								<a class="sortable-column-name"><span><spring:message code="label.activated" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.activated, 'fa-caret-up': !details.activated }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmimage')">
							<div ng-click="sort('tmimage')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmImage" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmImage, 'fa-caret-up': !details.tmImage }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('firstname')">
							<div ng-click="sort('firstname')" >
								<a class="sortable-column-name"><span><spring:message code="label.firstname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.firstname, 'fa-caret-up': !details.firstname }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('landingpage')">
							<div ng-click="sort('landingpage')" >
								<a class="sortable-column-name"><span><spring:message code="label.landingpage" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.landingpage, 'fa-caret-up': !details.landingpage }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('activationkey')">
							<div ng-click="sort('activationkey')" >
								<a class="sortable-column-name"><span><spring:message code="label.activationkey" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.activationkey, 'fa-caret-up': !details.activationkey }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('lastname')">
							<div ng-click="sort('lastname')" >
								<a class="sortable-column-name"><span><spring:message code="label.lastname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.lastname, 'fa-caret-up': !details.lastname }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('password')">
							<div ng-click="sort('password')" >
								<a class="sortable-column-name"><span><spring:message code="label.password" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.password, 'fa-caret-up': !details.password }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('langkey')">
							<div ng-click="sort('langkey')" >
								<a class="sortable-column-name"><span><spring:message code="label.langkey" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.langkey, 'fa-caret-up': !details.langkey }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email')">
							<div ng-click="sort('email')" >
								<a class="sortable-column-name"><span><spring:message code="label.email" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email, 'fa-caret-up': !details.email }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('username')">
							<div ng-click="sort('username')" >
								<a class="sortable-column-name"><span><spring:message code="label.username" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.username, 'fa-caret-up': !details.username }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.userses track by $index">
						<td ng-if="::checkVisibility('enabled')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.enabled, 'fa fa-lg fa-circle-o': !item.enabled}"></i></td>
						<td ng-if="::checkVisibility('activated')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.activated, 'fa fa-lg fa-circle-o': !item.activated}"></i></td>
						<td ng-if="::checkVisibility('tmimage')"><label>{{ ::item.tmimage }}</label></td>
						<td ng-if="::checkVisibility('firstname')"><label>{{ ::item.firstname }}</label></td>
						<td ng-if="::checkVisibility('landingpage')"><label>{{ ::item.landingpage }}</label></td>
						<td ng-if="::checkVisibility('activationkey')"><label>{{ ::item.activationkey }}</label></td>
						<td ng-if="::checkVisibility('lastname')"><label>{{ ::item.lastname }}</label></td>
						<td ng-if="::checkVisibility('password')"><label>{{ ::item.password }}</label></td>
						<td ng-if="::checkVisibility('langkey')"><label>{{ ::item.langkey }}</label></td>
						<td ng-if="::checkVisibility('email')"><label>{{ ::item.email }}</label></td>
						<td ng-if="::checkVisibility('username')"><label>{{ ::item.username }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredUsers.length }}/{{ selectedItem.userses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>