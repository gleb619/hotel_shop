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
				<spring:message code="default.edit" /><spring:message code="label.ServTicketsRail" />
			<c:if test="${debug}">
				<a href="../data/servticketsrail/{{ ::item.id }}" target="_blank" class="btn btn-default"> JSON DATA </a>
			</c:if>
			</h4>
		</div>
		<div class="modal-body padding-top-0">
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
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('currcurrency')">
						<label><spring:message code="label.currCurrency" /></label>
						<div class="input-group combobox-holder">
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-add" type="button"
									ng-click="addDict('currcurrency', 'CurrCurrency', 'servticketsrail', dataCurrCurrency)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.currcurrency"
									ng-options="item.label for item in dataCurrCurrency track by item.id"
									tabindex="7">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('currcurrency', 'CurrCurrency', 'servticketsrail', dataCurrCurrency)">
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
									ng-click="addDict('tmaccount', 'TmAccount', 'servticketsrail', dataTmAccount)">
									<i class="fa fa-plus"></i>
								</button>
							</span>
							
							<select class="form-control"
									ng-model="item.tmaccount"
									ng-options="item.label for item in dataTmAccount track by item.id"
									tabindex="8">
							</select>
							
							<span class="input-group-btn">
								<button class="btn btn-default combobox-holder-search" type="button"
									ng-click="searchDict('tmaccount', 'TmAccount', 'servticketsrail', dataTmAccount)">
									<i class="fa fa-search"></i>
								</button>
							</span>
							
						</div>
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('railcompanydep')">
						<label><spring:message code="label.railCompanyDepId" /></label>
						<input type="number" ng-model="item.railcompanydep" class="form-control" tabindex="9" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackarrival')">
						<label><spring:message code="label.cityBackArrivalId" /></label>
						<input type="number" ng-model="item.citybackarrival" class="form-control" tabindex="10" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytherearrival')">
						<label><spring:message code="label.cityThereArrivalId" /></label>
						<input type="number" ng-model="item.citytherearrival" class="form-control" tabindex="11" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('railcompanyarrival')">
						<label><spring:message code="label.railCompanyArrivalId" /></label>
						<input type="number" ng-model="item.railcompanyarrival" class="form-control" tabindex="12" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('numtraindep')">
						<label><spring:message code="label.numTrainDep" /></label>
						<input type="number" ng-model="item.numtraindep" class="form-control" tabindex="13" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('classtrainarrival')">
						<label><spring:message code="label.classTrainArrivalId" /></label>
						<input type="number" ng-model="item.classtrainarrival" class="form-control" tabindex="14" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('citytheredep')">
						<label><spring:message code="label.cityThereDepId" /></label>
						<input type="number" ng-model="item.citytheredep" class="form-control" tabindex="15" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('classtraindep')">
						<label><spring:message code="label.classTrainDepId" /></label>
						<input type="number" ng-model="item.classtraindep" class="form-control" tabindex="16" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('citybackdep')">
						<label><spring:message code="label.cityBackDepId" /></label>
						<input type="number" ng-model="item.citybackdep" class="form-control" tabindex="17" />
					</div>

					<div class="form-group margin-top-5" ng-if="::checkVisibility('numtrainarrival')">
						<label><spring:message code="label.numTrainArrival" /></label>
						<input type="number" ng-model="item.numtrainarrival" class="form-control" tabindex="18" />
					</div>
				</div>
			
				<div class="col-md-6 col-lg-4 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('railname')">
						<label><spring:message code="label.railName" /></label>
						<input type="text" ng-model="item.railname" class="form-control" tabindex="19" />
					</div>
				</div>
			
				<div class="col-md-12 edit-block">
						
					<div class="form-group margin-top-5" ng-if="::checkVisibility('descr')">
						<label><spring:message code="label.descr" /></label>
						<div class="custom-textarea-holder">
							<!-- ui-tinymce="tinymceOptions" -->
							<!-- <textarea type="text" ng-model="item.descr" class="form-control custom-textarea" tabindex="20"> -->
							<div text-angular ng-model="item.descr"></div>
							<!-- </textarea> -->
						</div>
					</div>
				</div>
			

			</div>
		</div>
		<div class="modal-footer">
			<div class="col-xs-6 col-md-6">
				<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
					<spring:message code="default.cancel" />
				</a>
			</div>
			<div class="col-xs-6 col-md-6">
				<a ng-click="updateItem()"
					class="btn btn-success btn-block btn-lg"> <spring:message
						code="default.submit" />
				</a>
			</div>
		</div>
  </div>
  <div ng-show="loading" class="loading-bar-holder border-none">
	<div class="loading-bar">
		<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
	</div>
  </div>
</div>
