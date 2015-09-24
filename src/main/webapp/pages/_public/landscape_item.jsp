<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="col-sm-6 col-md-4 col-lg-3 ribbon landscape-item">
	<div class="thumbnail folded">
		<div class="starcount-holder">
			<span class="fa-stack fa-lg star-holder">
				<i class="fa fa-star fa-stack-2x star"></i>
				<span class="fa-stack-1x star-label">{{ item.starcount }}</span>
			</span>
		</div>
		<div class="landscape-item-head">
			<span class="folded-container" ng-show="item.freesale">Free Sale</span>
			<img ng-src="../images/{{ item.image }}" class="img-responsive">
		</div>
		<hr>
		<div class="caption landscape-item-body">
			<h3>{{ item.label }}</h3>
			<p class="landscape-item-descr" ng-bind-html="item.descr"></p>
			<p>
				<a href="#/landscape_detail/{{ item.id }}" class="btn btn-primary landscape-item-detail col-xs-offset-1 col-xs-10" role="button">
					<span><spring:message code="default.detail" /></span>
				</a>
				<!-- <button type="button" class="btn btn-primary">Detail</button> -->
			</p>
			<br>
			<br>
		</div>
	</div>
</div>