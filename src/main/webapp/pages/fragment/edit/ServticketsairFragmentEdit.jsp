<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servticketsair.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('price')">
						<label><spring:message code="label.price" /></label>
						<input type="number" step="0.01" ng-model="item.servticketsair.price" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('datestartdep')">
						<label><spring:message code="label.dateStartDep" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'datestartdep')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsair.datestartdep" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.datestartdep, 'datestartdep')"
										is-open="details.datestartdep" close-text="X" tabindex="3">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsair.datestartdep" show-meridian="false" ng-change="convertDateAndTime(item.datestartdep, 'datestartdep')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dateendarrival')">
						<label><spring:message code="label.dateEndArrival" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'dateendarrival')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsair.dateendarrival" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.dateendarrival, 'dateendarrival')"
										is-open="details.dateendarrival" close-text="X" tabindex="4">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsair.dateendarrival" show-meridian="false" ng-change="convertDateAndTime(item.dateendarrival, 'dateendarrival')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dateenddep')">
						<label><spring:message code="label.dateEndDep" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'dateenddep')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsair.dateenddep" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.dateenddep, 'dateenddep')"
										is-open="details.dateenddep" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsair.dateenddep" show-meridian="false" ng-change="convertDateAndTime(item.dateenddep, 'dateenddep')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('datestartarrival')">
						<label><spring:message code="label.dateStartArrival" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'datestartarrival')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsair.datestartarrival" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.datestartarrival, 'datestartarrival')"
										is-open="details.datestartarrival" close-text="X" tabindex="6">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsair.datestartarrival" show-meridian="false" ng-change="convertDateAndTime(item.datestartarrival, 'datestartarrival')"></timepicker>
							</div>
						</div>
					</div>

					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbytypeplanearrival')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbytypeplanearrival', 'null', 'null', dataDictGlobalByTypePlaneArrivalId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servticketsair.dictglobalbytypeplanearrival"
									ng-options="item.label for item in dataDictGlobalByTypePlaneArrivalId track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbytypeplanearrival', 'null', 'null', dataDictGlobalByTypePlaneArrivalId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccountbyaircompanyarrival')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccountbyaircompanyarrival', 'null', 'null', dataTmAccountByAirCompanyArrivalId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servticketsair.tmaccountbyaircompanyarrival"
									ng-options="item.label for item in dataTmAccountByAirCompanyArrivalId track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccountbyaircompanyarrival', 'null', 'null', dataTmAccountByAirCompanyArrivalId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyairclass')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyairclass', 'null', 'null', dataDictGlobalByAirclassId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servticketsair.dictglobalbyairclass"
									ng-options="item.label for item in dataDictGlobalByAirclassId track by item.id"
									tabindex="9">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyairclass', 'null', 'null', dataDictGlobalByAirclassId)">
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
									ng-model="item.servticketsair.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="10">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'null', 'null', dataCurrCurrency)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbytypeplanedep')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbytypeplanedep', 'null', 'null', dataDictGlobalByTypePlaneDepId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servticketsair.dictglobalbytypeplanedep"
									ng-options="item.label for item in dataDictGlobalByTypePlaneDepId track by item.id"
									tabindex="11">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbytypeplanedep', 'null', 'null', dataDictGlobalByTypePlaneDepId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccountbyaccount')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccountbyaccount', 'null', 'null', dataTmAccountByAccountId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servticketsair.tmaccountbyaccount"
									ng-options="item.label for item in dataTmAccountByAccountId track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccountbyaccount', 'null', 'null', dataTmAccountByAccountId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccountbyaircompanydep')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccountbyaircompanydep', 'null', 'null', dataTmAccountByAirCompanyDepId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servticketsair.tmaccountbyaircompanydep"
									ng-options="item.label for item in dataTmAccountByAirCompanyDepId track by item.id"
									tabindex="13">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccountbyaircompanydep', 'null', 'null', dataTmAccountByAirCompanyDepId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackarrival')">
						<label><spring:message code="label.cityBackArrivalId" /></label>
						<input type="number" ng-model="item.servticketsair.citybackarrival" class="form-control" tabindex="14" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytherearrival')">
						<label><spring:message code="label.cityThereArrivalId" /></label>
						<input type="number" ng-model="item.servticketsair.citytherearrival" class="form-control" tabindex="15" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numflightdep')">
						<label><spring:message code="label.numFlightDep" /></label>
						<input type="number" ng-model="item.servticketsair.numflightdep" class="form-control" tabindex="16" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numflightarrival')">
						<label><spring:message code="label.numFlightArrival" /></label>
						<input type="number" ng-model="item.servticketsair.numflightarrival" class="form-control" tabindex="17" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytheredep')">
						<label><spring:message code="label.cityThereDepId" /></label>
						<input type="number" ng-model="item.servticketsair.citytheredep" class="form-control" tabindex="18" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackdep')">
						<label><spring:message code="label.cityBackDepId" /></label>
						<input type="number" ng-model="item.servticketsair.citybackdep" class="form-control" tabindex="19" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('airname')">
						<label><spring:message code="label.airName" /></label>
						<input type="text" ng-model="item.servticketsair.airname" class="form-control" tabindex="20" />
					</div>
				</div>
			

</div>
