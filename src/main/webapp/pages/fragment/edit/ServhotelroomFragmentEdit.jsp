<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('label')">
						<label><spring:message code="label.label" /></label>
						<input type="text" ng-model="item.servhotelroom.label" class="form-control" tabindex="1" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('breakfast')">
						<input type="checkbox" ng-model="item.servhotelroom.breakfast" tabindex="2"/>
						<label><spring:message code="label.breakfast" /></label>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyfood')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyfood', 'null', 'null', dataDictGlobalByFoodId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotelroom.dictglobalbyfood"
									ng-options="item.label for item in dataDictGlobalByFoodId track by item.id"
									tabindex="3">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyfood', 'null', 'null', dataDictGlobalByFoodId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyroomtype')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyroomtype', 'null', 'null', dataDictGlobalByRoomTypeId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotelroom.dictglobalbyroomtype"
									ng-options="item.label for item in dataDictGlobalByRoomTypeId track by item.id"
									tabindex="4">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyroomtype', 'null', 'null', dataDictGlobalByRoomTypeId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('groupglobal')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('groupglobal', 'null', 'null', dataGroupGlobal)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotelroom.groupglobal"
									ng-options="item.label for item in dataGroupGlobal track by item.id"
									tabindex="5">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('groupglobal', 'null', 'null', dataGroupGlobal)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('servhotel')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('servhotel', 'null', 'null', dataServHotel)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotelroom.servhotel"
									ng-options="item.label for item in dataServHotel track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('servhotel', 'null', 'null', dataServHotel)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
					
				</div>
				<div class="col-md-6 col-lg-4 edit-block-2">
					
					<div class="form-group margin-top-5" ng-if="::checkVisibility('roomnumber')">
						<label><spring:message code="label.roomNumber" /></label>
						<input type="number" ng-model="item.servhotelroom.roomnumber" class="form-control" tabindex="7" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('guestnumber')">
						<label><spring:message code="label.guestNumber" /></label>
						<input type="number" ng-model="item.servhotelroom.guestnumber" class="form-control" tabindex="8" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('category')">
						<label><spring:message code="label.category" /></label>
						<input type="text" ng-model="item.servhotelroom.category" class="form-control" tabindex="9" />
					</div>
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descriptioncollapsed')">
						<input type="checkbox" ng-model="item.servhotelroom.descriptioncollapsed" tabindex="10"/>
						<label><spring:message code="label.descriptioncollapsed" /></label>
					</div>
				</div>
			

</div>
