<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Hotels shop</title>
<link rel="icon" href="../resources/images/favicon_32.png" type="image/x-icon">
<link rel="stylesheet" href="../resources/css/bootstrap.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" type="text/css">
<link rel="stylesheet" href="../resources/js/plugins/animate.min.css">
<link rel="stylesheet" href="../resources/js/angular-module/ngToaster/toaster.min.css">
<link rel="stylesheet" href="../resources/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/js/jquery/easyzoom/css/easyzoom.css"   type="text/css" media="all" />
<link rel="stylesheet"  href="http://cdn.jsdelivr.net/angular.wizard/latest/angular-wizard.min.css" type="text/css" >	
<link rel="stylesheet" href="../resources/css/animate.css"   type="text/css" media="all" />	
<link rel="stylesheet" href="../resources/css/style.css"   type="text/css" media="all" />	
<link rel="stylesheet" href="../resources/css/project.css"   type="text/css" media="all" />	
</head>
<body ng-app="shopApp" id="body" affix>
	<div class="app-content-loading" ng-show="loading">
		<div class="center">
			<i class="fa-3x glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
		</div>
	</div>
	<toaster-container toaster-options="::{ 'position-class': 'toast-top-full-width' }"></toaster-container>
	<div ng-view ng-cloak class="app-content" ng-if="!loading"></div>
	<input id="key_holder" type="hidden" value="${key}">
</body>
<jsp:include page="footer.jsp" />
</html>