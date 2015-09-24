<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('locationcountries')">
				<span class="list-group-item-caption"><spring:message code="label.locationCountries" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcountries.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('nameeng')">
				<span class="list-group-item-caption"><spring:message code="label.nameeng" /></span>
				<span class="pull-right">{{ ::selectedItem.nameeng }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('cityname')">
				<span class="list-group-item-caption"><spring:message code="label.cityname" /></span>
				<span class="pull-right">{{ ::selectedItem.cityname }}</span>
			</li>

		</ol>
	</div>
</div>