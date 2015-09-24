<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="header">
	<div class="bottom-header">
		<div class="container">
			<div class="header-bottom-left">
				<div class="col-xs-2">
					<div class="logo">
						<a href="#/"><h2>Shop</h2></a>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="login-holder">
						<sec:authorize access="isAnonymous()">
							<a href="#/login_page"> <span> Вход </span> </a>
							<span>|</span>
							<a href="#/register_page">Регистрация</a>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
							<i class="fa fa-user"></i>
							<span> <sec:authentication property="principal.username" /> </span>
							<span>|</span>
							<a href="../login?logout&redirectTo=d/index3">LOGOUT</a>
						</sec:authorize>
						<!-- 
						<ul class="login">
							<li> <a href="login.html"> <span> LOGIN </span> </a> </li>
							<li>|</li>
							<li>
								<a href="register.html">SIGNUP</a>
							</li>
						</ul>
						 -->
						<!-- <div class="clearfix"></div> -->
					</div>
				</div>
				<div class="col-xs-8">
				
					<div class="input-group search-holder">
						<input type="text" class="form-control" placeholder="Искать..."
								ng-model="search.query"
								ng-model-options="{ debounce: 300 }"
								ng-change="search()"
						>
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
					<!-- 
					<div class="search">
						<input type="text" placeholder="Search for..."
								ng-model="search.query"
								ng-model-options="{ debounce: 300 }"
								ng-change="search()"
						>
						<button class="btn-lg btn btn-default pull-right" type="button">
							<i class="fa fa-search"></i>
						</button>
					</div>
					 -->
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- 
			<div class="header-bottom-right">
				<div class="account">
					<a href="login.html">
						<span> </span>
						YOUR ACCOUNT
					</a>
				</div>
				<ul class="login">
					<li>
						<a href="login.html">
							<span> </span>
							LOGIN
						</a>
					</li>
					|
					<li>
						<a href="register.html">SIGNUP</a>
					</li>
				</ul>
				<div class="cart">
					<a href="#">
						<span> </span>
						CART
					</a>
				</div>
				<div class="clearfix"></div>
			</div>
			-->
			<div class="clearfix"></div>
		</div>
	</div>
</div>