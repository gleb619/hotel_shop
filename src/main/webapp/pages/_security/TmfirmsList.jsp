<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="my-container-3 sectors-holder">
	<div class="row sector-header">
		<div class="without-padding margin-bottom-5"
			ng-class="{ 'col-md-1': details.isCollapsedTmFirms, 'col-md-12': !details.isCollapsedTmFirms }">
			<button type="button" class="btn btn-default btn-collapsed" ng-click="details.isCollapsedTmFirms = !details.isCollapsedTmFirms">
				<i class="fa fa-ellipsis-h" ng-show="details.isCollapsedTmFirms"></i>
				<i class="fa fa-times" ng-hide="details.isCollapsedTmFirms"></i>
			</button>
			<div ng-hide="details.isCollapsedTmFirms">
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
					<a href="../data/tmfirms?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA
					</a>
					<a href="../data/tmfirmsview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA FOR VIEW
					</a>
				</div>
			</c:if>
			</div>
		</div>
		<div class="without-padding" ng-class="{ 'col-md-11': details.isCollapsedTmFirms, 'col-md-12': !details.isCollapsedTmFirms }">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordTmFirms" class="form-control"
						placeholder="<spring:message code="default.filterKeyword" />"
						tabindex="1"/>
                   	<i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="sector-1">
		<div class="col-md-12 without-padding"
			ng-class="{ 'scrollable-content-84': details.isDetailTmFirms, 'scrollable-content-65': !details.isDetailTmFirms }">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataTmFirms()">
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
						<th ng-show="checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.label"></i>
								<i class="fa fa-caret-up" ng-hide="details.label"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('lastpay')">
							<div ng-click="sort('lastpay')" >
								<a class="sortable-column-name"><span><spring:message code="label.lastpay" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.lastpay"></i>
								<i class="fa fa-caret-up" ng-hide="details.lastpay"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('accountid')">
							<div ng-click="sort('accountid')" >
								<a class="sortable-column-name"><span><spring:message code="label.accountid" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.accountid"></i>
								<i class="fa fa-caret-up" ng-hide="details.accountid"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('mounthcount')">
							<div ng-click="sort('mounthcount')" >
								<a class="sortable-column-name"><span><spring:message code="label.mounthcount" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.mounthcount"></i>
								<i class="fa fa-caret-up" ng-hide="details.mounthcount"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('active')">
							<div ng-click="sort('active')" >
								<a class="sortable-column-name"><span><spring:message code="label.active" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.active"></i>
								<i class="fa fa-caret-up" ng-hide="details.active"></i>
							</div>
						</th>
						<th ng-show="checkVisibility('firmname')">
							<div ng-click="sort('firmname')" >
								<a class="sortable-column-name"><span><spring:message code="label.firmName" /></span></a>
								<i class="fa fa-caret-down" ng-show="details.firmName"></i>
								<i class="fa fa-caret-up" ng-hide="details.firmName"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="item in filteredTmFirms = ( dataTmFirms | filter:searchKeywordTmFirms | orderBy: details.sortableColumn: details.sortableReverse )"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ item.id }}</td>
					</c:if>
						<td ng-show="checkVisibility('label')"><label>{{ item.label }}</label></td>
						<td ng-show="checkVisibility('lastpay')"><label>{{ item.lastpay }}</label></td>
						<td ng-show="checkVisibility('accountid')"><label>{{ item.account }}</label></td>
						<td ng-show="checkVisibility('mounthcount')"><label>{{ item.mounthcount }}</label></td>
						<td ng-show="checkVisibility('active')"><label>{{ item.active }}</label></td>
						<td ng-show="checkVisibility('firmname')"><label>{{ item.firmName }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordTmFirms = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredTmFirms.length }} / {{ dataTmFirms.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordTmFirms = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataTmFirms()" ng-disabled="scrollable.dataLoading">
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
						<li><a ng-disabled="scrollable.dataLoading" ng-click="loadDataTmFirms()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-disabled="scrollable.dataLoading" ng-click="loadAllDataTmFirms()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>

  				<button type="button" class="btn btn-default" data-toggle="button"
					ng-click="details.isDetailTmFirms = !details.isDetailTmFirms">
					Detail
				</button>
  			</div>
		</div>
		</div>

	</div>
