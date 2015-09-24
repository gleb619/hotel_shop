<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-6">
		<div class="row">
			<!-- 
			<div class="col-md-12">
				<div class="images-slider-full bounceInLeft wow">
					<img ng-src="{{ detail.coverimage }}" class="img-responsive">
				</div>
			</div>
			<div class="col-md-12">
				<div class="images-slider">
					<div class="img-wrapper" ng-repeat="image in ::item.images track by image.id">
						<div class="center bounceInUp wow" data-wow-delay="{{ ::(($index * 10) + 100) }}ms">
							<img ng-src="../images/{{ ::image.image }}?mw=500" ng-click="selectImage(image)">
						</div>
					</div>
				</div>
			</div>
			 -->
			
			<div class="col-md-12">
				<carousel disable-ng-animate class="bounceInLeft wow">
					<slide ng-repeat="image in ::item.images track by $index" active="image.active"> 
						<img ng-src="../images/{{ ::image.image }}?mw=500" style="margin: auto;">
					</slide> 
				</carousel>
			</div>
			
		</div>
	</div>
	<div class="col-md-6">
		<div class="padding-right-10 margin-left-10 bounceInRight wow" data-wow-delay="0.5s">
			<h4>{{ ::item.label }}</h4>
			<div class="cart-b">
				<div class="left-n row">
					<div class="col-md-12">
						{{ ::item.cost }}
						<span>{{ ::item.currencysign }}</span>
		
						<span>
							<spring:message code="default.for" />
							{{ ::item.humannumber }}
							
							<small ng-switch="::item.humannumber">
								<span ng-switch-when="1"><spring:message code="default.client" /></span>
								<span ng-switch-default><spring:message code="default.clients" /></span>
							</small>
							
							<!-- <spring:message code="default.human_s" /> -->
						</span>
					</div>
				</div>
				<div class="clearfix"></div>
				<hr class="separator">
				<h4>
					<rating readonly="true" ng-model="item.starcount" max="5" class="rating-custom"></rating>
				</h4>
				<div class="clearfix"></div>
				<p ng-bind-html="item.descr"></p>
				<div class="clearfix"></div>
				<div class="inline">
					<br>
					<h3><span><spring:message code="default.Location" /> :</span><small><i class="fa-2x fa fa-map-marker"></i>{{ ::item.countryname }}, {{ ::item.cityname }}, {{ ::item.addressname }}</small></h3>
				</div>
				
				<div class="clearfix"></div>
				<hr class="separator">
				<img alt="location" ng-src="http://static-maps.yandex.ru/1.x/?ll={{ ::item.yandexmappointx }},{{ ::item.yandexmappointy }}&z=13&l=map&size=300,300" class="img-responsive center">
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>