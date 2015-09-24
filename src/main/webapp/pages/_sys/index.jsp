<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link rel="stylesheet" href="../resources/css/hero.bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/hero.wrapper.css">
<link rel="stylesheet"
	href="../resources/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/js/plugins/animate.min.css">
<link rel="stylesheet"
	href="../resources/js/angular-module/ngToaster/toaster.min.css">
<link rel="stylesheet" href="../resources/css/hero.timeline.css">
<link rel="stylesheet" href="../resources/css/hero.styles.css">
<title>Index page</title>
</head>
<body ng-app="tourismApp" class="has-navbar" ng-controller="IndexCtrl" onload="onLoad()">
	<jsp:include page="navbar.jsp" />
	<div id="wrapper">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Generate Data</h4>
					</div>
					<div class="modal-body">
						<div class="te">
							<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${showCalendar}">
			<div class="sidebar-wrapper">
				<jsp:include page="sidebar.jsp" />
			</div>
		</c:if>
		<div class="page-content-wrapper">
			<div id="app-body" class="col-md-12 my-container-2">
				<toaster-container></toaster-container>
				<div id="loadingBar" ng-show="loading" class="app-content-loading">
					<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
				</div>
				<ng-view id="app_content" class="app-content" ng-hide="loading"></ng-view>
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp" />
</html>