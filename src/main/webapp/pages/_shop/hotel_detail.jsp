<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%-- <%@ include file="data_navbar_simple.jsp"%> --%>
<div class="back-holder">
	<a role="button" href="#/" class="btn btn-circle-md">
		<i class="fa-3x fa fa-home"></i>
	</a>
</div>
<div ng-controller="ShopHotelLandscapeEditCtrl" class="edit-container">
	<div ng-if="!scrollable.dataLoading">
		<c:if test="${debug}">
		<section class="helper collapsed" id="helper">
			<%@ include file="vol2/data_helper_pane.jsp" %>
		</section>
		</c:if>
		
		<section class="single_grid" id="description">
			<%@ include file="vol2/data_description_pane.jsp" %>
		</section>
		
		<section class="second" id="rooms">
			<h3 class="center"><spring:message code="default.Rooms" /></h3>
			<hr class="separator">
			<div class="bounceInUp wow" data-wow-delay="0.3s" data-wow-offset="30">
				<%@ include file="vol2/data_rooms.jsp" %>
			</div>
		</section>
		
		<sec:authorize access="isAnonymous()">
			<section class="first" id="login">
				<div class="bounceInUp wow" data-wow-offset="50">
					<jsp:include page="../_shop/login_embedded_page.jsp" />
				</div>
			</section>
		</sec:authorize>
	</div>	
	<section ng-show="scrollable.dataLoading">
		<div class="app-content-loading">
			<div class="center">
				<i class="fa-3x glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</div>
	</section>
</div>
