<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.reqservhotel.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('price')">
						<label><spring:message code="label.price" /></label>
						<input type="number" step="0.01" ng-model="item.reqservhotel.price" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('accept')">
						<input type="checkbox" ng-model="item.reqservhotel.accept" tabindex="3"/>
						<label><spring:message code="label.accept" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('decline')">
						<input type="checkbox" ng-model="item.reqservhotel.decline" tabindex="4"/>
						<label><spring:message code="label.decline" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('race')">
						<label><spring:message code="label.race" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'race')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.reqservhotel.race" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.race, 'race')"
										is-open="details.race" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.reqservhotel.race" show-meridian="false" ng-change="convertDateAndTime(item.race, 'race')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('departure')">
						<label><spring:message code="label.departure" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'departure')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.reqservhotel.departure" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.departure, 'departure')"
										is-open="details.departure" close-text="X" tabindex="6">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.reqservhotel.departure" show-meridian="false" ng-change="convertDateAndTime(item.departure, 'departure')"></timepicker>
							</div>
						</div>
					</div>

					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbypaymenttype')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbypaymenttype', 'null', 'null', dataDictGlobalByPaymentTypeId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.dictglobalbypaymenttype"
									ng-options="item.label for item in dataDictGlobalByPaymentTypeId track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbypaymenttype', 'null', 'null', dataDictGlobalByPaymentTypeId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('usersbyrequestuser')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('usersbyrequestuser', 'null', 'null', dataUsersByRequestUserId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.usersbyrequestuser"
									ng-options="item.label for item in dataUsersByRequestUserId track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('usersbyrequestuser', 'null', 'null', dataUsersByRequestUserId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('usersbyresponseuser')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('usersbyresponseuser', 'null', 'null', dataUsersByResponseUserId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.usersbyresponseuser"
									ng-options="item.label for item in dataUsersByResponseUserId track by item.id"
									tabindex="9">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('usersbyresponseuser', 'null', 'null', dataUsersByResponseUserId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('docdocumentsbydocumentforhotel')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('docdocumentsbydocumentforhotel', 'null', 'null', dataDocDocumentsByDocumentForHotelId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.docdocumentsbydocumentforhotel"
									ng-options="item.label for item in dataDocDocumentsByDocumentForHotelId track by item.id"
									tabindex="10">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('docdocumentsbydocumentforhotel', 'null', 'null', dataDocDocumentsByDocumentForHotelId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyplacement')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyplacement', 'null', 'null', dataDictGlobalByPlacementId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.dictglobalbyplacement"
									ng-options="item.label for item in dataDictGlobalByPlacementId track by item.id"
									tabindex="11">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyplacement', 'null', 'null', dataDictGlobalByPlacementId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('servhotelroom')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('servhotelroom', 'null', 'null', dataServHotelRoom)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.servhotelroom"
									ng-options="item.label for item in dataServHotelRoom track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('servhotelroom', 'null', 'null', dataServHotelRoom)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('docdocumentsbydocumentforuser')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('docdocumentsbydocumentforuser', 'null', 'null', dataDocDocumentsByDocumentForUserId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.docdocumentsbydocumentforuser"
									ng-options="item.label for item in dataDocDocumentsByDocumentForUserId track by item.id"
									tabindex="13">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('docdocumentsbydocumentforuser', 'null', 'null', dataDocDocumentsByDocumentForUserId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('servhotel')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('servhotel', 'null', 'null', dataServHotel)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.reqservhotel.servhotel"
									ng-options="item.label for item in dataServHotel track by item.id"
									tabindex="14">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('servhotel', 'null', 'null', dataServHotel)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('roomcount')">
						<label><spring:message code="label.roomCount" /></label>
						<input type="number" ng-model="item.reqservhotel.roomcount" class="form-control" tabindex="15" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('progress')">
						<label><spring:message code="label.progress" /></label>
						<input type="number" ng-model="item.reqservhotel.progress" class="form-control" tabindex="16" />
					</div>
				</div>
			

</div>
