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
				<spring:message code="label.TmAccount" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/tmaccount/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
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
				<div class="col-sm-8 col-md-6 col-xs-offset-0 col-sm-offset-2 col-md-offset-3 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcountries')">
						<label><spring:message code="label.tmaccount.locationcountries" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcountries', 'LocationCountries', 'tmaccount', dataLocationCountries)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.locationcountries"
									ng-options="item.label for item in dataLocationCountries track by item.id"
									tabindex="1">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcountries', 'LocationCountries', 'tmaccount', dataLocationCountries)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('accountname')">
						<label><spring:message code="label.accountName" /></label>
						<input type="text" ng-model="item.accountname" class="form-control" tabindex="2" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('accountfullname')">
						<label><spring:message code="label.accountFullname" /></label>
						<input type="text" ng-model="item.accountfullname" class="form-control" tabindex="3" />
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="4"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			

				</div>
			  </tab>
			  
			  <tab select="initTab('servticketsrail', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServTicketsRail"/></tab-heading>
						
						<div ng-if="templates.servticketsrail.fragmentledit.init" ng-include="templates.servticketsrail.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servticketsair', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServTicketsAir"/></tab-heading>
						
						<div ng-if="templates.servticketsair.fragmentledit.init" ng-include="templates.servticketsair.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmaccountdetails', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmAccountDetails"/></tab-heading>
						
						<div ng-if="templates.tmaccountdetails.fragmentledit.init" ng-include="templates.tmaccountdetails.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servtransfer', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServTransfer"/></tab-heading>
						
						<div ng-if="templates.servtransfer.fragmentledit.init" ng-include="templates.servtransfer.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servexcursions', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServExcursions"/></tab-heading>
						
						<div ng-if="templates.servexcursions.fragmentledit.init" ng-include="templates.servexcursions.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servhotel', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServHotel"/></tab-heading>
						
						<div ng-if="templates.servhotel.fragmentledit.init" ng-include="templates.servhotel.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servvisas', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServVisas"/></tab-heading>
						
						<div ng-if="templates.servvisas.fragmentledit.init" ng-include="templates.servvisas.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmorder', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmOrder"/></tab-heading>
						
						<div ng-if="templates.tmorder.fragmentledit.init" ng-include="templates.tmorder.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servticketsair', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServTicketsAir"/></tab-heading>
						
						<div ng-if="templates.servticketsair.fragmentledit.init" ng-include="templates.servticketsair.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servcruise', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServCruise"/></tab-heading>
						
						<div ng-if="templates.servcruise.fragmentledit.init" ng-include="templates.servcruise.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servtour', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServTour"/></tab-heading>
						
						<div ng-if="templates.servtour.fragmentledit.init" ng-include="templates.servtour.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('paymentaccount', 'fragmentledit')">
						<tab-heading><spring:message code="label.PaymentAccount"/></tab-heading>
						
						<div ng-if="templates.paymentaccount.fragmentledit.init" ng-include="templates.paymentaccount.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servticketsair', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServTicketsAir"/></tab-heading>
						
						<div ng-if="templates.servticketsair.fragmentledit.init" ng-include="templates.servticketsair.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relaccountcontacts', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelAccountContacts"/></tab-heading>
						
						<div ng-if="templates.relaccountcontacts.fragmentledit.init" ng-include="templates.relaccountcontacts.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmincidents', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmIncidents"/></tab-heading>
						
						<div ng-if="templates.tmincidents.fragmentledit.init" ng-include="templates.tmincidents.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmaccountcommunications', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmAccountCommunications"/></tab-heading>
						
						<div ng-if="templates.tmaccountcommunications.fragmentledit.init" ng-include="templates.tmaccountcommunications.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmaccountaddresses', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmAccountAddresses"/></tab-heading>
						
						<div ng-if="templates.tmaccountaddresses.fragmentledit.init" ng-include="templates.tmaccountaddresses.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servinsurances', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServInsurances"/></tab-heading>
						
						<div ng-if="templates.servinsurances.fragmentledit.init" ng-include="templates.servinsurances.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servinsurances', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServInsurances"/></tab-heading>
						
						<div ng-if="templates.servinsurances.fragmentledit.init" ng-include="templates.servinsurances.fragmentledit.url"></div>
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
