<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('contactname')">
						<label><spring:message code="label.contactName" /></label>
						<input type="text" ng-model="item.tmcontact.contactname" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('contactpatronymic')">
						<label><spring:message code="label.contactPatronymic" /></label>
						<input type="text" ng-model="item.tmcontact.contactpatronymic" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('contactsurname')">
						<label><spring:message code="label.contactSurname" /></label>
						<input type="text" ng-model="item.tmcontact.contactsurname" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('birthday')">
						<label><spring:message code="label.birthday" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'birthday')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.tmcontact.birthday" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.birthday, 'birthday')"
										is-open="details.birthday" close-text="X" tabindex="4">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.tmcontact.birthday" show-meridian="false" ng-change="convertDateAndTime(item.birthday, 'birthday')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('passportenddate')">
						<label><spring:message code="label.passportEndDate" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'passportenddate')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.tmcontact.passportenddate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.passportenddate, 'passportenddate')"
										is-open="details.passportenddate" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.tmcontact.passportenddate" show-meridian="false" ng-change="convertDateAndTime(item.passportenddate, 'passportenddate')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('passportstartdate')">
						<label><spring:message code="label.passportStartDate" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'passportstartdate')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.tmcontact.passportstartdate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.passportstartdate, 'passportstartdate')"
										is-open="details.passportstartdate" close-text="X" tabindex="6">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.tmcontact.passportstartdate" show-meridian="false" ng-change="convertDateAndTime(item.passportstartdate, 'passportstartdate')"></timepicker>
							</div>
						</div>
					</div>

					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
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
									ng-model="item.tmcontact.locationcountries"
									ng-options="item.label for item in dataLocationCountries track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcountries', 'null', 'null', dataLocationCountries)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('passportnumber')">
						<label><spring:message code="label.passportNumber" /></label>
						<input type="text" ng-model="item.tmcontact.passportnumber" class="form-control" tabindex="8" />
					</div>
				</div>
			

</div>
