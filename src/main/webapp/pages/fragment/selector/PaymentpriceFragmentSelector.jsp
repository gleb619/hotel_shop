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
				<spring:message code="default.listof" /> <spring:message code="label.PaymentPrice" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/paymentpriceview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordPaymentPrice" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataPaymentPrice()">
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
						<th ng-if="::checkVisibility('vat')">
							<div ng-click="sort('vat')" >
								<a class="sortable-column-name"><span><spring:message code="label.vat" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.vat, 'fa-caret-up': !details.vat }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('course')">
							<div ng-click="sort('course')" >
								<a class="sortable-column-name"><span><spring:message code="label.course" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.course, 'fa-caret-up': !details.course }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('value')">
							<div ng-click="sort('value')" >
								<a class="sortable-column-name"><span><spring:message code="label.value" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.value, 'fa-caret-up': !details.value }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('paymenttariff')">
							<div ng-click="sort('paymenttariff')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentTariff" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentTariff, 'fa-caret-up': !details.paymentTariff }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('humannumber')">
							<div ng-click="sort('humannumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.humannumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.humannumber, 'fa-caret-up': !details.humannumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('discount')">
							<div ng-click="sort('discount')" >
								<a class="sortable-column-name"><span><spring:message code="label.discount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.discount, 'fa-caret-up': !details.discount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('commission')">
							<div ng-click="sort('commission')" >
								<a class="sortable-column-name"><span><spring:message code="label.commission" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.commission, 'fa-caret-up': !details.commission }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredPaymentPrice = ( dataPaymentPrice | filter:searchKeywordPaymentPrice ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('vat')"><label>{{ ::item.vat }}</label></td>
						<td ng-if="::checkVisibility('course')"><label>{{ ::item.course }}</label></td>
						<td ng-if="::checkVisibility('value')"><label>{{ ::item.value }}</label></td>
						<td ng-if="::checkVisibility('paymenttariff')"><label>{{ ::item.paymenttariff }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('humannumber')"><label>{{ ::item.humannumber }}</label></td>
						<td ng-if="::checkVisibility('discount')"><label>{{ ::item.discount }}</label></td>
						<td ng-if="::checkVisibility('commission')"><label>{{ ::item.commission }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredPaymentPrice.length }} / {{ dataPaymentPrice.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataPaymentPrice()">
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
