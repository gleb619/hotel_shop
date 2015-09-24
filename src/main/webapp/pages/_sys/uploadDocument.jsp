<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div nv-file-drop="" uploader="uploader">
<div class="modal-content" ng-hide="loading">
	<div class="modal-header">
		<button type="button" class="close" ng-click="cancel()">&times;</button>
		<h4 class="modal-title">
			Upload Documents
		</h4>
	</div>
	<div class="modal-body padding-top-0">
		<div class="row">
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
			
			<table class="table">
                <thead>
                    <tr>
                        <th width="50%">Name</th>
                        <th ng-show="uploader.isHTML5">Size</th>
                        <th ng-show="uploader.isHTML5">Progress</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="item in uploader.queue">
                        <td><strong>{{ item.file.name }}</strong></td>
                        <td ng-show="uploader.isHTML5" nowrap>{{ item.file.size/1024/1024|number:2 }} MB</td>
                        <td ng-show="uploader.isHTML5">
                            <div class="progress" style="margin-bottom: 0;">
                                <div class="progress-bar" role="progressbar" ng-style="{ 'width': item.progress + '%' }"></div>
                            </div>
                        </td>
                        <td class="text-center">
                            <span ng-show="item.isSuccess"><i class="glyphicon glyphicon-ok"></i></span>
                            <span ng-show="item.isCancel"><i class="glyphicon glyphicon-ban-circle"></i></span>
                            <span ng-show="item.isError"><i class="glyphicon glyphicon-remove"></i></span>
                        </td>
                    </tr>
                </tbody>
            </table>
		</div>
	</div>
	<div class="modal-footer">
		<div class="col-xs-6 col-md-6">
			<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
				<spring:message code="default.cancel" />
			</a>
		</div>
		<div class="col-xs-6 col-md-6">
			<a ng-click="submitFunc()" class="btn btn-success btn-block btn-lg"> 
				<spring:message code="default.submit" />
			</a>
		</div>
	</div>
</div>
 <div class="modal-content progress-holder" ng-show="loading">
 	<div id="loadingBar" class="app-content-loading" ng-hide="uploading">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
	
	<div ng-show="uploading">
	 	<progressbar class="progress-striped active" value="uploader.progress" type="info"><b>{{ uploader.progress }}%</b></progressbar>
	 	<div>
	 		<div ng-repeat="item in uploader.queue">
	 			<strong>{{ item.file.name }}</strong>
	 			<span>
	 				<span ng-show="item.isSuccess"><i class="glyphicon glyphicon-ok"></i></span>
                    <span ng-show="item.isCancel"><i class="glyphicon glyphicon-ban-circle"></i></span>
                    <span ng-show="item.isError"><i class="glyphicon glyphicon-remove"></i></span>
	 			</span>
	 		</div>
	 	</div>
	</div>
</div>
</div>
