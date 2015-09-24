<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="scrollable-content-300">
	<div ng-show="item.servHotelRooms.length == 0" ng-include src="view.getView()"></div>
	<div ng-show="item.servHotelRooms.length != 0">
		<div ng-repeat="item in filteredServHotelRoom = ( item.servHotelRooms | filter:searchKeyword )">
			<div class="row without-margin">
				<div class="col-md-offset-3 col-md-6 center-holder">
					<h4>{{ item.label }}</h4>
				</div>
				<div class="col-md-5 col-lg-4">
					<div class="center-div v-holder-300" ng-show="item.relServHotelRoomImages.length != 0">
						<carousel> <slide ng-repeat="image in item.relServHotelRoomImages"> 
						<img ng-src="../images/{{ image.image.label }}" >
						<!-- style="max-height: 300px; max-width: 300px;" -->
						</slide> </carousel>
					</div>
					<div class="fa-lg-holder center-div" ng-hide="item.relServHotelRoomImages.length != 0">
						<i class="fa fa-picture-o fa-7x"></i>
					</div>
					<footer>
						<button class="btn btn-info col-md-10 col-md-offset-1" ng-click="request(item)">
							<spring:message code="default.request" />
							<i class="fa fa-angle-double-right"></i>
						</button>
					</footer>
				</div>
				<div class="col-md-7 col-lg-8">
					<ol class="list-group">
						<li class="list-group-item">
							<span class="list-group-item-caption">
								<spring:message code="label.label" />
							</span>
							<span class="pull-right">{{ item.label }}</span>
						</li>
						<li class="list-group-item">
							<span class="list-group-item-caption">
								<spring:message code="label.dictGlobal" />
							</span>
							<span class="pull-right">{{ item.dictglobal }}</span>
						</li>
						<li class="list-group-item">
							<span class="list-group-item-caption">
								<spring:message code="label.groupGlobal" />
							</span>
							<span class="pull-right">{{ item.groupglobal }}</span>
						</li>
						<li class="list-group-item">
							<span class="list-group-item-caption">
								<spring:message code="label.roomNumber" />
							</span>
							<span class="pull-right">{{ item.roomnumber }}</span>
						</li>
						<li class="list-group-item">
							<span class="list-group-item-caption">
								<spring:message code="label.guestNumber" />
							</span>
							<span class="pull-right">{{ item.guestnumber }}</span>
						</li>
					</ol>
				</div>
			</div>
			<div class="row edit-block padding-left-right-15 without-margin">
				<table class="table table-bordered margin-bottom-0">
					<thead>
						<tr>
							<th class="width-10 center-content">
								<spring:message code="label.name" />
							</th>
							<th>
								<table class="full-width">
									<thead>
										<th class="width-20">
											<spring:message code="label.humannumber" />
										</th>
										<th class="width-50">
											<spring:message code="label.price" />
										</th>
										<th class="width-30">
											<spring:message code="label.currcurrency" />
										</th>
									</thead>
								</table>
							</th>
						</tr>
					</thead>
				</table>
				<table class="table table-bordered">
					<tbody>
						<tr ng-repeat="tariff in item.paymentTariffs">
							<td class="center-content width-10">
								<h4>{{ tariff.label }}</h4>
							</td>
							<td>
								<table class="table table-hover">
									<tbody>
										<tr ng-repeat="price in tariff.paymentPrices">
											<td class="width-20">
												{{ price.humannumber }}
												<spring:message code="default.short.man" />
											</td>
											<td class="width-50">{{ price.value }}</td>
											<td class="width-30">{{ price.currcurrency.label }}</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
				<!-- 
			<ul class="list-inline">
				<li ng-repeat="tariff in item.paymentTariffs">
					{{ tariff.label }}
				</li>
			</ul>
			 -->
			</div>
			<hr>
		</div>
	</div>
</div>