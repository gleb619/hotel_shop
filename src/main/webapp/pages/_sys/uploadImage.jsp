<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div nv-file-drop="" uploader="uploader">
<!-- 
<style>
.nv-file-over { 
	border: dotted 3px red; 
} 
</style>
 -->
<div class="modal-content" ng-hide="loading">
	<div class="modal-header">
		<button type="button" class="close" ng-click="cancel()">&times;</button>
		<h4 class="modal-title">
			Upload Images
		</h4>
	</div>
	<div class="modal-body padding-top-0">
		<div class="row">
			<%-- <jsp:include page="../upload2.jsp"></jsp:include> --%>			
			
			<div class="col-md-8">
		       <div class="well my-drop-zone" nv-file-over="" uploader="uploader" ng-show="uploader.isHTML5">
		           Drop here !!!
		       </div>
			</div>
			<div class="col-md-1" style="text-align: center;">
				<h3>OR</h3>
			</div>
			<div class="col-md-2">
				<input type="file" nv-file-select="" uploader="uploader" multiple />
			</div>
			
		</div>
		<div class="row canvas-gallery">
			<hr class="separator">
			
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 without-margin" ng-repeat="item in uploader.queue">
				<button type="button" class="btn btn-default btn-delete boxclose" ng-click="item.remove()">
	                <span class="glyphicon glyphicon-trash"></span>
	            </button>
				<div ng-show="uploader.isHTML5" ng-thumb="{ file: item._file, height: 150 }" class="gallery-item"></div>
			</div>
		</div>
		<!-- 
		<div class="row" ng-show="uploader.queue.length > 0">
			<hr class="separator">
			<p>
				Queue length: {{ uploader.queue.length }} 
				<button type="button" class="btn btn-success btn-s" ng-click="uploader.uploadAll()" ng-disabled="!uploader.getNotUploadedItems().length">
	                <span class="glyphicon glyphicon-upload"></span> Upload all
	            </button>
	            <button type="button" class="btn btn-danger btn-s" ng-click="uploader.clearQueue()" ng-disabled="!uploader.queue.length">
	                <span class="glyphicon glyphicon-trash"></span> Remove all
	            </button>
	        </p>
		</div>
		 -->
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
 <div class="modal-content" ng-show="loading" ng-class="{ 'border-none': loading }">
	<div id="loadingBar" class="app-content-loading">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
</div>
</div>
