<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div>
	<c:if test="${debug}">
		<a target="_blank" class="btn btn-default btn-circle btn-lg" href="../data/shopservhotel2view/{{ item.id }}?initLists=true&initDicts=true">
			S
		</a>
		<a role="button" class="btn btn-default btn-circle btn-lg" ng-click="randomRequest()" title="<spring:message code="default.random.request" />" scroll-to="#request">
			<i class="fa fa-random"></i>
		</a>
	</c:if>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_DEBUG')">
		<a role="button" class="btn btn-default btn-circle btn-lg" title="<spring:message code="default.show.hotel" />"
			target="_blank" href="../../tourism-rcr-server/crm/index2#/ServhotelEdit/{{ ::item.id }}">
			<i class="fa fa-building-o"></i>
		</a>
		<a role="button" class="btn btn-default btn-circle btn-lg" title="<spring:message code="default.show.request" />"
			target="_blank" href="../../tourism-rcr-server/crm/index2#/ReqservhotelList/{{ ::item.label }}">
			<i class="fa fa-file-text"></i>
		</a>
	</sec:authorize>
</div>