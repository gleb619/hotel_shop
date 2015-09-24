<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div>
	<div class="modal-header danger">
		{{ item.head }}
	</div>
	<div class="modal-body">
		<div ng-bind-html="item.body"></div>
	</div>
	<div class="modal-footer">
		<div class="col-sm-offset-2 col-md-offset-3 col-sm-8 col-md-6 text-overflow">
			<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
				<span><spring:message code="default.ok" /></span>
			</a>
		</div>
	</div>
</div>