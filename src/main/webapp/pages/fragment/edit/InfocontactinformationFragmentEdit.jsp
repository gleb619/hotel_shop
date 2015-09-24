<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('contact')">
						<label><spring:message code="label.contact" /></label>
						<input type="text" ng-model="item.infocontactinformation.contact" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.infocontactinformation.label" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('email3')">
						<label><spring:message code="label.email3" /></label>
						<input type="text" ng-model="item.infocontactinformation.email3" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('email2')">
						<label><spring:message code="label.email2" /></label>
						<input type="text" ng-model="item.infocontactinformation.email2" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('website')">
						<label><spring:message code="label.website" /></label>
						<input type="text" ng-model="item.infocontactinformation.website" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('phone')">
						<label><spring:message code="label.phone" /></label>
						<input type="text" ng-model="item.infocontactinformation.phone" class="form-control" tabindex="6" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('phone2')">
						<label><spring:message code="label.phone2" /></label>
						<input type="text" ng-model="item.infocontactinformation.phone2" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('phone3')">
						<label><spring:message code="label.phone3" /></label>
						<input type="text" ng-model="item.infocontactinformation.phone3" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('email')">
						<label><spring:message code="label.email" /></label>
						<input type="text" ng-model="item.infocontactinformation.email" class="form-control" tabindex="9" />
					</div>
				</div>
			

</div>
