<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.paymentaccount.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('paymentenddate')">
						<label><spring:message code="label.paymentEndDate" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'paymentenddate')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.paymentaccount.paymentenddate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.paymentenddate, 'paymentenddate')"
										is-open="details.paymentenddate" close-text="X" tabindex="2">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.paymentaccount.paymentenddate" show-meridian="false" ng-change="convertDateAndTime(item.paymentenddate, 'paymentenddate')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('paymentstartdate')">
						<label><spring:message code="label.paymentStartDate" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'paymentstartdate')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.paymentaccount.paymentstartdate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.paymentstartdate, 'paymentstartdate')"
										is-open="details.paymentstartdate" close-text="X" tabindex="3">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.paymentaccount.paymentstartdate" show-meridian="false" ng-change="convertDateAndTime(item.paymentstartdate, 'paymentstartdate')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbypaymentmethod')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbypaymentmethod', 'null', 'null', dataDictGlobalByPaymentMethodId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentaccount.dictglobalbypaymentmethod"
									ng-options="item.label for item in dataDictGlobalByPaymentMethodId track by item.id"
									tabindex="4">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbypaymentmethod', 'null', 'null', dataDictGlobalByPaymentMethodId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmorder')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmorder', 'null', 'null', dataTmOrder)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentaccount.tmorder"
									ng-options="item.label for item in dataTmOrder track by item.id"
									tabindex="5">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmorder', 'null', 'null', dataTmOrder)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyservicetype')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyservicetype', 'null', 'null', dataDictGlobalByServiceTypeId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentaccount.dictglobalbyservicetype"
									ng-options="item.label for item in dataDictGlobalByServiceTypeId track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyservicetype', 'null', 'null', dataDictGlobalByServiceTypeId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccount')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccount', 'null', 'null', dataTmAccount)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentaccount.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'null', 'null', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('infoservices')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('infoservices', 'null', 'null', dataInfoServices)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentaccount.infoservices"
									ng-options="item.label for item in dataInfoServices track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('infoservices', 'null', 'null', dataInfoServices)">
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
									ng-model="item.paymentaccount.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="9">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'null', 'null', dataCurrCurrency)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('paymentcost')">
						<label><spring:message code="label.paymentCost" /></label>
						<input type="number" ng-model="item.paymentaccount.paymentcost" class="form-control" tabindex="10" />
					</div>
				</div>
			

</div>
