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
						<th ng-if="::checkVisibility('paymentcost')">
							<div ng-click="sort('paymentcost')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentCost" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentCost, 'fa-caret-up': !details.paymentCost }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('costprice')">
							<div ng-click="sort('costprice')" >
								<a class="sortable-column-name"><span><spring:message code="label.costPrice" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.costPrice, 'fa-caret-up': !details.costPrice }"></i>
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
						<th ng-if="::checkVisibility('tmorder')">
							<div ng-click="sort('tmorder')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmOrder" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmOrder, 'fa-caret-up': !details.tmOrder }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmcontact')">
							<div ng-click="sort('tmcontact')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmContact" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmContact, 'fa-caret-up': !details.tmContact }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.paymentContacts track by $index">
						<td ng-if="::checkVisibility('paymentcost')"><label>{{ ::item.paymentcost }}</label></td>
						<td ng-if="::checkVisibility('costprice')"><label>{{ ::item.costprice }}</label></td>
						<td ng-if="::checkVisibility('paymentenddate')"><label>{{ ::item.paymentenddate }}</label></td>
						<td ng-if="::checkVisibility('paymentstartdate')"><label>{{ ::item.paymentstartdate }}</label></td>
						<td ng-if="::checkVisibility('tmorder')"><label>{{ ::item.tmorder }}</label></td>
						<td ng-if="::checkVisibility('tmcontact')"><label>{{ ::item.tmcontact }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredPaymentContact.length }}/{{ selectedItem.paymentContacts.length }}
				</div>
			  </div>
		</div>
	</div>
</div>