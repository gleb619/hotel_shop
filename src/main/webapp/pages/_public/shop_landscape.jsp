<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div ng-controller="ShopHotelLandscapeCtrl" class="tab-body">
	<header>
		<div class="center-content">
			<div class="pull-left">
				<jsp:include page="../_sys/shop-navbar.jsp" />
			</div>
			<form class="form-inline">
				<div class="form-group">
					<label for="exampleInputName2">City</label> <select class="form-control" placeholder="City">
						<option>Almaty</option>
						<option>Astana</option>
					</select>
				</div>
				<div class="form-group">
					<label for="starcount">Star Count</label> <input type="number" class="form-control" id="starcount"
						placeholder="Starcount">
				</div>
				<div class="form-group">
					<label for="search">Search</label> <input type="text" class="form-control" id="search"
						placeholder="Name, City or whatever">
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-primary col-xs-12">
						<span>Search</span>
					</button>
				</div>
			</form>
		</div>
	</header>
    <section class="content-section" ng-hide="scrollable.initLoading" when-scrolled="loadData()">
    	<div class="row">
            <div class="col-md-12">
                <hr>
                <div ng-repeat="item in filtered = ( data | filter: keyword )">
                	<jsp:include page="landscape_item.jsp"/>
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