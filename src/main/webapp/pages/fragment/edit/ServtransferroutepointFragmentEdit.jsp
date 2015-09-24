<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servtransferroutepoint.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('fixedallowance')">
						<label><spring:message code="label.fixedAllowance" /></label>
						<input type="number" step="0.01" ng-model="item.servtransferroutepoint.fixedallowance" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('percentageofallowances')">
						<label><spring:message code="label.percentageOfAllowances" /></label>
						<input type="number" step="0.01" ng-model="item.servtransferroutepoint.percentageofallowances" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('free')">
						<input type="checkbox" ng-model="item.servtransferroutepoint.free" tabindex="4"/>
						<label><spring:message code="label.free" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('starton')">
						<label><spring:message code="label.startOn" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'starton')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.servtransferroutepoint.starton" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.starton, 'starton')"
										is-open="details.starton" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servtransferroutepoint.starton" show-meridian="false" ng-change="convertDateAndTime(item.starton, 'starton')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('servtransferroute')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('servtransferroute', 'null', 'null', dataServTransferRoute)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servtransferroutepoint.servtransferroute"
									ng-options="item.label for item in dataServTransferRoute track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('servtransferroute', 'null', 'null', dataServTransferRoute)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('sum')">
						<label><spring:message code="label.sum" /></label>
						<input type="number" ng-model="item.servtransferroutepoint.sum" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('pointfrom')">
						<label><spring:message code="label.pointFrom" /></label>
						<input type="text" ng-model="item.servtransferroutepoint.pointfrom" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('pointto')">
						<label><spring:message code="label.pointTo" /></label>
						<input type="text" ng-model="item.servtransferroutepoint.pointto" class="form-control" tabindex="9" />
					</div>
				</div>
			

</div>
