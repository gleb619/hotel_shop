<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dicttype')">
						<label><spring:message code="label.dictType" /></label>
						<input type="text" ng-model="item.dictglobal.dicttype" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictvalue')">
						<label><spring:message code="label.dictValue" /></label>
						<input type="text" ng-model="item.dictglobal.dictvalue" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictvalueadditional')">
						<label><spring:message code="label.dictValueAdditional" /></label>
						<input type="text" ng-model="item.dictglobal.dictvalueadditional" class="form-control" tabindex="3" />
					</div>
				</div>
			

</div>
