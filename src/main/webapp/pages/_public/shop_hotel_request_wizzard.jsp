<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="modal-header header" cdraggable movable-id="modal-body">
	<button type="button" class="close round-button" ng-click="finalCancel()">&times;</button>
	<h4 class="modal-title">
		<span>
			<spring:message code="default.request-create" />
		</span>
	</h4>
</div>

<div class="modal-body">
	<jsp:include page="../_shop/vol2/request_wizzard.jsp" />
</div>