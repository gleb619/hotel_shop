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
					ng-click="createModalItemCurrCurrency()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemCurrCurrency(selectedItemcurrCurrencies.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('currCurrencies', 'CurrCurrency', selectedItemcurrCurrencies.id, itemIndex)">
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
						<th ng-if="::checkVisibility('isbase')">
							<div ng-click="sort('isbase')" >
								<a class="sortable-column-name"><span><spring:message code="label.isbase" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.isbase, 'fa-caret-up': !details.isbase }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currencyname')">
							<div ng-click="sort('currencyname')" >
								<a class="sortable-column-name"><span><spring:message code="label.currencyname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currencyname, 'fa-caret-up': !details.currencyname }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameru')">
							<div ng-click="sort('nameru')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameru" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameru, 'fa-caret-up': !details.nameru }"></i>
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
						<tr ng-repeat="item in item.currCurrencies track by $index"
							ng-class="{ 'success' : selectedItemcurrCurrencies.id == item.id }"
							ng-dblclick="editModalItemCurrCurrency(item.id)"
							ng-click="setSelected('selectedItemcurrCurrencies', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('isbase')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.isbase, 'fa fa-lg fa-circle-o': !item.isbase}"></i></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('currencyname')"><label>{{ ::item.currencyname }}</label></td>
						<td ng-if="::checkVisibility('nameru')"><label>{{ ::item.nameru }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
							<td>
								<a ng-click="editModalItemCurrCurrency(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('currCurrencies', 'CurrCurrency', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.currCurrencies.length }}
				</div>
			</div>
		</div>
	</div>
</div>