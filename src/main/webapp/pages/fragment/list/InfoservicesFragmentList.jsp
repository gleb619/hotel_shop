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
						<th ng-if="::checkVisibility('servtour')">
							<div ng-click="sort('servtour')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTour" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTour, 'fa-caret-up': !details.servTour }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servinsurances')">
							<div ng-click="sort('servinsurances')" >
								<a class="sortable-column-name"><span><spring:message code="label.servInsurances" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servInsurances, 'fa-caret-up': !details.servInsurances }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servticketsrail')">
							<div ng-click="sort('servticketsrail')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTicketsRail" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTicketsRail, 'fa-caret-up': !details.servTicketsRail }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servexcursions')">
							<div ng-click="sort('servexcursions')" >
								<a class="sortable-column-name"><span><spring:message code="label.servExcursions" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servExcursions, 'fa-caret-up': !details.servExcursions }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servvisas')">
							<div ng-click="sort('servvisas')" >
								<a class="sortable-column-name"><span><spring:message code="label.servVisas" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servVisas, 'fa-caret-up': !details.servVisas }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servtransfer')">
							<div ng-click="sort('servtransfer')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTransfer" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTransfer, 'fa-caret-up': !details.servTransfer }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servgifts')">
							<div ng-click="sort('servgifts')" >
								<a class="sortable-column-name"><span><spring:message code="label.servGifts" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servGifts, 'fa-caret-up': !details.servGifts }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servticketsair')">
							<div ng-click="sort('servticketsair')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTicketsAir" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTicketsAir, 'fa-caret-up': !details.servTicketsAir }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servcruise')">
							<div ng-click="sort('servcruise')" >
								<a class="sortable-column-name"><span><spring:message code="label.servCruise" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servCruise, 'fa-caret-up': !details.servCruise }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.infoServiceses track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('servtour')"><label>{{ ::item.servtour }}</label></td>
						<td ng-if="::checkVisibility('servinsurances')"><label>{{ ::item.servinsurances }}</label></td>
						<td ng-if="::checkVisibility('servticketsrail')"><label>{{ ::item.servticketsrail }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						<td ng-if="::checkVisibility('servexcursions')"><label>{{ ::item.servexcursions }}</label></td>
						<td ng-if="::checkVisibility('servvisas')"><label>{{ ::item.servvisas }}</label></td>
						<td ng-if="::checkVisibility('servtransfer')"><label>{{ ::item.servtransfer }}</label></td>
						<td ng-if="::checkVisibility('servgifts')"><label>{{ ::item.servgifts }}</label></td>
						<td ng-if="::checkVisibility('servticketsair')"><label>{{ ::item.servticketsair }}</label></td>
						<td ng-if="::checkVisibility('servcruise')"><label>{{ ::item.servcruise }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredInfoServices.length }}/{{ selectedItem.infoServiceses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>