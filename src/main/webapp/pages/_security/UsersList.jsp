<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="my-container-3 sectors-holder">
	<div class="row sector-header">
		<div class="without-padding margin-bottom-5"
			ng-class="{ 'col-md-1': details.isCollapsedUsers, 'col-md-12': !details.isCollapsedUsers }">
			<button type="button" class="btn btn-default btn-collapsed" ng-click="details.isCollapsedUsers = !details.isCollapsedUsers">
				<i class="fa fa-ellipsis-h" ng-show="details.isCollapsedUsers"></i>
				<i class="fa fa-times" ng-hide="details.isCollapsedUsers"></i>
			</button>
			<div ng-hide="details.isCollapsedUsers">
				<div class="btn-group">
					<button type="button" class="btn btn-default btn-create" ng-click="createModalNewItem()">
						<i class="fa fa-file-o pull-left"></i>
						<i class="fa fa-file pull-left"></i>
						<span>&nbsp;&nbsp;<spring:message code="default.create" /></span>
					</button>
					<button type="button" class="btn btn-default btn-edit"
						ng-disabled="isDisabledEdit()"
						ng-click="editModalItem(selectedItem.id)">
						<i class="glyphicon glyphicon-pencil pull-left"></i>
						<span>&nbsp;&nbsp;<spring:message code="default.edit" /></span>
					</button>
					<button type="button" class="btn btn-default btn-delete"
						ng-disabled="isDisabledEdit()"
						ng-click="deleteItem(selectedItem.id)">
						<i class="glyphicon glyphicon-trash pull-left"></i>
						<span>&nbsp;&nbsp;<spring:message code="default.delete" /></span>
					</button>
					<button type="button" class="btn btn-default btn-reload"
						ng-click="reloadData()">
						<i class="glyphicon glyphicon-repeat pull-left"></i>
						<span>&nbsp;&nbsp;<spring:message code="default.reload" /></span>
					</button>
				</div>
			<c:if test="${debug}">
				<div class="btn-group">
					<a href="../data/users?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA
					</a>
					<a href="../data/usersview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA FOR VIEW
					</a>
				</div>
			</c:if>
			</div>
		</div>
		<div class="without-padding" ng-class="{ 'col-md-11': details.isCollapsedUsers, 'col-md-12': !details.isCollapsedUsers }">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordUsers" class="form-control"
						placeholder="<spring:message code="default.filterKeyword" />"
						tabindex="1"/>
                   	<i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="sector-1">
		<div class="col-md-12 without-padding"
			ng-class="{ 'scrollable-content-84': details.isDetailUsers, 'scrollable-content-65': !details.isDetailUsers }">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataUsers()">
			<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
				<thead>
					<tr>
					<c:if test="${debug}">
						<th>
							<div ng-click="sort('id')">
								<a class="sortable-column-name"><span>id</span></a>
								<i class="fa fa-caret-down" ng-show="details.id"></i>
								<i class="fa fa-caret-up" ng-hide="details.id"></i>
							</div>
						</th>
					</c:if>
						<th ng-show="checkVisibility('enabled')">
							<div ng-click="sort('enabled')" >
								<a class="sortable-column-name"><span><spring:message code="label.enabled" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.enabled"></i>
								<i class="fa fa-caret-up" ng-hide="details.enabled"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('activated')">
							<div ng-click="sort('activated')" >
								<a class="sortable-column-name"><span><spring:message code="label.activated" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.activated"></i>
								<i class="fa fa-caret-up" ng-hide="details.activated"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('tmimage')">
							<div ng-click="sort('tmimage')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmImage" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.tmImage"></i>
								<i class="fa fa-caret-up" ng-hide="details.tmImage"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('firstname')">
							<div ng-click="sort('firstname')" >
								<a class="sortable-column-name"><span><spring:message code="label.firstname" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.firstname"></i>
								<i class="fa fa-caret-up" ng-hide="details.firstname"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('activationkey')">
							<div ng-click="sort('activationkey')" >
								<a class="sortable-column-name"><span><spring:message code="label.activationkey" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.activationkey"></i>
								<i class="fa fa-caret-up" ng-hide="details.activationkey"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('lastname')">
							<div ng-click="sort('lastname')" >
								<a class="sortable-column-name"><span><spring:message code="label.lastname" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.lastname"></i>
								<i class="fa fa-caret-up" ng-hide="details.lastname"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('password')">
							<div ng-click="sort('password')" >
								<a class="sortable-column-name"><span><spring:message code="label.password" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.password"></i>
								<i class="fa fa-caret-up" ng-hide="details.password"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('langkey')">
							<div ng-click="sort('langkey')" >
								<a class="sortable-column-name"><span><spring:message code="label.langkey" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.langkey"></i>
								<i class="fa fa-caret-up" ng-hide="details.langkey"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('email')">
							<div ng-click="sort('email')" >
								<a class="sortable-column-name"><span><spring:message code="label.email" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.email"></i>
								<i class="fa fa-caret-up" ng-hide="details.email"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('username')">
							<div ng-click="sort('username')" >
								<a class="sortable-column-name"><span><spring:message code="label.username" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.username"></i>
								<i class="fa fa-caret-up" ng-hide="details.username"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="item in filteredUsers = ( dataUsers | filter:searchKeywordUsers | orderBy: details.sortableColumn: details.sortableReverse )"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ item.id }}</td>
					</c:if>
						<td ng-show="checkVisibility('enabled')" class="switch-td"><i ng-class="{'fa fa-lg fa-check': item.enabled, 'fa fa-lg fa-circle-o': !item.enabled}"></i></td>
						<td ng-show="checkVisibility('activated')" class="switch-td"><i ng-class="{'fa fa-lg fa-check': item.activated, 'fa fa-lg fa-circle-o': !item.activated}"></i></td>
						<td ng-show="checkVisibility('tmimage')"><label>{{ item.tmimage }}</label></td>
						<td ng-show="checkVisibility('firstname')"><label>{{ item.firstname }}</label></td>
						<td ng-show="checkVisibility('activationkey')"><label>{{ item.activationkey }}</label></td>
						<td ng-show="checkVisibility('lastname')"><label>{{ item.lastname }}</label></td>
						<td ng-show="checkVisibility('password')"><label>{{ item.password }}</label></td>
						<td ng-show="checkVisibility('langkey')"><label>{{ item.langkey }}</label></td>
						<td ng-show="checkVisibility('email')"><label>{{ item.email }}</label></td>
						<td ng-show="checkVisibility('username')"><label>{{ item.username }}</label></td>
						<td>
							<button type="button" ng-click="editModalItem(item.id)" class="btn button-transparent">
								<i class="glyphicon glyphicon-pencil"></i> 
							</button>
						</td>
						<td>
							<button type="button" ng-click="deleteItem(item.id)" class="btn button-transparent">
								<i class="glyphicon glyphicon glyphicon-trash"></i>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		  </div>
		</div>
		<div class="col-md-12 margin-bottom-10">
			<div class="btn-toolbar">
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-default" ng-click="searchKeywordUsers = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredUsers.length }} / {{ dataUsers.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordUsers = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataUsers()" ng-disabled="scrollable.dataLoading">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span>
							<spring:message code="default.loadMore" />
						</span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle ng-disabled="scrollable.dataLoading">
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-disabled="scrollable.dataLoading" ng-click="loadDataUsers()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-disabled="scrollable.dataLoading" ng-click="loadAllDataUsers()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>

  				<button type="button" class="btn btn-default" data-toggle="button"
					ng-click="details.isDetailUsers = !details.isDetailUsers">
					Detail
				</button>
  			</div>
		</div>
		</div>
	<div class="sector-2" ng-hide="details.isDetailUsers">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12">
		<tabset >
			
			<tab>
						<tab-heading>
							<spring:message code="label.ReqServHotel"/>
						</tab-heading>
						
						<jsp:include page="../fragment/list/ReqservhotelFragmentList.jsp"/>
					</tab>
					
					<tab>
						<tab-heading>
							<spring:message code="label.UserRoles"/>
						</tab-heading>
						
						<jsp:include page="../fragment/list/UserrolesFragmentList.jsp"/>
					</tab>
					
					<tab>
						<tab-heading>
							<spring:message code="label.ReqServHotel"/>
						</tab-heading>
						
						<jsp:include page="../fragment/list/ReqservhotelFragmentList.jsp"/>
					</tab>
					
					
		</tabset>
		</div>
	</div>
	</div>
