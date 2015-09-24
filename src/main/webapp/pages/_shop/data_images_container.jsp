<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <div class="grid images_3_of_2"> -->
<div class="col-md-6">
	<div class="easyzoom easyzoom--overlay easyzoom--with-thumbnails bounceInLeft wow">
	    <a href="../images/{{ item.image }}?scale=2">
	        <img ng-src="../images/{{ item.image }}" class="img-responsive" />
	    </a>
	</div>
	
	<div class="clearfix"></div>
</div>
