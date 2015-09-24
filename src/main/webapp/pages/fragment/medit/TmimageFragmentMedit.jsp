<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-if="!loading" class="edit-form-body">
		<div class="modal-header header">
			<button type="button" class="close round-button" ng-click="cancel()">&times;</button>
			<h4 class="modal-title">
				<spring:message code="default.edit" /><spring:message code="label.TmImage" />
			<c:if test="${debug}">
				<a href="../data/tmimage/{{ ::item.id }}" target="_blank" class="btn btn-default"> JSON DATA </a>
			</c:if>
			</h4>
		</div>
		<div class="modal-body padding-top-0">
			<div class="row">
				</div>
			
				<div class="col-md-12 separator" />
				<div class="col-md-12 edit-block">
					<jsp:include page="../ledit/RelservhotelimageFragmentLedit.jsp" />
				</div>
			
				<div class="col-md-12 separator" />
				<div class="col-md-12 edit-block">
					<jsp:include page="../ledit/RelservhotelroomimageFragmentLedit.jsp" />
				<div class="col-sm-8 col-md-6 col-xs-offset-0 col-sm-offset-2 col-md-offset-3 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('path')">
						<label><spring:message code="label.path" /></label>
						<input type="text" ng-model="item.path" class="form-control" tabindex="1" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('extension')">
						<label><spring:message code="label.extension" /></label>
						<input type="text" ng-model="item.extension" class="form-control" tabindex="2" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('originalfilename')">
						<label><spring:message code="label.originalfilename" /></label>
						<input type="text" ng-model="item.originalfilename" class="form-control" tabindex="3" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('size')">
						<label><spring:message code="label.size" /></label>
						<input type="text" ng-model="item.size" class="form-control" tabindex="4" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('name')">
						<label><spring:message code="label.name" /></label>
						<input type="text" ng-model="item.name" class="form-control" tabindex="5" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('contenttype')">
						<label><spring:message code="label.contenttype" /></label>
						<input type="text" ng-model="item.contenttype" class="form-control" tabindex="6" />
					</div>
				</div>
			

			</div>
		</div>
		<div class="modal-footer">
			<div class="col-xs-6 col-md-6">
				<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
					<spring:message code="default.cancel" />
				</a>
			</div>
			<div class="col-xs-6 col-md-6">
				<a ng-click="updateItem()"
					class="btn btn-success btn-block btn-lg"> <spring:message
						code="default.submit" />
				</a>
			</div>
		</div>
  </div>
  <div ng-show="loading" class="loading-bar-holder border-none">
	<div class="loading-bar">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
  </div>
</div>
