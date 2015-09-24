<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.tmfirms.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('lastpay')">
						<label><spring:message code="label.lastpay" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'lastpay')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.tmfirms.lastpay" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.lastpay, 'lastpay')"
										is-open="details.lastpay" close-text="X" tabindex="2">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.tmfirms.lastpay" show-meridian="false" ng-change="convertDateAndTime(item.lastpay, 'lastpay')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('account')">
						<label><spring:message code="label.accountid" /></label>
						<input type="number" ng-model="item.tmfirms.account" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('mounthcount')">
						<label><spring:message code="label.mounthcount" /></label>
						<input type="number" ng-model="item.tmfirms.mounthcount" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('active')">
						<label><spring:message code="label.active" /></label>
						<input type="text" ng-model="item.tmfirms.active" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('firmname')">
						<label><spring:message code="label.firmName" /></label>
						<input type="text" ng-model="item.tmfirms.firmname" class="form-control" tabindex="6" />
					</div>
				</div>
			

</div>
