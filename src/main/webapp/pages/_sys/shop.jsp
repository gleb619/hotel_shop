<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--  -->
<head>
	<meta charset="utf-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="author" content="Taimax" />
	<meta name="description" content="Tourism" />
	<meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
	<link rel="icon" href="../resources/images/favicon.png"
		type="image/x-icon" />
	
	<!-- <link rel="stylesheet"
		href="../resources/js/bootstrap/css/bootstrap.min.css"> -->
	<link rel="stylesheet"
		href="../resources/css/paper.bootstrap.min.css">
	<link rel="stylesheet" href="../resources/css/wrapper.css">
	
	
	<!-- <link rel="stylesheet"
		href="../resources/js/bootstrap/css/bootstrap-theme.min.css"> -->
	<link rel="stylesheet"
		href="../resources/js/bootstrap-module/css/datepicker3.css">
	<link rel="stylesheet"
		href="../resources/js/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet"
		href="../resources/js/plugins/animate.min.css">
	<link rel="stylesheet"
		href="../resources/css/timeline.css">
	<link rel="stylesheet" href="../resources/css/paper.styles.css">
		
	<!-- <link rel="stylesheet" href="bower_components/angular-motion/dist/angular-motion.css" /> -->
    <link rel="stylesheet" href="../resources/js/angular-module/css/angular-gantt.css" />
    <link rel="stylesheet" href="../resources/js/angular-module/css/angular-gantt-plugins.css" />
	<!-- 
	<link rel="stylesheet"
		href="../resources/js/angular-module/css/select.min.css">
	 -->
	<title>Index page</title>
</head>
<body ng-app="tourismApp" class="has-navbar">
	 <div class="navbar navbar-inverse navbar-fixed-top top-navbar animated bounceInDown">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="#">Hotel shop</a>
                </div>
                <div class="navbar-collapse collapse navbar-inverse-collapse">
                  <ul class="nav navbar-nav">
						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li class="active"><a href="#">Home</a></li>
								<li class="divider"></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
                  <form class="navbar-form navbar-right">
                  	<div class=" has-feedback search" ng-controller="SearchCtrl">
                    	<input type="text" class="form-control" placeholder="Search">
                    	<i class="form-control-feedback glyphicon glyphicon-search"></i>
                    </div>
                  </form>
                </div>
              </div>

	<div id="mainPanel"  class="col-md-12 container" ng-controller="IndexCtrl">
		<div id="loadingBar" ng-show="loading" class="app-content-loading">
			<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
		</div>
		<ng-view id="app_content" class="app-content" ng-hide="loading"></ng-view>
	</div>

</body>

<script type="text/javascript"
	src="../resources/js/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jquery/jquery.ba-throttle-debounce.min.js"></script>
<script type="text/javascript"
	src="../resources/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../resources/js/bootstrap-module/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="../resources/js/bootstrap-module/js/locales/bootstrap-datepicker.ru.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		checkScreenSize();
	});

	$(window).resize(function() {
		checkScreenSize();
	});

	function checkScreenSize() {
		/* 
		if ($(window).width() < 768) {
			if ($("#wrapper").hasClass("toggled")) {
				$("#wrapper").removeClass("toggled");
			}
		}
		if ($(window).width() > 768) {
			if (!$("#wrapper").hasClass("toggled")) {
				$("#wrapper").addClass("toggled");
			}
		}
		 */
		 
		$('#loadingBar').css({ top: ($(window).height() / 2) + 100 });
	}
	
</script>
<script type="text/javascript" 
	src="../resources/js/jquery/date.js"></script>
<script type="text/javascript" 
	src="../resources/js/jsog/jsog-master/lib/JSOG.js"></script>
<script type="text/javascript" 
	src="../resources/js/other/moment.js"></script>
<!-- <script type="text/javascript" 
	src="../resources/js/plugins/wow.min.js"></script> -->
<script type="text/javascript"
	src="../resources/js/angular/angular.min.js"></script>
<script type="text/javascript"
	src="../resources/js/angular/angular-route.min.js"></script>
<script type="text/javascript"
	src="../resources/js/angular/angular-resource.min.js"></script>
<script type="text/javascript"
	src="../resources/js/angular/angular-animate.js"></script>

<script type="text/javascript"
	src="../resources/js/angular-module/js/angular-moment.min.js"></script>
<script type="text/javascript"
	src="../resources/js/angular-module/js/draganddrop.js"></script>
<script type="text/javascript"
	src="../resources/js/angular-module/angular-file-upload-master/angular-file-upload.min.js"></script>
<script type="text/javascript"
	src="../resources/js/angular-module/ngInfiniteScroll-1.0.0/build/ng-infinite-scroll.min.js"></script>
	
	<!-- 
    <script src="bower_components/angular-animate/angular-animate.js"></script>
    <script src="bower_components/angular-strap/dist/angular-strap.js"></script>
    <script src="bower_components/angular-strap/dist/angular-strap.tpl.js"></script>
    <script src="bower_components/moment/moment.js"></script>
    <script src="bower_components/angular-moment/angular-moment.js"></script>
    <script src="bower_components/angular-native-dragdrop/draganddrop.js"></script>
     -->
     
    <script src="../resources/js/angular-module/mgcrea-angular-strap-63cc89e/dist/angular-strap.js"></script>
    <script src="../resources/js/angular-module/mgcrea-angular-strap-63cc89e/dist/angular-strap.tpl.js"></script>
    <script src="../resources/js/angular-module/js/angular-gantt.js"></script>
    <script src="../resources/js/angular-module/js/angular-gantt-plugins.js"></script>
	
<!-- 
<script type="text/javascript"
	src="../resources/js/angular-module/js/select.js"></script>
 -->
 <script type="text/javascript"
	src="../resources/js/angular-module/js/ui-bootstrap-tpls-0.11.2.js"></script>
<!-- <script type="text/javascript"
	src="../resources/js/angular-module/js/ui-bootstrap-0.11.2.min.js"></script> -->
<script type="text/javascript" src="../resources/js/app.js"></script>
<script type="text/javascript"
	src="../resources/js/services/services.js"></script>
<script type="text/javascript"
	src="../resources/js/controllers/controllers.js"></script>
<script type="text/javascript"
	src="../resources/js/directives/directives.js"></script>
<script type="text/javascript"
	src="../resources/js/util/ComplexTypeStorage.js"></script>
</html>