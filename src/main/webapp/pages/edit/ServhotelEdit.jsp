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
				<spring:message code="label.ServHotel" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/servhotel/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
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

					<div class="form-group margin-top-5" ng-if="::checkVisibility('starcount')">
						<label><spring:message code="label.starcount" /></label>
						<rating ng-model="item.starcount" class="rating-custom" tabindex="2"></rating>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('showonline')">
						<input type="checkbox" ng-model="item.showonline" tabindex="3"/>
						<label><spring:message code="label.showonline" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('problem')">
						<input type="checkbox" ng-model="item.problem" tabindex="4"/>
						<label><spring:message code="label.problem" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('credit')">
						<input type="checkbox" ng-model="item.credit" tabindex="5"/>
						<label><spring:message code="label.credit" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('workonprepayment')">
						<input type="checkbox" ng-model="item.workonprepayment" tabindex="6"/>
						<label><spring:message code="label.workonprepayment" /></label>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('blacklist')">
						<input type="checkbox" ng-model="item.blacklist" tabindex="7"/>
						<label><spring:message code="label.blacklist" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('freesale')">
						<input type="checkbox" ng-model="item.freesale" tabindex="8"/>
						<label><spring:message code="label.freesale" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('favorite')">
						<input type="checkbox" ng-model="item.favorite" tabindex="9"/>
						<label><spring:message code="label.favorite" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyquality')">
						<label><spring:message code="label.dictGlobalByQualityId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyquality', 'DictGlobal', 'servhotel', dataDictGlobalByQualityId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbyquality"
									ng-options="item.label for item in dataDictGlobalByQualityId track by item.id"
									tabindex="10">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyquality', 'DictGlobal', 'servhotel', dataDictGlobalByQualityId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyserviceid')">
						<label><spring:message code="label.dictGlobalByServiceidId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyserviceid', 'DictGlobal', 'servhotel', dataDictGlobalByServiceidId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbyserviceid"
									ng-options="item.label for item in dataDictGlobalByServiceidId track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyserviceid', 'DictGlobal', 'servhotel', dataDictGlobalByServiceidId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccount')">
						<label><spring:message code="label.tmAccount" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccount', 'TmAccount', 'servhotel', dataTmAccount)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="13">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'TmAccount', 'servhotel', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbytype')">
						<label><spring:message code="label.dictGlobalByTypeId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbytype', 'DictGlobal', 'servhotel', dataDictGlobalByTypeId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbytype"
									ng-options="item.label for item in dataDictGlobalByTypeId track by item.id"
									tabindex="15">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbytype', 'DictGlobal', 'servhotel', dataDictGlobalByTypeId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcities')">
						<label><spring:message code="label.locationCities" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcities', 'LocationCities', 'servhotel', dataLocationCities)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.locationcities"
									ng-options="item.label for item in dataLocationCities track by item.id"
									tabindex="16">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcities', 'LocationCities', 'servhotel', dataLocationCities)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcountries')">
						<label><spring:message code="label.locationCountries" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcountries', 'LocationCountries', 'servhotel', dataLocationCountries)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.locationcountries"
									ng-options="item.label for item in dataLocationCountries track by item.id"
									tabindex="18">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcountries', 'LocationCountries', 'servhotel', dataLocationCountries)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrency')">
						<label><spring:message code="label.currCurrency" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrency', 'CurrCurrency', 'servhotel', dataCurrCurrency)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="19">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'CurrCurrency', 'servhotel', dataCurrCurrency)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationtypeplacement')">
						<label><spring:message code="label.locationTypePlacement" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationtypeplacement', 'LocationTypePlacement', 'servhotel', dataLocationTypePlacement)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.locationtypeplacement"
									ng-options="item.label for item in dataLocationTypePlacement track by item.id"
									tabindex="20">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationtypeplacement', 'LocationTypePlacement', 'servhotel', dataLocationTypePlacement)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('roomsnumber')">
						<label><spring:message code="label.roomsnumber" /></label>
						<input type="number" ng-model="item.roomsnumber" class="form-control" tabindex="21" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('storeys')">
						<label><spring:message code="label.storeys" /></label>
						<input type="number" ng-model="item.storeys" class="form-control" tabindex="22" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('whereroomsarebooked')">
						<label><spring:message code="label.whereroomsarebooked" /></label>
						<input type="text" ng-model="item.whereroomsarebooked" class="form-control" tabindex="23" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameeng')">
						<label><spring:message code="label.nameeng" /></label>
						<input type="text" ng-model="item.nameeng" class="form-control" tabindex="24" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('timedeparture')">
						<label><spring:message code="label.timedeparture" /></label>
						<div class="col-md-12 auto-center">
							<timepicker ng-model="item.timedeparture" show-meridian="::false" ng-change="convertTime(item.timedeparture, 'timedeparture')"></timepicker>
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('timerace')">
						<label><spring:message code="label.timerace" /></label>
						<div class="col-md-12 auto-center">
							<timepicker ng-model="item.timerace" show-meridian="::false" ng-change="convertTime(item.timerace, 'timerace')"></timepicker>
						</div>
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descrinternal')">
						<label><spring:message code="label.descrInternal" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descrinternal" class="form-control custom-textarea" tabindex="27"> -->
							<div text-angular ng-model="item.descrinternal"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('conditiontext')">
						<label><spring:message code="label.conditionText" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.conditiontext" class="form-control custom-textarea" tabindex="28"> -->
							<div text-angular ng-model="item.conditiontext"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="29"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			

				</div>
			  </tab>
			  
			  <tab>
						<tab-heading>
							<spring:message code="label.locationAddress"/>
						</tab-heading>
						<div class="v-holder-300">
							<jsp:include page="../fragment/edit/LocationaddressFragmentEdit.jsp" />
						</div>
					</tab>
					<tab>
						<tab-heading>
							<spring:message code="label.paymentDetails"/>
						</tab-heading>
						<div class="v-holder-300">
							<jsp:include page="../fragment/edit/PaymentdetailsFragmentEdit.jsp" />
						</div>
					</tab>
					<tab>
						<tab-heading>
							<spring:message code="label.infoContactInformation"/>
						</tab-heading>
						<div class="v-holder-300">
							<jsp:include page="../fragment/edit/InfocontactinformationFragmentEdit.jsp" />
						</div>
					</tab>
					<tab select="initTab('relservhotelinfocommercial', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelInfoCommercial"/></tab-heading>
						
						<div ng-if="templates.relservhotelinfocommercial.fragmentledit.init" ng-include="templates.relservhotelinfocommercial.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhoteldocdocuments', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelDocDocuments"/></tab-heading>
						
						<div ng-if="templates.relservhoteldocdocuments.fragmentledit.init" ng-include="templates.relservhoteldocdocuments.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('reltourhotels', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelTourHotels"/></tab-heading>
						
						<div ng-if="templates.reltourhotels.fragmentledit.init" ng-include="templates.reltourhotels.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('servhotelroom', 'fragmentledit')">
						<tab-heading><spring:message code="label.ServHotelRoom"/></tab-heading>
						
						<div ng-if="templates.servhotelroom.fragmentledit.init" ng-include="templates.servhotelroom.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelinfohotelservices', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelInfoHotelServices"/></tab-heading>
						
						<div ng-if="templates.relservhotelinfohotelservices.fragmentledit.init" ng-include="templates.relservhotelinfohotelservices.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelcreditcards', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelCreditCards"/></tab-heading>
						
						<div ng-if="templates.relservhotelcreditcards.fragmentledit.init" ng-include="templates.relservhotelcreditcards.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('infoservices', 'fragmentledit')">
						<tab-heading><spring:message code="label.InfoServices"/></tab-heading>
						
						<div ng-if="templates.infoservices.fragmentledit.init" ng-include="templates.infoservices.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('reqcruisehotels', 'fragmentledit')">
						<tab-heading><spring:message code="label.ReqCruiseHotels"/></tab-heading>
						
						<div ng-if="templates.reqcruisehotels.fragmentledit.init" ng-include="templates.reqcruisehotels.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelinfopolicies', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelInfoPolicies"/></tab-heading>
						
						<div ng-if="templates.relservhotelinfopolicies.fragmentledit.init" ng-include="templates.relservhotelinfopolicies.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('tmincidents', 'fragmentledit')">
						<tab-heading><spring:message code="label.TmIncidents"/></tab-heading>
						
						<div ng-if="templates.tmincidents.fragmentledit.init" ng-include="templates.tmincidents.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelfeatures', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelFeatures"/></tab-heading>
						
						<div ng-if="templates.relservhotelfeatures.fragmentledit.init" ng-include="templates.relservhotelfeatures.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelentertainmentandsport', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelEntertainmentAndSport"/></tab-heading>
						
						<div ng-if="templates.relservhotelentertainmentandsport.fragmentledit.init" ng-include="templates.relservhotelentertainmentandsport.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('reqservhotel', 'fragmentledit')">
						<tab-heading><spring:message code="label.ReqServHotel"/></tab-heading>
						
						<div ng-if="templates.reqservhotel.fragmentledit.init" ng-include="templates.reqservhotel.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelservkidsrule', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelServKidsRule"/></tab-heading>
						
						<div ng-if="templates.relservhotelservkidsrule.fragmentledit.init" ng-include="templates.relservhotelservkidsrule.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelimage', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelImage"/></tab-heading>
						
						<div ng-if="templates.relservhotelimage.fragmentledit.init" ng-include="templates.relservhotelimage.fragmentledit.url"></div>
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
