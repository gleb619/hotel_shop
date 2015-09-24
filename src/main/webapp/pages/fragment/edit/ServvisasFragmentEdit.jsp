<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servvisas.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('price')">
						<label><spring:message code="label.price" /></label>
						<input type="number" step="0.01" ng-model="item.servvisas.price" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('datestart')">
						<label><spring:message code="label.datestart" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'datestart')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.servvisas.datestart" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.datestart, 'datestart')"
										is-open="details.datestart" close-text="X" tabindex="3">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servvisas.datestart" show-meridian="false" ng-change="convertDateAndTime(item.datestart, 'datestart')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dateend')">
						<label><spring:message code="label.dateend" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'dateend')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.servvisas.dateend" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.dateend, 'dateend')"
										is-open="details.dateend" close-text="X" tabindex="4">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servvisas.dateend" show-meridian="false" ng-change="convertDateAndTime(item.dateend, 'dateend')"></timepicker>
							</div>
						</div>
					</div>

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
									ng-model="item.servvisas.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="5">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'null', 'null', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcountries')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcountries', 'null', 'null', dataLocationCountries)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servvisas.locationcountries"
									ng-options="item.label for item in dataLocationCountries track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcountries', 'null', 'null', dataLocationCountries)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
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
									ng-model="item.servvisas.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'null', 'null', dataCurrCurrency)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobal')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobal', 'null', 'null', dataDictGlobal)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servvisas.dictglobal"
									ng-options="item.label for item in dataDictGlobal track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobal', 'null', 'null', dataDictGlobal)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('name')">
						<label><spring:message code="label.name" /></label>
						<input type="text" ng-model="item.servvisas.name" class="form-control" tabindex="9" />
					</div>
				</div>
			

</div>
