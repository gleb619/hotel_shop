<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>  
<div class="operation-holder row">

	<div class="col-md-12" ng-if="access.ownRequest">
		<div class="col-md-5">
			<button type="button" class="btn btn-primary" ng-click="taketomyself()">
				<span><spring:message code="default.take-to-myself.label" /></span>
			</button>
		</div>
		<div class="col-md-7">
			<label><spring:message code="default.take-to-myself.descr" /></label>
		</div>
	</div>
	<div class="col-md-12" ng-if="!access.ownRequest">
		<div class="col-md-5">
			<button type="button" class="btn btn-success">
				<span>{{ item.usersbyresponseuser.label }}</span>
			</button>
		</div>
		<div class="col-md-7">
			<label><spring:message code="default.not-mine.descr" /></label>
		</div>
	</div>
	
	<div class="col-md-12">
		<div class="col-md-5">
			<button type="button" class="btn btn-default" ng-click="hotelemailsend()" ng-disabled="!access.myRequest">
				<span><spring:message code="default.start-hotel-email-sending.label" /></span>
			</button>
		</div>
		<div class="col-md-7">
			<label><spring:message code="default.start-hotel-email-sending.descr" /></label>
		</div>
	</div>
	
	<div class="col-md-12">
		<div class="col-md-5">
			<button type="button" class="btn btn-default" ng-click="emailsend()" ng-disabled="!access.myRequest">
				<span><spring:message code="default.start-email-sending.label" /></span>
			</button>
		</div>
		<div class="col-md-7">
			<label><spring:message code="default.start-email-sending.descr" /></label>
		</div>
	</div>
	<div class="col-md-12">
		<div class="col-md-5">
			<button type="button" class="btn btn-success" ng-click="accept()" ng-disabled="!access.myRequest">
				<span><spring:message code="default.accept.label" /></span>
			</button>
		</div>
		<div class="col-md-7">
			<label><spring:message code="default.accept.descr" /></label>
		</div>
	</div>
	<div class="col-md-12">
		<div class="col-md-5">
			<button type="button" class="btn btn-danger" ng-click="decline()" ng-disabled="!access.myRequest">
				<span><spring:message code="default.decline.label" /></span>
			</button>
		</div>
		<div class="col-md-7">
			<label><spring:message code="default.decline.descr" /></label>
		</div>
	</div>
	
	<div class="progress-holder col-md-12 margin-top-10">	
		<progressbar class="progress-striped active" value="item.progress" type="{{ progress.type }}"><b>{{ item.progress }}%</b></progressbar>
	</div>
</div>