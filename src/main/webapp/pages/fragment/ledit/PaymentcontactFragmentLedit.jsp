<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div>
	<div class="row">
		<div class="padding-left-right-15">
			<div class="btn-group without-padding display-block toolbar-panel margin-bottom-5">
				<button type="button" class="btn btn-default btn-create"
					ng-click="createModalItemPaymentContact()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemPaymentContact(selectedItempaymentContacts.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('paymentContacts', 'PaymentContact', selectedItempaymentContacts.id, itemIndex)">
					<i class="glyphicon glyphicon-trash pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.delete" /></span>
				</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive margin-bottom-5 table-body ledit-scroll">
				<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
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

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.paymentContacts track by $index"
							ng-class="{ 'success' : selectedItempaymentContacts.id == item.id }"
							ng-dblclick="editModalItemPaymentContact(item.id)"
							ng-click="setSelected('selectedItempaymentContacts', item, $index)">
						<td ng-if="::checkVisibility('paymentcost')"><label>{{ ::item.paymentcost }}</label></td>
						<td ng-if="::checkVisibility('costprice')"><label>{{ ::item.costprice }}</label></td>
						<td ng-if="::checkVisibility('paymentenddate')"><label>{{ ::item.paymentenddate }}</label></td>
						<td ng-if="::checkVisibility('paymentstartdate')"><label>{{ ::item.paymentstartdate }}</label></td>
						<td ng-if="::checkVisibility('tmorder')"><label>{{ ::item.tmorder.label }}</label></td>
						<td ng-if="::checkVisibility('tmcontact')"><label>{{ ::item.tmcontact.label }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal.label }}</label></td>
							<td>
								<a ng-click="editModalItemPaymentContact(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('paymentContacts', 'PaymentContact', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.paymentContacts.length }}
				</div>
			</div>
		</div>
	</div>
</div>