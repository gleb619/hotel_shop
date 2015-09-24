<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servkidsrule.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('startage')">
						<label><spring:message code="label.startAge" /></label>
						<input type="number" ng-model="item.servkidsrule.startage" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('endage')">
						<label><spring:message code="label.endAge" /></label>
						<input type="number" ng-model="item.servkidsrule.endage" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('name')">
						<label><spring:message code="label.name" /></label>
						<input type="text" ng-model="item.servkidsrule.name" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('synopsys')">
						<label><spring:message code="label.synopsys" /></label>
						<input type="text" ng-model="item.servkidsrule.synopsys" class="form-control" tabindex="5" />
					</div>
				</div>
			

</div>
