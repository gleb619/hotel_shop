<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('dicttype')">
				<span class="list-group-item-caption"><spring:message code="label.dictType" /></span>
				<span class="pull-right">{{ ::selectedItem.dicttype }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictvalue')">
				<span class="list-group-item-caption"><spring:message code="label.dictValue" /></span>
				<span class="pull-right">{{ ::selectedItem.dictvalue }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictvalueadditional')">
				<span class="list-group-item-caption"><spring:message code="label.dictValueAdditional" /></span>
				<span class="pull-right">{{ ::selectedItem.dictvalueadditional }}</span>
			</li>

		</ol>
	</div>
</div>