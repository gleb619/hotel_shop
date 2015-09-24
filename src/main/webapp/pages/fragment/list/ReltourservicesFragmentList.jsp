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
						<th ng-if="::checkVisibility('servtour')">
							<div ng-click="sort('servtour')" >
								<a class="sortable-column-name"><span><spring:message code="label.servTour" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servTour, 'fa-caret-up': !details.servTour }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('infoservices')">
							<div ng-click="sort('infoservices')" >
								<a class="sortable-column-name"><span><spring:message code="label.infoServices" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.infoServices, 'fa-caret-up': !details.infoServices }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.relTourServiceses track by $index">
						<td ng-if="::checkVisibility('servtour')"><label>{{ ::item.servtour }}</label></td>
						<td ng-if="::checkVisibility('infoservices')"><label>{{ ::item.infoservices }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredRelTourServices.length }}/{{ selectedItem.relTourServiceses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>