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
				<spring:message code="default.listof" /> <spring:message code="label.ServTransfer" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/servtransferview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordServTransfer" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataServTransfer()">
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
						<th ng-if="::checkVisibility('datefrom')">
							<div ng-click="sort('datefrom')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateFrom" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateFrom, 'fa-caret-up': !details.dateFrom }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dateto')">
							<div ng-click="sort('dateto')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateTo" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateTo, 'fa-caret-up': !details.dateTo }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbypaymenttypeid')">
							<div ng-click="sort('dictglobalbypaymenttypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPaymentTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPaymentTypeId, 'fa-caret-up': !details.dictGlobalByPaymentTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcities')">
							<div ng-click="sort('locationcities')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCities" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCities, 'fa-caret-up': !details.locationCities }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytransportid')">
							<div ng-click="sort('dictglobalbytransportid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTransportId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTransportId, 'fa-caret-up': !details.dictGlobalByTransportId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytypetransferid')">
							<div ng-click="sort('dictglobalbytypetransferid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTypeTransferId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTypeTransferId, 'fa-caret-up': !details.dictGlobalByTypeTransferId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passengersphones')">
							<div ng-click="sort('passengersphones')" >
								<a class="sortable-column-name"><span><spring:message code="label.passengersPhones" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passengersPhones, 'fa-caret-up': !details.passengersPhones }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('visittable')">
							<div ng-click="sort('visittable')" >
								<a class="sortable-column-name"><span><spring:message code="label.visitTable" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.visitTable, 'fa-caret-up': !details.visitTable }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('transfername')">
							<div ng-click="sort('transfername')" >
								<a class="sortable-column-name"><span><spring:message code="label.transferName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.transferName, 'fa-caret-up': !details.transferName }"></i>
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
							<tr ng-repeat="item in filteredServTransfer = ( dataServTransfer | filter:searchKeywordServTransfer ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('datefrom')"><label>{{ ::item.datefrom }}</label></td>
						<td ng-if="::checkVisibility('dateto')"><label>{{ ::item.dateto }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbypaymenttype')"><label>{{ ::item.dictglobalbypaymenttype }}</label></td>
						<td ng-if="::checkVisibility('locationcities')"><label>{{ ::item.locationcities }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytransport')"><label>{{ ::item.dictglobalbytransport }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytypetransfer')"><label>{{ ::item.dictglobalbytypetransfer }}</label></td>
						<td ng-if="::checkVisibility('passengersphones')"><label>{{ ::item.passengersphones }}</label></td>
						<td ng-if="::checkVisibility('visittable')"><label>{{ ::item.visittable }}</label></td>
						<td ng-if="::checkVisibility('transfername')"><label>{{ ::item.transfername }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredServTransfer.length }} / {{ dataServTransfer.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataServTransfer()">
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
