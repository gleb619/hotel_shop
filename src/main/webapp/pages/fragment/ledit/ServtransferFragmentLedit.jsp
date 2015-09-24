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
					ng-click="createModalItemServTransfer()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemServTransfer(selectedItemservTransfers.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('servTransfers', 'ServTransfer', selectedItemservTransfers.id, itemIndex)">
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
						<th ng-if="::checkVisibility('price')">
							<div ng-click="sort('price')" >
								<a class="sortable-column-name"><span><spring:message code="label.price" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.price, 'fa-caret-up': !details.price }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('datefrom')">
							<div ng-click="sort('datefrom')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateFrom" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateFrom, 'fa-caret-up': !details.dateFrom }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dateto')">
							<div ng-click="sort('dateto')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateTo" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateTo, 'fa-caret-up': !details.dateTo }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbypaymenttypeid')">
							<div ng-click="sort('dictglobalbypaymenttypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPaymentTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPaymentTypeId, 'fa-caret-up': !details.dictGlobalByPaymentTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcities')">
							<div ng-click="sort('locationcities')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCities" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCities, 'fa-caret-up': !details.locationCities }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytransportid')">
							<div ng-click="sort('dictglobalbytransportid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTransportId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTransportId, 'fa-caret-up': !details.dictGlobalByTransportId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytypetransferid')">
							<div ng-click="sort('dictglobalbytypetransferid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTypeTransferId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTypeTransferId, 'fa-caret-up': !details.dictGlobalByTypeTransferId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passengersphones')">
							<div ng-click="sort('passengersphones')" >
								<a class="sortable-column-name"><span><spring:message code="label.passengersPhones" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passengersPhones, 'fa-caret-up': !details.passengersPhones }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('visittable')">
							<div ng-click="sort('visittable')" >
								<a class="sortable-column-name"><span><spring:message code="label.visitTable" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.visitTable, 'fa-caret-up': !details.visitTable }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('transfername')">
							<div ng-click="sort('transfername')" >
								<a class="sortable-column-name"><span><spring:message code="label.transferName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.transferName, 'fa-caret-up': !details.transferName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.servTransfers track by $index"
							ng-class="{ 'success' : selectedItemservTransfers.id == item.id }"
							ng-dblclick="editModalItemServTransfer(item.id)"
							ng-click="setSelected('selectedItemservTransfers', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('datefrom')"><label>{{ ::item.datefrom }}</label></td>
						<td ng-if="::checkVisibility('dateto')"><label>{{ ::item.dateto }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbypaymenttype')"><label>{{ ::item.dictglobalbypaymenttype.label }}</label></td>
						<td ng-if="::checkVisibility('locationcities')"><label>{{ ::item.locationcities.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytransport')"><label>{{ ::item.dictglobalbytransport.label }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries.label }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency.label }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytypetransfer')"><label>{{ ::item.dictglobalbytypetransfer.label }}</label></td>
						<td ng-if="::checkVisibility('passengersphones')"><label>{{ ::item.passengersphones }}</label></td>
						<td ng-if="::checkVisibility('visittable')"><label>{{ ::item.visittable }}</label></td>
						<td ng-if="::checkVisibility('transfername')"><label>{{ ::item.transfername }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
							<td>
								<a ng-click="editModalItemServTransfer(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('servTransfers', 'ServTransfer', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.servTransfers.length }}
				</div>
			</div>
		</div>
	</div>
</div>