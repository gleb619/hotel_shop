<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-hide="loading">
		<div class="modal-header header" cdraggable movable-id="modal-body">
			<button type="button" class="close round-button" ng-click="cancel()">
				<span>&times;</span>
			</button>
			<h4 class="modal-title">
				{{ item.label }}
				
				<a href="../data/servhotel/{{ item.id }}" target="_blank" class="btn btn-default">
					JSON DATA
				</a>
				
			</h4>
		</div>

		<div class="modal-body padding-top-0">
			<tabset justified="true">
    		<tab heading="Hotel" active="tabsFocus.hotel.main">
    			<jsp:include page="/pages/_sys/hotelDetail.jsp" />
    		</tab>
    		<tab heading="Request" active="tabsFocus.request.main">
    			<jsp:include page="/pages/_sys/requestServhotel.jsp" />
    		</tab>
    		</tabset>
		</div>
		<div class="modal-footer">
			<div class="col-xs-6 col-md-6 text-overflow">
				<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
					<span><spring:message code="default.cancel" /></span>
				</a>
			</div>
			<div class="col-xs-6 col-md-6 text-overflow">
				<a ng-click="submit()" class="btn btn-success btn-block btn-lg" ng-show="tabsFocus.request.contact"> 
					<span><spring:message code="default.send-request" /></span>
				</a>
				<a ng-click="next()" class="btn btn-primary btn-block btn-lg" ng-hide="tabsFocus.request.contact"> 
					<span><spring:message code="default.next" /></span>
				</a>
			</div>
		</div>
  </div>
  <div ng-show="loading" ng-class="{ 'border-none': loading }" class="loading-bar-holder">
	<div id="loadingBar" class="loading-bar">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
  </div>
</div>
