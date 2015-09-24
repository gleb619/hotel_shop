<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.paymentprice.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('vat')">
						<label><spring:message code="label.vat" /></label>
						<input type="number" step="0.01" ng-model="item.paymentprice.vat" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('course')">
						<label><spring:message code="label.course" /></label>
						<input type="number" step="0.01" ng-model="item.paymentprice.course" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('value')">
						<label><spring:message code="label.value" /></label>
						<input type="number" step="0.01" ng-model="item.paymentprice.value" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('paymenttariff')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('paymenttariff', 'null', 'null', dataPaymentTariff)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.paymentprice.paymenttariff"
									ng-options="item.label for item in dataPaymentTariff track by item.id"
									tabindex="5">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('paymenttariff', 'null', 'null', dataPaymentTariff)">
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
									ng-model="item.paymentprice.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'null', 'null', dataCurrCurrency)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('humannumber')">
						<label><spring:message code="label.humannumber" /></label>
						<input type="number" ng-model="item.paymentprice.humannumber" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('discount')">
						<label><spring:message code="label.discount" /></label>
						<input type="text" ng-model="item.paymentprice.discount" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('commission')">
						<label><spring:message code="label.commission" /></label>
						<input type="text" ng-model="item.paymentprice.commission" class="form-control" tabindex="9" />
					</div>
				</div>
			

</div>
