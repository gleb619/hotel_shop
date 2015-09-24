<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.docdocuments.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('realfile')">
						<input type="checkbox" ng-model="item.docdocuments.realfile" tabindex="2"/>
						<label><spring:message code="label.realfile" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('extension')">
						<label><spring:message code="label.extension" /></label>
						<input type="text" ng-model="item.docdocuments.extension" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('contenttype')">
						<label><spring:message code="label.contenttype" /></label>
						<input type="text" ng-model="item.docdocuments.contenttype" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('path')">
						<label><spring:message code="label.path" /></label>
						<input type="text" ng-model="item.docdocuments.path" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('originalfilename')">
						<label><spring:message code="label.originalfilename" /></label>
						<input type="text" ng-model="item.docdocuments.originalfilename" class="form-control" tabindex="6" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('size')">
						<label><spring:message code="label.size" /></label>
						<input type="text" ng-model="item.docdocuments.size" class="form-control" tabindex="7" />
					</div>
				</div>
			

</div>
