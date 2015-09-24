<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-if="!loading">
		<div class="modal-header">
			<button type="button" class="close round-button" ng-click="cancel()">&times;</button>
			<h4 class="modal-title">
				<spring:message code="default.listof" /> <spring:message code="label.Users" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/usersview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordUsers" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataUsers()">
					<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
						<thead>
							<tr>
								<th class="picker-th"></th>
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
							<tr ng-repeat="item in filteredUsers = ( dataUsers | filter:searchKeywordUsers ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
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
				  </div>
			</div>
			<div class="col-md-12 margin-bottom-10">
				<div class="btn-toolbar">
	  				<div class="btn-group">
						<button type="button" class="btn btn-default">
							<i class="fa fa-list-alt fa-lg"></i>
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredUsers.length }} / {{ dataUsers.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataUsers()">
							<i class="fa fa-database fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
							<span><spring:message code="default.loadMore" /></span>
						</button>
	  				</div>
	  			</div>
			</div>
		</div>
		<div class="modal-footer">
			<div class="col-xs-6 col-md-6">
				<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
					<spring:message code="default.cancel" />
				</a>
			</div>
			<div class="col-xs-6 col-md-6">
				<a ng-click="submitFunc()"
					class="btn btn-success btn-block btn-lg"> <spring:message
						code="default.submit" />
				</a>
			</div>
		</div>
	</div>
	 <div ng-show="loading" class="loading-bar-holder border-none">
		<div class="loading-bar">
			<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
		</div>
	</div>
</div>
