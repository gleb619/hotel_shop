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
				<a href="../data/servhotelroom?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/servhotelroomview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordServHotelRoom" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredServHotelRoom', 'dataServHotelRoom', searchKeywordServHotelRoom)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataServHotelRoom()">
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
						<th ng-if="::checkVisibility('breakfast')">
							<div ng-click="sort('breakfast')" >
								<a class="sortable-column-name"><span><spring:message code="label.breakfast" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.breakfast, 'fa-caret-up': !details.breakfast }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyfoodid')">
							<div ng-click="sort('dictglobalbyfoodid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByFoodId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByFoodId, 'fa-caret-up': !details.dictGlobalByFoodId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyroomtypeid')">
							<div ng-click="sort('dictglobalbyroomtypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByRoomTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByRoomTypeId, 'fa-caret-up': !details.dictGlobalByRoomTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('groupglobal')">
							<div ng-click="sort('groupglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.groupGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.groupGlobal, 'fa-caret-up': !details.groupGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roomnumber')">
							<div ng-click="sort('roomnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.roomNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roomNumber, 'fa-caret-up': !details.roomNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('guestnumber')">
							<div ng-click="sort('guestnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.guestNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.guestNumber, 'fa-caret-up': !details.guestNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('category')">
							<div ng-click="sort('category')" >
								<a class="sortable-column-name"><span><spring:message code="label.category" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.category, 'fa-caret-up': !details.category }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descriptioncollapsed')">
							<div ng-click="sort('descriptioncollapsed')" >
								<a class="sortable-column-name"><span><spring:message code="label.descriptioncollapsed" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descriptioncollapsed, 'fa-caret-up': !details.descriptioncollapsed }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredServHotelRoom = ( dataServHotelRoom | filter:searchKeywordServHotelRoom | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredServHotelRoom track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('breakfast')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.breakfast, 'fa fa-lg fa-circle-o': !item.breakfast}"></i></td>
						<td ng-if="::checkVisibility('dictglobalbyfoodid')"><label>{{ ::item.dictglobalbyfood }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyroomtypeid')"><label>{{ ::item.dictglobalbyroomtype }}</label></td>
						<td ng-if="::checkVisibility('groupglobal')"><label>{{ ::item.groupglobal }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('roomnumber')"><label>{{ ::item.roomnumber }}</label></td>
						<td ng-if="::checkVisibility('guestnumber')"><label>{{ ::item.guestnumber }}</label></td>
						<td ng-if="::checkVisibility('category')"><label>{{ ::item.category }}</label></td>
						<td ng-if="::checkVisibility('descriptioncollapsed')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.descriptioncollapsed, 'fa fa-lg fa-circle-o': !item.descriptioncollapsed}"></i></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordServHotelRoom = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredServHotelRoom.length }} / {{ dataServHotelRoom.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordServHotelRoom = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataServHotelRoom()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataServHotelRoom()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataServHotelRoom()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset type="pills">
			
					<tab select="initTab('reqservhotelroombusy', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqServHotelRoomBusy"/></tab-heading>
						
						<div ng-if="templates.reqservhotelroombusy.fragmentlist.init" ng-include="templates.reqservhotelroombusy.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelroomfeatures', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelRoomFeatures"/></tab-heading>
						
						<div ng-if="templates.relservhotelroomfeatures.fragmentlist.init" ng-include="templates.relservhotelroomfeatures.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reqhotelroomsbusy', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqHotelRoomsBusy"/></tab-heading>
						
						<div ng-if="templates.reqhotelroomsbusy.fragmentlist.init" ng-include="templates.reqhotelroomsbusy.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reqservhotel', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqServHotel"/></tab-heading>
						
						<div ng-if="templates.reqservhotel.fragmentlist.init" ng-include="templates.reqservhotel.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelroomimage', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelRoomImage"/></tab-heading>
						
						<div ng-if="templates.relservhotelroomimage.fragmentlist.init" ng-include="templates.relservhotelroomimage.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('paymenttariff', 'fragmentlist')">
						<tab-heading><spring:message code="label.PaymentTariff"/></tab-heading>
						
						<div ng-if="templates.paymenttariff.fragmentlist.init" ng-include="templates.paymenttariff.fragmentlist.url"></div>
					</tab>
					
					<tab>
						<tab-heading>
							<spring:message code="label.descr"/>
						</tab-heading>
						
						<div class="custom-textarea-holder">
							<pre ng-bind-html="selectedItem.descr"></pre>
						</div>
					</tab>
					
					
			</tabset>
		</div>
	</div>
	</div>
