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
			<li class="list-group-item" ng-if="::checkVisibility('isbase')">
				<span class="list-group-item-caption"><spring:message code="label.isBase" /></span>
				<span class="pull-right">{{ ::selectedItem.isbase }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('isdetail')">
				<span class="list-group-item-caption"><spring:message code="label.isDetail" /></span>
				<span class="pull-right">{{ ::selectedItem.isdetail }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('tmaccount')">
				<span class="list-group-item-caption"><spring:message code="label.tmAccount" /></span>
				<span class="pull-right">{{ ::selectedItem.tmaccount.label }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('bankid')">
				<span class="list-group-item-caption"><spring:message code="label.bankId" /></span>
				<span class="pull-right">{{ ::selectedItem.bankid }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('rnn')">
				<span class="list-group-item-caption"><spring:message code="label.rnn" /></span>
				<span class="pull-right">{{ ::selectedItem.rnn }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('bik')">
				<span class="list-group-item-caption"><spring:message code="label.bik" /></span>
				<span class="pull-right">{{ ::selectedItem.bik }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('bin')">
				<span class="list-group-item-caption"><spring:message code="label.bin" /></span>
				<span class="pull-right">{{ ::selectedItem.bin }}</span>
			</li>
			<li class="list-group-item" ng-if="::checkVisibility('bankaccount')">
				<span class="list-group-item-caption"><spring:message code="label.bankaccount" /></span>
				<span class="pull-right">{{ ::selectedItem.bankaccount }}</span>
			</li>

		</ol>
	</div>
</div>