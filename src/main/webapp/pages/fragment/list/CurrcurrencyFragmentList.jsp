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

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.currCurrencies track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('isbase')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.isbase, 'fa fa-lg fa-circle-o': !item.isbase}"></i></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('currencyname')"><label>{{ ::item.currencyname }}</label></td>
						<td ng-if="::checkVisibility('nameru')"><label>{{ ::item.nameru }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredCurrCurrency.length }}/{{ selectedItem.currCurrencies.length }}
				</div>
			  </div>
		</div>
	</div>
</div>