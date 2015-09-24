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
				<spring:message code="default.listof" /> <spring:message code="label.PaymentDetails" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/paymentdetailsview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordPaymentDetails" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataPaymentDetails()">
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
						<th ng-if="::checkVisibility('bin')">
							<div ng-click="sort('bin')" >
								<a class="sortable-column-name"><span><spring:message code="label.bin" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bin, 'fa-caret-up': !details.bin }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone2')">
							<div ng-click="sort('phone2')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone2" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone2, 'fa-caret-up': !details.phone2 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('fullname')">
							<div ng-click="sort('fullname')" >
								<a class="sortable-column-name"><span><spring:message code="label.fullName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.fullName, 'fa-caret-up': !details.fullName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nceo')">
							<div ng-click="sort('nceo')" >
								<a class="sortable-column-name"><span><spring:message code="label.nceo" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nceo, 'fa-caret-up': !details.nceo }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('banklocation')">
							<div ng-click="sort('banklocation')" >
								<a class="sortable-column-name"><span><spring:message code="label.bankLocation" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bankLocation, 'fa-caret-up': !details.bankLocation }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('legaladdress')">
							<div ng-click="sort('legaladdress')" >
								<a class="sortable-column-name"><span><spring:message code="label.legalAddress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.legalAddress, 'fa-caret-up': !details.legalAddress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('iin')">
							<div ng-click="sort('iin')" >
								<a class="sortable-column-name"><span><spring:message code="label.iin" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.iin, 'fa-caret-up': !details.iin }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('postaladdress')">
							<div ng-click="sort('postaladdress')" >
								<a class="sortable-column-name"><span><spring:message code="label.postalAddress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.postalAddress, 'fa-caret-up': !details.postalAddress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameofthebank')">
							<div ng-click="sort('nameofthebank')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameOfTheBank" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameOfTheBank, 'fa-caret-up': !details.nameOfTheBank }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone')">
							<div ng-click="sort('phone')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone, 'fa-caret-up': !details.phone }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('correspondentaccount')">
							<div ng-click="sort('correspondentaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.correspondentAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.correspondentAccount, 'fa-caret-up': !details.correspondentAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currentaccount')">
							<div ng-click="sort('currentaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.currentAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currentAccount, 'fa-caret-up': !details.currentAccount }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredPaymentDetails = ( dataPaymentDetails | filter:searchKeywordPaymentDetails ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('bin')"><label>{{ ::item.bin }}</label></td>
						<td ng-if="::checkVisibility('phone2')"><label>{{ ::item.phone2 }}</label></td>
						<td ng-if="::checkVisibility('fullname')"><label>{{ ::item.fullname }}</label></td>
						<td ng-if="::checkVisibility('nceo')"><label>{{ ::item.nceo }}</label></td>
						<td ng-if="::checkVisibility('banklocation')"><label>{{ ::item.banklocation }}</label></td>
						<td ng-if="::checkVisibility('legaladdress')"><label>{{ ::item.legaladdress }}</label></td>
						<td ng-if="::checkVisibility('iin')"><label>{{ ::item.iin }}</label></td>
						<td ng-if="::checkVisibility('postaladdress')"><label>{{ ::item.postaladdress }}</label></td>
						<td ng-if="::checkVisibility('nameofthebank')"><label>{{ ::item.nameofthebank }}</label></td>
						<td ng-if="::checkVisibility('phone')"><label>{{ ::item.phone }}</label></td>
						<td ng-if="::checkVisibility('correspondentaccount')"><label>{{ ::item.correspondentaccount }}</label></td>
						<td ng-if="::checkVisibility('currentaccount')"><label>{{ ::item.currentaccount }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredPaymentDetails.length }} / {{ dataPaymentDetails.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataPaymentDetails()">
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
