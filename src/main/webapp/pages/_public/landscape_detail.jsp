<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div ng-controller="ShopHotelLandscapeEditCtrl">
	<div class="container" ng-hide="scrollable.dataLoading">
		<section id="back" class="section-back text-center">
			<a href="#/shop_landscape" role="button" class="btn btn-default col-xs-12">Back</a>
		</section>
		<section id="main" class="section text-center">
			<div class="row">
				<div class="col-sm-6">
					<carousel> <slide ng-repeat="relimage in item.relServHotelImages"> <img
						ng-src="../images/{{ relimage.image.label }}" style="margin: auto;"> </slide> </carousel>
				</div>
				<div class="col-sm-6">
					<h3>{{ item.label }}</h3>
					<h4>
						<rating readonly="true" ng-model="item.starcount" max="5" class="rating-custom"></rating>
					</h4>
					<hr>
					<p ng-bind-html="item.descr"></p>
					<p>
						<a ng-click="item.collapsed = !item.collapsed">Detail >></a>
					</p>
				</div>
			</div>
		</section>
		<section id="hotel" class="section text-center" collapse="item.collapsed">
		<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td><spring:message code="label.label" /></td>
					<td>{{ item.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.starcount" /></td>
					<td>
						<rating readonly="true" ng-model="item.starcount" max="5" class="rating-custom" tabindex="2"> </rating>
					</td>
				</tr>
				<tr>
					<td><spring:message code="label.dictGlobalByQualityId" /></td>
					<td>{{ item.dictglobalbyquality.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.dictGlobalByServiceidId" /></td>
					<td>{{ item.dictglobalbyserviceid.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.dictGlobalByPlacementId" /></td>
					<td>{{ item.dictglobalbyplacement.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.dictGlobalByTypeId" /></td>
					<td>{{ item.dictglobalbytype.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.dictGlobalByCategoryId" /></td>
					<td>{{ item.dictglobalbycategory.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.locationCities" /></td>
					<td>{{ item.locationcities.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.locationCountries" /></td>
					<td>{{ item.locationcountries.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.currCurrency" /></td>
					<td>{{ item.currcurrency.label }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.roomsnumber" /></td>
					<td>{{ item.roomsnumber }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.storeys" /></td>
					<td>{{ item.storeys }}</td>
				</tr>
				<tr>
					<td><spring:message code="label.nameeng" /></td>
					<td>{{ item.nameeng }}</td>
				</tr>
			
			</tbody>
		</table>
			
		</section>
		<section id="rooms" class="section text-center">
			<div class="panel panel-primary" ng-repeat="room in item.servHotelRooms">
				<div class="panel-heading" ng-click="room.collapsed = !room.collapsed">
					<img class="img-responsive header-image"
						ng-src="../images/{{ room.relServHotelRoomImages[0].image.label }}?size=64">
					<h3 class="panel-title">{{ room.label }} {{ room.category }}</h3>
				</div>
				<div class="panel-body" collapse="room.collapsed">
					<div class="row">
						<div class="col-md-6">
							<div class="col-md-12">
								<carousel> <slide ng-repeat="relimage in room.relServHotelRoomImages"> <img
									ng-src="../images/{{ relimage.image.label }}" style="margin: auto;"> </slide> </carousel>
							</div>
							<div class="col-md-12">
								<button class="btn btn-info pull-left" ng-click="pickRoom(room)" scroll-to="#request">
									<spring:message code="default.request" />
									<i class="fa fa-angle-double-right"></i>
								</button>
							</div>
						</div>
						<div class="col-md-6">
							<p ng-bind-html="room.descr"></p>
						</div>
					</div>
					<div class="row">
						<jsp:include page="currency-filter.jsp" />
						<div class="col-md-12">
							<table class="table table-bordered">
								<tbody>
									<tr ng-repeat="tariff in room.paymentTariffs">
										<td class="center-content width-10">
											<h4>{{ tariff.label }}</h4>
										</td>
										<td>
											<table class="table table-hover">
												<tbody>
													<tr ng-repeat="price in tariff.paymentPrices | currency: priceFilter">
														<td class="width-20">
															{{ price.humannumber }}
															<spring:message code="default.short.man" />
														</td>
														<td class="width-50">{{ price.value }}</td>
														<td class="width-30">{{ price.currcurrency.label || price.currcurrency.currencyname }}</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
		<%-- 
	<section id="payment_detail" class="section text-center">
		<div class="media">
	      <div class="media-left">
	        <a href="#">
	          <img class="media-object"  style="width: 64px; height: 64px;">
	        </a>
	      </div>
	      <div class="media-body">
	        <h4 class="media-heading">Credit cards</h4>
	        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
	      </div>
	    </div>
	</section>
	--%>
		<hr>
		<section id="request" class="section text-center">
			<h3>REQUEST</h3>
			<jsp:include page="landscape_request.jsp" />
		</section>
	</div>
	<div class="container" ng-show="scrollable.dataLoading">
		<div class="app-content-loading">
			<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
		</div>
	</div>
</div>