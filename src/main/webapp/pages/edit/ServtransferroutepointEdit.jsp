<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-if="!loading" class="edit-form-body">
		<div class="modal-header header">
			<button type="button" class="close round-button" ng-click="cancel()">&times;</button>
			<h4 class="modal-title">
				<span ng-if="::(access.edit || access.simple)"><spring:message code="default.edit" /></span>
				<span ng-if="::access.create"><spring:message code="default.createnew" /></span>
				<spring:message code="label.ServTransferRoutePoint" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/servtransferroutepoint/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA
					</a>
				</c:if>
				<!--
				<div class="btn-group navigator">
				    <a class="btn btn-default navigator-item">
				    	<i class="fa fa-2x fa-backward"></i>
				    </a>
				    <a class="btn btn-default navigator-item">
				    	<i class="fa fa-2x fa-forward"></i>
				    </a>
				</div>
				-->
			</h4>
		</div>

		<div class="modal-body padding-top-0">
			<tabset type="pills"> 
			  <tab> 
				<tab-heading>
					<spring:message code="default.main" /> 
				</tab-heading> 
				<br/>
				<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.label" class="form-control" tabindex="1" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('fixedallowance')">
						<label><spring:message code="label.fixedAllowance" /></label>
						<input type="number" step="0.01" ng-model="item.fixedallowance" class="form-control" tabindex="2" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('percentageofallowances')">
						<label><spring:message code="label.percentageOfAllowances" /></label>
						<input type="number" step="0.01" ng-model="item.percentageofallowances" class="form-control" tabindex="3" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('free')">
						<input type="checkbox" ng-model="item.free" tabindex="4"/>
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
									
									<input type="text" class="form-control picker-input" ng-model="item.starton" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.starton, 'starton')"
										is-open="details.starton" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.starton" show-meridian="false" ng-change="convertDateAndTime(item.starton, 'starton')"></timepicker>
							</div>
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('servtransferroute')">
						<label><spring:message code="label.servTransferRoute" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('servtransferroute', 'ServTransferRoute', 'servtransferroutepoint', dataServTransferRoute)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servtransferroute"
									ng-options="item.label for item in dataServTransferRoute track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('servtransferroute', 'ServTransferRoute', 'servtransferroutepoint', dataServTransferRoute)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('sum')">
						<label><spring:message code="label.sum" /></label>
						<input type="number" ng-model="item.sum" class="form-control" tabindex="7" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('pointfrom')">
						<label><spring:message code="label.pointFrom" /></label>
						<input type="text" ng-model="item.pointfrom" class="form-control" tabindex="8" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('pointto')">
						<label><spring:message code="label.pointTo" /></label>
						<input type="text" ng-model="item.pointto" class="form-control" tabindex="9" />
					</div>
				</div>
			

				</div>
			  </tab>
			  
			  
			</tabset>
		</div>
		<div class="modal-footer">
			<div class="row margin-top-15">
				<div class="col-xs-6 col-md-6 text-overflow">
					<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
						<span><spring:message code="default.cancel" /></span>
					</a>
				</div>
				<div class="col-xs-6 col-md-6 text-overflow">
					<a ng-click="updateItem()" class="btn btn-success btn-block btn-lg"> 
						<span><spring:message code="default.submit" /></span>
					</a>
				</div>
			</div>
		</div>
  </div>
  <div ng-show="loading" class="loading-bar-holder border-none">
	<div class="loading-bar">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
  </div>
</div>
