<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('path')">
				<span class="list-group-item-caption"><spring:message code="label.path" /></span>
				<span class="pull-right">{{ ::selectedItem.path }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('extension')">
				<span class="list-group-item-caption"><spring:message code="label.extension" /></span>
				<span class="pull-right">{{ ::selectedItem.extension }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('originalfilename')">
				<span class="list-group-item-caption"><spring:message code="label.originalfilename" /></span>
				<span class="pull-right">{{ ::selectedItem.originalfilename }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('size')">
				<span class="list-group-item-caption"><spring:message code="label.size" /></span>
				<span class="pull-right">{{ ::selectedItem.size }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('name')">
				<span class="list-group-item-caption"><spring:message code="label.name" /></span>
				<span class="pull-right">{{ ::selectedItem.name }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('contenttype')">
				<span class="list-group-item-caption"><spring:message code="label.contenttype" /></span>
				<span class="pull-right">{{ ::selectedItem.contenttype }}</span>
			</li>

		</ol>
	</div>
</div>