<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<div ng-controller="ShopHotelCtrl" class="padding-left-right-10 fragment-page animated-content">
	<div class="row">
		<div class="col-md-6 without-padding">
			<a href="../data/servhotel/scrollable" target="_blank" class="btn btn-default"> JSON DATA </a>
			<a href="../data/servhotelview/scrollable" target="_blank" class="btn btn-default"> JSON DATA
				FOR VIEW </a>
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" class="btn btn-info" ng-click="isAdvancedSearch = !isAdvancedSearch">Advanced
					search</button>
				<jsp:include page="shop-navbar.jsp" />
			</div>
		</div>
		<div class="col-md-6 without-padding">
			<div class="has-feedback has-success filterBar">
				<input type="text" ng-model="searchKeyword" class="form-control"
					placeholder="<spring:message code="default.searchKeyword" />" />
				<i class="form-control-feedback glyphicon glyphicon-search"></i>
			</div>
		</div>
	</div>
	<!-- 
	<span style="color: red;">calc: {{ pageNumber * pageSize }}</span>|
	<span style="color: red;">pageNumber: {{ pageNumber }}</span>|
	<span style="color: red;">pageSize: {{ pageSize }}</span>|
	<span style="color: red;">total: {{ total }}</span>|
	<span style="color: blue;">event: {{ event }}</span>|
	<span style="color: blue;">attemptsNumber: {{ attemptsNumber }}</span>
	 -->
	<div class="animated-content-item"
		ng-class="{'col-md-3' : isAdvancedSearch, 'col-md-0' : !isAdvancedSearch }">
		<div class="wrapper2">
			<form class="form-horizontal round-button-holder margin-top-10">
				<button type="button" class="close round-button" ng-click="isAdvancedSearch = !isAdvancedSearch">&times;</button>
				<fieldset>
					<legend>Advanced search</legend>
					<div class="form-group">
						<label for="inputCountry" class="col-lg-2 control-label">Country</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="Country" list="countries">
							<datalist id="countries">
								<option value="Country 1"></option>
								<option value="Country 2"></option>
								<option value="Country 3"></option>
							</datalist>
						</div>
					</div>
					<div class="form-group">
						<label for="inputCity" class="col-lg-2 control-label">City</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="City" list="cities">
							<datalist id="cities">
								<option value="City 1"></option>
								<option value="City 2"></option>
								<option value="City 3"></option>
							</datalist>
						</div>
					</div>
					<div class="form-group">
						<label for="inputCity" class="col-lg-2 control-label">Hotel</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="Hotel" list="hotels">
							<datalist id="hotels">
								<option value="Hotel 1"></option>
								<option value="Hotel 2"></option>
								<option value="Hotel 3"></option>
							</datalist>
						</div>
					</div>
					<div class="form-group">
						<label for="inputCity" class="col-lg-2 control-label">Guests</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="Guests" list="guests">
							<datalist id="guests">
								<option value="1"></option>
								<option value="2"></option>
								<option value="3"></option>
								<option value="4"></option>
							</datalist>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-10 col-lg-offset-2">
							<div class="checkbox">
								<label>
									<input type="checkbox">
									Freesale
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-lg-2 control-label">Price</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="Price">
						</div>
					</div>
				</fieldset>
				<div class="form-group">
					<div class="col-md-10 col-xs-offset-1 col-sm-offset-1">
						<button type="submit" class="btn btn-primary form-control">Submit</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div ng-class="{'col-md-9' : isAdvancedSearch, 'col-md-12' : !isAdvancedSearch }"
		class="animated-content-item scrollable-content" when-scrolled="loadData()" debug="true">
		<div class="col-md-12 margin-top-5 shop-item"
			ng-repeat="item in filtered = ( data  | filter:searchKeyword )">
			<div class="row">
				<div class="col-md-11">
					<button type="submit" ng-disabled="modalOpening" ng-click="request(item.id)"
						class="btn btn-lg btn-primary form-control">
						<span>{{ item.label }}</span>
					</button>
					<!-- <h3>{{ item.label }}</h3> -->
				</div>
				<div class="col-xs-offset-5 col-sm-offset-5 col-md-offset-0 col-xs-2 col-md-1 center-content">
					<span class="fa-stack fa-lg star-holder">
						<i class="fa fa-star fa-stack-2x star"></i>
						<span class="fa-stack-1x star-label">{{ item.starcount }}</span>
					</span>
				</div>
			</div>
			<div class="row margin-top-5">
				<div class="col-md-3">
					<div>
						<div ng-show="item.relServHotelImages.length > 0" class="shop-gallery">
							<carousel> <slide ng-repeat="image in item.relServHotelImages"> <img
								ng-src="../images/{{ image.image }}?size=300"> </slide> </carousel>
						</div>
						<div class="fa-lg-holder" ng-show="item.relServHotelImages.length == 0">
							<i class="fa fa-picture-o fa-8x"></i>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<tabset> <tab> <tab-heading> <spring:message code="label.descr" />
					</tab-heading>
					<div class="custom-textarea-holder scrollable-content-300 margin-bottom-10">
						<p ng-bind-html="item.descr"></p>
						<a class="btn btn-default margin-5" ng-disabled="modalOpening" ng-click="request(item.id)"
							role="button">
							<span>
								<spring:message code="default.detail" />
							</span>
							<span>
								<i class="fa fa-angle-double-right"></i>
							</span>
						</a>
					</div>
					</tab> <tab> <tab-heading> <spring:message code="label.characteristicsOf" /> </tab-heading>
					<div class="scrollable-content-300">
						<ol class="list-group">
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.starcount" />
								</span>
								<span class="pull-right">
									<rating ng-model="item.starcount" max="10" class="rating-custom" readonly="true"></rating>
								</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.dictGlobalByQualityId" />
								</span>
								<span class="pull-right">{{ item.dictglobalbyquality }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.locationAddress" />
								</span>
								<span class="pull-right">{{ item.locationaddress }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.dictGlobalByServiceidId" />
								</span>
								<span class="pull-right">{{ item.dictglobalbyserviceid }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.dictGlobalByPlacementId" />
								</span>
								<span class="pull-right">{{ item.dictglobalbyplacement }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.tmAccount" />
								</span>
								<span class="pull-right">{{ item.tmaccount }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.paymentDetails" />
								</span>
								<span class="pull-right">{{ item.paymentdetails }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.dictGlobalByReserveticketstypeId" />
								</span>
								<span class="pull-right">{{ item.dictglobalbyreserveticketstype }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.dictGlobalByTypeId" />
								</span>
								<span class="pull-right">{{ item.dictglobalbytype }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.dictGlobalByCategoryId" />
								</span>
								<span class="pull-right">{{ item.dictglobalbycategory }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.locationCities" />
								</span>
								<span class="pull-right">{{ item.locationcities }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.infoContactInformation" />
								</span>
								<span class="pull-right">{{ item.infocontactinformation }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.locationCountries" />
								</span>
								<span class="pull-right">{{ item.locationcountries }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.currCurrency" />
								</span>
								<span class="pull-right">{{ item.currcurrency }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.locationTypePlacement" />
								</span>
								<span class="pull-right">{{ item.locationtypeplacement }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.dictGlobalByCredittypeId" />
								</span>
								<span class="pull-right">{{ item.dictglobalbycredittype }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.roomsnumber" />
								</span>
								<span class="pull-right">{{ item.roomsnumber }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.storeys" />
								</span>
								<span class="pull-right">{{ item.storeys }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.whereroomsarebooked" />
								</span>
								<span class="pull-right">{{ item.whereroomsarebooked }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.nameeng" />
								</span>
								<span class="pull-right">{{ item.nameeng }}</span>
							</li>
							<li class="list-group-item">
								<span class="list-group-item-caption">
									<spring:message code="label.label" />
								</span>
								<span class="pull-right">{{ item.label }}</span>
							</li>
						</ol>
					</div>
					</tab> </tabset>
				</div>
				<div class="col-md-1">
					<div ng-show="item.freesale" class="fa-stack fa-2x free-sale-holder" title="FreeSale">
						<i class="fa fa-circle	 fa-stack-2x free-sale-icon"></i>
						<span class="fa fa-lg fa-stack-1x fa-inverse free-sale-label">F</span>
					</div>
					<div ng-show="item.favorite" class="fa-stack fa-2x favorite-holder" title="Favorite">
						<i class="fa fa-circle	 fa-stack-2x favorite-icon"></i>
						<i class="fa fa-star fa-stack-1x fa-inverse favorite-label"></i>
					</div>
				</div>
				<div class="col-md-12 data-loading-bar-holder" ng-show="dataLoading">
					<div class="data-loading-bar">
						<i class="glyphicon fa-3x glyphicon-refresh fa-spin data-loading-bar-spinner"></i>
					</div>
				</div>
			</div>
		</div>
		<button type="button" ng-disabled="dataLoading" class="btn btn-primary form-control"
			ng-click="loadData()">
			<i class="fa fa-database fa-lg" ng-hide="dataLoading"></i>
			<i class="fa fa-refresh fa-lg fa-spin" ng-show="dataLoading"></i>
			<span>
				<spring:message code="default.loadMore" />
			</span>
		</button>
	</div>
</div>
