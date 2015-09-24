<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servticketsrail.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('price')">
						<label><spring:message code="label.price" /></label>
						<input type="number" step="0.01" ng-model="item.servticketsrail.price" class="form-control" tabindex="2" />
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
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsrail.datestartdep" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.datestartdep, 'datestartdep')"
										is-open="details.datestartdep" close-text="X" tabindex="3">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsrail.datestartdep" show-meridian="false" ng-change="convertDateAndTime(item.datestartdep, 'datestartdep')"></timepicker>
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
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsrail.dateendarrival" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.dateendarrival, 'dateendarrival')"
										is-open="details.dateendarrival" close-text="X" tabindex="4">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsrail.dateendarrival" show-meridian="false" ng-change="convertDateAndTime(item.dateendarrival, 'dateendarrival')"></timepicker>
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
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsrail.dateenddep" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.dateenddep, 'dateenddep')"
										is-open="details.dateenddep" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsrail.dateenddep" show-meridian="false" ng-change="convertDateAndTime(item.dateenddep, 'dateenddep')"></timepicker>
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
									
									<input type="text" class="form-control picker-input" ng-model="item.servticketsrail.datestartarrival" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.datestartarrival, 'datestartarrival')"
										is-open="details.datestartarrival" close-text="X" tabindex="6">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.servticketsrail.datestartarrival" show-meridian="false" ng-change="convertDateAndTime(item.datestartarrival, 'datestartarrival')"></timepicker>
							</div>
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
									ng-model="item.servticketsrail.currcurrency"
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
									ng-model="item.servticketsrail.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'null', 'null', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('railcompanydep')">
						<label><spring:message code="label.railCompanyDepId" /></label>
						<input type="number" ng-model="item.servticketsrail.railcompanydep" class="form-control" tabindex="9" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackarrival')">
						<label><spring:message code="label.cityBackArrivalId" /></label>
						<input type="number" ng-model="item.servticketsrail.citybackarrival" class="form-control" tabindex="10" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytherearrival')">
						<label><spring:message code="label.cityThereArrivalId" /></label>
						<input type="number" ng-model="item.servticketsrail.citytherearrival" class="form-control" tabindex="11" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('railcompanyarrival')">
						<label><spring:message code="label.railCompanyArrivalId" /></label>
						<input type="number" ng-model="item.servticketsrail.railcompanyarrival" class="form-control" tabindex="12" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numtraindep')">
						<label><spring:message code="label.numTrainDep" /></label>
						<input type="number" ng-model="item.servticketsrail.numtraindep" class="form-control" tabindex="13" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('classtrainarrival')">
						<label><spring:message code="label.classTrainArrivalId" /></label>
						<input type="number" ng-model="item.servticketsrail.classtrainarrival" class="form-control" tabindex="14" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytheredep')">
						<label><spring:message code="label.cityThereDepId" /></label>
						<input type="number" ng-model="item.servticketsrail.citytheredep" class="form-control" tabindex="15" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('classtraindep')">
						<label><spring:message code="label.classTrainDepId" /></label>
						<input type="number" ng-model="item.servticketsrail.classtraindep" class="form-control" tabindex="16" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackdep')">
						<label><spring:message code="label.cityBackDepId" /></label>
						<input type="number" ng-model="item.servticketsrail.citybackdep" class="form-control" tabindex="17" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numtrainarrival')">
						<label><spring:message code="label.numTrainArrival" /></label>
						<input type="number" ng-model="item.servticketsrail.numtrainarrival" class="form-control" tabindex="18" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('railname')">
						<label><spring:message code="label.railName" /></label>
						<input type="text" ng-model="item.servticketsrail.railname" class="form-control" tabindex="19" />
					</div>
				</div>
			

</div>
