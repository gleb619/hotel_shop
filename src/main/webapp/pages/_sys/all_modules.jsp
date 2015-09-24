<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div>
	<h4>List of Modules</h4>
	
	<div class="has-feedback filterBar">
		<input type="text" ng-model="modulesFilter" class="form-control"
			placeholder="<spring:message code="default.filterKeyword" />">
		<i class="form-control-feedback glyphicon glyphicon-search"></i>
	</div>
	
	<div class="box-holder">
		<div ng-repeat="item in filteredModules = ( modules | filter:modulesFilter )" class="col-md-6 box-item-medium">
			<div class="box-item-medium-content">
				<div class="col-md-2 center-content">
					<i class="icon-cell {{ ::item.cls }}"></i>
				</div>
				<div class="col-md-10">
					<a href="#/{{ ::item.url }}">
						<strong>{{ ::item.nameRus }}</strong>
					</a>
					<p>Eng name: {{ ::item.name }}</p>
					<p>Group: {{ ::item.group }}</p>
					<p>{{ ::item.descriptions }}</p>
				</div>
			</div>
		</div>
	</div>
</div>