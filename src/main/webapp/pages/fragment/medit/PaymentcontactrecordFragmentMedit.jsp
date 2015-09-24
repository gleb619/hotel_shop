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
				<spring:message code="default.edit" /><spring:message code="label.PaymentContactRecord" />
			<c:if test="${debug}">
				<a href="../data/paymentcontactrecord/{{ ::item.id }}" target="_blank" class="btn btn-default"> JSON DATA </a>
			</c:if>
			</h4>
		</div>
		<div class="modal-body padding-top-0">
			<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.label" class="form-control" tabindex="1" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('monthinstalamount')">
						<label><spring:message code="label.monthinstalAmount" /></label>
						<input type="number" step="0.01" ng-model="item.monthinstalamount" class="form-control" tabindex="2" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('overdueamount')">
						<label><spring:message code="label.overdueAmount" /></label>
						<input type="number" step="0.01" ng-model="item.overdueamount" class="form-control" tabindex="3" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('residualamount')">
						<label><spring:message code="label.residualAmount" /></label>
						<input type="number" step="0.01" ng-model="item.residualamount" class="form-control" tabindex="4" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('penalty')">
						<label><spring:message code="label.penalty" /></label>
						<input type="number" step="0.01" ng-model="item.penalty" class="form-control" tabindex="5" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('fine')">
						<label><spring:message code="label.fine" /></label>
						<input type="number" step="0.01" ng-model="item.fine" class="form-control" tabindex="6" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
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
									
									<input type="text" class="form-control picker-input" ng-model="item.recordaccountingdate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.recordaccountingdate, 'recordaccountingdate')"
										is-open="details.recordaccountingdate" close-text="X" tabindex="7">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.recordaccountingdate" show-meridian="false" ng-change="convertDateAndTime(item.recordaccountingdate, 'recordaccountingdate')"></timepicker>
							</div>
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybypenaltycurrency')">
						<label><spring:message code="label.currCurrencyByPenaltyCurrencyId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybypenaltycurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByPenaltyCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrencybypenaltycurrency"
									ng-options="item.label for item in dataCurrCurrencyByPenaltyCurrencyId track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybypenaltycurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByPenaltyCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('paymentcontact')">
						<label><spring:message code="label.paymentContact" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('paymentcontact', 'PaymentContact', 'paymentcontactrecord', dataPaymentContact)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentcontact"
									ng-options="item.label for item in dataPaymentContact track by item.id"
									tabindex="9">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('paymentcontact', 'PaymentContact', 'paymentcontactrecord', dataPaymentContact)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybyfinecurrency')">
						<label><spring:message code="label.currCurrencyByFineCurrencyId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybyfinecurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByFineCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrencybyfinecurrency"
									ng-options="item.label for item in dataCurrCurrencyByFineCurrencyId track by item.id"
									tabindex="10">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybyfinecurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByFineCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybymonthinstalcurrency')">
						<label><spring:message code="label.currCurrencyByMonthinstalCurrencyId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybymonthinstalcurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByMonthinstalCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrencybymonthinstalcurrency"
									ng-options="item.label for item in dataCurrCurrencyByMonthinstalCurrencyId track by item.id"
									tabindex="11">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybymonthinstalcurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByMonthinstalCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybyresidualamountcurrency')">
						<label><spring:message code="label.currCurrencyByResidualAmountCurrencyId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybyresidualamountcurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByResidualAmountCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrencybyresidualamountcurrency"
									ng-options="item.label for item in dataCurrCurrencyByResidualAmountCurrencyId track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybyresidualamountcurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByResidualAmountCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrencybyoverdueamountcurrency')">
						<label><spring:message code="label.currCurrencyByOverdueAmountCurrencyId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrencybyoverdueamountcurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByOverdueAmountCurrencyId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrencybyoverdueamountcurrency"
									ng-options="item.label for item in dataCurrCurrencyByOverdueAmountCurrencyId track by item.id"
									tabindex="13">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrencybyoverdueamountcurrency', 'CurrCurrency', 'paymentcontactrecord', dataCurrCurrencyByOverdueAmountCurrencyId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('overdueinstalmentcount')">
						<label><spring:message code="label.overdueInstalmentCount" /></label>
						<input type="number" ng-model="item.overdueinstalmentcount" class="form-control" tabindex="14" />
					</div>
				</div>
			

			</div>
		</div>
		<div class="modal-footer">
			<div class="col-xs-6 col-md-6">
				<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
					<spring:message code="default.cancel" />
				</a>
			</div>
			<div class="col-xs-6 col-md-6">
				<a ng-click="updateItem()"
					class="btn btn-success btn-block btn-lg"> <spring:message
						code="default.submit" />
				</a>
			</div>
		</div>
  </div>
  <div ng-show="loading" class="loading-bar-holder border-none">
	<div class="loading-bar">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
  </div>
</div>
