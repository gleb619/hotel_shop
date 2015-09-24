<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('reqservhotel')">
				<span class="list-group-item-caption"><spring:message code="label.reqServHotel" /></span>
				<span class="pull-right">{{ ::selectedItem.reqservhotel.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmcontacteasy')">
				<span class="list-group-item-caption"><spring:message code="label.tmContactEasy" /></span>
				<span class="pull-right">{{ ::selectedItem.tmcontacteasy.label }}</span>
			</li>

		</ol>
	</div>
</div>