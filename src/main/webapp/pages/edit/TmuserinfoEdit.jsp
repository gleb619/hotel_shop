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
				<span ng-if="::(access.edit || access.simple)"><spring:message code="default.edit" /></span>
				<span ng-if="::access.create"><spring:message code="default.createnew" /></span>
				<spring:message code="label.TmUserInfo" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/tmuserinfo/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
						JSON DATA
					</a>
				</c:if>
				<!--
				<div class="btn-group navigator">
				    <a class="btn btn-default navigator-item">
				    	<i class="fa fa-2x fa-backward"></i>
				    </a>
				    <a class="btn btn-default navigator-item">
				    	<i class="fa fa-2x fa-forward"></i>
				    </a>
				</div>
				-->
			</h4>
		</div>

		<div class="modal-body padding-top-0">
			<tabset type="pills"> 
			  <tab> 
				<tab-heading>
					<spring:message code="default.main" /> 
				</tab-heading> 
				<br/>
				<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.label" class="form-control" tabindex="1" />
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
									
									<input type="text" class="form-control picker-input" ng-model="item.lastlogin" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.lastlogin, 'lastlogin')"
										is-open="details.lastlogin" close-text="X" tabindex="2">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.lastlogin" show-meridian="false" ng-change="convertDateAndTime(item.lastlogin, 'lastlogin')"></timepicker>
							</div>
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('proxycontent')">
						<label><spring:message code="label.proxyContent" /></label>
						<input type="text" ng-model="item.proxycontent" class="form-control" tabindex="3" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('remotehost')">
						<label><spring:message code="label.remoteHost" /></label>
						<input type="text" ng-model="item.remotehost" class="form-control" tabindex="4" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('browser')">
						<label><spring:message code="label.browser" /></label>
						<input type="text" ng-model="item.browser" class="form-control" tabindex="5" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('browserversion')">
						<label><spring:message code="label.browserVersion" /></label>
						<input type="text" ng-model="item.browserversion" class="form-control" tabindex="6" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('useripaddress')">
						<label><spring:message code="label.userIpAddress" /></label>
						<input type="text" ng-model="item.useripaddress" class="form-control" tabindex="7" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('useragent')">
						<label><spring:message code="label.userAgent" /></label>
						<input type="text" ng-model="item.useragent" class="form-control" tabindex="8" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('platformversion')">
						<label><spring:message code="label.platformversion" /></label>
						<input type="text" ng-model="item.platformversion" class="form-control" tabindex="9" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('platform')">
						<label><spring:message code="label.platform" /></label>
						<input type="text" ng-model="item.platform" class="form-control" tabindex="10" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('username')">
						<label><spring:message code="label.username" /></label>
						<input type="text" ng-model="item.username" class="form-control" tabindex="11" />
					</div>
				</div>
			

				</div>
			  </tab>
			  
			  
			</tabset>
		</div>
		<div class="modal-footer">
			<div class="row margin-top-15">
				<div class="col-xs-6 col-md-6 text-overflow">
					<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
						<span><spring:message code="default.cancel" /></span>
					</a>
				</div>
				<div class="col-xs-6 col-md-6 text-overflow">
					<a ng-click="updateItem()" class="btn btn-success btn-block btn-lg"> 
						<span><spring:message code="default.submit" /></span>
					</a>
				</div>
			</div>
		</div>
  </div>
  <div ng-show="loading" class="loading-bar-holder border-none">
	<div class="loading-bar">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
  </div>
</div>
