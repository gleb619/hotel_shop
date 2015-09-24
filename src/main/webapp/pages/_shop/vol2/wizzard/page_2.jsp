<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4 col-md-3">
			<h1><spring:message code="default.Rooms" /></h1>
        	<hr class="separator">
	        <p><spring:message code="default.Rooms-hint" /></p>
	        <c:if test="${debug}">
	        	<hr class="separator">
	        	<p><spring:message code="default.Rooms-hint-debug" /></p>
	        	<button type="button" class="btn btn-default" ng-click="tariffRandom()" wz-next>
	        		<i class="fa fa-random"></i>
					<span><spring:message code="default.random.room" /></span>
				</button>
	        </c:if>
	        <hr class="separator visible-xs">
		</div>
		<div class="col-sm-8 col-md-9">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 center">
					<div class="input-group">
						<span class="input-group-btn">
							<button type="button" class="btn btn-default" ng-click="detail.currency = !detail.currency">
								<span ng-show="detail.currency">$</span>
								<span ng-hide="detail.currency">₸</span>
							</button>
						</span>
						<select class="form-control input-md" ng-model="details.room" ng-options="room.label for room in item.rooms track by room.id"
							ng-change="roomSelect()">
						</select>
					</div>
				</div>
			</div>
			<hr class="separator hidden-xs">
			<div class="scrollable-pane">
				<div class="col-md-12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th></th>
								<c:if test="${debug}">
								<th>id</th>
								</c:if>
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
							<tr ng-repeat="tariff in details.tariffGeneralRate track by tariff.id">
								<td class="center">
									<button type="button" class="btn btn-success" ng-click="tariffSelect(tariff)" wz-next>
										<spring:message code="default.book2" />
									</button>
								</td>
								<c:if test="${debug}">
								<td>{{ ::tariff.id }}</td>
								</c:if>
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
</div>