<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<wizard on-finish="finishedWizard()"> 
    <wz-step title="<spring:message code="default.step" />1">
        <jsp:include page="wizzard/page_3.jsp" />
    </wz-step>
    <wz-step title="<spring:message code="default.step" />2">
        <jsp:include page="wizzard/page_1.jsp" />
    </wz-step>
    <%-- 
    <wz-step title="<spring:message code="default.step" />2">
        <jsp:include page="wizzard/page_2.jsp" />
    </wz-step>
    --%>
</wizard>
