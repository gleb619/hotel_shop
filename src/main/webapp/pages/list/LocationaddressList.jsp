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
				<a href="../data/locationaddress?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/locationaddressview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordLocationAddress" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredLocationAddress', 'dataLocationAddress', searchKeywordLocationAddress)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataLocationAddress()">
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
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('gmappointx')">
							<div ng-click="sort('gmappointx')" >
								<a class="sortable-column-name"><span><spring:message code="label.gmapPointX" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.gmapPointX, 'fa-caret-up': !details.gmapPointX }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('gmappointy')">
							<div ng-click="sort('gmappointy')" >
								<a class="sortable-column-name"><span><spring:message code="label.gmapPointY" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.gmapPointY, 'fa-caret-up': !details.gmapPointY }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('metro')">
							<div ng-click="sort('metro')" >
								<a class="sortable-column-name"><span><spring:message code="label.metro" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.metro, 'fa-caret-up': !details.metro }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('yandexmappointx')">
							<div ng-click="sort('yandexmappointx')" >
								<a class="sortable-column-name"><span><spring:message code="label.yandexMapPointX" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.yandexMapPointX, 'fa-caret-up': !details.yandexMapPointX }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roadmap')">
							<div ng-click="sort('roadmap')" >
								<a class="sortable-column-name"><span><spring:message code="label.roadMap" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roadMap, 'fa-caret-up': !details.roadMap }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('yandexmappointy')">
							<div ng-click="sort('yandexmappointy')" >
								<a class="sortable-column-name"><span><spring:message code="label.yandexMapPointY" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.yandexMapPointY, 'fa-caret-up': !details.yandexMapPointY }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredLocationAddress = ( dataLocationAddress | filter:searchKeywordLocationAddress | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredLocationAddress track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('gmappointx')"><label>{{ ::item.gmappointx }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('gmappointy')"><label>{{ ::item.gmappointy }}</label></td>
						<td ng-if="::checkVisibility('metro')"><label>{{ ::item.metro }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('yandexmappointx')"><label>{{ ::item.yandexmappointx }}</label></td>
						<td ng-if="::checkVisibility('roadmap')"><label>{{ ::item.roadmap }}</label></td>
						<td ng-if="::checkVisibility('yandexmappointy')"><label>{{ ::item.yandexmappointy }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordLocationAddress = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredLocationAddress.length }} / {{ dataLocationAddress.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordLocationAddress = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataLocationAddress()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataLocationAddress()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataLocationAddress()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
</div>
