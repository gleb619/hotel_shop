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
				<a href="../data/infoservices?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/infoservicesview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordInfoServices" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredInfoServices', 'dataInfoServices', searchKeywordInfoServices)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataInfoServices()">
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
						<th ng-if="::checkVisibility('servtour')">
							<div ng-click="sort('servtour')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTour" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTour, 'fa-caret-up': !details.servTour }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servinsurances')">
							<div ng-click="sort('servinsurances')" >
								<a class="sortable-column-name"><span><spring:message code="label.servInsurances" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servInsurances, 'fa-caret-up': !details.servInsurances }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servticketsrail')">
							<div ng-click="sort('servticketsrail')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTicketsRail" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTicketsRail, 'fa-caret-up': !details.servTicketsRail }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servexcursions')">
							<div ng-click="sort('servexcursions')" >
								<a class="sortable-column-name"><span><spring:message code="label.servExcursions" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servExcursions, 'fa-caret-up': !details.servExcursions }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servvisas')">
							<div ng-click="sort('servvisas')" >
								<a class="sortable-column-name"><span><spring:message code="label.servVisas" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servVisas, 'fa-caret-up': !details.servVisas }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servtransfer')">
							<div ng-click="sort('servtransfer')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTransfer" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTransfer, 'fa-caret-up': !details.servTransfer }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servgifts')">
							<div ng-click="sort('servgifts')" >
								<a class="sortable-column-name"><span><spring:message code="label.servGifts" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servGifts, 'fa-caret-up': !details.servGifts }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servticketsair')">
							<div ng-click="sort('servticketsair')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTicketsAir" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTicketsAir, 'fa-caret-up': !details.servTicketsAir }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servcruise')">
							<div ng-click="sort('servcruise')" >
								<a class="sortable-column-name"><span><spring:message code="label.servCruise" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servCruise, 'fa-caret-up': !details.servCruise }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredInfoServices = ( dataInfoServices | filter:searchKeywordInfoServices | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredInfoServices track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('servtour')"><label>{{ ::item.servtour }}</label></td>
						<td ng-if="::checkVisibility('servinsurances')"><label>{{ ::item.servinsurances }}</label></td>
						<td ng-if="::checkVisibility('servticketsrail')"><label>{{ ::item.servticketsrail }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						<td ng-if="::checkVisibility('servexcursions')"><label>{{ ::item.servexcursions }}</label></td>
						<td ng-if="::checkVisibility('servvisas')"><label>{{ ::item.servvisas }}</label></td>
						<td ng-if="::checkVisibility('servtransfer')"><label>{{ ::item.servtransfer }}</label></td>
						<td ng-if="::checkVisibility('servgifts')"><label>{{ ::item.servgifts }}</label></td>
						<td ng-if="::checkVisibility('servticketsair')"><label>{{ ::item.servticketsair }}</label></td>
						<td ng-if="::checkVisibility('servcruise')"><label>{{ ::item.servcruise }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordInfoServices = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredInfoServices.length }} / {{ dataInfoServices.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordInfoServices = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataInfoServices()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataInfoServices()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataInfoServices()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset >
			
					<tab select="initTab('reqcruiseservices', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqCruiseServices"/></tab-heading>
						
						<div ng-if="templates.reqcruiseservices.fragmentlist.init" ng-include="templates.reqcruiseservices.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('paymentaccount', 'fragmentlist')">
						<tab-heading><spring:message code="label.PaymentAccount"/></tab-heading>
						
						<div ng-if="templates.paymentaccount.fragmentlist.init" ng-include="templates.paymentaccount.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reltmorderinfoservices', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelTmOrderInfoServices"/></tab-heading>
						
						<div ng-if="templates.reltmorderinfoservices.fragmentlist.init" ng-include="templates.reltmorderinfoservices.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reltourservices', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelTourServices"/></tab-heading>
						
						<div ng-if="templates.reltourservices.fragmentlist.init" ng-include="templates.reltourservices.fragmentlist.url"></div>
					</tab>
					
					
			</tabset>
		</div>
	</div>
	</div>
