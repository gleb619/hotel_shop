<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="my-container-3 sectors-holder">
	<div class="row sector-header">
		<div class="without-padding margin-bottom-5"
			ng-class="{ 'col-md-1': details.isCollapsedTmUserInfo, 'col-md-12': !details.isCollapsedTmUserInfo }">
			<button type="button" class="btn btn-default btn-collapsed" ng-click="details.isCollapsedTmUserInfo = !details.isCollapsedTmUserInfo">
				<i class="fa fa-ellipsis-h" ng-show="details.isCollapsedTmUserInfo"></i>
				<i class="fa fa-times" ng-hide="details.isCollapsedTmUserInfo"></i>
			</button>
			<div ng-hide="details.isCollapsedTmUserInfo">
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
					<a href="../data/tmuserinfo?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA
					</a>
					<a href="../data/tmuserinfoview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA FOR VIEW
					</a>
				</div>
			</c:if>
			</div>
		</div>
		<div class="without-padding" ng-class="{ 'col-md-11': details.isCollapsedTmUserInfo, 'col-md-12': !details.isCollapsedTmUserInfo }">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordTmUserInfo" class="form-control"
						placeholder="<spring:message code="default.filterKeyword" />"
						tabindex="1"/>
                   	<i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="sector-1">
		<div class="col-md-12 without-padding"
			ng-class="{ 'scrollable-content-84': details.isDetailTmUserInfo, 'scrollable-content-65': !details.isDetailTmUserInfo }">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataTmUserInfo()">
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
						<th ng-show="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.label"></i>
								<i class="fa fa-caret-up" ng-hide="details.label"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('lastlogin')">
							<div ng-click="sort('lastlogin')" >
								<a class="sortable-column-name"><span><spring:message code="label.lastLogin" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.lastLogin"></i>
								<i class="fa fa-caret-up" ng-hide="details.lastLogin"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('proxycontent')">
							<div ng-click="sort('proxycontent')" >
								<a class="sortable-column-name"><span><spring:message code="label.proxyContent" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.proxyContent"></i>
								<i class="fa fa-caret-up" ng-hide="details.proxyContent"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('remotehost')">
							<div ng-click="sort('remotehost')" >
								<a class="sortable-column-name"><span><spring:message code="label.remoteHost" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.remoteHost"></i>
								<i class="fa fa-caret-up" ng-hide="details.remoteHost"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('browser')">
							<div ng-click="sort('browser')" >
								<a class="sortable-column-name"><span><spring:message code="label.browser" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.browser"></i>
								<i class="fa fa-caret-up" ng-hide="details.browser"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('browserversion')">
							<div ng-click="sort('browserversion')" >
								<a class="sortable-column-name"><span><spring:message code="label.browserVersion" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.browserVersion"></i>
								<i class="fa fa-caret-up" ng-hide="details.browserVersion"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('useripaddress')">
							<div ng-click="sort('useripaddress')" >
								<a class="sortable-column-name"><span><spring:message code="label.userIpAddress" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.userIpAddress"></i>
								<i class="fa fa-caret-up" ng-hide="details.userIpAddress"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('useragent')">
							<div ng-click="sort('useragent')" >
								<a class="sortable-column-name"><span><spring:message code="label.userAgent" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.userAgent"></i>
								<i class="fa fa-caret-up" ng-hide="details.userAgent"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('platformversion')">
							<div ng-click="sort('platformversion')" >
								<a class="sortable-column-name"><span><spring:message code="label.platformversion" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.platformversion"></i>
								<i class="fa fa-caret-up" ng-hide="details.platformversion"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('platform')">
							<div ng-click="sort('platform')" >
								<a class="sortable-column-name"><span><spring:message code="label.platform" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.platform"></i>
								<i class="fa fa-caret-up" ng-hide="details.platform"></i>
							</div>
						</th>
						<th ng-show="::checkVisibility('username')">
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
					<tr ng-repeat="item in filteredTmUserInfo = ( dataTmUserInfo | filter:searchKeywordTmUserInfo | orderBy: details.sortableColumn: details.sortableReverse )"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-show="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-show="::checkVisibility('lastlogin')"><label>{{ ::item.lastlogin }}</label></td>
						<td ng-show="::checkVisibility('proxycontent')"><label>{{ ::item.proxycontent }}</label></td>
						<td ng-show="::checkVisibility('remotehost')"><label>{{ ::item.remotehost }}</label></td>
						<td ng-show="::checkVisibility('browser')"><label>{{ ::item.browser }}</label></td>
						<td ng-show="::checkVisibility('browserversion')"><label>{{ ::item.browserversion }}</label></td>
						<td ng-show="::checkVisibility('useripaddress')"><label>{{ ::item.useripaddress }}</label></td>
						<td ng-show="::checkVisibility('useragent')"><label>{{ ::item.useragent }}</label></td>
						<td ng-show="::checkVisibility('platformversion')"><label>{{ ::item.platformversion }}</label></td>
						<td ng-show="::checkVisibility('platform')"><label>{{ ::item.platform }}</label></td>
						<td ng-show="::checkVisibility('username')"><label>{{ ::item.username }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordTmUserInfo = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredTmUserInfo.length }} / {{ dataTmUserInfo.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordTmUserInfo = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataTmUserInfo()" ng-disabled="scrollable.dataLoading">
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
						<li><a ng-disabled="scrollable.dataLoading" ng-click="loadDataTmUserInfo()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-disabled="scrollable.dataLoading" ng-click="loadAllDataTmUserInfo()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>

  				<button type="button" class="btn btn-default" data-toggle="button"
					ng-click="details.isDetailTmUserInfo = !details.isDetailTmUserInfo">
					Detail
				</button>
  			</div>
		</div>
		</div>

	</div>
