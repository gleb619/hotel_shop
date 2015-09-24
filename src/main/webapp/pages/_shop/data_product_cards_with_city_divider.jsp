<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="product-left">
	<div class="product-wrapper" infinite-scroll="test()" infinite-scroll-distance="3" infinite-scroll-disabled='scrollable.scrollableLoading'>
		<div ng-repeat="value in data track by value.name" class="repeat-animation">
			<%@ include file="data_product_card_with_city_divider_2.jsp" %>
	    </div>
	</div>
	<div class="clearfix"></div>
</div>