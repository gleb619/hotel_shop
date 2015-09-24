<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="product-left">
	
	<!-- <div ng-repeat="item in filtered = ( data | filter: keyword ) track by item.id"> -->
	<!-- <div ng-repeat="item in filtered = ( data | filter: keyword )"> -->
	<div ng-repeat="item in data track by $index" class="repeat-animation">
		<%@ include file="data_product_card.jsp" %>
    </div>
    
    <div ng-if="data.length == 0">
    	No hotel found
    </div>
    
	<div class="clearfix"></div>
</div>