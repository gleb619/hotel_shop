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
				<a href="../data/tmaccount?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/tmaccountview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordTmAccount" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredTmAccount', 'dataTmAccount', searchKeywordTmAccount)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataTmAccount()">
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
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('accountname')">
							<div ng-click="sort('accountname')" >
								<a class="sortable-column-name"><span><spring:message code="label.accountName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.accountName, 'fa-caret-up': !details.accountName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('accountfullname')">
							<div ng-click="sort('accountfullname')" >
								<a class="sortable-column-name"><span><spring:message code="label.accountFullname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.accountFullname, 'fa-caret-up': !details.accountFullname }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredTmAccount = ( dataTmAccount | filter:searchKeywordTmAccount | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredTmAccount track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('accountname')"><label>{{ ::item.accountname }}</label></td>
						<td ng-if="::checkVisibility('accountfullname')"><label>{{ ::item.accountfullname }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordTmAccount = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredTmAccount.length }} / {{ dataTmAccount.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordTmAccount = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataTmAccount()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataTmAccount()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataTmAccount()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset type="pills">
			
					<tab select="initTab('servticketsrail', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServTicketsRail"/></tab-heading>
						
						<div ng-if="templates.servticketsrail.fragmentlist.init" ng-include="templates.servticketsrail.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servticketsair', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServTicketsAir"/></tab-heading>
						
						<div ng-if="templates.servticketsair.fragmentlist.init" ng-include="templates.servticketsair.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmaccountdetails', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmAccountDetails"/></tab-heading>
						
						<div ng-if="templates.tmaccountdetails.fragmentlist.init" ng-include="templates.tmaccountdetails.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servtransfer', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServTransfer"/></tab-heading>
						
						<div ng-if="templates.servtransfer.fragmentlist.init" ng-include="templates.servtransfer.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servexcursions', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServExcursions"/></tab-heading>
						
						<div ng-if="templates.servexcursions.fragmentlist.init" ng-include="templates.servexcursions.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servhotel', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServHotel"/></tab-heading>
						
						<div ng-if="templates.servhotel.fragmentlist.init" ng-include="templates.servhotel.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servvisas', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServVisas"/></tab-heading>
						
						<div ng-if="templates.servvisas.fragmentlist.init" ng-include="templates.servvisas.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmorder', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmOrder"/></tab-heading>
						
						<div ng-if="templates.tmorder.fragmentlist.init" ng-include="templates.tmorder.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servticketsair', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServTicketsAir"/></tab-heading>
						
						<div ng-if="templates.servticketsair.fragmentlist.init" ng-include="templates.servticketsair.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servcruise', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServCruise"/></tab-heading>
						
						<div ng-if="templates.servcruise.fragmentlist.init" ng-include="templates.servcruise.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servtour', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServTour"/></tab-heading>
						
						<div ng-if="templates.servtour.fragmentlist.init" ng-include="templates.servtour.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('paymentaccount', 'fragmentlist')">
						<tab-heading><spring:message code="label.PaymentAccount"/></tab-heading>
						
						<div ng-if="templates.paymentaccount.fragmentlist.init" ng-include="templates.paymentaccount.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servticketsair', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServTicketsAir"/></tab-heading>
						
						<div ng-if="templates.servticketsair.fragmentlist.init" ng-include="templates.servticketsair.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relaccountcontacts', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelAccountContacts"/></tab-heading>
						
						<div ng-if="templates.relaccountcontacts.fragmentlist.init" ng-include="templates.relaccountcontacts.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmincidents', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmIncidents"/></tab-heading>
						
						<div ng-if="templates.tmincidents.fragmentlist.init" ng-include="templates.tmincidents.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmaccountcommunications', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmAccountCommunications"/></tab-heading>
						
						<div ng-if="templates.tmaccountcommunications.fragmentlist.init" ng-include="templates.tmaccountcommunications.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmaccountaddresses', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmAccountAddresses"/></tab-heading>
						
						<div ng-if="templates.tmaccountaddresses.fragmentlist.init" ng-include="templates.tmaccountaddresses.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servinsurances', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServInsurances"/></tab-heading>
						
						<div ng-if="templates.servinsurances.fragmentlist.init" ng-include="templates.servinsurances.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servinsurances', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServInsurances"/></tab-heading>
						
						<div ng-if="templates.servinsurances.fragmentlist.init" ng-include="templates.servinsurances.fragmentlist.url"></div>
					</tab>
					
					<tab>
						<tab-heading>
							<spring:message code="label.descr"/>
						</tab-heading>
						
						<div class="custom-textarea-holder">
							<pre ng-bind-html="selectedItem.descr"></pre>
						</div>
					</tab>
					
					
			</tabset>
		</div>
	</div>
	</div>
