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
						<th ng-if="::checkVisibility('reqservhotel')">
							<div ng-click="sort('reqservhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.reqServHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.reqServHotel, 'fa-caret-up': !details.reqServHotel }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmcontacteasy')">
							<div ng-click="sort('tmcontacteasy')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmContactEasy" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmContactEasy, 'fa-caret-up': !details.tmContactEasy }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.relReqServHotelTmContactEasies track by $index">
						<td ng-if="::checkVisibility('reqservhotel')"><label>{{ ::item.reqservhotel }}</label></td>
						<td ng-if="::checkVisibility('tmcontacteasy')"><label>{{ ::item.tmcontacteasy }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredRelReqServHotelTmContactEasy.length }}/{{ selectedItem.relReqServHotelTmContactEasies.length }}
				</div>
			  </div>
		</div>
	</div>
</div>