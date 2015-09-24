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
						<th ng-if="::checkVisibility('dicttype')">
							<div ng-click="sort('dicttype')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictType" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictType, 'fa-caret-up': !details.dictType }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictvalue')">
							<div ng-click="sort('dictvalue')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictValue" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictValue, 'fa-caret-up': !details.dictValue }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictvalueadditional')">
							<div ng-click="sort('dictvalueadditional')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictValueAdditional" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictValueAdditional, 'fa-caret-up': !details.dictValueAdditional }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.dictGlobals track by $index">
						<td ng-if="::checkVisibility('dicttype')"><label>{{ ::item.dicttype }}</label></td>
						<td ng-if="::checkVisibility('dictvalue')"><label>{{ ::item.dictvalue }}</label></td>
						<td ng-if="::checkVisibility('dictvalueadditional')"><label>{{ ::item.dictvalueadditional }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredDictGlobal.length }}/{{ selectedItem.dictGlobals.length }}
				</div>
			  </div>
		</div>
	</div>
</div>