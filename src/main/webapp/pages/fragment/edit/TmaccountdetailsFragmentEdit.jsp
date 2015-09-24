<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.tmaccountdetails.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('isbase')">
						<input type="checkbox" ng-model="item.tmaccountdetails.isBase" tabindex="2"/>
						<label><spring:message code="label.isBase" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('isdetail')">
						<input type="checkbox" ng-model="item.tmaccountdetails.isDetail" tabindex="3"/>
						<label><spring:message code="label.isDetail" /></label>
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
									ng-model="item.tmaccountdetails.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="4">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'null', 'null', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('bank')">
						<label><spring:message code="label.bankId" /></label>
						<input type="number" ng-model="item.tmaccountdetails.bank" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('rnn')">
						<label><spring:message code="label.rnn" /></label>
						<input type="text" ng-model="item.tmaccountdetails.rnn" class="form-control" tabindex="6" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('bik')">
						<label><spring:message code="label.bik" /></label>
						<input type="text" ng-model="item.tmaccountdetails.bik" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('bin')">
						<label><spring:message code="label.bin" /></label>
						<input type="text" ng-model="item.tmaccountdetails.bin" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('bankaccount')">
						<label><spring:message code="label.bankaccount" /></label>
						<input type="text" ng-model="item.tmaccountdetails.bankaccount" class="form-control" tabindex="9" />
					</div>
				</div>
			

</div>
