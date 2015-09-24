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
				<a href="../data/paymentaccountrecord?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/paymentaccountrecordview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordPaymentAccountRecord" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredPaymentAccountRecord', 'dataPaymentAccountRecord', searchKeywordPaymentAccountRecord)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataPaymentAccountRecord()">
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
					<!-- <tr ng-repeat="item in filteredPaymentAccountRecord = ( dataPaymentAccountRecord | filter:searchKeywordPaymentAccountRecord | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredPaymentAccountRecord track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('monthinstalamount')"><label>{{ ::item.monthinstalamount }}</label></td>
						<td ng-if="::checkVisibility('overdueamount')"><label>{{ ::item.overdueamount }}</label></td>
						<td ng-if="::checkVisibility('residualamount')"><label>{{ ::item.residualamount }}</label></td>
						<td ng-if="::checkVisibility('penalty')"><label>{{ ::item.penalty }}</label></td>
						<td ng-if="::checkVisibility('fine')"><label>{{ ::item.fine }}</label></td>
						<td ng-if="::checkVisibility('recordaccountingdate')"><label>{{ ::item.recordaccountingdate }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybypenaltycurrencyid')"><label>{{ ::item.currcurrencybypenaltycurrency }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyfinecurrencyid')"><label>{{ ::item.currcurrencybyfinecurrency }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybymonthinstalcurrencyid')"><label>{{ ::item.currcurrencybymonthinstalcurrency }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyresidualamountcurrencyid')"><label>{{ ::item.currcurrencybyresidualamountcurrency }}</label></td>
						<td ng-if="::checkVisibility('paymentaccount')"><label>{{ ::item.paymentaccount }}</label></td>
						<td ng-if="::checkVisibility('currcurrencybyoverdueamountcurrencyid')"><label>{{ ::item.currcurrencybyoverdueamountcurrency }}</label></td>
						<td ng-if="::checkVisibility('overdueinstalmentcount')"><label>{{ ::item.overdueinstalmentcount }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordPaymentAccountRecord = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredPaymentAccountRecord.length }} / {{ dataPaymentAccountRecord.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordPaymentAccountRecord = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataPaymentAccountRecord()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataPaymentAccountRecord()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataPaymentAccountRecord()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
</div>
