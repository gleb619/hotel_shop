
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" 	content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" 	content="IE=edge" />
<meta name="viewport" 		content="width=device-width, initial-scale=1" />
<meta name="author" 		content="Taimax" />
<meta name="description" 	content="Tourism" />
<link rel="icon" 		href="../resources/images/favicon.png" type="image/x-icon" />
<link rel="stylesheet" 	href="../resources/css/paper.bootstrap.min.css">
<link rel="stylesheet" 	href="../resources/css/paper.wrapper.min.css">
<link rel="stylesheet" 	href="../resources/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" 	href="../resources/js/plugins/animate.min.css">
<link rel="stylesheet" 	href="../resources/js/angular-module/ngToaster/toaster.min.css">
<link rel="stylesheet"  href="http://cdn.jsdelivr.net/angular.wizard/latest/angular-wizard.min.css" type="text/css" >
<link rel="stylesheet" 	href="../resources/css/paper.timeline.min.css">
<link rel="stylesheet" 	href="../resources/css/paper.styles.css">
<!-- <link rel="stylesheet" href="../resources/css/shop.css"> -->
<title>Index page</title>
</head>
<body ng-app="tourismApp" class="has-navbar" ng-controller="IndexCtrl" onload="onLoad()">
<!-- <body ng-app="tourismApp" class="has-navbar" onload="onLoad()"> -->
	<jsp:include page="navbar.jsp" />
	<div id="wrapper">
		<c:if test="${showCalendar}">
			<!-- <div class="sidebar-wrapper" ng-class="::{ 'animated bounceInLeft': $storage.benchmark_result.power }"> -->
			<div class="sidebar-wrapper">
				<jsp:include page="sidebar.jsp" />
			</div>
		</c:if>
		<!-- <div class="page-content-wrapper" ng-class="::{ 'animated fadeIn': $storage.benchmark_result.power }"> -->
		<div class="page-content-wrapper">
			<div id="app-body" class="col-md-12 my-container-2">
				<toaster-container toaster-options="{ 'position-class': 'toast-top-full-width' }"></toaster-container>
				<div id="loadingBar" ng-show="loading" class="app-content-loading">
					<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
				</div>
				<ng-view id="app_content" ng-cloak class="app-content" ng-if="!loading"></ng-view>
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp" />
</html>