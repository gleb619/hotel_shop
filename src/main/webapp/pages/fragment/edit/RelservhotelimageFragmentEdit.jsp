<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="row">
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmimage')">
						<label><spring:message code="label.null" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmimage', 'null', 'null', dataTmImage)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.relservhotelimage.tmimage"
									ng-options="item.label for item in dataTmImage track by item.id"
									tabindex="1">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmimage', 'null', 'null', dataTmImage)">
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
									ng-model="item.relservhotelimage.servhotel"
									ng-options="item.label for item in dataServHotel track by item.id"
									tabindex="2">
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
			

</div>
