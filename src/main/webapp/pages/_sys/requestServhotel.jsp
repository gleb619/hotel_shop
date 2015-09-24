<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group margin-top-5">
				<label> <spring:message code="label.dictGlobalByPaymentTypeId" />
				</label> <select class="form-control" id="selectdictDictGlobalByPaymentTypeId" ng-model="reqitem.dictglobalbypaymenttype"
					ng-options="reqitem.label for reqitem in dataDictGlobalByPaymentTypeId track by reqitem.id" tabindex="4">
				</select>
			</div>
			<div class="form-group margin-top-5">
				<label> <spring:message code="label.dictGlobalByFoodId" />
				</label> <select class="form-control" id="selectdictDictGlobalByFoodId" ng-model="reqitem.dictglobalbyfood"
					ng-options="reqitem.label for reqitem in dataDictGlobalByFoodId track by reqitem.id" tabindex="6">
				</select>
			</div>
			<div class="form-group margin-top-5">
				<label> <spring:message code="label.dictGlobalByPlacementId" />
				</label> <select class="form-control" id="selectdictDictGlobalByPlacementId" ng-model="reqitem.dictglobalbyplacement"
					ng-options="reqitem.label for reqitem in dataDictGlobalByPlacementId track by reqitem.id" tabindex="7">
				</select>
			</div>
			<div class="form-group margin-top-5">
				<label> <spring:message code="label.roomCount" />
				</label> <input type="number" ng-model="reqitem.roomcount" class="form-control" tabindex="11" />
			</div>
			<div class="form-group margin-top-5">
				<label> <spring:message code="label.changePrepayment" />
				</label> <input type="text" ng-model="reqitem.changeprepayment" class="form-control" tabindex="13" />
			</div>
			<div class="form-group margin-top-5">
				<label> <spring:message code="label.cancelPrepayment" />
				</label> <input type="text" ng-model="reqitem.cancelprepayment" class="form-control" tabindex="14" />
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group margin-top-5 time-holder">
				<div class="time-datepicker-label">
					<label> <spring:message code="label.race" />
					</label>
				</div>

				<div class="picker-holder row">
					<div class="col-xs-7">
						<div class="input-group picker-item">
							<input type="text" class="form-control" ng-model="reqitem.race" datepicker-popup="yyyy-MM-dd"
								ng-change="convertDateAndTime(reqitem.race, 'race')" is-open="datePicker.race" close-text="X" tabindex="3" />
							<span class="input-group-btn">
								<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'race')">
									<i class="glyphicon glyphicon-calendar"></i>
								</button>
							</span>
						</div>
					</div>
					<div class="col-xs-4 auto-center">
						<timepicker ng-model="reqitem.race" show-meridian="false" ng-change="convertDateAndTime(reqitem.race, 'race')"></timepicker>
					</div>
				</div>

			</div>
			<div class="form-group margin-top-5 time-holder">
				<div class="time-datepicker-label">
					<label> <spring:message code="label.departure" />
					</label>
				</div>

				<div class="picker-holder row">
					<div class="col-xs-7">
						<div class="input-group picker-item">
							<input type="text" class="form-control" ng-model="reqitem.departure" datepicker-popup="yyyy-MM-dd"
								ng-change="convertDateAndTime(reqitem.departure, 'departure')" is-open="datePicker.departure" close-text="X"
								tabindex="4" />
							<span class="input-group-btn">
								<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'departure')">
									<i class="glyphicon glyphicon-calendar"></i>
								</button>
							</span>
						</div>
					</div>
					<div class="col-xs-4 auto-center">
						<timepicker ng-model="reqitem.departure" show-meridian="false"
							ng-change="convertDateAndTime(reqitem.departure, 'departure')"></timepicker>
					</div>
				</div>

			</div>
		</div>
		<div class="col-md-12">
			<div class="form-group margin-top-5">
				<label> <spring:message code="default.additional-information" />
				</label>
				<div class="custom-textarea-holder">
					<!--ui-tinymce="tinymceOptions"-->
					<textarea type="text" ng-model="reqitem.descr" class="form-control custom-textarea" tabindex="9" />
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="v-holder-300">
		<div class="btn-group">
			<button type="button" class="btn btn-default btn-create" ng-click="addrelReqServHotelTmContactEasies()">
				<i class="fa fa-file-o pull-left"></i> <i class="fa fa-file pull-left"></i>
				<spring:message code="default.add" />
			</button>
		</div>
		<div class="edit-block row" ng-repeat="row in reqitem.relReqServHotelTmContactEasies">
			<div class="col-md-2">
				<div class="form-group margin-top-5 center-holder">
					<input type="checkbox" ng-model="row.manFoman" tabindex="2" /> <label> <spring:message
							code="label.manFoman" />
					</label>
				</div>
				<div class="form-group margin-top-5 center-holder">
					<i class="fa fa-3x fa-male" ng-click="row.manFoman = !row.manFoman" ng-hide="row.manFoman"></i> 
					<i class="fa fa-3x fa-female" ng-click="row.manFoman = !row.manFoman" ng-show="row.manFoman"></i>
				</div>
				<br>
				<div class="form-group margin-top-5 center-holder">
					<button type="button" class="btn btn-default btn-delete" ng-disabled="canDeleterelReqServHotelTmContactEasies()"
						ng-click="removerelReqServHotelTmContactEasies(row)">
						<i class="glyphicon glyphicon-trash pull-left"></i>
						<spring:message code="default.delete" />
					</button>
				</div>
			</div>
			<div class="col-md-8 col-md-offset-1">
				<div class="form-group margin-top-5">
					<label> <spring:message code="default.fullname" />
					</label> <input type="text" ng-model="row.label" class="form-control" tabindex="1" />
				</div>
				<br>
				<div class="form-group margin-top-5">
					<label> <spring:message code="label.locationCountries" />
					</label> <select class="form-control" id="selectdictLocationCountries" ng-model="row.locationcountries"
						ng-options="row.label for row in dataLocationCountries track by row.id" tabindex="3">
					</select>
				</div>
			</div>
		</div>
	</div>
</div>
