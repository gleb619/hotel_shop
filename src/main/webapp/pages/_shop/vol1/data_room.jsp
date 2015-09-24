<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <div class="col-xs-12 col-sm-6 col-md-3 col-lg-4" -->
<div class="animated" ng-class="{ 'col-xs-12 col-sm-6 col-md-4 col-lg-3': room.tarriffcollapsed, 'col-xs-12 full': !room.tarriffcollapsed }" id="room{{room.id}}">
	<div class="con-sed-grid">
	<!-- <div> -->
		<div ng-class="{ 'row': !room.tarriffcollapsed }" class="e2604af">
			<div class="image-holder"
				ng-class="{ 'col-xs-6': !room.tarriffcollapsed }">
		        <!-- <img ng-src="../images/{{ room.relServHotelRoomImages[0].image.label }}?thumbnail=3" class="img-responsive center" /> -->
		        <img ng-src="../images/{{ room.image }}?thumbnail=2" class="img-responsive center" />
		    </div>
		    <div ng-class="{ 'col-xs-6': !room.tarriffcollapsed }">
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
		<div class="clearfix"></div>
		<div class="description-holder">
			<br>
			<div ng-show="room.tarriffcollapsed">
				<button class="btn btn-default btn-block" ng-click="room.descriptioncollapsed = !room.descriptioncollapsed">
					<span><spring:message code="default.show-description" /></span>
				</button>
				<div collapse="room.descriptioncollapsed">
					<p ng-bind-html="::room.descr"></p>
				</div>
			</div>
			
			<%@ include file="data_tarriffs.jsp" %>
			
			<button ng-show="room.tarriffcollapsed" type="button" class="btn btn-success btn-block" ng-click="pickRoom(room)" scroll-to="#condition_text">
				<spring:message code="default.request" />
			</button>
		</div>
	</div>
</div>


<!-- =============================================== -->
<!-- 
<div class="panel-heading" ng-click="room.collapsed = !room.collapsed">
		<h3 class="panel-title">{{ room.label }} {{ room.category }}</h3>
	</div>
	<div class="panel-body" collapse="room.collapsed">
		<div class="row">
			<div class="col-md-6">
				<div class="col-md-12">
					<carousel> 
						<slide ng-repeat="relimage in room.relServHotelRoomImages"> 
							<img ng-src="../images/{{ relimage.image.label }}" style="margin: auto;"> 
						</slide> 
					</carousel>
				</div>
			</div>
			<div class="col-md-6">
				<p ng-bind-html="room.descr"></p>
			</div>
		</div>
 -->		