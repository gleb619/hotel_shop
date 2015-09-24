<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="animated rooms-holder">
	<div>
		<span id="room_card{{::room.id}}" class="scroll-point"></span>
		<div class="card item-opacity" ng-if="room.tarriffcollapsed">
		
			<div class="ibox">
				<div class="ibox-content product-box">
					<!-- 
					<carousel disable-ng-animate>
						<slide ng-repeat="image in ::item.images track by $index" active="image.active"> 
							<img ng-src="../images/{{ ::image.image }}?mw=500" style="margin: auto;">
						</slide> 
					</carousel>
					 -->
					<div class="image-holder">
						<carousel disable-ng-animate>
							<slide ng-repeat="image in ::room.images track by $index" active="image.active"> 
								<img ng-src="../images/{{ ::image.image }}?mw=500" style="margin: auto;">
							</slide> 
						</carousel>
						<!-- <img class="img-responsive chain" ng-src="../images/{{ ::room.image }}?thumbnail=2" alt="{{ ::item.label }}" /> -->
					</div>
					<hr class="separator">
					<div class="product-synopsys">
						<a ng-click="room.tarriffcollapsed = !room.tarriffcollapsed" class="product-name">{{ ::room.label }}</a>
						<hr class="separator">
						<div class="m-t text-righ">
							<button class="btn-sm btn btn-info ng-isolate-scope" ng-click="room.tarriffcollapsed = !room.tarriffcollapsed" scroll-to="#room_detail{{::room.id}}" scroll-timeout="300">
								<span><spring:message code="default.show-tarriffs" /></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div>
		<span id="room_detail{{::room.id}}" class="scroll-point"></span>
		<div class="detailed-view item-opacity" ng-if="!room.tarriffcollapsed">
			
			<br>
			<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-t pull-right" ng-click="room.tarriffcollapsed = !room.tarriffcollapsed" scroll-to="#room_card{{::room.id}}" scroll-timeout="300">
						<i class="fa fa-times"></i>
					</button>
					<h4 class="caption-holder">{{ ::room.label }}<small>{{ ::room.category }}</small></h4>
						<hr class="separator">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<p ng-bind-html="::room.descr"></p>
				</div>
				<div class="col-sm-6">
					<carousel disable-ng-animate>
						<slide ng-repeat="image in ::room.images track by $index" active="image.active"> 
							<img ng-src="../images/{{ ::image.image }}?mw=500" style="margin: auto;">
						</slide> 
					</carousel>
					<!-- <img class="img-responsive chain" ng-src="../images/{{ ::room.image }}?thumbnail=2" alt="{{ ::item.label }}" /> -->
				</div>
				
				<div class="clearfix"></div>
				<div class="description-holder">
					<br>
					<%@ include file="data_tarriffs.jsp" %>
					<sec:authorize access="isAnonymous()">
						<div class="col-xs-8 col-sm-6 col-md-4 col-xs-offset-2 col-sm-offset-3 col-md-offset-4">
							<button class="btn btn-warning btn-block" scroll-to="#login">
								<spring:message code="default.login" />
							</button>
						</div>
					</sec:authorize>
				</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<!-- <div class="card item-opacity" ng-if="room.tarriffcollapsed"> -->
	
	
	<!-- 
	<div class="animated" ng-class="{ 'col-xs-12 col-sm-6 col-md-4 col-lg-3': room.tarriffcollapsed, 'col-xs-12 full': !room.tarriffcollapsed }" id="room{{::room.id}}">
		<div class="con-sed-grid">
			<div ng-class="{ 'row': !room.tarriffcollapsed }" class="e2604af">
				<div class="image-holder" ng-class="{ 'col-sm-6': !room.tarriffcollapsed }">
			        <img ng-src="../images/{{ ::room.image }}?thumbnail=2" class="img-responsive center" />
			    </div>
			    <div ng-class="{ 'col-sm-6': !room.tarriffcollapsed }">
					<button class="btn btn-t pull-right" ng-show="!room.tarriffcollapsed" ng-click="room.tarriffcollapsed = !room.tarriffcollapsed">
						<i class="fa fa-times"></i>
					</button>
					<h4 class="caption-holder">{{ ::room.label }}<small>{{ ::room.category }}</small></h4>
					<div ng-show="!room.tarriffcollapsed">
						<hr class="separator">
						<p ng-bind-html="::room.descr"></p>
					</div>
			    </div>
			</div>
			
		</div>
	</div>
	-->
</div>