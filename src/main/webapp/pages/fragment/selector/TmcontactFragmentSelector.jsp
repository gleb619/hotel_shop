<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-if="!loading">
		<div class="modal-header">
			<button type="button" class="close round-button" ng-click="cancel()">&times;</button>
			<h4 class="modal-title">
				<spring:message code="default.listof" /> <spring:message code="label.TmContact" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/tmcontactview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordTmContact" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataTmContact()">
					<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
						<thead>
							<tr>
								<th class="picker-th"></th>
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
							<tr ng-repeat="item in filteredTmContact = ( dataTmContact | filter:searchKeywordTmContact ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
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
				  </div>
			</div>
			<div class="col-md-12 margin-bottom-10">
				<div class="btn-toolbar">
	  				<div class="btn-group">
						<button type="button" class="btn btn-default">
							<i class="fa fa-list-alt fa-lg"></i>
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredTmContact.length }} / {{ dataTmContact.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataTmContact()">
							<i class="fa fa-database fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
							<span><spring:message code="default.loadMore" /></span>
						</button>
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
				<a ng-click="submitFunc()"
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
