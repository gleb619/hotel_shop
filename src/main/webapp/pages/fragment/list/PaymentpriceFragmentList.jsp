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
						<tr ng-repeat="item in selectedItem.paymentPrices track by $index">
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
				<div>
					<spring:message code="default.total" />: {{ filteredPaymentPrice.length }}/{{ selectedItem.paymentPrices.length }}
				</div>
			  </div>
		</div>
	</div>
</div>