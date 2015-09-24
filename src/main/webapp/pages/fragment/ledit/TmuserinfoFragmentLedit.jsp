<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div>
	<div class="row">
		<div class="padding-left-right-15">
			<div class="btn-group without-padding display-block toolbar-panel margin-bottom-5">
				<button type="button" class="btn btn-default btn-create"
					ng-click="createModalItemTmUserInfo()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemTmUserInfo(selectedItemtmUserInfoes.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('tmUserInfoes', 'TmUserInfo', selectedItemtmUserInfoes.id, itemIndex)">
					<i class="glyphicon glyphicon-trash pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.delete" /></span>
				</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive margin-bottom-5 table-body ledit-scroll">
				<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
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

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.tmUserInfoes track by $index"
							ng-class="{ 'success' : selectedItemtmUserInfoes.id == item.id }"
							ng-dblclick="editModalItemTmUserInfo(item.id)"
							ng-click="setSelected('selectedItemtmUserInfoes', item, $index)">
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
							<td>
								<a ng-click="editModalItemTmUserInfo(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('tmUserInfoes', 'TmUserInfo', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.tmUserInfoes.length }}
				</div>
			</div>
		</div>
	</div>
</div>