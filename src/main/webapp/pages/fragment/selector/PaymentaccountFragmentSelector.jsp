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
				<spring:message code="default.listof" /> <spring:message code="label.PaymentAccount" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/paymentaccountview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordPaymentAccount" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataPaymentAccount()">
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
						<th ng-if="::checkVisibility('paymentenddate')">
							<div ng-click="sort('paymentenddate')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentEndDate" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentEndDate, 'fa-caret-up': !details.paymentEndDate }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('paymentstartdate')">
							<div ng-click="sort('paymentstartdate')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentStartDate" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentStartDate, 'fa-caret-up': !details.paymentStartDate }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbypaymentmethodid')">
							<div ng-click="sort('dictglobalbypaymentmethodid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPaymentMethodId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPaymentMethodId, 'fa-caret-up': !details.dictGlobalByPaymentMethodId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmorder')">
							<div ng-click="sort('tmorder')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmOrder" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmOrder, 'fa-caret-up': !details.tmOrder }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyservicetypeid')">
							<div ng-click="sort('dictglobalbyservicetypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByServiceTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByServiceTypeId, 'fa-caret-up': !details.dictGlobalByServiceTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('infoservices')">
							<div ng-click="sort('infoservices')" >
								<a class="sortable-column-name"><span><spring:message code="label.infoServices" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.infoServices, 'fa-caret-up': !details.infoServices }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('paymentcost')">
							<div ng-click="sort('paymentcost')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentCost" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentCost, 'fa-caret-up': !details.paymentCost }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredPaymentAccount = ( dataPaymentAccount | filter:searchKeywordPaymentAccount ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('paymentenddate')"><label>{{ ::item.paymentenddate }}</label></td>
						<td ng-if="::checkVisibility('paymentstartdate')"><label>{{ ::item.paymentstartdate }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbypaymentmethod')"><label>{{ ::item.dictglobalbypaymentmethod }}</label></td>
						<td ng-if="::checkVisibility('tmorder')"><label>{{ ::item.tmorder }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyservicetype')"><label>{{ ::item.dictglobalbyservicetype }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('infoservices')"><label>{{ ::item.infoservices }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('paymentcost')"><label>{{ ::item.paymentcost }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredPaymentAccount.length }} / {{ dataPaymentAccount.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataPaymentAccount()">
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
