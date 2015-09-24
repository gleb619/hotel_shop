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
				<spring:message code="default.listof" /> <spring:message code="label.TmAccountDetails" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/tmaccountdetailsview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordTmAccountDetails" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataTmAccountDetails()">
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
						<th ng-if="::checkVisibility('isbase')">
							<div ng-click="sort('isbase')" >
								<a class="sortable-column-name"><span><spring:message code="label.isBase" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.isBase, 'fa-caret-up': !details.isBase }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('isdetail')">
							<div ng-click="sort('isdetail')" >
								<a class="sortable-column-name"><span><spring:message code="label.isDetail" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.isDetail, 'fa-caret-up': !details.isDetail }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bankid')">
							<div ng-click="sort('bankid')" >
								<a class="sortable-column-name"><span><spring:message code="label.bankId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bankId, 'fa-caret-up': !details.bankId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('rnn')">
							<div ng-click="sort('rnn')" >
								<a class="sortable-column-name"><span><spring:message code="label.rnn" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.rnn, 'fa-caret-up': !details.rnn }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bik')">
							<div ng-click="sort('bik')" >
								<a class="sortable-column-name"><span><spring:message code="label.bik" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bik, 'fa-caret-up': !details.bik }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bin')">
							<div ng-click="sort('bin')" >
								<a class="sortable-column-name"><span><spring:message code="label.bin" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bin, 'fa-caret-up': !details.bin }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bankaccount')">
							<div ng-click="sort('bankaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.bankaccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bankaccount, 'fa-caret-up': !details.bankaccount }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredTmAccountDetails = ( dataTmAccountDetails | filter:searchKeywordTmAccountDetails ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('isbase')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.isBase, 'fa fa-lg fa-circle-o': !item.isBase}"></i></td>
						<td ng-if="::checkVisibility('isdetail')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.isDetail, 'fa fa-lg fa-circle-o': !item.isDetail}"></i></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('bank')"><label>{{ ::item.bank }}</label></td>
						<td ng-if="::checkVisibility('rnn')"><label>{{ ::item.rnn }}</label></td>
						<td ng-if="::checkVisibility('bik')"><label>{{ ::item.bik }}</label></td>
						<td ng-if="::checkVisibility('bin')"><label>{{ ::item.bin }}</label></td>
						<td ng-if="::checkVisibility('bankaccount')"><label>{{ ::item.bankaccount }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredTmAccountDetails.length }} / {{ dataTmAccountDetails.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataTmAccountDetails()">
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
