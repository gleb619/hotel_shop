<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="padding-top-10">
	<div class="row">
			<div class="col-md-12">
			  <div class="table-responsive">
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr>
						<th ng-if="::checkVisibility('contactname')">
							<div ng-click="sort('contactname')" >
								<a class="sortable-column-name"><span><spring:message code="label.contactName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contactName, 'fa-caret-up': !details.contactName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('contactpatronymic')">
							<div ng-click="sort('contactpatronymic')" >
								<a class="sortable-column-name"><span><spring:message code="label.contactPatronymic" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contactPatronymic, 'fa-caret-up': !details.contactPatronymic }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('contactsurname')">
							<div ng-click="sort('contactsurname')" >
								<a class="sortable-column-name"><span><spring:message code="label.contactSurname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contactSurname, 'fa-caret-up': !details.contactSurname }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('birthday')">
							<div ng-click="sort('birthday')" >
								<a class="sortable-column-name"><span><spring:message code="label.birthday" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.birthday, 'fa-caret-up': !details.birthday }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passportenddate')">
							<div ng-click="sort('passportenddate')" >
								<a class="sortable-column-name"><span><spring:message code="label.passportEndDate" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passportEndDate, 'fa-caret-up': !details.passportEndDate }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passportstartdate')">
							<div ng-click="sort('passportstartdate')" >
								<a class="sortable-column-name"><span><spring:message code="label.passportStartDate" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passportStartDate, 'fa-caret-up': !details.passportStartDate }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passportnumber')">
							<div ng-click="sort('passportnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.passportNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passportNumber, 'fa-caret-up': !details.passportNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.tmContacts track by $index">
						<td ng-if="::checkVisibility('contactname')"><label>{{ ::item.contactname }}</label></td>
						<td ng-if="::checkVisibility('contactpatronymic')"><label>{{ ::item.contactpatronymic }}</label></td>
						<td ng-if="::checkVisibility('contactsurname')"><label>{{ ::item.contactsurname }}</label></td>
						<td ng-if="::checkVisibility('birthday')"><label>{{ ::item.birthday }}</label></td>
						<td ng-if="::checkVisibility('passportenddate')"><label>{{ ::item.passportenddate }}</label></td>
						<td ng-if="::checkVisibility('passportstartdate')"><label>{{ ::item.passportstartdate }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('passportnumber')"><label>{{ ::item.passportnumber }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredTmContact.length }}/{{ selectedItem.tmContacts.length }}
				</div>
			  </div>
		</div>
	</div>
</div>