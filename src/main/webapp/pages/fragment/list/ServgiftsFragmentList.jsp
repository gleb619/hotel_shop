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
						<th ng-if="::checkVisibility('giftscost')">
							<div ng-click="sort('giftscost')" >
								<a class="sortable-column-name"><span><spring:message code="label.giftsCost" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.giftsCost, 'fa-caret-up': !details.giftsCost }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('giftsname')">
							<div ng-click="sort('giftsname')" >
								<a class="sortable-column-name"><span><spring:message code="label.giftsName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.giftsName, 'fa-caret-up': !details.giftsName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('giftsdescr')">
							<div ng-click="sort('giftsdescr')" >
								<a class="sortable-column-name"><span><spring:message code="label.giftsDescr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.giftsDescr, 'fa-caret-up': !details.giftsDescr }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.servGiftses track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('giftscost')"><label>{{ ::item.giftscost }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal }}</label></td>
						<td ng-if="::checkVisibility('giftsname')"><label>{{ ::item.giftsname }}</label></td>
						<td ng-if="::checkVisibility('giftsdescr')"><label>{{ ::item.giftsdescr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredServGifts.length }}/{{ selectedItem.servGiftses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>