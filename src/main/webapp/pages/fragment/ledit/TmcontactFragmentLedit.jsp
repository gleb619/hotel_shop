<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div>
	<div class="row">
		<div class="padding-left-right-15">
			<div class="btn-group without-padding display-block toolbar-panel margin-bottom-5">
				<button type="button" class="btn btn-default btn-create"
					ng-click="createModalItemTmContact()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemTmContact(selectedItemtmContacts.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('tmContacts', 'TmContact', selectedItemtmContacts.id, itemIndex)">
					<i class="glyphicon glyphicon-trash pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.delete" /></span>
				</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive margin-bottom-5 table-body ledit-scroll">
				<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
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

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.tmContacts track by $index"
							ng-class="{ 'success' : selectedItemtmContacts.id == item.id }"
							ng-dblclick="editModalItemTmContact(item.id)"
							ng-click="setSelected('selectedItemtmContacts', item, $index)">
						<td ng-if="::checkVisibility('contactname')"><label>{{ ::item.contactname }}</label></td>
						<td ng-if="::checkVisibility('contactpatronymic')"><label>{{ ::item.contactpatronymic }}</label></td>
						<td ng-if="::checkVisibility('contactsurname')"><label>{{ ::item.contactsurname }}</label></td>
						<td ng-if="::checkVisibility('birthday')"><label>{{ ::item.birthday }}</label></td>
						<td ng-if="::checkVisibility('passportenddate')"><label>{{ ::item.passportenddate }}</label></td>
						<td ng-if="::checkVisibility('passportstartdate')"><label>{{ ::item.passportstartdate }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries.label }}</label></td>
						<td ng-if="::checkVisibility('passportnumber')"><label>{{ ::item.passportnumber }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
							<td>
								<a ng-click="editModalItemTmContact(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('tmContacts', 'TmContact', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.tmContacts.length }}
				</div>
			</div>
		</div>
	</div>
</div>