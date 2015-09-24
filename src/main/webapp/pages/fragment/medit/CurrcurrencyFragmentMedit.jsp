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
				<spring:message code="default.edit" /><spring:message code="label.CurrCurrency" />
			<c:if test="${debug}">
				<a href="../data/currcurrency/{{ ::item.id }}" target="_blank" class="btn btn-default"> JSON DATA </a>
			</c:if>
			</h4>
		</div>
		<div class="modal-body padding-top-0">
			<div class="row">
				<div class="col-sm-8 col-md-6 col-xs-offset-0 col-sm-offset-2 col-md-offset-3 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.label" class="form-control" tabindex="1" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('isbase')">
						<input type="checkbox" ng-model="item.isbase" tabindex="2"/>
						<label><spring:message code="label.isbase" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameeng')">
						<label><spring:message code="label.nameeng" /></label>
						<input type="text" ng-model="item.nameeng" class="form-control" tabindex="3" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('currencyname')">
						<label><spring:message code="label.currencyname" /></label>
						<input type="text" ng-model="item.currencyname" class="form-control" tabindex="4" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameru')">
						<label><spring:message code="label.nameru" /></label>
						<input type="text" ng-model="item.nameru" class="form-control" tabindex="5" />
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="6"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
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
