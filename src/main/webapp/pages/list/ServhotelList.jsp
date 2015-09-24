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
				<a href="../data/servhotel?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/servhotelview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordServHotel" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredServHotel', 'dataServHotel', searchKeywordServHotel)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataServHotel()">
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
						<th ng-if="::checkVisibility('starcount')">
							<div ng-click="sort('starcount')" >
								<a class="sortable-column-name"><span><spring:message code="label.starcount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.starcount, 'fa-caret-up': !details.starcount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('showonline')">
							<div ng-click="sort('showonline')" >
								<a class="sortable-column-name"><span><spring:message code="label.showonline" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.showonline, 'fa-caret-up': !details.showonline }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('problem')">
							<div ng-click="sort('problem')" >
								<a class="sortable-column-name"><span><spring:message code="label.problem" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.problem, 'fa-caret-up': !details.problem }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('credit')">
							<div ng-click="sort('credit')" >
								<a class="sortable-column-name"><span><spring:message code="label.credit" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.credit, 'fa-caret-up': !details.credit }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('workonprepayment')">
							<div ng-click="sort('workonprepayment')" >
								<a class="sortable-column-name"><span><spring:message code="label.workonprepayment" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.workonprepayment, 'fa-caret-up': !details.workonprepayment }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('blacklist')">
							<div ng-click="sort('blacklist')" >
								<a class="sortable-column-name"><span><spring:message code="label.blacklist" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.blacklist, 'fa-caret-up': !details.blacklist }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('freesale')">
							<div ng-click="sort('freesale')" >
								<a class="sortable-column-name"><span><spring:message code="label.freesale" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.freesale, 'fa-caret-up': !details.freesale }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('favorite')">
							<div ng-click="sort('favorite')" >
								<a class="sortable-column-name"><span><spring:message code="label.favorite" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.favorite, 'fa-caret-up': !details.favorite }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyqualityid')">
							<div ng-click="sort('dictglobalbyqualityid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByQualityId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByQualityId, 'fa-caret-up': !details.dictGlobalByQualityId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationaddress')">
							<div ng-click="sort('locationaddress')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationAddress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationAddress, 'fa-caret-up': !details.locationAddress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyserviceidid')">
							<div ng-click="sort('dictglobalbyserviceidid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByServiceidId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByServiceidId, 'fa-caret-up': !details.dictGlobalByServiceidId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyplacementid')">
							<div ng-click="sort('dictglobalbyplacementid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPlacementId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPlacementId, 'fa-caret-up': !details.dictGlobalByPlacementId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('paymentdetails')">
							<div ng-click="sort('paymentdetails')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentDetails" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentDetails, 'fa-caret-up': !details.paymentDetails }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyreserveticketstypeid')">
							<div ng-click="sort('dictglobalbyreserveticketstypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByReserveticketstypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByReserveticketstypeId, 'fa-caret-up': !details.dictGlobalByReserveticketstypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytypeid')">
							<div ng-click="sort('dictglobalbytypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTypeId, 'fa-caret-up': !details.dictGlobalByTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbycategoryid')">
							<div ng-click="sort('dictglobalbycategoryid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByCategoryId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByCategoryId, 'fa-caret-up': !details.dictGlobalByCategoryId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcities')">
							<div ng-click="sort('locationcities')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCities" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCities, 'fa-caret-up': !details.locationCities }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('infocontactinformation')">
							<div ng-click="sort('infocontactinformation')" >
								<a class="sortable-column-name"><span><spring:message code="label.infoContactInformation" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.infoContactInformation, 'fa-caret-up': !details.infoContactInformation }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationtypeplacement')">
							<div ng-click="sort('locationtypeplacement')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationTypePlacement" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationTypePlacement, 'fa-caret-up': !details.locationTypePlacement }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roomsnumber')">
							<div ng-click="sort('roomsnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.roomsnumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roomsnumber, 'fa-caret-up': !details.roomsnumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('storeys')">
							<div ng-click="sort('storeys')" >
								<a class="sortable-column-name"><span><spring:message code="label.storeys" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.storeys, 'fa-caret-up': !details.storeys }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('whereroomsarebooked')">
							<div ng-click="sort('whereroomsarebooked')" >
								<a class="sortable-column-name"><span><spring:message code="label.whereroomsarebooked" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.whereroomsarebooked, 'fa-caret-up': !details.whereroomsarebooked }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredServHotel = ( dataServHotel | filter:searchKeywordServHotel | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredServHotel track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td class="star-td" ng-if="::checkVisibility('starcount')">
							<span class="fa-stack fa-lg star-holder">
								<i class="fa fa-star fa-stack-2x star"></i>
								<span class="fa-stack-1x star-label">{{ ::item.starcount }}</span>
							</span>
						</td>
						<td ng-if="::checkVisibility('showonline')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.showonline, 'fa fa-lg fa-circle-o': !item.showonline}"></i></td>
						<td ng-if="::checkVisibility('problem')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.problem, 'fa fa-lg fa-circle-o': !item.problem}"></i></td>
						<td ng-if="::checkVisibility('credit')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.credit, 'fa fa-lg fa-circle-o': !item.credit}"></i></td>
						<td ng-if="::checkVisibility('workonprepayment')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.workonprepayment, 'fa fa-lg fa-circle-o': !item.workonprepayment}"></i></td>
						<td ng-if="::checkVisibility('blacklist')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.blacklist, 'fa fa-lg fa-circle-o': !item.blacklist}"></i></td>
						<td ng-if="::checkVisibility('freesale')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.freesale, 'fa fa-lg fa-circle-o': !item.freesale}"></i></td>
						<td ng-if="::checkVisibility('favorite')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.favorite, 'fa fa-lg fa-circle-o': !item.favorite}"></i></td>
						<td ng-if="::checkVisibility('dictglobalbyqualityid')"><label>{{ ::item.dictglobalbyquality }}</label></td>
						<td ng-if="::checkVisibility('locationaddress')"><label>{{ ::item.locationaddress }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyserviceidid')"><label>{{ ::item.dictglobalbyserviceid }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyplacementid')"><label>{{ ::item.dictglobalbyplacement }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount }}</label></td>
						<td ng-if="::checkVisibility('paymentdetails')"><label>{{ ::item.paymentdetails }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyreserveticketstypeid')"><label>{{ ::item.dictglobalbyreserveticketstype }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytypeid')"><label>{{ ::item.dictglobalbytype }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbycategoryid')"><label>{{ ::item.dictglobalbycategory }}</label></td>
						<td ng-if="::checkVisibility('locationcities')"><label>{{ ::item.locationcities }}</label></td>
						<td ng-if="::checkVisibility('infocontactinformation')"><label>{{ ::item.infocontactinformation }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency }}</label></td>
						<td ng-if="::checkVisibility('locationtypeplacement')"><label>{{ ::item.locationtypeplacement }}</label></td>
						<td ng-if="::checkVisibility('roomsnumber')"><label>{{ ::item.roomsnumber }}</label></td>
						<td ng-if="::checkVisibility('storeys')"><label>{{ ::item.storeys }}</label></td>
						<td ng-if="::checkVisibility('whereroomsarebooked')"><label>{{ ::item.whereroomsarebooked }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordServHotel = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredServHotel.length }} / {{ dataServHotel.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordServHotel = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataServHotel()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataServHotel()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataServHotel()"><spring:message code="default.loadAll" /></a></li>
					</ul>
				</div>
  			</div>
		</div>
		</div>
	<div class="row sector-2">
		<div class="col-md-12 separator" />
		
		<div class="col-md-12 margin-top-15">
			<tabset type="pills">
			
					<tab select="initTab('relservhotelinfocommercial', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelInfoCommercial"/></tab-heading>
						
						<div ng-if="templates.relservhotelinfocommercial.fragmentlist.init" ng-include="templates.relservhotelinfocommercial.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhoteldocdocuments', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelDocDocuments"/></tab-heading>
						
						<div ng-if="templates.relservhoteldocdocuments.fragmentlist.init" ng-include="templates.relservhoteldocdocuments.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reltourhotels', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelTourHotels"/></tab-heading>
						
						<div ng-if="templates.reltourhotels.fragmentlist.init" ng-include="templates.reltourhotels.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('servhotelroom', 'fragmentlist')">
						<tab-heading><spring:message code="label.ServHotelRoom"/></tab-heading>
						
						<div ng-if="templates.servhotelroom.fragmentlist.init" ng-include="templates.servhotelroom.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelinfohotelservices', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelInfoHotelServices"/></tab-heading>
						
						<div ng-if="templates.relservhotelinfohotelservices.fragmentlist.init" ng-include="templates.relservhotelinfohotelservices.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelcreditcards', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelCreditCards"/></tab-heading>
						
						<div ng-if="templates.relservhotelcreditcards.fragmentlist.init" ng-include="templates.relservhotelcreditcards.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('infoservices', 'fragmentlist')">
						<tab-heading><spring:message code="label.InfoServices"/></tab-heading>
						
						<div ng-if="templates.infoservices.fragmentlist.init" ng-include="templates.infoservices.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reqcruisehotels', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqCruiseHotels"/></tab-heading>
						
						<div ng-if="templates.reqcruisehotels.fragmentlist.init" ng-include="templates.reqcruisehotels.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelinfopolicies', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelInfoPolicies"/></tab-heading>
						
						<div ng-if="templates.relservhotelinfopolicies.fragmentlist.init" ng-include="templates.relservhotelinfopolicies.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('tmincidents', 'fragmentlist')">
						<tab-heading><spring:message code="label.TmIncidents"/></tab-heading>
						
						<div ng-if="templates.tmincidents.fragmentlist.init" ng-include="templates.tmincidents.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelfeatures', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelFeatures"/></tab-heading>
						
						<div ng-if="templates.relservhotelfeatures.fragmentlist.init" ng-include="templates.relservhotelfeatures.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelentertainmentandsport', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelEntertainmentAndSport"/></tab-heading>
						
						<div ng-if="templates.relservhotelentertainmentandsport.fragmentlist.init" ng-include="templates.relservhotelentertainmentandsport.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('reqservhotel', 'fragmentlist')">
						<tab-heading><spring:message code="label.ReqServHotel"/></tab-heading>
						
						<div ng-if="templates.reqservhotel.fragmentlist.init" ng-include="templates.reqservhotel.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelservkidsrule', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelServKidsRule"/></tab-heading>
						
						<div ng-if="templates.relservhotelservkidsrule.fragmentlist.init" ng-include="templates.relservhotelservkidsrule.fragmentlist.url"></div>
					</tab>
					
					<tab select="initTab('relservhotelimage', 'fragmentlist')">
						<tab-heading><spring:message code="label.RelServHotelImage"/></tab-heading>
						
						<div ng-if="templates.relservhotelimage.fragmentlist.init" ng-include="templates.relservhotelimage.fragmentlist.url"></div>
					</tab>
					
					<tab>
						<tab-heading>
							<spring:message code="label.descrInternal"/>
						</tab-heading>
						
						<div class="custom-textarea-holder">
							<pre ng-bind-html="selectedItem.descrinternal"></pre>
						</div>
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
