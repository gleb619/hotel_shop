<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div ng-controller="ShopHotelLandscape2Ctrl" class="tab-body">
	<header ng-class="{ 'center-pane-holder': !scrollable.isInit }" class="row">
		<div class="center-content" ng-class="{ 'center-pane row': !scrollable.isInit }">
			<div class="col-md-offset-2 col-md-8">
				<div class="input-group">
					<input type="text" class="form-control input-lg" placeholder="Search for..."
							ng-model="search.query"
							ng-model-options="{ debounce: 300 }"
							ng-change="search()"
					>
					<span class="input-group-btn">
						<button class="btn-lg btn btn-default btn-round-right" type="button">
							<i class="fa-lg fa fa-search"></i>
						</button>
					</span>
				</div>
			</div>
		</div>
	</header>
	<div ng-if="scrollable.isInit" class="row">
	    <section class="content-section" ng-hide="scrollable.initLoading">
	    	<div class="row">
	            <div class="col-md-12">
	                <hr>
	                <div ng-repeat="item in filtered = ( data | filter: keyword )">
	                	<jsp:include page="landscape_item_2.jsp"/>
	                </div>
	                <div class="content-preloader" ng-show="scrollable.dataLoading">
						<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>	                
	                </div>
	            </div>
	        </div>
	    </section>
	    <section class="content-section" ng-show="scrollable.initLoading">
	    	<div class="app-content-loading">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
	    </section>
    </div>
</div>