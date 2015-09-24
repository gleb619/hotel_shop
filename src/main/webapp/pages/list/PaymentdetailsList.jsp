<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="my-container-3 sectors-holder">
	<div class="row sector-header">
		<div class="without-padding margin-bottom-5">
			<div class="btn-group">
				<button type="button" class="btn btn-default btn-create" ng-click="createModalNewItem()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit" ng-click="editModalItem()">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete" ng-click="deleteItem()">
					<i class="glyphicon glyphicon-trash pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.delete" /></span>
				</button>
				<button type="button" class="btn btn-default btn-reload" ng-click="reloadData()">
					<i class="glyphicon glyphicon-repeat pull-left"></i>
					<span>&nbsp;&nbsp;<spring:message code="default.reload" /></span>
				</button>
			</div>
		<c:if test="${debug}">
			<div class="btn-group">
				<a href="../data/paymentdetails?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/paymentdetailsview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordPaymentDetails" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredPaymentDetails', 'dataPaymentDetails', searchKeywordPaymentDetails)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataPaymentDetails()">
			<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
				<thead>
					<tr>
					<c:if test="${debug}">
						<th>
							<div ng-click="sort('id')">
								<a class="sortable-column-name"><span>id</span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.id, 'fa-caret-up': !details.id }"></i>
							</div>
						</th>
					</c:if>
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bin')">
							<div ng-click="sort('bin')" >
								<a class="sortable-column-name"><span><spring:message code="label.bin" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bin, 'fa-caret-up': !details.bin }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone2')">
							<div ng-click="sort('phone2')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone2" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone2, 'fa-caret-up': !details.phone2 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('fullname')">
							<div ng-click="sort('fullname')" >
								<a class="sortable-column-name"><span><spring:message code="label.fullName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.fullName, 'fa-caret-up': !details.fullName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nceo')">
							<div ng-click="sort('nceo')" >
								<a class="sortable-column-name"><span><spring:message code="label.nceo" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nceo, 'fa-caret-up': !details.nceo }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('banklocation')">
							<div ng-click="sort('banklocation')" >
								<a class="sortable-column-name"><span><spring:message code="label.bankLocation" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bankLocation, 'fa-caret-up': !details.bankLocation }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('legaladdress')">
							<div ng-click="sort('legaladdress')" >
								<a class="sortable-column-name"><span><spring:message code="label.legalAddress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.legalAddress, 'fa-caret-up': !details.legalAddress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('iin')">
							<div ng-click="sort('iin')" >
								<a class="sortable-column-name"><span><spring:message code="label.iin" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.iin, 'fa-caret-up': !details.iin }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('postaladdress')">
							<div ng-click="sort('postaladdress')" >
								<a class="sortable-column-name"><span><spring:message code="label.postalAddress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.postalAddress, 'fa-caret-up': !details.postalAddress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameofthebank')">
							<div ng-click="sort('nameofthebank')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameOfTheBank" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameOfTheBank, 'fa-caret-up': !details.nameOfTheBank }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone')">
							<div ng-click="sort('phone')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone, 'fa-caret-up': !details.phone }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('correspondentaccount')">
							<div ng-click="sort('correspondentaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.correspondentAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.correspondentAccount, 'fa-caret-up': !details.correspondentAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currentaccount')">
							<div ng-click="sort('currentaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.currentAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currentAccount, 'fa-caret-up': !details.currentAccount }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredPaymentDetails = ( dataPaymentDetails | filter:searchKeywordPaymentDetails | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredPaymentDetails track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('bin')"><label>{{ ::item.bin }}</label></td>
						<td ng-if="::checkVisibility('phone2')"><label>{{ ::item.phone2 }}</label></td>
						<td ng-if="::checkVisibility('fullname')"><label>{{ ::item.fullname }}</label></td>
						<td ng-if="::checkVisibility('nceo')"><label>{{ ::item.nceo }}</label></td>
						<td ng-if="::checkVisibility('banklocation')"><label>{{ ::item.banklocation }}</label></td>
						<td ng-if="::checkVisibility('legaladdress')"><label>{{ ::item.legaladdress }}</label></td>
						<td ng-if="::checkVisibility('iin')"><label>{{ ::item.iin }}</label></td>
						<td ng-if="::checkVisibility('postaladdress')"><label>{{ ::item.postaladdress }}</label></td>
						<td ng-if="::checkVisibility('nameofthebank')"><label>{{ ::item.nameofthebank }}</label></td>
						<td ng-if="::checkVisibility('phone')"><label>{{ ::item.phone }}</label></td>
						<td ng-if="::checkVisibility('correspondentaccount')"><label>{{ ::item.correspondentaccount }}</label></td>
						<td ng-if="::checkVisibility('currentaccount')"><label>{{ ::item.currentaccount }}</label></td>
						<td>
							<button type="button" ng-click="editModalItem(item.id)" class="btn button-transparent">
								<i class="glyphicon glyphicon-pencil"></i> 
							</button>
						</td>
						<td>
							<button type="button" ng-click="deleteItem(item.id, $index)" class="btn button-transparent">
								<i class="glyphicon glyphicon glyphicon-trash"></i>
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		  </div>
		</div>
		<div class="col-md-12 margin-bottom-10">
			<div class="btn-toolbar">
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-default" ng-click="searchKeywordPaymentDetails = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredPaymentDetails.length }} / {{ dataPaymentDetails.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordPaymentDetails = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataPaymentDetails()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataPaymentDetails()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataPaymentDetails()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset >
			
					<tab select="initTab('servhotel', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServHotel"/></tab-heading>
						
						<div ng-if="templates.servhotel.fragmentlist.init" ng-include="templates.servhotel.fragmentlist.url"></div>
					</tab>
					
					
			</tabset>
		</div>
	</div>
	</div>
