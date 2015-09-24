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
				<spring:message code="default.listof" /> <spring:message code="label.ReqServHotel" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/reqservhotelview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordReqServHotel" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataReqServHotel()">
					<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
						<thead>
							<tr>
								<th class="picker-th"></th>
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
							<tr ng-repeat="item in filteredReqServHotel = ( dataReqServHotel | filter:searchKeywordReqServHotel ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('accept')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.accept, 'fa fa-lg fa-circle-o': !item.accept}"></i></td>
						<td ng-if="::checkVisibility('decline')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.decline, 'fa fa-lg fa-circle-o': !item.decline}"></i></td>
						<td ng-if="::checkVisibility('race')"><label>{{ ::item.race }}</label></td>
						<td ng-if="::checkVisibility('departure')"><label>{{ ::item.departure }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbypaymenttype')"><label>{{ ::item.dictglobalbypaymenttype }}</label></td>
						<td ng-if="::checkVisibility('usersbyrequestuser')"><label>{{ ::item.usersbyrequestuser }}</label></td>
						<td ng-if="::checkVisibility('usersbyresponseuser')"><label>{{ ::item.usersbyresponseuser }}</label></td>
						<td ng-if="::checkVisibility('docdocumentsbydocumentforhotel')"><label>{{ ::item.docdocumentsbydocumentforhotel }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyplacement')"><label>{{ ::item.dictglobalbyplacement }}</label></td>
						<td ng-if="::checkVisibility('servhotelroom')"><label>{{ ::item.servhotelroom }}</label></td>
						<td ng-if="::checkVisibility('docdocumentsbydocumentforuser')"><label>{{ ::item.docdocumentsbydocumentforuser }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						<td ng-if="::checkVisibility('roomcount')"><label>{{ ::item.roomcount }}</label></td>
						<td ng-if="::checkVisibility('progress')"><label>{{ ::item.progress }}</label></td>
						<td ng-if="::checkVisibility('descrinternal')"><label>{{ ::item.descrinternal }}</label></td>
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
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredReqServHotel.length }} / {{ dataReqServHotel.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataReqServHotel()">
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
