<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-if="!loading">
		<div class="modal-header">
			<div class="row">
				<div class="col-xs-10 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordTmImage" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.searchKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
				<c:if test="${debug}">
					<div class="col-xs-2">
						<button type="button" class="close round-button" ng-click="cancel()">&times;</button>
						<a href="../data/tmimage/{{ ::item.id }}" target="_blank" class="btn btn-default">
							JSON DATA
						</a>
					</div>
				</c:if>
			</div>
		</div>
		<div class="row modal-body padding-top-0 selector-gallery">
			<br>
		  	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" 
		  		ng-repeat="item in dataTmImage track by $index | filter:searchKeywordTmImage"
		  		ng-class="{ 'selected-gallery-item' : item.checked }">
		  		<input type="checkbox" class="form-control boxclose-checkbox"
		  			   ng-model="item.checked" ng-change="onSelectionChanged(item)" />
		  		<div class="gallery-item">
					<img ng-src="../images/{{ ::item.label }}?size=300" class="img-responsive">
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
				<a ng-click="submitFunc()"
					class="btn btn-success btn-block btn-lg"> <spring:message
						code="default.submit" />
				</a>
			</div>
		</div>
	</div>
	 <div class="modal-content border-none" ng-show="loading">
		<div class="app-content-loading">
			<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
		</div>
	</div>
</div>
