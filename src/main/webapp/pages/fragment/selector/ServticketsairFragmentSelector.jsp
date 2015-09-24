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
				<spring:message code="default.listof" /> <spring:message code="label.ServTicketsAir" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/servticketsairview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordServTicketsAir" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataServTicketsAir()">
					<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
						<thead>
							<tr>
								<th class="picker-th"></th>
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
						<th ng-if="::checkVisibility('datestartdep')">
							<div ng-click="sort('datestartdep')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateStartDep" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateStartDep, 'fa-caret-up': !details.dateStartDep }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dateendarrival')">
							<div ng-click="sort('dateendarrival')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateEndArrival" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateEndArrival, 'fa-caret-up': !details.dateEndArrival }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dateenddep')">
							<div ng-click="sort('dateenddep')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateEndDep" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateEndDep, 'fa-caret-up': !details.dateEndDep }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('datestartarrival')">
							<div ng-click="sort('datestartarrival')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateStartArrival" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateStartArrival, 'fa-caret-up': !details.dateStartArrival }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytypeplanearrivalid')">
							<div ng-click="sort('dictglobalbytypeplanearrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTypePlaneArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTypePlaneArrivalId, 'fa-caret-up': !details.dictGlobalByTypePlaneArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccountbyaircompanyarrivalid')">
							<div ng-click="sort('tmaccountbyaircompanyarrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccountByAirCompanyArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccountByAirCompanyArrivalId, 'fa-caret-up': !details.tmAccountByAirCompanyArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyairclassid')">
							<div ng-click="sort('dictglobalbyairclassid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByAirclassId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByAirclassId, 'fa-caret-up': !details.dictGlobalByAirclassId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytypeplanedepid')">
							<div ng-click="sort('dictglobalbytypeplanedepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTypePlaneDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTypePlaneDepId, 'fa-caret-up': !details.dictGlobalByTypePlaneDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccountbyaccountid')">
							<div ng-click="sort('tmaccountbyaccountid')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccountByAccountId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccountByAccountId, 'fa-caret-up': !details.tmAccountByAccountId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccountbyaircompanydepid')">
							<div ng-click="sort('tmaccountbyaircompanydepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccountByAirCompanyDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccountByAirCompanyDepId, 'fa-caret-up': !details.tmAccountByAirCompanyDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citybackarrivalid')">
							<div ng-click="sort('citybackarrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityBackArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityBackArrivalId, 'fa-caret-up': !details.cityBackArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citytherearrivalid')">
							<div ng-click="sort('citytherearrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityThereArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityThereArrivalId, 'fa-caret-up': !details.cityThereArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numflightdep')">
							<div ng-click="sort('numflightdep')" >
								<a class="sortable-column-name"><span><spring:message code="label.numFlightDep" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numFlightDep, 'fa-caret-up': !details.numFlightDep }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numflightarrival')">
							<div ng-click="sort('numflightarrival')" >
								<a class="sortable-column-name"><span><spring:message code="label.numFlightArrival" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numFlightArrival, 'fa-caret-up': !details.numFlightArrival }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citytheredepid')">
							<div ng-click="sort('citytheredepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityThereDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityThereDepId, 'fa-caret-up': !details.cityThereDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citybackdepid')">
							<div ng-click="sort('citybackdepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityBackDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityBackDepId, 'fa-caret-up': !details.cityBackDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('airname')">
							<div ng-click="sort('airname')" >
								<a class="sortable-column-name"><span><spring:message code="label.airName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.airName, 'fa-caret-up': !details.airName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredServTicketsAir = ( dataServTicketsAir | filter:searchKeywordServTicketsAir ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('datestartdep')"><label>{{ ::item.datestartdep }}</label></td>
						<td ng-if="::checkVisibility('dateendarrival')"><label>{{ ::item.dateendarrival }}</label></td>
						<td ng-if="::checkVisibility('dateenddep')"><label>{{ ::item.dateenddep }}</label></td>
						<td ng-if="::checkVisibility('datestartarrival')"><label>{{ ::item.datestartarrival }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytypeplanearrival')"><label>{{ ::item.dictglobalbytypeplanearrival }}</label></td>
						<td ng-if="::checkVisibility('tmaccountbyaircompanyarrival')"><label>{{ ::item.tmaccountbyaircompanyarrival }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyairclass')"><label>{{ ::item.dictglobalbyairclass }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytypeplanedep')"><label>{{ ::item.dictglobalbytypeplanedep }}</label></td>
						<td ng-if="::checkVisibility('tmaccountbyaccount')"><label>{{ ::item.tmaccountbyaccount }}</label></td>
						<td ng-if="::checkVisibility('tmaccountbyaircompanydep')"><label>{{ ::item.tmaccountbyaircompanydep }}</label></td>
						<td ng-if="::checkVisibility('citybackarrival')"><label>{{ ::item.citybackarrival }}</label></td>
						<td ng-if="::checkVisibility('citytherearrival')"><label>{{ ::item.citytherearrival }}</label></td>
						<td ng-if="::checkVisibility('numflightdep')"><label>{{ ::item.numflightdep }}</label></td>
						<td ng-if="::checkVisibility('numflightarrival')"><label>{{ ::item.numflightarrival }}</label></td>
						<td ng-if="::checkVisibility('citytheredep')"><label>{{ ::item.citytheredep }}</label></td>
						<td ng-if="::checkVisibility('citybackdep')"><label>{{ ::item.citybackdep }}</label></td>
						<td ng-if="::checkVisibility('airname')"><label>{{ ::item.airname }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredServTicketsAir.length }} / {{ dataServTicketsAir.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataServTicketsAir()">
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
