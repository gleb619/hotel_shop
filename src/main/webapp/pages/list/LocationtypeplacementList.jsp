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
				<a href="../data/locationtypeplacement?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/locationtypeplacementview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordLocationTypePlacement" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredLocationTypePlacement', 'dataLocationTypePlacement', searchKeywordLocationTypePlacement)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataLocationTypePlacement()">
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
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numberofbuildings')">
							<div ng-click="sort('numberofbuildings')" >
								<a class="sortable-column-name"><span><spring:message code="label.numberOfBuildings" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numberOfBuildings, 'fa-caret-up': !details.numberOfBuildings }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numberofrooms')">
							<div ng-click="sort('numberofrooms')" >
								<a class="sortable-column-name"><span><spring:message code="label.numberOfRooms" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numberOfRooms, 'fa-caret-up': !details.numberOfRooms }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('availablenumberofrooms')">
							<div ng-click="sort('availablenumberofrooms')" >
								<a class="sortable-column-name"><span><spring:message code="label.availableNumberOfRooms" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.availableNumberOfRooms, 'fa-caret-up': !details.availableNumberOfRooms }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('availablenumberoflevels')">
							<div ng-click="sort('availablenumberoflevels')" >
								<a class="sortable-column-name"><span><spring:message code="label.availableNumberOfLevels" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.availableNumberOfLevels, 'fa-caret-up': !details.availableNumberOfLevels }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numberoflevels')">
							<div ng-click="sort('numberoflevels')" >
								<a class="sortable-column-name"><span><spring:message code="label.numberOfLevels" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numberOfLevels, 'fa-caret-up': !details.numberOfLevels }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotelid')">
							<div ng-click="sort('servhotelid')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotelId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotelId, 'fa-caret-up': !details.servHotelId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('availablenumberofbuildings')">
							<div ng-click="sort('availablenumberofbuildings')" >
								<a class="sortable-column-name"><span><spring:message code="label.availableNumberOfBuildings" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.availableNumberOfBuildings, 'fa-caret-up': !details.availableNumberOfBuildings }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('value')">
							<div ng-click="sort('value')" >
								<a class="sortable-column-name"><span><spring:message code="label.value" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.value, 'fa-caret-up': !details.value }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('valueeng')">
							<div ng-click="sort('valueeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.valueeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.valueeng, 'fa-caret-up': !details.valueeng }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredLocationTypePlacement = ( dataLocationTypePlacement | filter:searchKeywordLocationTypePlacement | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredLocationTypePlacement track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						<td ng-if="::checkVisibility('numberofbuildings')"><label>{{ ::item.numberofbuildings }}</label></td>
						<td ng-if="::checkVisibility('numberofrooms')"><label>{{ ::item.numberofrooms }}</label></td>
						<td ng-if="::checkVisibility('availablenumberofrooms')"><label>{{ ::item.availablenumberofrooms }}</label></td>
						<td ng-if="::checkVisibility('availablenumberoflevels')"><label>{{ ::item.availablenumberoflevels }}</label></td>
						<td ng-if="::checkVisibility('numberoflevels')"><label>{{ ::item.numberoflevels }}</label></td>
						<td ng-if="::checkVisibility('servhotelid')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('availablenumberofbuildings')"><label>{{ ::item.availablenumberofbuildings }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('value')"><label>{{ ::item.value }}</label></td>
						<td ng-if="::checkVisibility('valueeng')"><label>{{ ::item.valueeng }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordLocationTypePlacement = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredLocationTypePlacement.length }} / {{ dataLocationTypePlacement.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordLocationTypePlacement = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataLocationTypePlacement()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataLocationTypePlacement()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataLocationTypePlacement()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
</div>
