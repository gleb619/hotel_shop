<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!-- col-md-offset-2 col-md-8 -->
<div class="form-holder">
	<form id="formRequest" name="formRequest" class="form-horizontal" novalidate ng-submit="validateItem(formRequest)" ng-class="details.showHints">
		<fieldset>
			<legend>{{ reqitem.label }}</legend>
			<%-- 
			<div class="form-group">
				<label><spring:message code="label.breakfast" /></label>
				<input type="checkbox" ng-model="requestinformation.breakfast" disabled/>
			</div>
			 --%>
			<div class="form-group">
				<div class="radio">
					<label> <input type="radio" ng-model="reqitem.cashless" ng-change="paymetTypeChange()" value="true" checked>
						Безналичный расчет
					</label>
				</div>
				<div class="radio">
					<label> <input type="radio" ng-model="reqitem.cashless" ng-change="paymetTypeChange()" value="false">
						Наличный расчет
					</label>
				</div>
			</div>
			<%-- 
			<div class="form-group">
				<label><spring:message code="label.dictGlobalByFoodId" /></label>
				<label>{{ requestinformation.dictglobalbyfood.label }}</label>
			</div>
			<div class="form-group">
				<label> <spring:message code="label.dictGlobalByPaymentTypeId" />
				</label> <select class="form-control" id="selectdictDictGlobalByPaymentTypeId" ng-model="reqitem.dictglobalbypaymenttype"
					ng-options="reqitem.label for reqitem in dataDictGlobalByPaymentTypeId track by reqitem.id" tabindex="4">
				</select>
			</div>
			<div class="form-group">
				<label> <spring:message code="label.dictGlobalByPlacementId" />
				</label> <select class="form-control" id="selectdictDictGlobalByPlacementId" ng-model="reqitem.dictglobalbyplacement"
					ng-options="reqitem.label for reqitem in dataDictGlobalByPlacementId track by reqitem.id" tabindex="7">
				</select>
			</div>
			--%>
			<div class="form-group">
				<label> <spring:message code="label.roomCount" />
				</label> <input type="number" ng-model="reqitem.roomcount" class="form-control" tabindex="11" ng-change="calculateTotalprice()" required ng-pattern="/^\d+\.\d+|\d+$/" />
			</div>
			<%-- 
			<div class="form-group">
				<label> <spring:message code="label.maxcapacity" /> </label> 
				<select class="form-control" ng-model="reqitem.maxcapacity" ng-options="capacity as capacity for capacity in details.capacities"></select>
			</div>
			--%>
			<div class="form-group time-holder">
				<div class="time-datepicker-label">
					<label> <spring:message code="label.race" /> </label>
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
			
			<div class="form-group">

				<div class="custom-toolbar">
					<div>
						<div class="btn-group">
							<button type="button" class="btn btn-default" ng-click="changeDeparture(1, 'day')">1 день</button>
							<button type="button" class="btn btn-default" ng-click="changeDeparture(3, 'day')">3 дня</button>
							<button type="button" class="btn btn-default" ng-click="changeDeparture(1, 'week')">1 неделя</button>
						</div>
					</div>

					<div>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Количество дней" ng-model="$storage.numberOfDate">
							<span class="input-group-btn">
								<button type="button" class="btn btn-default" ng-click="changeDeparture($storage.numberOfDate, 'day')">
									<i class="fa fa-check"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group time-holder">
				<div class="time-datepicker-label">
					<label> <spring:message code="label.departure" /> </label>
				</div>

				<div class="picker-holder row">
					<div class="col-xs-7">
						<div class="input-group picker-item">
							<input type="text" class="form-control" ng-model="reqitem.departure" datepicker-popup="yyyy-MM-dd"
								ng-change="convertDateAndTime(reqitem.departure, 'departure')" is-open="datePicker.departure" close-text="X"
								min-date="details.minDate" tabindex="4" />
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
			<c:if test="${debug}">
			<div class="form-group inline-holder">
				<div class="panel panel-default">
					<div class="panel-heading">Формула расчета(панель видна только в тестовом режиме)</div>
					<div class="panel-body">
						<h3>
							<small>(</small> 
							{{ reqitem.singleprice }} 
							<small> {{ reqitem.tariffcurrency }} </small>
							<small>&nbsp;*&nbsp;&nbsp;</small>
						</h3>
						<h3>{{ reqitem.datedifference }} 
							<small ng-switch="reqitem.datedifferencetype">
								<span ng-switch-when="1"><spring:message code="default.day-s-1" /></span>
								<span ng-switch-when="2"><spring:message code="default.day-s-2" /></span>
								<span ng-switch-default><spring:message code="default.day-s" /></span>
							</small>
							<small>)</small>
						</h3>
						<h3>
							<small>&nbsp;&nbsp;*</small>
							{{ reqitem.roomcount }}
							<small><spring:message code="label.roomCount" /></small>
						</h3>
						<h3>
							<small>&nbsp;&nbsp;=&nbsp;</small>
							{{ reqitem.totalprice }}
							<small> {{ reqitem.tariffcurrency }} </small>
						</h3>
					</div>
				</div>
			</div>
			</c:if>
			<div class="form-group inline-holder">
				<h3>
				 	<small><spring:message code="default.total-cost" /></small>
					{{ reqitem.totalprice }}
					<small> {{ reqitem.tariffcurrency }} </small>
				</h3>
				<h3>
					<small>&nbsp;&nbsp;<spring:message code="default.for" />&nbsp;</small>
					{{ reqitem.datedifference }} 
					<small ng-switch="reqitem.datedifferencetype">
						<span ng-switch-when="1"><spring:message code="default.day-s-1" /></span>
						<span ng-switch-when="2"><spring:message code="default.day-s-2" /></span>
						<span ng-switch-default><spring:message code="default.day-s" /></span>
					</small>
				</h3>
			</div>
			<div class="form-group">
				<label> <spring:message code="default.additional-information" />
				</label>
				<div class="custom-textarea-holder">
					<!--ui-tinymce="tinymceOptions"-->
					<textarea type="text" ng-model="reqitem.descr" class="form-control custom-textarea" tabindex="9" />
				</div>
			</div>
			<hr>
			<div class="table-responsive table-stretched">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th style="min-width: 100px;"><spring:message code="label.manFoman" /></th>
						<th><spring:message code="default.fullname" /></th>
						<th style="min-width: 150px;"><spring:message code="label.locationCountries" /></th>
						<th><spring:message code="default.email2" /></th>
						<th>...</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="row in requestinformation.tmContactEasies track by $index">
						<td>
							<%-- 
							<div class="col-xs-4">
							<input type="checkbox" ng-model="row.manFoman" placeholder="<spring:message code="label.manFoman" />" />
							</div>
							<div class="col-xs-6">
							<div class="pull-right">
								<i class="fa fa-3x fa-male" ng-click="row.manFoman = !row.manFoman" ng-hide="row.manFoman"></i> 
								<i class="fa fa-3x fa-female" ng-click="row.manFoman = !row.manFoman" ng-show="row.manFoman"></i>
							</div>
							</div>
							 --%>
							<div>
								<div class="radio">
									<label> 
										<input type="radio" ng-model="row.manFoman" ng-value="true" checked> 
										<span><spring:message code="default.man" /></span>
									</label>
								</div>
								<div class="radio">
									<label> 
										<input type="radio" ng-model="row.manFoman" ng-value="false">
										<span><spring:message code="default.woman" /></span>
									</label>
								</div>
							</div>
						</td>
						<td>
							<input type="text" ng-model="row.label" class="form-control" required />
						</td>
						<td>
							<select class="form-control" id="selectdictLocationCountries" ng-model="row.locationcountries" required
								ng-options="country.label for country in dataLocationCountries track by country.id" tabindex="3">
							</select>
						</td>
						<td>
							<input type="email" ng-model="row.email" class="form-control" />
						</td>
						<td>
							<button type="button" ng-click="deleteElement(row, requestinformation.tmContactEasies)" class="btn button-transparent">
								<i class="glyphicon glyphicon glyphicon-trash"></i>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
			</div>
			<div class="btn-group">
				<br>
				<button type="button" class="btn btn-default" ng-click="addLead()">
					<spring:message code="default.add" />
				</button>
			</div>
			<hr>
			
			<c:if test="${param.submitType}">
			<div class="form-group">
				<button type="submit" class="btn btn-info col-xs-12 col-xs-offset-0 col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3" ng-click="beforeAcceptWithValidate(formRequest)">
					<spring:message code="default.send-request" />
				</button>
			</div>
			</c:if>
			<c:if test="${!param.submitType}">
			<div class="form-group">
				<button type="submit" class="btn btn-success col-xs-12 col-xs-offset-0 col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3" ng-click="finalAcceptWithValidate(formRequest)">
					<spring:message code="default.send-request" />
				</button>
			</div>
			</c:if>
		</fieldset>
	</form>
</div>