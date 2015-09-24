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
						<th ng-if="::checkVisibility('grouptype')">
							<div ng-click="sort('grouptype')" >
								<a class="sortable-column-name"><span><spring:message code="label.groupType" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.groupType, 'fa-caret-up': !details.groupType }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('groupvalue')">
							<div ng-click="sort('groupvalue')" >
								<a class="sortable-column-name"><span><spring:message code="label.groupValue" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.groupValue, 'fa-caret-up': !details.groupValue }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.groupGlobals track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('grouptype')"><label>{{ ::item.grouptype }}</label></td>
						<td ng-if="::checkVisibility('groupvalue')"><label>{{ ::item.groupvalue }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredGroupGlobal.length }}/{{ selectedItem.groupGlobals.length }}
				</div>
			  </div>
		</div>
	</div>
</div>