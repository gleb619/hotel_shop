<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div>
	<button class="btn btn-default btn-block" ng-click="room.tarriffcollapsed = !room.tarriffcollapsed" scroll-to="#room{{room.id}}" scroll-timeout="300">
		<span><spring:message code="default.show-tarriffs" /></span>
	</button>
	<div collapse="room.tarriffcollapsed">
		<div class="row">
			<div class="col-md-12">
				<div class="btn-group" role="group" aria-label="....">
					<button type="button" class="btn btn-default"
						ng-click="detail.currency = !detail.currency">
						<span ng-show="detail.currency"><spring:message code="default.show-tarriff-usd" /></span>
						<span ng-hide="detail.currency"><spring:message code="default.show-tarriff-kzt" /></span>
					</button>
					<%-- 
					<button ng-hide="detail.currency" type="button" class="btn btn-default"
						ng-click="detail.currency = !detail.currency">
						<spring:message code="default.show-tarriff-kzt" />
					</button>
					 --%>
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th>#</th>
							<sec:authorize access="isAuthenticated()">
							<th ng-show="detail.currency"><spring:message code="default.corporateRateCost" /></th>
							<th ng-hide="detail.currency"><spring:message code="default.corporateRateCost" /></th>
							</sec:authorize>
							<th ng-show="detail.currency"><spring:message code="default.originalRateCost" /></th>
							<th ng-hide="detail.currency"><spring:message code="default.originalRateCost" /></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="tariff in room.tariffGeneralRate track by $index">
							<td class="center">
								<button type="button" class="btn btn-success" ng-click="pickRoom2(room, tariff.humannumber)" scroll-to="#condition_text">
									<spring:message code="default.request" />
								</button>
							</td>
							<td> {{ ::tariff.humannumber }} <spring:message code="default.human_s-short" /></td>
							<sec:authorize access="isAuthenticated()">
							<td ng-show="detail.currency"> {{ ::tariff.corporateRateCost }}<small>{{ ::tariff.corporateRateCurrencyname }}</small> </td>
							<td ng-hide="detail.currency"> {{ ::tariff.corporateRateCostUsdCurrency }}<small>{{ ::tariff.corporateRateCostUsdcurrencysign }}</small> </td>
							</sec:authorize>
							<td ng-show="detail.currency"> {{ ::tariff.originalRateCost }}<small>{{ ::tariff.originalRateCurrencyname }}</small> </td>
							<td ng-hide="detail.currency"> {{ ::tariff.originalRateCostUsdCurrency }}<small>{{ ::tariff.originalRateCostUsdcurrencysign }}</small> </td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
</div>
</div>