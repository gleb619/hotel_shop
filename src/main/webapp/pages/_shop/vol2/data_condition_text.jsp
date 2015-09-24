<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<p ng-bind-html="item.conditionText"></p>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<button type="button" class="btn btn-success btn-block" ng-click="accept()" scroll-to="#request">
				<span><spring:message code="default.agree" /></span>
			</button>
		</div>
	</div>
</div>