<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="row">
	<h2 class="separator">{{ key }}<small>&nbsp;&nbsp;({{ value.length }})</small></h2>
	<!-- <div class="col-xs-8 col-sm-6 col-md-4 col-lg-3 chain-grid col-xs-offset-2 col-md-offset-0" ng-repeat="item in value track by $index"> -->
	<div class="col-xs-8 col-sm-6 col-md-4 col-lg-3 col-xs-offset-2 col-sm-offset-0" ng-repeat="item in value track by $index">
		<div class="image-holder">
			<a href="#/hotel_detail/{{ item.id }}" scroll-to="#body">
				<img class="img-responsive chain" ng-src="../images/{{ item.image }}?thumbnail=2" alt=" " />
			</a>
		</div>
		<h4>
			<rating readonly="true" ng-model="item.starcount" max="5" class="rating-custom"></rating>
		</h4>
		<!-- 
		<span class="sticker" ng-if="item.freesale">
			<span class="fa-stack fa-lg">
			  <i class="fa fa-comment-o fa-stack-2x"></i>
			  <span class="sticker-label fa-stack-1x">Freesale</span>
			</span>
		</span>
		<span class="star">
			
		</span>
		-->
		<div class="grid-chain-bottom">
			<h6>
				<a href="#/hotel_detail/{{ item.id }}" scroll-to="#body"><span>{{ item.label }}</span></a>
			</h6>
			<div class="star-price">
				<div class="dolor-grid">
					<div class="col-md-12">
						<span class="inline-content">
							<span class="actual">{{ item.cost }}</span>
							<span ng-switch on="item.currencyname">
								<div class="animate-switch" ng-switch-when="DOLLAR">
									<i class="fa-lg fa fa-usd"></i>
								</div>
								<div class="animate-switch" ng-switch-default>
									<span class="fa-lg fa">₸</span>
								</div>
							</span>
						</span>
					</div>
					<!-- <span class="reducedfrom">400$</span> -->
					<!-- 
					<div class="star-rating col-xs-6">
						<span class="fa-stack pull-right">
							<i class="fa fa-star fa-stack-2x star"></i>
							<span class="fa-stack-1x star-label">{{ item.starcount }}</span>
						</span>
					</div>
					 -->
				</div>
				
				
				<div class="clearfix"></div>
			</div>
			<a href="#/hotel_detail/{{ item.id }}" scroll-to="#body" class="now-get get-cart btn-block">
				<span>Детали</span>
			</a>
			<%-- 
			<sec:authorize access="isAuthenticated()">
			</sec:authorize>
			
			<sec:authorize access="isAnonymous()">
				<a href="#/login_page" class="now-get get-cart btn-block"> 
					<span>LOGIN</span> 
				</a>
			</sec:authorize>
			--%>
		</div>
	</div>
</div>