<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.tmuserinfo.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('lastlogin')">
						<label><spring:message code="label.lastLogin" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'lastlogin')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.tmuserinfo.lastlogin" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.lastlogin, 'lastlogin')"
										is-open="details.lastlogin" close-text="X" tabindex="2">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.tmuserinfo.lastlogin" show-meridian="false" ng-change="convertDateAndTime(item.lastlogin, 'lastlogin')"></timepicker>
							</div>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('proxycontent')">
						<label><spring:message code="label.proxyContent" /></label>
						<input type="text" ng-model="item.tmuserinfo.proxycontent" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('remotehost')">
						<label><spring:message code="label.remoteHost" /></label>
						<input type="text" ng-model="item.tmuserinfo.remotehost" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('browser')">
						<label><spring:message code="label.browser" /></label>
						<input type="text" ng-model="item.tmuserinfo.browser" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('browserversion')">
						<label><spring:message code="label.browserVersion" /></label>
						<input type="text" ng-model="item.tmuserinfo.browserversion" class="form-control" tabindex="6" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('useripaddress')">
						<label><spring:message code="label.userIpAddress" /></label>
						<input type="text" ng-model="item.tmuserinfo.useripaddress" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('useragent')">
						<label><spring:message code="label.userAgent" /></label>
						<input type="text" ng-model="item.tmuserinfo.useragent" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('platformversion')">
						<label><spring:message code="label.platformversion" /></label>
						<input type="text" ng-model="item.tmuserinfo.platformversion" class="form-control" tabindex="9" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('platform')">
						<label><spring:message code="label.platform" /></label>
						<input type="text" ng-model="item.tmuserinfo.platform" class="form-control" tabindex="10" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('username')">
						<label><spring:message code="label.username" /></label>
						<input type="text" ng-model="item.tmuserinfo.username" class="form-control" tabindex="11" />
					</div>
				</div>
			

</div>
