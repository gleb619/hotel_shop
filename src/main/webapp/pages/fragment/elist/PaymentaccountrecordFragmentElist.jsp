<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('label')">
				<span class="list-group-item-caption"><spring:message code="label.label" /></span>
				<span class="pull-right">{{ ::selectedItem.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('monthinstalamount')">
				<span class="list-group-item-caption"><spring:message code="label.monthinstalAmount" /></span>
				<span class="pull-right">{{ ::selectedItem.monthinstalamount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('overdueamount')">
				<span class="list-group-item-caption"><spring:message code="label.overdueAmount" /></span>
				<span class="pull-right">{{ ::selectedItem.overdueamount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('residualamount')">
				<span class="list-group-item-caption"><spring:message code="label.residualAmount" /></span>
				<span class="pull-right">{{ ::selectedItem.residualamount }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('penalty')">
				<span class="list-group-item-caption"><spring:message code="label.penalty" /></span>
				<span class="pull-right">{{ ::selectedItem.penalty }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('fine')">
				<span class="list-group-item-caption"><spring:message code="label.fine" /></span>
				<span class="pull-right">{{ ::selectedItem.fine }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('recordaccountingdate')">
				<span class="list-group-item-caption"><spring:message code="label.recordAccountingDate" /></span>
				<span class="pull-right">{{ ::selectedItem.recordaccountingdate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrencybypenaltycurrencyid')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrencyByPenaltyCurrencyId" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrencybypenaltycurrencyid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrencybyfinecurrencyid')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrencyByFineCurrencyId" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrencybyfinecurrencyid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrencybymonthinstalcurrencyid')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrencyByMonthinstalCurrencyId" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrencybymonthinstalcurrencyid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrencybyresidualamountcurrencyid')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrencyByResidualAmountCurrencyId" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrencybyresidualamountcurrencyid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('paymentaccount')">
				<span class="list-group-item-caption"><spring:message code="label.paymentAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.paymentaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('currcurrencybyoverdueamountcurrencyid')">
				<span class="list-group-item-caption"><spring:message code="label.currCurrencyByOverdueAmountCurrencyId" /></span>
				<span class="pull-right">{{ ::selectedItem.currcurrencybyoverdueamountcurrencyid.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('overdueinstalmentcount')">
				<span class="list-group-item-caption"><spring:message code="label.overdueInstalmentCount" /></span>
				<span class="pull-right">{{ ::selectedItem.overdueinstalmentcount }}</span>
			</li>

		</ol>
	</div>
</div>