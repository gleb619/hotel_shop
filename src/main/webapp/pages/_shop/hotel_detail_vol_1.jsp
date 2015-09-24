<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="data_navbar_simple.jsp"%>
<div ng-controller="ShopHotelLandscapeEditCtrl" class="edit-container">
	<div ng-if="!scrollable.dataLoading">
		<c:if test="${debug}">
		<section class="helper collapsed" id="helper">
			<%@ include file="vol1/data_helper_pane.jsp" %>
		</section>
		</c:if>
		
		<section class="single_grid" id="description">
			<%@ include file="vol1/data_description_pane.jsp" %>
		</section>
		<%-- 
		<section class="second bounceInUp wow" id="detail">
			<h3 class="center">DETAIL</h3>
			<hr class="separator">
			<%@ include file="vol1/data_hotel_detail.jsp" %>
		</section>
		 --%>
		<section class="first bounceInUp wow" id="location">
			<h3 class="center"><spring:message code="default.map" /></h3>
			<hr class="separator">
			<%@ include file="vol1/location_map.jsp" %>
		</section>
		<section class="second bounceInUp wow" id="rooms">
			<h3 class="center"><spring:message code="default.Rooms" /></h3>
			<hr class="separator">
			<%@ include file="vol1/data_rooms.jsp" %>
		</section>
		
		<section class="first bounceInUp wow" id="condition_text">
			<h3 class="center"><spring:message code="default.condition-text" /></h3>
			<hr class="separator">
			<%@ include file="vol1/data_condition_text.jsp" %>
		</section>
		
		<section id="request">
			<sec:authorize access="isAnonymous()">
				<div class="bounceInUp wow">
					<jsp:include page="../_shop/login_embedded_page.jsp" />
				</div>
			</sec:authorize>
	
			<sec:authorize access="isAuthenticated()">
				<div class="bounceInUp wow">
					<div class="container" ng-hide="reqitem.init">
						<div class="alert alert-warning" role="alert">
							<button type="button" class="close" scroll-to="#rooms"><spring:message code="default.show-me" /></button>
							<span class="fa fa-exclamation-triangle" aria-hidden="true"></span>
							<span><spring:message code="default.pick-room" /></span>
						</div>
						<div class="alert alert-danger" role="alert">
							<button type="button" class="close" scroll-to="#condition_text"><spring:message code="default.show-me" /></button>
							<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
							<span><spring:message code="default.agree-with-conditions" /></span>
						</div>
					</div>
				</div>
			
				<div class="bounceInUp wow" ng-if="reqitem.init">
					<h3 class="center"><spring:message code="default.request" /></h3>
					<div class="col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-2 col-md-8">
					
					<jsp:include page="../_public/landscape_request.jsp">
						<jsp:param name="submitType" value="false" />
					</jsp:include>
					
					</div>
				</div>
			</sec:authorize>
		</section>
		
	<script>
		$('.easyzoom').easyZoom();
	</script>	
	</div>	
	<section ng-show="scrollable.dataLoading">
		<div class="app-content-loading">
			<div class="center">
				<i class="fa-3x glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</div>
	</section>
</div>
