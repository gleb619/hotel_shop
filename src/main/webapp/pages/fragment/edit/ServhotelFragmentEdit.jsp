<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servhotel.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('showonline')">
						<input type="checkbox" ng-model="item.servhotel.showonline" tabindex="2"/>
						<label><spring:message code="label.showonline" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('problem')">
						<input type="checkbox" ng-model="item.servhotel.problem" tabindex="3"/>
						<label><spring:message code="label.problem" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('credit')">
						<input type="checkbox" ng-model="item.servhotel.credit" tabindex="4"/>
						<label><spring:message code="label.credit" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('workonprepayment')">
						<input type="checkbox" ng-model="item.servhotel.workonprepayment" tabindex="5"/>
						<label><spring:message code="label.workonprepayment" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('blacklist')">
						<input type="checkbox" ng-model="item.servhotel.blacklist" tabindex="6"/>
						<label><spring:message code="label.blacklist" /></label>
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('freesale')">
						<input type="checkbox" ng-model="item.servhotel.freesale" tabindex="7"/>
						<label><spring:message code="label.freesale" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('favorite')">
						<input type="checkbox" ng-model="item.servhotel.favorite" tabindex="8"/>
						<label><spring:message code="label.favorite" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyquality')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyquality', 'null', 'null', dataDictGlobalByQualityId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.dictglobalbyquality"
									ng-options="item.label for item in dataDictGlobalByQualityId track by item.id"
									tabindex="9">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyquality', 'null', 'null', dataDictGlobalByQualityId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyserviceid')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyserviceid', 'null', 'null', dataDictGlobalByServiceidId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.dictglobalbyserviceid"
									ng-options="item.label for item in dataDictGlobalByServiceidId track by item.id"
									tabindex="10">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyserviceid', 'null', 'null', dataDictGlobalByServiceidId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyplacement')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyplacement', 'null', 'null', dataDictGlobalByPlacementId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.dictglobalbyplacement"
									ng-options="item.label for item in dataDictGlobalByPlacementId track by item.id"
									tabindex="11">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyplacement', 'null', 'null', dataDictGlobalByPlacementId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
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
									ng-model="item.servhotel.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="12">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'null', 'null', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyreserveticketstype')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyreserveticketstype', 'null', 'null', dataDictGlobalByReserveticketstypeId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.dictglobalbyreserveticketstype"
									ng-options="item.label for item in dataDictGlobalByReserveticketstypeId track by item.id"
									tabindex="13">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyreserveticketstype', 'null', 'null', dataDictGlobalByReserveticketstypeId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbytype')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbytype', 'null', 'null', dataDictGlobalByTypeId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.dictglobalbytype"
									ng-options="item.label for item in dataDictGlobalByTypeId track by item.id"
									tabindex="14">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbytype', 'null', 'null', dataDictGlobalByTypeId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbycategory')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbycategory', 'null', 'null', dataDictGlobalByCategoryId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.dictglobalbycategory"
									ng-options="item.label for item in dataDictGlobalByCategoryId track by item.id"
									tabindex="15">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbycategory', 'null', 'null', dataDictGlobalByCategoryId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcities')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcities', 'null', 'null', dataLocationCities)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.locationcities"
									ng-options="item.label for item in dataLocationCities track by item.id"
									tabindex="16">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcities', 'null', 'null', dataLocationCities)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcountries')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcountries', 'null', 'null', dataLocationCountries)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.locationcountries"
									ng-options="item.label for item in dataLocationCountries track by item.id"
									tabindex="17">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcountries', 'null', 'null', dataLocationCountries)">
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
									ng-model="item.servhotel.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="18">
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
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationtypeplacement')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationtypeplacement', 'null', 'null', dataLocationTypePlacement)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel.locationtypeplacement"
									ng-options="item.label for item in dataLocationTypePlacement track by item.id"
									tabindex="19">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationtypeplacement', 'null', 'null', dataLocationTypePlacement)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('roomsnumber')">
						<label><spring:message code="label.roomsnumber" /></label>
						<input type="number" ng-model="item.servhotel.roomsnumber" class="form-control" tabindex="20" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('storeys')">
						<label><spring:message code="label.storeys" /></label>
						<input type="number" ng-model="item.servhotel.storeys" class="form-control" tabindex="21" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('whereroomsarebooked')">
						<label><spring:message code="label.whereroomsarebooked" /></label>
						<input type="text" ng-model="item.servhotel.whereroomsarebooked" class="form-control" tabindex="22" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameeng')">
						<label><spring:message code="label.nameeng" /></label>
						<input type="text" ng-model="item.servhotel.nameeng" class="form-control" tabindex="23" />
					</div>
				</div>
			

</div>
