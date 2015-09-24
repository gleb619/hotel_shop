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
					ng-click="createModalItemTmContactAddresses()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemTmContactAddresses(selectedItemtmContactAddresseses.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('tmContactAddresseses', 'TmContactAddresses', selectedItemtmContactAddresseses.id, itemIndex)">
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
						<th ng-if="::checkVisibility('tmcontact')">
							<div ng-click="sort('tmcontact')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmContact" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmContact, 'fa-caret-up': !details.tmContact }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcities')">
							<div ng-click="sort('locationcities')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCities" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCities, 'fa-caret-up': !details.locationCities }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('zip')">
							<div ng-click="sort('zip')" >
								<a class="sortable-column-name"><span><spring:message code="label.zip" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.zip, 'fa-caret-up': !details.zip }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('address')">
							<div ng-click="sort('address')" >
								<a class="sortable-column-name"><span><spring:message code="label.address" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.address, 'fa-caret-up': !details.address }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('addressname')">
							<div ng-click="sort('addressname')" >
								<a class="sortable-column-name"><span><spring:message code="label.addressName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.addressName, 'fa-caret-up': !details.addressName }"></i>
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
						<tr ng-repeat="item in item.tmContactAddresseses track by $index"
							ng-class="{ 'success' : selectedItemtmContactAddresseses.id == item.id }"
							ng-dblclick="editModalItemTmContactAddresses(item.id)"
							ng-click="setSelected('selectedItemtmContactAddresseses', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('tmcontact')"><label>{{ ::item.tmcontact.label }}</label></td>
						<td ng-if="::checkVisibility('locationcities')"><label>{{ ::item.locationcities.label }}</label></td>
						<td ng-if="::checkVisibility('zip')"><label>{{ ::item.zip }}</label></td>
						<td ng-if="::checkVisibility('address')"><label>{{ ::item.address }}</label></td>
						<td ng-if="::checkVisibility('addressname')"><label>{{ ::item.addressname }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
							<td>
								<a ng-click="editModalItemTmContactAddresses(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('tmContactAddresseses', 'TmContactAddresses', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.tmContactAddresseses.length }}
				</div>
			</div>
		</div>
	</div>
</div>