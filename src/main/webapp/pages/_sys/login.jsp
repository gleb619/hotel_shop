<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/favicon.png" type="image/x-icon">
<link rel="stylesheet" href="resources/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/login.css">
<title>Login Page</title>
</head>
<body id="loginpage0" onload='document.loginForm.username.focus();'>
	<div class="container">
		<c:if test="${not empty error}">
			<div class="alert alert-danger alert-error">
				<a href="#" class="close" data-dismiss="alert">&times;</a>
				<strong>Error!</strong> ${error}
			</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-info">
				<a href="#" class="close" data-dismiss="alert">&times;</a>
				<strong>Note!</strong> ${msg}
			</div>
		</c:if>
		<c:if test="${debug}">
			<div class="alert alert-info">
				<a href="#" class="close" data-dismiss="alert">&times;</a>
				<strong>Credentials!</strong> You can enter with username: <b>user1</b> and password: <b>user1</b>
				<p>
					<button id="enterUser1" class="btn btn-lg btn-default">Enter</button>
				</p>
			</div>
			<div class="alert alert-info">
				<a href="#" class="close" data-dismiss="alert">&times; </a>
				<strong>Credentials!</strong> You can enter with username: <b>root1</b> and password: <b>root1</b>
				<p>
					<button id="enterManager_test" class="btn btn-lg btn-default">Enter</button>
				</p>
			</div>
		</c:if>
		<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="default.title" />
					</div>
				</div>
				<%-- <form name="loginForm" class="form-horizontal form-log-in" role="form" action="<c:url value='/login' />" --%>
				<form name="loginForm" class="form-horizontal form-log-in" role="form" action="login" method="POST">
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input id="username" name="username" class="form-control input-lg"
							placeholder="<spring:message code="default.email"/>" required autofocus />
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock"></i>
						</span>
						<input id="password" name="password" type="password" class="form-control input-lg"
							placeholder="<spring:message code="default.password"/>" required />
					</div>
					<%-- 
					<c:if test="${empty loginUpdate}">
						<label class="checkbox padding-left"> 
							<input type="checkbox" value="remember-me" /> 
							<spring:message code="default.rememberme" />
						</label>
					</c:if>
					--%>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="top-margin">
						<button id="submitBtn" name="submitBtn" type="submit" class="btn btn-lg btn-primary btn-block">
							<spring:message code="default.login" />
						</button>
					</div>
				</form>
			</div>
		</div>
		<br />
		<div class="centre">
			<a href="?language=ru" class="btn btn-lg">
				<img src="resources/images/ru.png" />
			</a>
			<a href="?language=en" class="btn btn-lg">
				<img src="resources/images/en.png" />
			</a>
		</div>
	</div>
</body>
<script type="text/javascript" src="resources/js/jquery/jquery-2.1.3.min.js"></script>
<c:if test="${login}">
	<script type="text/javascript" src="resources/js/debug/login.debug.js"></script>
</c:if>
</html>