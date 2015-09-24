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
				<spring:message code="label.TmContact" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/tmcontact/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
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
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('contactname')">
						<label><spring:message code="label.contactName" /></label>
						<input type="text" ng-model="item.contactname" class="form-control" tabindex="1" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('contactpatronymic')">
						<label><spring:message code="label.contactPatronymic" /></label>
						<input type="text" ng-model="item.contactpatronymic" class="form-control" tabindex="2" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('contactsurname')">
						<label><spring:message code="label.contactSurname" /></label>
						<input type="text" ng-model="item.contactsurname" class="form-control" tabindex="3" />
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
									
									<input type="text" class="form-control picker-input" ng-model="item.birthday" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.birthday, 'birthday')"
										is-open="details.birthday" close-text="X" tabindex="4">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.birthday" show-meridian="false" ng-change="convertDateAndTime(item.birthday, 'birthday')"></timepicker>
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
									
									<input type="text" class="form-control picker-input" ng-model="item.passportenddate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.passportenddate, 'passportenddate')"
										is-open="details.passportenddate" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.passportenddate" show-meridian="false" ng-change="convertDateAndTime(item.passportenddate, 'passportenddate')"></timepicker>
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
									
									<input type="text" class="form-control picker-input" ng-model="item.passportstartdate" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.passportstartdate, 'passportstartdate')"
										is-open="details.passportstartdate" close-text="X" tabindex="6">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.passportstartdate" show-meridian="false" ng-change="convertDateAndTime(item.passportstartdate, 'passportstartdate')"></timepicker>
							</div>
						</div>
					</div>

				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcountries')">
						<label><spring:message code="label.tmcontact.locationcountries" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcountries', 'LocationCountries', 'tmcontact', dataLocationCountries)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.locationcountries"
									ng-options="item.label for item in dataLocationCountries track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcountries', 'LocationCountries', 'tmcontact', dataLocationCountries)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('passportnumber')">
						<label><spring:message code="label.passportNumber" /></label>
						<input type="text" ng-model="item.passportnumber" class="form-control" tabindex="8" />
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="9"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			

				</div>
			  </tab>
			  
			  <tab select="initTab('tmcontactcommunications', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmContactCommunications"/></tab-heading>
						
						<div ng-if="templates.tmcontactcommunications.fragmentledit.init" ng-include="templates.tmcontactcommunications.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relcruisecontacts', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelCruiseContacts"/></tab-heading>
						
						<div ng-if="templates.relcruisecontacts.fragmentledit.init" ng-include="templates.relcruisecontacts.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmorder', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmOrder"/></tab-heading>
						
						<div ng-if="templates.tmorder.fragmentledit.init" ng-include="templates.tmorder.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('reltmordertmcontact', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelTmOrderTmContact"/></tab-heading>
						
						<div ng-if="templates.reltmordertmcontact.fragmentledit.init" ng-include="templates.reltmordertmcontact.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmincidents', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmIncidents"/></tab-heading>
						
						<div ng-if="templates.tmincidents.fragmentledit.init" ng-include="templates.tmincidents.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relaccountcontacts', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelAccountContacts"/></tab-heading>
						
						<div ng-if="templates.relaccountcontacts.fragmentledit.init" ng-include="templates.relaccountcontacts.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmcontactaddresses', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmContactAddresses"/></tab-heading>
						
						<div ng-if="templates.tmcontactaddresses.fragmentledit.init" ng-include="templates.tmcontactaddresses.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('paymentcontact', 'fragmentledit')">
						<tab-heading><spring:message code="label.PaymentContact"/></tab-heading>
						
						<div ng-if="templates.paymentcontact.fragmentledit.init" ng-include="templates.paymentcontact.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservtransfertmcontact', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServTransferTmContact"/></tab-heading>
						
						<div ng-if="templates.relservtransfertmcontact.fragmentledit.init" ng-include="templates.relservtransfertmcontact.fragmentledit.url"></div>
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
