<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<tabset type="pills"> <tab> <tab-heading> <spring:message
	code="default.main" /> </tab-heading> <br />
<div class="row">
	<div class="col-md-4">
		<div ng-show="item.relServHotelImages.length > 0" class="shop-gallery">
			<carousel> <slide ng-repeat="image in item.relServHotelImages"> <img
				ng-src="../images/{{ image.image }}?size=300"> </slide> </carousel>
		</div>
		<div class="fa-lg-holder" ng-show="item.relServHotelImages.length == 0">
			<i class="fa fa-picture-o fa-8x"></i>
		</div>
	</div>
	<div class="col-md-8">
		<ol class="list-group">
			<li class="list-group-item" ng-show="checkVisibility('label')">
				<span class="list-group-item-caption">
					<spring:message code="label.label" />
				</span>
				<span class="pull-right">{{ item.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('starcount')">
				<span class="list-group-item-caption">
					<spring:message code="label.starcount" />
				</span>
				<span class="pull-right">
					<rating readonly="true" ng-model="item.starcount" max="10" class="rating-custom" tabindex="2">
					</rating>
				</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('dictglobalbyqualityid')">
				<span class="list-group-item-caption">
					<spring:message code="label.dictGlobalByQualityId" />
				</span>
				<span class="pull-right">{{ item.dictglobalbyqualityid.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('dictglobalbyserviceidid')">
				<span class="list-group-item-caption">
					<spring:message code="label.dictGlobalByServiceidId" />
				</span>
				<span class="pull-right">{{ item.dictglobalbyserviceidid.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('dictglobalbyplacementid')">
				<span class="list-group-item-caption">
					<spring:message code="label.dictGlobalByPlacementId" />
				</span>
				<span class="pull-right">{{ item.dictglobalbyplacementid.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('dictglobalbytypeid')">
				<span class="list-group-item-caption">
					<spring:message code="label.dictGlobalByTypeId" />
				</span>
				<span class="pull-right">{{ item.dictglobalbytypeid.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('dictglobalbycategoryid')">
				<span class="list-group-item-caption">
					<spring:message code="label.dictGlobalByCategoryId" />
				</span>
				<span class="pull-right">{{ item.dictglobalbycategoryid.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('locationcities')">
				<span class="list-group-item-caption">
					<spring:message code="label.locationCities" />
				</span>
				<span class="pull-right">{{ item.locationcities.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('locationcountries')">
				<span class="list-group-item-caption">
					<spring:message code="label.locationCountries" />
				</span>
				<span class="pull-right">{{ item.locationcountries.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('currcurrency')">
				<span class="list-group-item-caption">
					<spring:message code="label.currCurrency" />
				</span>
				<span class="pull-right">{{ item.currcurrency.label }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('roomsnumber')">
				<span class="list-group-item-caption">
					<spring:message code="label.roomsnumber" />
				</span>
				<span class="pull-right">{{ item.roomsnumber }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('storeys')">
				<span class="list-group-item-caption">
					<spring:message code="label.storeys" />
				</span>
				<span class="pull-right">{{ item.storeys }}</span>
			</li>
			<li class="list-group-item" ng-show="checkVisibility('nameeng')">
				<span class="list-group-item-caption">
					<spring:message code="label.nameeng" />
				</span>
				<span class="pull-right">{{ item.nameeng }}</span>
			</li>
		</ol>
	</div>
	<div class="col-md-12 edit-block">
		<div class="form-group margin-top-5" ng-show="checkVisibility('null')">
			<label>
				<spring:message code="label.descr" />
			</label>
			<div class="custom-textarea-holder">
				<!--ui-tinymce="tinymceOptions"-->
				<p ng-bind-html="item.descr"></p>
			</div>
		</div>
	</div>
</div>
</tab> <tab active="tabsFocus.hotel.servhotelroom"> <tab-heading> <spring:message
	code="label.ServHotelRoom" /> </tab-heading> <%-- 
	<jsp:include page="../fragment/list/ServhotelroomFragmentList.jsp">
		<jsp:param name="hideColumn" value="column" />
	</jsp:include>
	  --%> <jsp:include page="/pages/_sys/servhotelroomDetail.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message code="label.locationAddress" /> </tab-heading> <!-- page="../fragment/edit/LocationaddressFragmentEdit.jsp"> -->
<jsp:include page="../fragment/elist/LocationaddressFragmentElist.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message code="label.RelServHotelInfoCommercial" />
</tab-heading> <jsp:include page="../fragment/list/RelservhotelinfocommercialFragmentList.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message code="label.RelServHotelInfoHotelServices" />
</tab-heading> <jsp:include page="../fragment/list/RelservhotelinfohotelservicesFragmentList.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message code="label.RelServHotelCreditCards" /> </tab-heading>
<jsp:include page="../fragment/list/RelservhotelcreditcardsFragmentList.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message code="label.RelServHotelInfoPolicies" />
</tab-heading> <jsp:include page="../fragment/list/RelservhotelinfopoliciesFragmentList.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message code="label.RelServHotelFeatures" /> </tab-heading> <jsp:include
	page="../fragment/list/RelservhotelfeaturesFragmentList.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message
	code="label.RelServHotelEntertainmentAndSport" /> </tab-heading> <jsp:include
	page="../fragment/list/RelservhotelentertainmentandsportFragmentList.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> <tab> <tab-heading> <spring:message code="label.RelServHotelServKidsRule" />
</tab-heading> <jsp:include page="../fragment/list/RelservhotelservkidsruleFragmentList.jsp">
	<jsp:param name="hideColumn" value="column" />
</jsp:include> </tab> </tabset>
