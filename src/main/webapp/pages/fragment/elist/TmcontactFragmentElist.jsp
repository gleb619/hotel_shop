<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('contactname')">
				<span class="list-group-item-caption"><spring:message code="label.contactName" /></span>
				<span class="pull-right">{{ ::selectedItem.contactname }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('contactpatronymic')">
				<span class="list-group-item-caption"><spring:message code="label.contactPatronymic" /></span>
				<span class="pull-right">{{ ::selectedItem.contactpatronymic }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('contactsurname')">
				<span class="list-group-item-caption"><spring:message code="label.contactSurname" /></span>
				<span class="pull-right">{{ ::selectedItem.contactsurname }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('birthday')">
				<span class="list-group-item-caption"><spring:message code="label.birthday" /></span>
				<span class="pull-right">{{ ::selectedItem.birthday }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('passportenddate')">
				<span class="list-group-item-caption"><spring:message code="label.passportEndDate" /></span>
				<span class="pull-right">{{ ::selectedItem.passportenddate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('passportstartdate')">
				<span class="list-group-item-caption"><spring:message code="label.passportStartDate" /></span>
				<span class="pull-right">{{ ::selectedItem.passportstartdate }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('locationcountries')">
				<span class="list-group-item-caption"><spring:message code="label.locationCountries" /></span>
				<span class="pull-right">{{ ::selectedItem.locationcountries.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('passportnumber')">
				<span class="list-group-item-caption"><spring:message code="label.passportNumber" /></span>
				<span class="pull-right">{{ ::selectedItem.passportnumber }}</span>
			</li>

		</ol>
	</div>
</div>