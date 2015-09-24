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
				<spring:message code="label.ServHotelRoom" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/servhotelroom/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
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

					<div class="form-group margin-top-5" ng-if="::checkVisibility('breakfast')">
						<input type="checkbox" ng-model="item.breakfast" tabindex="2"/>
						<label><spring:message code="label.breakfast" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyfood')">
						<label><spring:message code="label.dictGlobalByFoodId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyfood', 'DictGlobal', 'servhotelroom', dataDictGlobalByFoodId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbyfood"
									ng-options="item.label for item in dataDictGlobalByFoodId track by item.id"
									tabindex="3">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyfood', 'DictGlobal', 'servhotelroom', dataDictGlobalByFoodId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobalbyroomtype')">
						<label><spring:message code="label.dictGlobalByRoomTypeId" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobalbyroomtype', 'DictGlobal', 'servhotelroom', dataDictGlobalByRoomTypeId)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobalbyroomtype"
									ng-options="item.label for item in dataDictGlobalByRoomTypeId track by item.id"
									tabindex="4">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobalbyroomtype', 'DictGlobal', 'servhotelroom', dataDictGlobalByRoomTypeId)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('groupglobal')">
						<label><spring:message code="label.groupGlobal" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('groupglobal', 'GroupGlobal', 'servhotelroom', dataGroupGlobal)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.groupglobal"
									ng-options="item.label for item in dataGroupGlobal track by item.id"
									tabindex="5">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('groupglobal', 'GroupGlobal', 'servhotelroom', dataGroupGlobal)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('servhotel')">
						<label><spring:message code="label.servHotel" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('servhotel', 'ServHotel', 'servhotelroom', dataServHotel)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.servhotel"
									ng-options="item.label for item in dataServHotel track by item.id"
									tabindex="6">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('servhotel', 'ServHotel', 'servhotelroom', dataServHotel)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('roomnumber')">
						<label><spring:message code="label.roomNumber" /></label>
						<input type="number" ng-model="item.roomnumber" class="form-control" tabindex="7" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('guestnumber')">
						<label><spring:message code="label.guestNumber" /></label>
						<input type="number" ng-model="item.guestnumber" class="form-control" tabindex="8" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('category')">
						<label><spring:message code="label.category" /></label>
						<input type="text" ng-model="item.category" class="form-control" tabindex="9" />
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="10"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descriptioncollapsed')">
						<input type="checkbox" ng-model="item.descriptioncollapsed" tabindex="11"/>
						<label><spring:message code="label.descriptioncollapsed" /></label>
					</div>
				</div>
			

				</div>
			  </tab>
			  
			  <tab select="initTab('reqservhotelroombusy', 'fragmentledit')">
						<tab-heading><spring:message code="label.ReqServHotelRoomBusy"/></tab-heading>
						
						<div ng-if="templates.reqservhotelroombusy.fragmentledit.init" ng-include="templates.reqservhotelroombusy.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelroomfeatures', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelRoomFeatures"/></tab-heading>
						
						<div ng-if="templates.relservhotelroomfeatures.fragmentledit.init" ng-include="templates.relservhotelroomfeatures.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('reqhotelroomsbusy', 'fragmentledit')">
						<tab-heading><spring:message code="label.ReqHotelRoomsBusy"/></tab-heading>
						
						<div ng-if="templates.reqhotelroomsbusy.fragmentledit.init" ng-include="templates.reqhotelroomsbusy.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('reqservhotel', 'fragmentledit')">
						<tab-heading><spring:message code="label.ReqServHotel"/></tab-heading>
						
						<div ng-if="templates.reqservhotel.fragmentledit.init" ng-include="templates.reqservhotel.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelroomimage', 'fragmentledit')">
						<tab-heading><spring:message code="label.RelServHotelRoomImage"/></tab-heading>
						
						<div ng-if="templates.relservhotelroomimage.fragmentledit.init" ng-include="templates.relservhotelroomimage.fragmentledit.url"></div>
					</tab>
					
					<tab select="initTab('paymenttariff', 'fragmentledit')">
						<tab-heading><spring:message code="label.PaymentTariff"/></tab-heading>
						
						<div ng-if="templates.paymenttariff.fragmentledit.init" ng-include="templates.paymenttariff.fragmentledit.url"></div>
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
