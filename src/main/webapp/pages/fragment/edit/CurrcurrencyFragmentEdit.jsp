<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.currcurrency.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('isbase')">
						<input type="checkbox" ng-model="item.currcurrency.isbase" tabindex="2"/>
						<label><spring:message code="label.isbase" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameeng')">
						<label><spring:message code="label.nameeng" /></label>
						<input type="text" ng-model="item.currcurrency.nameeng" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currencyname')">
						<label><spring:message code="label.currencyname" /></label>
						<input type="text" ng-model="item.currcurrency.currencyname" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameru')">
						<label><spring:message code="label.nameru" /></label>
						<input type="text" ng-model="item.currcurrency.nameru" class="form-control" tabindex="5" />
					</div>
				</div>
			

</div>
