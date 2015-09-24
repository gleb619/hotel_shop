<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="col-md-6 edit-block">
		<ya-map ya-zoom="10" ya-after-init="afterInit($target)" ya-event-click="mapClickLocationaddressFragmentEdit($event)">
			<ya-geo-object ya-source="markerStore"></ya-geo-object>
		</ya-map>
	</div>
	<div class="col-md-6 edit-block-2">
		<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
			<label><spring:message code="label.label" /></label>
			<input type="text" ng-model="item.locationaddress.label" class="form-control" tabindex="1" />
		</div>							 
		
		<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
			<label><spring:message code="label.descr" /></label>
			<div class="custom-textarea-holder">
				<textarea type="text" ng-model="item.locationaddress.descr" class="form-control custom-textarea">
				</textarea>
			</div>
		</div>
	</div>
</div>
