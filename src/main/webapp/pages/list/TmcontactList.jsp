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
				<a href="../data/tmcontact?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/tmcontactview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordTmContact" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredTmContact', 'dataTmContact', searchKeywordTmContact)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataTmContact()">
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
						<th ng-if="::checkVisibility('contactname')">
							<div ng-click="sort('contactname')" >
								<a class="sortable-column-name"><span><spring:message code="label.contactName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contactName, 'fa-caret-up': !details.contactName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('contactpatronymic')">
							<div ng-click="sort('contactpatronymic')" >
								<a class="sortable-column-name"><span><spring:message code="label.contactPatronymic" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contactPatronymic, 'fa-caret-up': !details.contactPatronymic }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('contactsurname')">
							<div ng-click="sort('contactsurname')" >
								<a class="sortable-column-name"><span><spring:message code="label.contactSurname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contactSurname, 'fa-caret-up': !details.contactSurname }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('birthday')">
							<div ng-click="sort('birthday')" >
								<a class="sortable-column-name"><span><spring:message code="label.birthday" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.birthday, 'fa-caret-up': !details.birthday }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passportenddate')">
							<div ng-click="sort('passportenddate')" >
								<a class="sortable-column-name"><span><spring:message code="label.passportEndDate" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passportEndDate, 'fa-caret-up': !details.passportEndDate }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passportstartdate')">
							<div ng-click="sort('passportstartdate')" >
								<a class="sortable-column-name"><span><spring:message code="label.passportStartDate" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passportStartDate, 'fa-caret-up': !details.passportStartDate }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('passportnumber')">
							<div ng-click="sort('passportnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.passportNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.passportNumber, 'fa-caret-up': !details.passportNumber }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredTmContact = ( dataTmContact | filter:searchKeywordTmContact | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredTmContact track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('contactname')"><label>{{ ::item.contactname }}</label></td>
						<td ng-if="::checkVisibility('contactpatronymic')"><label>{{ ::item.contactpatronymic }}</label></td>
						<td ng-if="::checkVisibility('contactsurname')"><label>{{ ::item.contactsurname }}</label></td>
						<td ng-if="::checkVisibility('birthday')"><label>{{ ::item.birthday }}</label></td>
						<td ng-if="::checkVisibility('passportenddate')"><label>{{ ::item.passportenddate }}</label></td>
						<td ng-if="::checkVisibility('passportstartdate')"><label>{{ ::item.passportstartdate }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('passportnumber')"><label>{{ ::item.passportnumber }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordTmContact = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredTmContact.length }} / {{ dataTmContact.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordTmContact = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataTmContact()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataTmContact()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataTmContact()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset type="pills">
			
					<tab select="initTab('tmcontactcommunications', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmContactCommunications"/></tab-heading>
						
						<div ng-if="templates.tmcontactcommunications.fragmentlist.init" ng-include="templates.tmcontactcommunications.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relcruisecontacts', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelCruiseContacts"/></tab-heading>
						
						<div ng-if="templates.relcruisecontacts.fragmentlist.init" ng-include="templates.relcruisecontacts.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmorder', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmOrder"/></tab-heading>
						
						<div ng-if="templates.tmorder.fragmentlist.init" ng-include="templates.tmorder.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reltmordertmcontact', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelTmOrderTmContact"/></tab-heading>
						
						<div ng-if="templates.reltmordertmcontact.fragmentlist.init" ng-include="templates.reltmordertmcontact.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmincidents', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmIncidents"/></tab-heading>
						
						<div ng-if="templates.tmincidents.fragmentlist.init" ng-include="templates.tmincidents.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relaccountcontacts', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelAccountContacts"/></tab-heading>
						
						<div ng-if="templates.relaccountcontacts.fragmentlist.init" ng-include="templates.relaccountcontacts.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmcontactaddresses', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmContactAddresses"/></tab-heading>
						
						<div ng-if="templates.tmcontactaddresses.fragmentlist.init" ng-include="templates.tmcontactaddresses.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('paymentcontact', 'fragmentlist')">
						<tab-heading><spring:message code="label.PaymentContact"/></tab-heading>
						
						<div ng-if="templates.paymentcontact.fragmentlist.init" ng-include="templates.paymentcontact.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservtransfertmcontact', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServTransferTmContact"/></tab-heading>
						
						<div ng-if="templates.relservtransfertmcontact.fragmentlist.init" ng-include="templates.relservtransfertmcontact.fragmentlist.url"></div>
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
