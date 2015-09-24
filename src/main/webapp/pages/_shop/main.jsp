<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div ng-controller="ShopHotelLandscape2Ctrl" class="margin-left-right-15">
	<%@ include file="data_navbar.jsp"%>
	<div class="row without-margin data-body">
		<div class="col-md-3">
			<%@ include file="data_sidebar.jsp"%>
			<div class="clearfix"></div>
		</div>
		<div class="col-sm-10 col-sm-offset-1 col-md-9 col-md-offset-0">
			<div class="content-loading" ng-show="scrollable.dataLoading">
				<div class="center">
					<i class="fa-3x glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
				</div>
			</div>
			<div class="padding-bottom-50" id="product_cards">
				<%@ include file="data_product_cards_with_city_divider.jsp"%>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>