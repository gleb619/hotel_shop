<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="padding-top-10">
	<div class="row">
			<div class="col-md-12">
			  <div class="table-responsive">
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr>
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
						<tr ng-repeat="item in selectedItem.paymentAccounts track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('paymentenddate')"><label>{{ ::item.paymentenddate }}</label></td>
						<td ng-if="::checkVisibility('paymentstartdate')"><label>{{ ::item.paymentstartdate }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbypaymentmethodid')"><label>{{ ::item.dictglobalbypaymentmethod }}</label></td>
						<td ng-if="::checkVisibility('tmorder')"><label>{{ ::item.tmorder }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyservicetypeid')"><label>{{ ::item.dictglobalbyservicetype }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('infoservices')"><label>{{ ::item.infoservices }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('paymentcost')"><label>{{ ::item.paymentcost }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredPaymentAccount.length }}/{{ selectedItem.paymentAccounts.length }}
				</div>
			  </div>
		</div>
	</div>
</div>