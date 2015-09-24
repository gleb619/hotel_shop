<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>

<nav class="navbar navbar-default" ng-class="::{ 'animated bounceInDown': animation.power }">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" collapse-target=".navbar-collapse" collapse-class="collapse">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <c:if test="${!empty param.home_url}">
      	<a class="navbar-brand" href="${param.home_url}">Shop</a>
      </c:if>
      <c:if test="${empty param.home_url}">
      	<a class="navbar-brand" href="#/">Shop</a>
      </c:if>
    </div>

    <div class="collapse navbar-collapse">
		<ul class="nav navbar-nav navbar-left">
			<sec:authorize access="isAnonymous()">
				<li><a href="#/login_page"><span>Вход</span></a></li>
				<li class="divider-vertical"></li>
				<li><a href="#/register_page">Регистрация</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li><i class="fa fa-user"></i></li>
				<li><span><sec:authentication property="principal.username" /></span></li>
				<li class="divider-vertical"></li>
				<li><a href="../login?logout&redirectTo=d/index3">Выйти</a></li>
			</sec:authorize>
			<c:if test="${debug}">
				<li class="divider-vertical"></li>
				<li><a href="#/widget_search">Search widget</a></li>
			</c:if>
		</ul>
		
		<form class="navbar-form navbar-right navbar-input-group" role="search">
			<div class="form-group">
				<input type="search" class="form-control" placeholder="Искать..."
					ng-model="search.query"
					ng-model-options="{ debounce: 500 }"
					ng-enter="searchHotel(true)"
					ng-change="searchHotel()">
			</div>
			<button type="button" class="btn btn-default" ng-click="searchHotel(true)">
				<i class="fa fa-search"></i>
			</button>
		</form>
    </div>
  </div>
</nav>