<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="sidebar">
	<a href="#menu-toggle" class="btn my-btn-lg-2" id="menu-toggle" onclick="blur()">
		<i class="glyphicon glyphicon-th-list"></i>
		<span id="menu-toggle-label">
			<spring:message code="default.hide" />
		</span>
	</a>
	<div class="menu-bar-collapsed">
		<a class="btn menu-bar-separator" href="#/">
			
		</a>
		<a class="btn menu-bar-item" href="#/standart_layout" title="<spring:message code="default.layout.standart" />">
			<i class="fa-lg fa fa-university"></i>
		</a>
		<a class="btn menu-bar-item" href="#/layout_3" title="<spring:message code="default.layout.number" /> 3">
			<i class="fa-lg fa fa-cube"></i>
		</a>
		<a class="btn menu-bar-item" href="#/" title="<spring:message code="default.layout.number" /> 4">
			<i class="fa-lg fa fa-bookmark"></i>
		</a>
		<a class="btn menu-bar-item" href="#/all_modules" title="<spring:message code="default.all-modules" />">
			<i class="fa-lg fa fa-folder"></i>
		</a>
		<a class="btn menu-bar-item" href="#/help" title="<spring:message code="default.help" />">
			<i class="fa-lg fa fa-question-circle"></i>
		</a>
	</div>
	<a class="btn my-btn-lg-2" id="scrollToTopBtn" scrollTo="#app_content">
		<i class="glyphicon glyphicon-chevron-up"></i>
	</a>
	<div class="menu-bar navigator">
		<button class="btn btn-default form-control navigator-item" ng-click="isCollapsed = !isCollapsed">
			Calendar <i class="fa fa-2x fa-calendar pull-left"></i>
		</button>
		<div id="sidebar-wrapper-content" collapse="isCollapsed" class="calendar">
			<datepicker ng-model="lastMonth" 	show-weeks="true" ng-click="openTimeLine(lastMonth)" 	class="well well-sm"></datepicker>
			<datepicker ng-model="currentMonth" show-weeks="true" ng-click="openTimeLine(currentMonth)" class="well well-sm"></datepicker>
			<datepicker ng-model="nextMonth" 	show-weeks="true" ng-click="openTimeLine(nextMonth)" 	class="well well-sm"></datepicker>
		</div>
		<button class="btn btn-default form-control navigator-item" ng-click="isCollapsed2 = !isCollapsed2">
			Other <i class="fa fa-2x fa-bullseye pull-left"></i>
		</button>
		<div collapse="isCollapsed2">Other</div>
	</div>
</div>
