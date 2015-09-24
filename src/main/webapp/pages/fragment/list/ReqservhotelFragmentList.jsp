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
						<th ng-if="::checkVisibility('accept')">
							<div ng-click="sort('accept')" >
								<a class="sortable-column-name"><span><spring:message code="label.accept" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.accept, 'fa-caret-up': !details.accept }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('decline')">
							<div ng-click="sort('decline')" >
								<a class="sortable-column-name"><span><spring:message code="label.decline" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.decline, 'fa-caret-up': !details.decline }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('race')">
							<div ng-click="sort('race')" >
								<a class="sortable-column-name"><span><spring:message code="label.race" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.race, 'fa-caret-up': !details.race }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('departure')">
							<div ng-click="sort('departure')" >
								<a class="sortable-column-name"><span><spring:message code="label.departure" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.departure, 'fa-caret-up': !details.departure }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbypaymenttypeid')">
							<div ng-click="sort('dictglobalbypaymenttypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPaymentTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPaymentTypeId, 'fa-caret-up': !details.dictGlobalByPaymentTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('usersbyrequestuserid')">
							<div ng-click="sort('usersbyrequestuserid')" >
								<a class="sortable-column-name"><span><spring:message code="label.usersByRequestUserId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.usersByRequestUserId, 'fa-caret-up': !details.usersByRequestUserId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('usersbyresponseuserid')">
							<div ng-click="sort('usersbyresponseuserid')" >
								<a class="sortable-column-name"><span><spring:message code="label.usersByResponseUserId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.usersByResponseUserId, 'fa-caret-up': !details.usersByResponseUserId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('docdocumentsbydocumentforhotelid')">
							<div ng-click="sort('docdocumentsbydocumentforhotelid')" >
								<a class="sortable-column-name"><span><spring:message code="label.docDocumentsByDocumentForHotelId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.docDocumentsByDocumentForHotelId, 'fa-caret-up': !details.docDocumentsByDocumentForHotelId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyplacementid')">
							<div ng-click="sort('dictglobalbyplacementid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPlacementId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPlacementId, 'fa-caret-up': !details.dictGlobalByPlacementId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotelroom')">
							<div ng-click="sort('servhotelroom')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotelRoom" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotelRoom, 'fa-caret-up': !details.servHotelRoom }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('docdocumentsbydocumentforuserid')">
							<div ng-click="sort('docdocumentsbydocumentforuserid')" >
								<a class="sortable-column-name"><span><spring:message code="label.docDocumentsByDocumentForUserId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.docDocumentsByDocumentForUserId, 'fa-caret-up': !details.docDocumentsByDocumentForUserId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roomcount')">
							<div ng-click="sort('roomcount')" >
								<a class="sortable-column-name"><span><spring:message code="label.roomCount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roomCount, 'fa-caret-up': !details.roomCount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('progress')">
							<div ng-click="sort('progress')" >
								<a class="sortable-column-name"><span><spring:message code="label.progress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.progress, 'fa-caret-up': !details.progress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descrinternal')">
							<div ng-click="sort('descrinternal')" >
								<a class="sortable-column-name"><span><spring:message code="label.descrInternal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descrInternal, 'fa-caret-up': !details.descrInternal }"></i>
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
						<tr ng-repeat="item in selectedItem.reqServHotels track by $index">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('accept')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.accept, 'fa fa-lg fa-circle-o': !item.accept}"></i></td>
						<td ng-if="::checkVisibility('decline')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.decline, 'fa fa-lg fa-circle-o': !item.decline}"></i></td>
						<td ng-if="::checkVisibility('race')"><label>{{ ::item.race }}</label></td>
						<td ng-if="::checkVisibility('departure')"><label>{{ ::item.departure }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbypaymenttypeid')"><label>{{ ::item.dictglobalbypaymenttype }}</label></td>
						<td ng-if="::checkVisibility('usersbyrequestuserid')"><label>{{ ::item.usersbyrequestuser }}</label></td>
						<td ng-if="::checkVisibility('usersbyresponseuserid')"><label>{{ ::item.usersbyresponseuser }}</label></td>
						<td ng-if="::checkVisibility('docdocumentsbydocumentforhotelid')"><label>{{ ::item.docdocumentsbydocumentforhotel }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyplacementid')"><label>{{ ::item.dictglobalbyplacement }}</label></td>
						<td ng-if="::checkVisibility('servhotelroom')"><label>{{ ::item.servhotelroom }}</label></td>
						<td ng-if="::checkVisibility('docdocumentsbydocumentforuserid')"><label>{{ ::item.docdocumentsbydocumentforuser }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('roomcount')"><label>{{ ::item.roomcount }}</label></td>
						<td ng-if="::checkVisibility('progress')"><label>{{ ::item.progress }}</label></td>
						<td ng-if="::checkVisibility('descrinternal')"><label>{{ ::item.descrinternal }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredReqServHotel.length }}/{{ selectedItem.reqServHotels.length }}
				</div>
			  </div>
		</div>
	</div>
</div>