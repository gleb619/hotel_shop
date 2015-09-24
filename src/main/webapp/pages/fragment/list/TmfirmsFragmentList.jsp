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
						<th ng-if="::checkVisibility('lastpay')">
							<div ng-click="sort('lastpay')" >
								<a class="sortable-column-name"><span><spring:message code="label.lastpay" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.lastpay, 'fa-caret-up': !details.lastpay }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('accountid')">
							<div ng-click="sort('accountid')" >
								<a class="sortable-column-name"><span><spring:message code="label.accountid" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.accountid, 'fa-caret-up': !details.accountid }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('mounthcount')">
							<div ng-click="sort('mounthcount')" >
								<a class="sortable-column-name"><span><spring:message code="label.mounthcount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.mounthcount, 'fa-caret-up': !details.mounthcount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('active')">
							<div ng-click="sort('active')" >
								<a class="sortable-column-name"><span><spring:message code="label.active" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.active, 'fa-caret-up': !details.active }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('firmname')">
							<div ng-click="sort('firmname')" >
								<a class="sortable-column-name"><span><spring:message code="label.firmName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.firmName, 'fa-caret-up': !details.firmName }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.tmFirmses track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('lastpay')"><label>{{ ::item.lastpay }}</label></td>
						<td ng-if="::checkVisibility('accountid')"><label>{{ ::item.account }}</label></td>
						<td ng-if="::checkVisibility('mounthcount')"><label>{{ ::item.mounthcount }}</label></td>
						<td ng-if="::checkVisibility('active')"><label>{{ ::item.active }}</label></td>
						<td ng-if="::checkVisibility('firmname')"><label>{{ ::item.firmname }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredTmFirms.length }}/{{ selectedItem.tmFirmses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>