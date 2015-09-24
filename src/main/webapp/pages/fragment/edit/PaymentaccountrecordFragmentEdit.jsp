<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.paymentaccountrecord.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('monthinstalamount')">
						<label><spring:message code="label.monthinstalAmount" /></label>
						<input type="number" step="0.01" ng-model="item.paymentaccountrecord.monthinstalamount" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('overdueamount')">
						<label><spring:message code="label.overdueAmount" /></label>
						<input type="number" step="0.01" ng-model="item.paymentaccountrecord.overdueamount" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('residualamount')">
						<label><spring:message code="label.residualAmount" /></label>
						<input type="number" step="0.01" ng-model="item.paymentaccountrecord.residualamount" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('penalty')">
						<label><spring:message code="label.penalty" /></label>
						<input type="number" step="0.01" ng-model="item.paymentaccountrecord.penalty" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('fine')">
						<label><spring:message code="label.fine" /></label>
						<input type="number" step="0.01" ng-model="item.paymentaccountrecord.fine" class="form-control" tabindex="6" />
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
									
									<input type="text" class="form-control picker-input" ng-model="item.paymentaccountrecord.recordaccountingdate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.recordaccountingdate, 'recordaccountingdate')"
										is-open="details.recordaccountingdate" close-text="X" tabindex="7">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.paymentaccountrecord.recordaccountingdate" show-meridian="false" ng-change="convertDateAndTime(item.recordaccountingdate, 'recordaccountingdate')"></timepicker>
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
									ng-model="item.paymentaccountrecord.currcurrencybypenaltycurrency"
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
									ng-model="item.paymentaccountrecord.currcurrencybyfinecurrency"
									ng-options="item.label for item in dataCurrCurrencyByFineCurrencyId track by item.id"
									tabindex="9">
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
									ng-model="item.paymentaccountrecord.currcurrencybymonthinstalcurrency"
									ng-options="item.label for item in dataCurrCurrencyByMonthinstalCurrencyId track by item.id"
									tabindex="10">
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
									ng-model="item.paymentaccountrecord.currcurrencybyresidualamountcurrency"
									ng-options="item.label for item in dataCurrCurrencyByResidualAmountCurrencyId track by item.id"
									tabindex="11">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybyresidualamountcurrency', 'null', 'null', dataCurrCurrencyByResidualAmountCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('paymentaccount')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('paymentaccount', 'null', 'null', dataPaymentAccount)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentaccountrecord.paymentaccount"
									ng-options="item.label for item in dataPaymentAccount track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('paymentaccount', 'null', 'null', dataPaymentAccount)">
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
									ng-model="item.paymentaccountrecord.currcurrencybyoverdueamountcurrency"
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
						<input type="number" ng-model="item.paymentaccountrecord.overdueinstalmentcount" class="form-control" tabindex="14" />
					</div>
				</div>
			

</div>
