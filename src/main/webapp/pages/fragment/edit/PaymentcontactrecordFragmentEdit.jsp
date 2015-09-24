<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.paymentcontactrecord.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('monthinstalamount')">
						<label><spring:message code="label.monthinstalAmount" /></label>
						<input type="number" step="0.01" ng-model="item.paymentcontactrecord.monthinstalamount" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('overdueamount')">
						<label><spring:message code="label.overdueAmount" /></label>
						<input type="number" step="0.01" ng-model="item.paymentcontactrecord.overdueamount" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('residualamount')">
						<label><spring:message code="label.residualAmount" /></label>
						<input type="number" step="0.01" ng-model="item.paymentcontactrecord.residualamount" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('penalty')">
						<label><spring:message code="label.penalty" /></label>
						<input type="number" step="0.01" ng-model="item.paymentcontactrecord.penalty" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('fine')">
						<label><spring:message code="label.fine" /></label>
						<input type="number" step="0.01" ng-model="item.paymentcontactrecord.fine" class="form-control" tabindex="6" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('recordaccountingdate')">
						<label><spring:message code="label.recordAccountingDate" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'recordaccountingdate')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.paymentcontactrecord.recordaccountingdate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.recordaccountingdate, 'recordaccountingdate')"
										is-open="details.recordaccountingdate" close-text="X" tabindex="7">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.paymentcontactrecord.recordaccountingdate" show-meridian="false" ng-change="convertDateAndTime(item.recordaccountingdate, 'recordaccountingdate')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybypenaltycurrency')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybypenaltycurrency', 'null', 'null', dataCurrCurrencyByPenaltyCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentcontactrecord.currcurrencybypenaltycurrency"
									ng-options="item.label for item in dataCurrCurrencyByPenaltyCurrencyId track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybypenaltycurrency', 'null', 'null', dataCurrCurrencyByPenaltyCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('paymentcontact')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('paymentcontact', 'null', 'null', dataPaymentContact)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentcontactrecord.paymentcontact"
									ng-options="item.label for item in dataPaymentContact track by item.id"
									tabindex="9">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('paymentcontact', 'null', 'null', dataPaymentContact)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybyfinecurrency')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybyfinecurrency', 'null', 'null', dataCurrCurrencyByFineCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentcontactrecord.currcurrencybyfinecurrency"
									ng-options="item.label for item in dataCurrCurrencyByFineCurrencyId track by item.id"
									tabindex="10">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybyfinecurrency', 'null', 'null', dataCurrCurrencyByFineCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybymonthinstalcurrency')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybymonthinstalcurrency', 'null', 'null', dataCurrCurrencyByMonthinstalCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentcontactrecord.currcurrencybymonthinstalcurrency"
									ng-options="item.label for item in dataCurrCurrencyByMonthinstalCurrencyId track by item.id"
									tabindex="11">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybymonthinstalcurrency', 'null', 'null', dataCurrCurrencyByMonthinstalCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybyresidualamountcurrency')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybyresidualamountcurrency', 'null', 'null', dataCurrCurrencyByResidualAmountCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentcontactrecord.currcurrencybyresidualamountcurrency"
									ng-options="item.label for item in dataCurrCurrencyByResidualAmountCurrencyId track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybyresidualamountcurrency', 'null', 'null', dataCurrCurrencyByResidualAmountCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybyoverdueamountcurrency')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybyoverdueamountcurrency', 'null', 'null', dataCurrCurrencyByOverdueAmountCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentcontactrecord.currcurrencybyoverdueamountcurrency"
									ng-options="item.label for item in dataCurrCurrencyByOverdueAmountCurrencyId track by item.id"
									tabindex="13">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybyoverdueamountcurrency', 'null', 'null', dataCurrCurrencyByOverdueAmountCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('overdueinstalmentcount')">
						<label><spring:message code="label.overdueInstalmentCount" /></label>
						<input type="number" ng-model="item.paymentcontactrecord.overdueinstalmentcount" class="form-control" tabindex="14" />
					</div>
				</div>
			

</div>
