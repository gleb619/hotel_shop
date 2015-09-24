<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!-- <div class="navbar navbar-inverse navbar-fixed-top top-navbar animated bounceInDown"> -->
<!-- <div class="navbar navbar-inverse navbar-fixed-top top-navbar" ng-class="::{ 'animated bounceInDown': $storage.benchmark_result.power }"> -->
<div class="navbar navbar-inverse navbar-fixed-top top-navbar">
	<div class="navbar-header">
		<!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-inverse-collapse"> -->
		<button type="button" class="navbar-toggle">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand">Taimax tourism</a>
	</div>
	<div class="navbar-collapse collapse navbar-inverse-collapse">
		<ul class="nav navbar-nav">
			<li class="active">
				<a href="#/"><spring:message code="default.home" /></a>
			</li>

			<li dropdown>
				<a class="dropdown-toggle" dropdown-toggle>
					<spring:message code="default.settings" />
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu" role="menu">
					<li>
						<a href="../crm/index">Dizain vol.1</a>
					</li>
					<li>
						<a href="../crm/index2">Dizain vol.2</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#/shop_landscape">Shop</a>
						<a href="#/shop_landscape_2">Shop2</a>
					</li>
				<c:if test="${debug}">
					<li class="divider"></li>
					<li class="dropdown-header">Debug features</li>
					<li>
						<a href="#/logs">Logs</a>
					</li>
					<li>
						<a href="#/localization">Localization</a>
					</li>
				</c:if>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
    				<li class="divider"></li>
					<li class="dropdown-header">Admin features</li>
					<li>
						<a href="#/TmfirmsList">Firms</a>
					</li>
					<li>
						<a href="#/UsersList">Users</a>
					</li>
					<li>
						<a href="#/ruser">RUSER</a>
					</li>
				</sec:authorize>
					<li class="divider"></li>
					<li class="dropdown-header">Settings</li>
					<li>
						<a href="#/settings">Local settings</a>
					</li>
				</ul>
			</li>
		</ul>
		<form class="navbar-form navbar-right">
			<div class="transparent-holder-inverse has-feedback">
				<input type="text" class="transparent-input form-control" placeholder="Search"> <i
					class="form-control-feedback glyphicon glyphicon-search"></i>
			</div>
		</form>
		<!-- 
		<ul class="nav navbar-nav">
			<li>
				<a class="navbar-clock" ng-cloak>{{ clock | date:'HH:mm' }}</a>
			</li>
		</ul>
		 -->
		<ul class="nav navbar-nav right-item">
			<li class="dropdown" dropdown>
				<a class="dropdown-toggle" dropdown-toggle>
					<span class="glyphicon glyphicon-user"></span>
					<strong><sec:authentication property="principal.username" /></strong>
					<span class="caret"></span>
				</a>
				<ul class="user-details dropdown-menu" role="menu">
					<li>
						<div class="navbar-login">
							<div class="row">
								<div class="col-lg-4">
									<p class="text-center">
										<span class="glyphicon glyphicon-user icon-size"></span>
									</p>
								</div>
								<div class="col-lg-8">
									<p class="text-left">
										<strong> <sec:authentication property="principal.user.firstName" /> <sec:authentication
												property="principal.user.lastName" />
										</strong>
									</p>
									<p class="text-left small">
										<sec:authentication property="principal.user.email" />
									</p>
									<p class="text-left">
										<a class="btn btn-primary btn-block btn-sm">
											<spring:message code="default.detail" />
										</a>
									</p>
								</div>
							</div>
						</div>
					</li>
					<li class="divider"></li>
					<li>
						<div class="navbar-login navbar-login-session">
							<div class="row">
								<div class="col-lg-12">
									<p>
										<a href="../login?logout" class="btn btn-danger btn-block">
											<spring:message code="default.logout" />
										</a>
									</p>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</div>