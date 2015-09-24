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
					ng-click="createModalItemPaymentAccountRecord()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemPaymentAccountRecord(selectedItempaymentAccountRecords.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('paymentAccountRecords', 'PaymentAccountRecord', selectedItempaymentAccountRecords.id, itemIndex)">
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
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('monthinstalamount')">
							<div ng-click="sort('monthinstalamount')" >
								<a class="sortable-column-name"><span><spring:message code="label.monthinstalAmount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.monthinstalAmount, 'fa-caret-up': !details.monthinstalAmount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('overdueamount')">
							<div ng-click="sort('overdueamount')" >
								<a class="sortable-column-name"><span><spring:message code="label.overdueAmount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.overdueAmount, 'fa-caret-up': !details.overdueAmount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('residualamount')">
							<div ng-click="sort('residualamount')" >
								<a class="sortable-column-name"><span><spring:message code="label.residualAmount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.residualAmount, 'fa-caret-up': !details.residualAmount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('penalty')">
							<div ng-click="sort('penalty')" >
								<a class="sortable-column-name"><span><spring:message code="label.penalty" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.penalty, 'fa-caret-up': !details.penalty }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('fine')">
							<div ng-click="sort('fine')" >
								<a class="sortable-column-name"><span><spring:message code="label.fine" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.fine, 'fa-caret-up': !details.fine }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('recordaccountingdate')">
							<div ng-click="sort('recordaccountingdate')" >
								<a class="sortable-column-name"><span><spring:message code="label.recordAccountingDate" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.recordAccountingDate, 'fa-caret-up': !details.recordAccountingDate }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrencybypenaltycurrencyid')">
							<div ng-click="sort('currcurrencybypenaltycurrencyid')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrencyByPenaltyCurrencyId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrencyByPenaltyCurrencyId, 'fa-caret-up': !details.currCurrencyByPenaltyCurrencyId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrencybyfinecurrencyid')">
							<div ng-click="sort('currcurrencybyfinecurrencyid')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrencyByFineCurrencyId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrencyByFineCurrencyId, 'fa-caret-up': !details.currCurrencyByFineCurrencyId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrencybymonthinstalcurrencyid')">
							<div ng-click="sort('currcurrencybymonthinstalcurrencyid')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrencyByMonthinstalCurrencyId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrencyByMonthinstalCurrencyId, 'fa-caret-up': !details.currCurrencyByMonthinstalCurrencyId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrencybyresidualamountcurrencyid')">
							<div ng-click="sort('currcurrencybyresidualamountcurrencyid')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrencyByResidualAmountCurrencyId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrencyByResidualAmountCurrencyId, 'fa-caret-up': !details.currCurrencyByResidualAmountCurrencyId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('paymentaccount')">
							<div ng-click="sort('paymentaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentAccount, 'fa-caret-up': !details.paymentAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrencybyoverdueamountcurrencyid')">
							<div ng-click="sort('currcurrencybyoverdueamountcurrencyid')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrencyByOverdueAmountCurrencyId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrencyByOverdueAmountCurrencyId, 'fa-caret-up': !details.currCurrencyByOverdueAmountCurrencyId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('overdueinstalmentcount')">
							<div ng-click="sort('overdueinstalmentcount')" >
								<a class="sortable-column-name"><span><spring:message code="label.overdueInstalmentCount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.overdueInstalmentCount, 'fa-caret-up': !details.overdueInstalmentCount }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.paymentAccountRecords track by $index"
							ng-class="{ 'success' : selectedItempaymentAccountRecords.id == item.id }"
							ng-dblclick="editModalItemPaymentAccountRecord(item.id)"
							ng-click="setSelected('selectedItempaymentAccountRecords', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('monthinstalamount')"><label>{{ ::item.monthinstalamount }}</label></td>
						<td ng-if="::checkVisibility('overdueamount')"><label>{{ ::item.overdueamount }}</label></td>
						<td ng-if="::checkVisibility('residualamount')"><label>{{ ::item.residualamount }}</label></td>
						<td ng-if="::checkVisibility('penalty')"><label>{{ ::item.penalty }}</label></td>
						<td ng-if="::checkVisibility('fine')"><label>{{ ::item.fine }}</label></td>
						<td ng-if="::checkVisibility('recordaccountingdate')"><label>{{ ::item.recordaccountingdate }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybypenaltycurrency')"><label>{{ ::item.currcurrencybypenaltycurrency.label }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyfinecurrency')"><label>{{ ::item.currcurrencybyfinecurrency.label }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybymonthinstalcurrency')"><label>{{ ::item.currcurrencybymonthinstalcurrency.label }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyresidualamountcurrency')"><label>{{ ::item.currcurrencybyresidualamountcurrency.label }}</label></td>
						<td ng-if="::checkVisibility('paymentaccount')"><label>{{ ::item.paymentaccount.label }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyoverdueamountcurrency')"><label>{{ ::item.currcurrencybyoverdueamountcurrency.label }}</label></td>
						<td ng-if="::checkVisibility('overdueinstalmentcount')"><label>{{ ::item.overdueinstalmentcount }}</label></td>
							<td>
								<a ng-click="editModalItemPaymentAccountRecord(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('paymentAccountRecords', 'PaymentAccountRecord', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.paymentAccountRecords.length }}
				</div>
			</div>
		</div>
	</div>
</div>