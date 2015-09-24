<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.paymentdetails.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('bin')">
						<label><spring:message code="label.bin" /></label>
						<input type="text" ng-model="item.paymentdetails.bin" class="form-control" tabindex="2" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('phone2')">
						<label><spring:message code="label.phone2" /></label>
						<input type="text" ng-model="item.paymentdetails.phone2" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('fullname')">
						<label><spring:message code="label.fullName" /></label>
						<input type="text" ng-model="item.paymentdetails.fullname" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('nceo')">
						<label><spring:message code="label.nceo" /></label>
						<input type="text" ng-model="item.paymentdetails.nceo" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('banklocation')">
						<label><spring:message code="label.bankLocation" /></label>
						<input type="text" ng-model="item.paymentdetails.banklocation" class="form-control" tabindex="6" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('legaladdress')">
						<label><spring:message code="label.legalAddress" /></label>
						<input type="text" ng-model="item.paymentdetails.legaladdress" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('iin')">
						<label><spring:message code="label.iin" /></label>
						<input type="text" ng-model="item.paymentdetails.iin" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('postaladdress')">
						<label><spring:message code="label.postalAddress" /></label>
						<input type="text" ng-model="item.paymentdetails.postaladdress" class="form-control" tabindex="9" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameofthebank')">
						<label><spring:message code="label.nameOfTheBank" /></label>
						<input type="text" ng-model="item.paymentdetails.nameofthebank" class="form-control" tabindex="10" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('phone')">
						<label><spring:message code="label.phone" /></label>
						<input type="text" ng-model="item.paymentdetails.phone" class="form-control" tabindex="11" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('correspondentaccount')">
						<label><spring:message code="label.correspondentAccount" /></label>
						<input type="text" ng-model="item.paymentdetails.correspondentaccount" class="form-control" tabindex="12" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currentaccount')">
						<label><spring:message code="label.currentAccount" /></label>
						<input type="text" ng-model="item.paymentdetails.currentaccount" class="form-control" tabindex="13" />
					</div>
				</div>
			

</div>
