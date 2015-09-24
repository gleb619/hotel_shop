<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div>
	<div class="row">
		<div class="padding-left-right-15">
			<div class="btn-group without-padding display-block toolbar-panel">
				<button type="button" class="btn btn-default btn-edit padding-top-2-bottom-4 margin-left-0 col-xs-6 col-sm-6 col-md-6"
					ng-click="createModalItemRelServHotelRoomImage()">
					<i class="fa fa-upload pull-left"></i>
					<spring:message code="default.upload" />
				</button>
				<button type="button" 
					class="btn btn-default btn-reload padding-top-2-bottom-4 
						   margin-left-0 col-xs-6 col-sm-6 col-md-6"
					ng-click="pickItemRelServHotelRoomImage()">
					<i class="glyphicon glyphicon-list-alt pull-left"></i>
					<spring:message code="default.pick" />
				</button>
			</div>
		</div>
	</div>
	<div class="row gallery">
		<br>
	  	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4 without-margin" 
	  		ng-repeat="item in item.relServHotelRoomImages track by $index">
  			<a ng-click="deleteItemRelServHotelRoomImage(item.id)" class="btn btn-default btn-delete boxclose">
				<i class="glyphicon glyphicon-trash"></i>
			</a>
			<img ng-src="../images/{{ ::item.image.label }}?size=300" class="img-responsive gallery-item">
		</div>
	</div>
</div>