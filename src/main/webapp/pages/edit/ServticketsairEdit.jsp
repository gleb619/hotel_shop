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
				<spring:message code="label.ServTicketsAir" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/servticketsair/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
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

					<div class="form-group margin-top-5" ng-if="::checkVisibility('price')">
						<label><spring:message code="label.price" /></label>
						<input type="number" step="0.01" ng-model="item.price" class="form-control" tabindex="2" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('datestartdep')">
						<label><spring:message code="label.dateStartDep" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'datestartdep')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.datestartdep" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.datestartdep, 'datestartdep')"
										is-open="details.datestartdep" close-text="X" tabindex="3">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.datestartdep" show-meridian="false" ng-change="convertDateAndTime(item.datestartdep, 'datestartdep')"></timepicker>
							</div>
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('dateendarrival')">
						<label><spring:message code="label.dateEndArrival" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'dateendarrival')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.dateendarrival" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.dateendarrival, 'dateendarrival')"
										is-open="details.dateendarrival" close-text="X" tabindex="4">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.dateendarrival" show-meridian="false" ng-change="convertDateAndTime(item.dateendarrival, 'dateendarrival')"></timepicker>
							</div>
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('dateenddep')">
						<label><spring:message code="label.dateEndDep" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'dateenddep')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.dateenddep" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.dateenddep, 'dateenddep')"
										is-open="details.dateenddep" close-text="X" tabindex="5">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.dateenddep" show-meridian="false" ng-change="convertDateAndTime(item.dateenddep, 'dateenddep')"></timepicker>
							</div>
						</div>
					</div>


					<div class="form-group margin-top-5" ng-if="::checkVisibility('datestartarrival')">
						<label><spring:message code="label.dateStartArrival" /></label>
						<div class="picker-holder">
							<div class="col-xs-8">
								<div class="input-group picker-item">
									<span class="input-group-btn">
										<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'datestartarrival')">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
									
									<input type="text" class="form-control picker-input" ng-model="item.datestartarrival" datepicker-popup="yyyy-MM-dd"
										ng-change="convertDateAndTime(item.datestartarrival, 'datestartarrival')"
										is-open="details.datestartarrival" close-text="X" tabindex="6">
									
								</div>
							</div>
							<div class="col-xs-4 auto-center">
								<timepicker ng-model="item.datestartarrival" show-meridian="false" ng-change="convertDateAndTime(item.datestartarrival, 'datestartarrival')"></timepicker>
							</div>
						</div>
					</div>

				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbytypeplanearrival')">
						<label><spring:message code="label.dictGlobalByTypePlaneArrivalId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbytypeplanearrival', 'DictGlobal', 'servticketsair', dataDictGlobalByTypePlaneArrivalId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbytypeplanearrival"
									ng-options="item.label for item in dataDictGlobalByTypePlaneArrivalId track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbytypeplanearrival', 'DictGlobal', 'servticketsair', dataDictGlobalByTypePlaneArrivalId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccountbyaircompanyarrival')">
						<label><spring:message code="label.tmAccountByAirCompanyArrivalId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccountbyaircompanyarrival', 'TmAccount', 'servticketsair', dataTmAccountByAirCompanyArrivalId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.tmaccountbyaircompanyarrival"
									ng-options="item.label for item in dataTmAccountByAirCompanyArrivalId track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccountbyaircompanyarrival', 'TmAccount', 'servticketsair', dataTmAccountByAirCompanyArrivalId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyairclass')">
						<label><spring:message code="label.dictGlobalByAirclassId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyairclass', 'DictGlobal', 'servticketsair', dataDictGlobalByAirclassId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbyairclass"
									ng-options="item.label for item in dataDictGlobalByAirclassId track by item.id"
									tabindex="9">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyairclass', 'DictGlobal', 'servticketsair', dataDictGlobalByAirclassId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrency')">
						<label><spring:message code="label.currCurrency" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrency', 'CurrCurrency', 'servticketsair', dataCurrCurrency)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="10">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'CurrCurrency', 'servticketsair', dataCurrCurrency)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbytypeplanedep')">
						<label><spring:message code="label.dictGlobalByTypePlaneDepId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbytypeplanedep', 'DictGlobal', 'servticketsair', dataDictGlobalByTypePlaneDepId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbytypeplanedep"
									ng-options="item.label for item in dataDictGlobalByTypePlaneDepId track by item.id"
									tabindex="11">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbytypeplanedep', 'DictGlobal', 'servticketsair', dataDictGlobalByTypePlaneDepId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccountbyaccount')">
						<label><spring:message code="label.tmAccountByAccountId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccountbyaccount', 'TmAccount', 'servticketsair', dataTmAccountByAccountId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.tmaccountbyaccount"
									ng-options="item.label for item in dataTmAccountByAccountId track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccountbyaccount', 'TmAccount', 'servticketsair', dataTmAccountByAccountId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccountbyaircompanydep')">
						<label><spring:message code="label.tmAccountByAirCompanyDepId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccountbyaircompanydep', 'TmAccount', 'servticketsair', dataTmAccountByAirCompanyDepId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.tmaccountbyaircompanydep"
									ng-options="item.label for item in dataTmAccountByAirCompanyDepId track by item.id"
									tabindex="13">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccountbyaircompanydep', 'TmAccount', 'servticketsair', dataTmAccountByAirCompanyDepId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackarrival')">
						<label><spring:message code="label.cityBackArrivalId" /></label>
						<input type="number" ng-model="item.citybackarrival" class="form-control" tabindex="14" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytherearrival')">
						<label><spring:message code="label.cityThereArrivalId" /></label>
						<input type="number" ng-model="item.citytherearrival" class="form-control" tabindex="15" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('numflightdep')">
						<label><spring:message code="label.numFlightDep" /></label>
						<input type="number" ng-model="item.numflightdep" class="form-control" tabindex="16" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('numflightarrival')">
						<label><spring:message code="label.numFlightArrival" /></label>
						<input type="number" ng-model="item.numflightarrival" class="form-control" tabindex="17" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytheredep')">
						<label><spring:message code="label.cityThereDepId" /></label>
						<input type="number" ng-model="item.citytheredep" class="form-control" tabindex="18" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackdep')">
						<label><spring:message code="label.cityBackDepId" /></label>
						<input type="number" ng-model="item.citybackdep" class="form-control" tabindex="19" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('airname')">
						<label><spring:message code="label.airName" /></label>
						<input type="text" ng-model="item.airname" class="form-control" tabindex="20" />
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="21"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			

				</div>
			  </tab>
			  
			  <tab select="initTab('infoservices', 'fragmentledit')">
						<tab-heading><spring:message code="label.InfoServices"/></tab-heading>
						
						<div ng-if="templates.infoservices.fragmentledit.init" ng-include="templates.infoservices.fragmentledit.url"></div>
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
