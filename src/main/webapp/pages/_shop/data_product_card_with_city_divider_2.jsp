<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>

<div class="wrapper-content">
	<div class="row">
		<h2 class="separator">{{ value.name }}<small>&nbsp;&nbsp;({{ value.data.length }})</small></h2>
	</div>
	
	<div class="row">
	
	<div class="col-sm-6 col-md-3" ng-repeat="item in value.data track by item.id">
	
		<div class="ibox" ng-class="::{'freesale': item.freesale}">
			<div class="ibox-content product-box">
		
				<div class="image-holder">
					<a href="#/hotel_detail/{{ ::item.id }}" scroll-to="#body">
						<img class="img-responsive chain" ng-src="../images/{{ ::item.image }}?thumbnail=2" alt=" " />
					</a>
				</div>
				
				<div class="product-desc">
					<span class="product-freesale">FREESALE</span>
					<span class="product-price">{{ ::item.currencysign }}{{ ::item.cost }}</span>
					<span class="product-price-2">{{ ::item.usdcurrencysign }}{{ ::item.usdcost }}</span>
					<small class="text-muted">
						<rating readonly="true" ng-model="item.starcount" class="rating-custom"></rating>
					</small>
					<a href="#/hotel_detail/{{ ::item.id }}" class="product-name">{{ ::item.label }}</a>
		
					<div class="small m-t-xs">{{ ::item.synopsis }}</div>
					<div class="m-t text-righ">
						<a href="#/hotel_detail/{{ ::item.id }}" class="btn btn-sm btn-primary btn-block">
							Детали <i class="fa fa-long-arrow-right"></i>
						</a>
						<a href="#/hotel_detail_old/{{ ::item.id }}" class="btn btn-sm btn-primary btn-block">
							Детали(Старые) <i class="fa fa-long-arrow-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	</div>
</div>