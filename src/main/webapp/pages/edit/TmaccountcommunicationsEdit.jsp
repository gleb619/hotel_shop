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
				<spring:message code="label.TmAccountCommunications" />
				<c:if test="${debug}">
					<span>{{ item.id }}</span>
					<a href="../data/tmaccountcommunications/{{ ::item.id }}?initLists=true&initDicts=true" target="_blank" class="btn btn-default">
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

					<div class="form-group margin-top-5" ng-if="::checkVisibility('isdetail')">
						<input type="checkbox" ng-model="item.isDetail" tabindex="2"/>
						<label><spring:message code="label.isDetail" /></label>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('locationcities')">
						<label><spring:message code="label.locationCities" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('locationcities', 'LocationCities', 'tmaccountcommunications', dataLocationCities)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.locationcities"
									ng-options="item.label for item in dataLocationCities track by item.id"
									tabindex="3">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('locationcities', 'LocationCities', 'tmaccountcommunications', dataLocationCities)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('tmaccount')">
						<label><spring:message code="label.tmAccount" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('tmaccount', 'TmAccount', 'tmaccountcommunications', dataTmAccount)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="4">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'TmAccount', 'tmaccountcommunications', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('dictglobal')">
						<label><spring:message code="label.dictGlobal" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('dictglobal', 'DictGlobal', 'tmaccountcommunications', dataDictGlobal)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.dictglobal"
									ng-options="item.label for item in dataDictGlobal track by item.id"
									tabindex="5">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('dictglobal', 'DictGlobal', 'tmaccountcommunications', dataDictGlobal)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('communicationname')">
						<label><spring:message code="label.communicationName" /></label>
						<input type="text" ng-model="item.communicationname" class="form-control" tabindex="6" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('communicationvalue')">
						<label><spring:message code="label.communicationValue" /></label>
						<input type="text" ng-model="item.communicationvalue" class="form-control" tabindex="7" />
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="8"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
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
