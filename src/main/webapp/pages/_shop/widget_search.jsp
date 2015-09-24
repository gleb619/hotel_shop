<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div ng-controller="ShopHotelLandscape2Ctrl" class="margin-left-right-15">
	<div class="navbar-fixed">
	<jsp:include page="data_navbar.jsp" >
	    <jsp:param name="home_url" value="#/widget_search" />
	</jsp:include>
	
	</div>
	<div class="row data-body">
		<div class="col-xs-4 col-md-3 data-searchbar">
			<%@ include file="data_sidebar.jsp" %>
			<div class="clearfix"></div>
		</div>
		<div class="col-xs-offset-4 col-md-offset-3 col-xs-8 col-md-9 data-wall">
			<div class="content-loading" ng-show="scrollable.dataLoading">
				<div class="center">
					<i class="fa-3x glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
				</div>
			</div>
			<div class="padding-bottom-50" id="product_cards">
				<%@ include file="widget_search_product_list.jsp"%>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>