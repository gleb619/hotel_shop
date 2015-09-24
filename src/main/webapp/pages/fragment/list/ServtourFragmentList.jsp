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
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('price')">
							<div ng-click="sort('price')" >
								<a class="sortable-column-name"><span><spring:message code="label.price" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.price, 'fa-caret-up': !details.price }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dateend')">
							<div ng-click="sort('dateend')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateEnd" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateEnd, 'fa-caret-up': !details.dateEnd }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('createdon')">
							<div ng-click="sort('createdon')" >
								<a class="sortable-column-name"><span><spring:message code="label.createdon" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.createdon, 'fa-caret-up': !details.createdon }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('datestart')">
							<div ng-click="sort('datestart')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateStart" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateStart, 'fa-caret-up': !details.dateStart }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcities')">
							<div ng-click="sort('locationcities')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCities" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCities, 'fa-caret-up': !details.locationCities }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('groupglobal')">
							<div ng-click="sort('groupglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.groupGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.groupGlobal, 'fa-caret-up': !details.groupGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numberofnights')">
							<div ng-click="sort('numberofnights')" >
								<a class="sortable-column-name"><span><spring:message code="label.numberOfNights" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numberOfNights, 'fa-caret-up': !details.numberOfNights }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tourname')">
							<div ng-click="sort('tourname')" >
								<a class="sortable-column-name"><span><spring:message code="label.tourName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tourName, 'fa-caret-up': !details.tourName }"></i>
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
						<tr ng-repeat="item in selectedItem.servTours track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('dateend')"><label>{{ ::item.dateend }}</label></td>
						<td ng-if="::checkVisibility('createdon')"><label>{{ ::item.createdon }}</label></td>
						<td ng-if="::checkVisibility('datestart')"><label>{{ ::item.datestart }}</label></td>
						<td ng-if="::checkVisibility('locationcities')"><label>{{ ::item.locationcities }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('groupglobal')"><label>{{ ::item.groupglobal }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('numberofnights')"><label>{{ ::item.numberofnights }}</label></td>
						<td ng-if="::checkVisibility('tourname')"><label>{{ ::item.tourname }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredServTour.length }}/{{ selectedItem.servTours.length }}
				</div>
			  </div>
		</div>
	</div>
</div>