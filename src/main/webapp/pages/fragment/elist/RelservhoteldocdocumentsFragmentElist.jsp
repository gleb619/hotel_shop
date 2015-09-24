<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('docdocuments')">
				<span class="list-group-item-caption"><spring:message code="label.docDocuments" /></span>
				<span class="pull-right">{{ ::selectedItem.docdocuments.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('servhotel')">
				<span class="list-group-item-caption"><spring:message code="label.servHotel" /></span>
				<span class="pull-right">{{ ::selectedItem.servhotel.label }}</span>
			</li>

		</ol>
	</div>
</div>