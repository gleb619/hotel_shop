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
						<th ng-if="::checkVisibility('gmappointx')">
							<div ng-click="sort('gmappointx')" >
								<a class="sortable-column-name"><span><spring:message code="label.gmapPointX" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.gmapPointX, 'fa-caret-up': !details.gmapPointX }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('gmappointy')">
							<div ng-click="sort('gmappointy')" >
								<a class="sortable-column-name"><span><spring:message code="label.gmapPointY" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.gmapPointY, 'fa-caret-up': !details.gmapPointY }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('metro')">
							<div ng-click="sort('metro')" >
								<a class="sortable-column-name"><span><spring:message code="label.metro" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.metro, 'fa-caret-up': !details.metro }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('yandexmappointx')">
							<div ng-click="sort('yandexmappointx')" >
								<a class="sortable-column-name"><span><spring:message code="label.yandexMapPointX" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.yandexMapPointX, 'fa-caret-up': !details.yandexMapPointX }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roadmap')">
							<div ng-click="sort('roadmap')" >
								<a class="sortable-column-name"><span><spring:message code="label.roadMap" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roadMap, 'fa-caret-up': !details.roadMap }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('yandexmappointy')">
							<div ng-click="sort('yandexmappointy')" >
								<a class="sortable-column-name"><span><spring:message code="label.yandexMapPointY" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.yandexMapPointY, 'fa-caret-up': !details.yandexMapPointY }"></i>
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
						<tr ng-repeat="item in selectedItem.locationAddresses track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('gmappointx')"><label>{{ ::item.gmappointx }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('gmappointy')"><label>{{ ::item.gmappointy }}</label></td>
						<td ng-if="::checkVisibility('metro')"><label>{{ ::item.metro }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('yandexmappointx')"><label>{{ ::item.yandexmappointx }}</label></td>
						<td ng-if="::checkVisibility('roadmap')"><label>{{ ::item.roadmap }}</label></td>
						<td ng-if="::checkVisibility('yandexmappointy')"><label>{{ ::item.yandexmappointy }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredLocationAddress.length }}/{{ selectedItem.locationAddresses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>