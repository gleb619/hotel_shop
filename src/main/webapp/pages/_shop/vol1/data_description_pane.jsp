<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-6">
		<div class="image-holder easyzoom easyzoom--overlay easyzoom--with-thumbnails bounceInLeft wow">
		    <a href="../images/{{ ::item.image }}?mw=500&scale=2">
		        <img ng-src="../images/{{ ::item.image }}?h=450&w=600&mw=600" class="img-responsive" />
		        <!-- <img ng-src="../images/{{ ::item.image }}?h=450&w=600&mw=600"  /> -->
		    </a>
		</div>
	</div>
	<div class="col-md-6">
		<div class="padding-right-10 margin-left-10 bounceInRight wow">
			<h4>{{ ::item.label }}</h4>
			<div class="cart-b">
				<div class="left-n row">
					<div class="col-md-8">
						{{ ::item.cost }}
						<span>{{ ::item.currencysign }}</span>
		
						<span>
							<spring:message code="default.for" />
							{{ ::item.humannumber }}
							
							<small ng-switch="item.humannumber">
								<span ng-switch-when="1"><spring:message code="default.client" /></span>
								<span ng-switch-default><spring:message code="default.clients" /></span>
							</small>
							
							<!-- <spring:message code="default.human_s" /> -->
						</span>
					</div>
					<div class="col-md-4">
						<a class="now-get get-cart-in" scroll-to="#rooms">
							<spring:message code="default.Rooms" />
						</a>
					</div>
					<div class="clearfix"></div>
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
			</div>
		</div>
	</div>
</div>