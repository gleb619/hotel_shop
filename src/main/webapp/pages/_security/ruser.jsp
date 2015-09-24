<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div ng-controller="RuserCtrl" class="main-layout">
	<tabset justified="true" class="tabset">
	    <tab class="tab">
	    	<tab-heading>
	        	<spring:message code="label.Users" />
	      	</tab-heading>
	      	
	    	<div ng-controller="UsersListCtrl" class="tab-body">
				<jsp:include page="UsersList.jsp"/>
	    	</div>
	    </tab>
	    <tab class="tab">
	    	<tab-heading>
	        	<spring:message code="label.TmUserInfo" />
	      	</tab-heading>
	      	
	    	<div ng-controller="TmUserInfoListCtrl" class="tab-body">
				<jsp:include page="TmuserinfoList.jsp"/>
	    	</div>
	    </tab>
	    <tab class="tab">
	    	<tab-heading>
	        	<spring:message code="label.TmFirms" />
	      	</tab-heading>
	      	
	    	<div ng-controller="TmFirmsListCtrl" class="tab-body">
				<jsp:include page="TmfirmsList.jsp"/>
	    	</div>
	    </tab>
	    <%-- 
	    <tab class="tab">
	    	<tab-heading>
	        	<spring:message code="default.online-users" />
	      	</tab-heading>
	    </tab>
	    --%>
	 </tabset>
</div>