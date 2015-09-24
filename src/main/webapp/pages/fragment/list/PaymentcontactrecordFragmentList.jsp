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
						<th ng-if="::checkVisibility('paymentcontact')">
							<div ng-click="sort('paymentcontact')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentContact" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentContact, 'fa-caret-up': !details.paymentContact }"></i>
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

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.paymentContactRecords track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('monthinstalamount')"><label>{{ ::item.monthinstalamount }}</label></td>
						<td ng-if="::checkVisibility('overdueamount')"><label>{{ ::item.overdueamount }}</label></td>
						<td ng-if="::checkVisibility('residualamount')"><label>{{ ::item.residualamount }}</label></td>
						<td ng-if="::checkVisibility('penalty')"><label>{{ ::item.penalty }}</label></td>
						<td ng-if="::checkVisibility('fine')"><label>{{ ::item.fine }}</label></td>
						<td ng-if="::checkVisibility('recordaccountingdate')"><label>{{ ::item.recordaccountingdate }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybypenaltycurrencyid')"><label>{{ ::item.currcurrencybypenaltycurrency }}</label></td>
						<td ng-if="::checkVisibility('paymentcontact')"><label>{{ ::item.paymentcontact }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyfinecurrencyid')"><label>{{ ::item.currcurrencybyfinecurrency }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybymonthinstalcurrencyid')"><label>{{ ::item.currcurrencybymonthinstalcurrency }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyresidualamountcurrencyid')"><label>{{ ::item.currcurrencybyresidualamountcurrency }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyoverdueamountcurrencyid')"><label>{{ ::item.currcurrencybyoverdueamountcurrency }}</label></td>
						<td ng-if="::checkVisibility('overdueinstalmentcount')"><label>{{ ::item.overdueinstalmentcount }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredPaymentContactRecord.length }}/{{ selectedItem.paymentContactRecords.length }}
				</div>
			  </div>
		</div>
	</div>
</div>