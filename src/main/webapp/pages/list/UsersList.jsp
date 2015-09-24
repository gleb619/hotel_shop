<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="my-container-3 sectors-holder">
	<div class="row sector-header">
		<div class="without-padding margin-bottom-5">
			<div class="btn-group">
				<button type="button" class="btn btn-default btn-create" ng-click="createModalNewItem()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit" ng-click="editModalItem()">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete" ng-click="deleteItem()">
					<i class="glyphicon glyphicon-trash pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.delete" /></span>
				</button>
				<button type="button" class="btn btn-default btn-reload" ng-click="reloadData()">
					<i class="glyphicon glyphicon-repeat pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.reload" /></span>
				</button>
			</div>
		<c:if test="${debug}">
			<div class="btn-group">
				<a href="../data/users?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/usersview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordUsers" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredUsers', 'dataUsers', searchKeywordUsers)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataUsers()">
			<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
				<thead>
					<tr>
					<c:if test="${debug}">
						<th>
							<div ng-click="sort('id')">
								<a class="sortable-column-name"><span>id</span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.id, 'fa-caret-up': !details.id }"></i>
							</div>
						</th>
					</c:if>
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

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredUsers = ( dataUsers | filter:searchKeywordUsers | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredUsers track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
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
						<td>
							<button type="button" ng-click="editModalItem(item.id)" class="btn button-transparent">
								<i class="glyphicon glyphicon-pencil"></i> 
							</button>
						</td>
						<td>
							<button type="button" ng-click="deleteItem(item.id, $index)" class="btn button-transparent">
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
					<button type="button" class="btn btn-primary" ng-click="loadDataUsers()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataUsers()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataUsers()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset >
			
					<tab select="initTab('reqservhotel', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqServHotel"/></tab-heading>
						
						<div ng-if="templates.reqservhotel.fragmentlist.init" ng-include="templates.reqservhotel.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('userroles', 'fragmentlist')">
						<tab-heading><spring:message code="label.UserRoles"/></tab-heading>
						
						<div ng-if="templates.userroles.fragmentlist.init" ng-include="templates.userroles.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reqservhotel', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqServHotel"/></tab-heading>
						
						<div ng-if="templates.reqservhotel.fragmentlist.init" ng-include="templates.reqservhotel.fragmentlist.url"></div>
					</tab>
					
					
			</tabset>
		</div>
	</div>
	</div>
