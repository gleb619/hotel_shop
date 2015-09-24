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
					ng-click="createModalItemPaymentDetails()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemPaymentDetails(selectedItempaymentDetailses.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('paymentDetailses', 'PaymentDetails', selectedItempaymentDetailses.id, itemIndex)">
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

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.paymentDetailses track by $index"
							ng-class="{ 'success' : selectedItempaymentDetailses.id == item.id }"
							ng-dblclick="editModalItemPaymentDetails(item.id)"
							ng-click="setSelected('selectedItempaymentDetailses', item, $index)">
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
							<td>
								<a ng-click="editModalItemPaymentDetails(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('paymentDetailses', 'PaymentDetails', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.paymentDetailses.length }}
				</div>
			</div>
		</div>
	</div>
</div>