<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servtransferroute.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('fixedallowance')">
						<label><spring:message code="label.fixedAllowance" /></label>
						<input type="number" step="0.01" ng-model="item.servtransferroute.fixedallowance" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('percentageofallowances')">
						<label><spring:message code="label.percentageOfAllowances" /></label>
						<input type="number" step="0.01" ng-model="item.servtransferroute.percentageofallowances" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('free')">
						<input type="checkbox" ng-model="item.servtransferroute.free" tabindex="4"/>
						<label><spring:message code="label.free" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('servtransfer')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('servtransfer', 'null', 'null', dataServTransfer)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servtransferroute.servtransfer"
									ng-options="item.label for item in dataServTransfer track by item.id"
									tabindex="5">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('servtransfer', 'null', 'null', dataServTransfer)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrency')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrency', 'null', 'null', dataCurrCurrency)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servtransferroute.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'null', 'null', dataCurrCurrency)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('sum')">
						<label><spring:message code="label.sum" /></label>
						<input type="number" ng-model="item.servtransferroute.sum" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('driver')">
						<label><spring:message code="label.driver" /></label>
						<input type="text" ng-model="item.servtransferroute.driver" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('driverphone')">
						<label><spring:message code="label.driverPhone" /></label>
						<input type="text" ng-model="item.servtransferroute.driverphone" class="form-control" tabindex="9" />
					</div>
				</div>
			

</div>
