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
				<a href="../data/reqservhotel?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/reqservhotelview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordReqServHotel" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredReqServHotel', 'dataReqServHotel', searchKeywordReqServHotel)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataReqServHotel()">
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
						<th ng-if="::checkVisibility('price')">
							<div ng-click="sort('price')" >
								<a class="sortable-column-name"><span><spring:message code="label.price" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.price, 'fa-caret-up': !details.price }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('accept')">
							<div ng-click="sort('accept')" >
								<a class="sortable-column-name"><span><spring:message code="label.accept" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.accept, 'fa-caret-up': !details.accept }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('decline')">
							<div ng-click="sort('decline')" >
								<a class="sortable-column-name"><span><spring:message code="label.decline" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.decline, 'fa-caret-up': !details.decline }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('race')">
							<div ng-click="sort('race')" >
								<a class="sortable-column-name"><span><spring:message code="label.race" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.race, 'fa-caret-up': !details.race }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('departure')">
							<div ng-click="sort('departure')" >
								<a class="sortable-column-name"><span><spring:message code="label.departure" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.departure, 'fa-caret-up': !details.departure }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbypaymenttypeid')">
							<div ng-click="sort('dictglobalbypaymenttypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPaymentTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPaymentTypeId, 'fa-caret-up': !details.dictGlobalByPaymentTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('usersbyrequestuserid')">
							<div ng-click="sort('usersbyrequestuserid')" >
								<a class="sortable-column-name"><span><spring:message code="label.usersByRequestUserId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.usersByRequestUserId, 'fa-caret-up': !details.usersByRequestUserId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('usersbyresponseuserid')">
							<div ng-click="sort('usersbyresponseuserid')" >
								<a class="sortable-column-name"><span><spring:message code="label.usersByResponseUserId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.usersByResponseUserId, 'fa-caret-up': !details.usersByResponseUserId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('docdocumentsbydocumentforhotelid')">
							<div ng-click="sort('docdocumentsbydocumentforhotelid')" >
								<a class="sortable-column-name"><span><spring:message code="label.docDocumentsByDocumentForHotelId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.docDocumentsByDocumentForHotelId, 'fa-caret-up': !details.docDocumentsByDocumentForHotelId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyplacementid')">
							<div ng-click="sort('dictglobalbyplacementid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPlacementId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPlacementId, 'fa-caret-up': !details.dictGlobalByPlacementId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotelroom')">
							<div ng-click="sort('servhotelroom')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotelRoom" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotelRoom, 'fa-caret-up': !details.servHotelRoom }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('docdocumentsbydocumentforuserid')">
							<div ng-click="sort('docdocumentsbydocumentforuserid')" >
								<a class="sortable-column-name"><span><spring:message code="label.docDocumentsByDocumentForUserId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.docDocumentsByDocumentForUserId, 'fa-caret-up': !details.docDocumentsByDocumentForUserId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roomcount')">
							<div ng-click="sort('roomcount')" >
								<a class="sortable-column-name"><span><spring:message code="label.roomCount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roomCount, 'fa-caret-up': !details.roomCount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('progress')">
							<div ng-click="sort('progress')" >
								<a class="sortable-column-name"><span><spring:message code="label.progress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.progress, 'fa-caret-up': !details.progress }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredReqServHotel = ( dataReqServHotel | filter:searchKeywordReqServHotel | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredReqServHotel track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('accept')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.accept, 'fa fa-lg fa-circle-o': !item.accept}"></i></td>
						<td ng-if="::checkVisibility('decline')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.decline, 'fa fa-lg fa-circle-o': !item.decline}"></i></td>
						<td ng-if="::checkVisibility('race')"><label>{{ ::item.race }}</label></td>
						<td ng-if="::checkVisibility('departure')"><label>{{ ::item.departure }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbypaymenttypeid')"><label>{{ ::item.dictglobalbypaymenttype }}</label></td>
						<td ng-if="::checkVisibility('usersbyrequestuserid')"><label>{{ ::item.usersbyrequestuser }}</label></td>
						<td ng-if="::checkVisibility('usersbyresponseuserid')"><label>{{ ::item.usersbyresponseuser }}</label></td>
						<td ng-if="::checkVisibility('docdocumentsbydocumentforhotelid')"><label>{{ ::item.docdocumentsbydocumentforhotel }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyplacementid')"><label>{{ ::item.dictglobalbyplacement }}</label></td>
						<td ng-if="::checkVisibility('servhotelroom')"><label>{{ ::item.servhotelroom }}</label></td>
						<td ng-if="::checkVisibility('docdocumentsbydocumentforuserid')"><label>{{ ::item.docdocumentsbydocumentforuser }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('roomcount')"><label>{{ ::item.roomcount }}</label></td>
						<td ng-if="::checkVisibility('progress')"><label>{{ ::item.progress }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordReqServHotel = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredReqServHotel.length }} / {{ dataReqServHotel.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordReqServHotel = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataReqServHotel()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataReqServHotel()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataReqServHotel()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset >
			
					<tab select="initTab('relreqservhoteltmcontacteasy', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelReqServHotelTmContactEasy"/></tab-heading>
						
						<div ng-if="templates.relreqservhoteltmcontacteasy.fragmentlist.init" ng-include="templates.relreqservhoteltmcontacteasy.fragmentlist.url"></div>
					</tab>
					
					<tab>
						<tab-heading>
							<spring:message code="label.descrInternal"/>
						</tab-heading>
						
						<div class="custom-textarea-holder">
							<pre ng-bind-html="selectedItem.descrinternal"></pre>
						</div>
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
