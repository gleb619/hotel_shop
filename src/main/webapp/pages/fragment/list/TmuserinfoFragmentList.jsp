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
						<th ng-if="::checkVisibility('lastlogin')">
							<div ng-click="sort('lastlogin')" >
								<a class="sortable-column-name"><span><spring:message code="label.lastLogin" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.lastLogin, 'fa-caret-up': !details.lastLogin }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('proxycontent')">
							<div ng-click="sort('proxycontent')" >
								<a class="sortable-column-name"><span><spring:message code="label.proxyContent" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.proxyContent, 'fa-caret-up': !details.proxyContent }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('remotehost')">
							<div ng-click="sort('remotehost')" >
								<a class="sortable-column-name"><span><spring:message code="label.remoteHost" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.remoteHost, 'fa-caret-up': !details.remoteHost }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('browser')">
							<div ng-click="sort('browser')" >
								<a class="sortable-column-name"><span><spring:message code="label.browser" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.browser, 'fa-caret-up': !details.browser }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('browserversion')">
							<div ng-click="sort('browserversion')" >
								<a class="sortable-column-name"><span><spring:message code="label.browserVersion" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.browserVersion, 'fa-caret-up': !details.browserVersion }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('useripaddress')">
							<div ng-click="sort('useripaddress')" >
								<a class="sortable-column-name"><span><spring:message code="label.userIpAddress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.userIpAddress, 'fa-caret-up': !details.userIpAddress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('useragent')">
							<div ng-click="sort('useragent')" >
								<a class="sortable-column-name"><span><spring:message code="label.userAgent" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.userAgent, 'fa-caret-up': !details.userAgent }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('platformversion')">
							<div ng-click="sort('platformversion')" >
								<a class="sortable-column-name"><span><spring:message code="label.platformversion" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.platformversion, 'fa-caret-up': !details.platformversion }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('platform')">
							<div ng-click="sort('platform')" >
								<a class="sortable-column-name"><span><spring:message code="label.platform" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.platform, 'fa-caret-up': !details.platform }"></i>
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
						<tr ng-repeat="item in selectedItem.tmUserInfoes track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('lastlogin')"><label>{{ ::item.lastlogin }}</label></td>
						<td ng-if="::checkVisibility('proxycontent')"><label>{{ ::item.proxycontent }}</label></td>
						<td ng-if="::checkVisibility('remotehost')"><label>{{ ::item.remotehost }}</label></td>
						<td ng-if="::checkVisibility('browser')"><label>{{ ::item.browser }}</label></td>
						<td ng-if="::checkVisibility('browserversion')"><label>{{ ::item.browserversion }}</label></td>
						<td ng-if="::checkVisibility('useripaddress')"><label>{{ ::item.useripaddress }}</label></td>
						<td ng-if="::checkVisibility('useragent')"><label>{{ ::item.useragent }}</label></td>
						<td ng-if="::checkVisibility('platformversion')"><label>{{ ::item.platformversion }}</label></td>
						<td ng-if="::checkVisibility('platform')"><label>{{ ::item.platform }}</label></td>
						<td ng-if="::checkVisibility('username')"><label>{{ ::item.username }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredTmUserInfo.length }}/{{ selectedItem.tmUserInfoes.length }}
				</div>
			  </div>
		</div>
	</div>
</div>