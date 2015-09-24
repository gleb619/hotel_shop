<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
	<div class="scrollable-content-300">
		<ol class="list-group">
			<li class="list-group-item" ng-if="::checkVisibility('label')">
				<span class="list-group-item-caption"><spring:message code="label.label" /></span>
				<span class="pull-right">{{ ::selectedItem.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('giftscost')">
				<span class="list-group-item-caption"><spring:message code="label.giftsCost" /></span>
				<span class="pull-right">{{ ::selectedItem.giftscost }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('dictglobal')">
				<span class="list-group-item-caption"><spring:message code="label.dictGlobal" /></span>
				<span class="pull-right">{{ ::selectedItem.dictglobal.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('giftsname')">
				<span class="list-group-item-caption"><spring:message code="label.giftsName" /></span>
				<span class="pull-right">{{ ::selectedItem.giftsname }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('giftsdescr')">
				<span class="list-group-item-caption"><spring:message code="label.giftsDescr" /></span>
				<span class="pull-right">{{ ::selectedItem.giftsdescr }}</span>
			</li>

		</ol>
	</div>
</div>