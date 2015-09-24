<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.locationtypeplacement.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobal')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobal', 'null', 'null', dataDictGlobal)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.locationtypeplacement.dictglobal"
									ng-options="item.label for item in dataDictGlobal track by item.id"
									tabindex="2">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobal', 'null', 'null', dataDictGlobal)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numberofbuildings')">
						<label><spring:message code="label.numberOfBuildings" /></label>
						<input type="number" ng-model="item.locationtypeplacement.numberofbuildings" class="form-control" tabindex="3" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numberofrooms')">
						<label><spring:message code="label.numberOfRooms" /></label>
						<input type="number" ng-model="item.locationtypeplacement.numberofrooms" class="form-control" tabindex="4" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('availablenumberofrooms')">
						<label><spring:message code="label.availableNumberOfRooms" /></label>
						<input type="number" ng-model="item.locationtypeplacement.availablenumberofrooms" class="form-control" tabindex="5" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('availablenumberoflevels')">
						<label><spring:message code="label.availableNumberOfLevels" /></label>
						<input type="number" ng-model="item.locationtypeplacement.availablenumberoflevels" class="form-control" tabindex="6" />
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numberoflevels')">
						<label><spring:message code="label.numberOfLevels" /></label>
						<input type="number" ng-model="item.locationtypeplacement.numberoflevels" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('servhotel')">
						<label><spring:message code="label.servHotelId" /></label>
						<input type="number" ng-model="item.locationtypeplacement.servhotel" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('availablenumberofbuildings')">
						<label><spring:message code="label.availableNumberOfBuildings" /></label>
						<input type="number" ng-model="item.locationtypeplacement.availablenumberofbuildings" class="form-control" tabindex="9" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('nameeng')">
						<label><spring:message code="label.nameeng" /></label>
						<input type="text" ng-model="item.locationtypeplacement.nameeng" class="form-control" tabindex="10" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('name')">
						<label><spring:message code="label.name" /></label>
						<input type="text" ng-model="item.locationtypeplacement.name" class="form-control" tabindex="11" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('value')">
						<label><spring:message code="label.value" /></label>
						<input type="text" ng-model="item.locationtypeplacement.value" class="form-control" tabindex="12" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('valueeng')">
						<label><spring:message code="label.valueeng" /></label>
						<input type="text" ng-model="item.locationtypeplacement.valueeng" class="form-control" tabindex="13" />
					</div>
				</div>
			

</div>
