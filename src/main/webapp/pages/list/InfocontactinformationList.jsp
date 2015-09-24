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
				<a href="../data/infocontactinformation?initLists=true&initDicts=true" 		target="_blank" class="btn btn-default"> JSON DATA </a>
				<a href="../data/infocontactinformationview?initLists=true&initDicts=true" 	target="_blank" class="btn btn-default"> JSON DATA FOR VIEW </a>
			</div>
		</c:if>
		</div>
		<div class="without-padding col-md-12">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordInfoContactInformation" class="form-control"
					   ng-model-options="{ debounce: 300 }" ng-change="search('filteredInfoContactInformation', 'dataInfoContactInformation', searchKeywordInfoContactInformation)"
					   placeholder="<spring:message code="default.filterKeyword" />">
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div class="row sector-1">
		<div class="col-md-12 without-padding scrollable-content-65">
		  <div class="table-responsive margin-bottom-5 table-body" when-scrolled="loadDataInfoContactInformation()">
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
						<th ng-if="::checkVisibility('contact')">
							<div ng-click="sort('contact')" >
								<a class="sortable-column-name"><span><spring:message code="label.contact" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contact, 'fa-caret-up': !details.contact }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email3')">
							<div ng-click="sort('email3')" >
								<a class="sortable-column-name"><span><spring:message code="label.email3" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email3, 'fa-caret-up': !details.email3 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email2')">
							<div ng-click="sort('email2')" >
								<a class="sortable-column-name"><span><spring:message code="label.email2" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email2, 'fa-caret-up': !details.email2 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('website')">
							<div ng-click="sort('website')" >
								<a class="sortable-column-name"><span><spring:message code="label.website" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.website, 'fa-caret-up': !details.website }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone')">
							<div ng-click="sort('phone')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone, 'fa-caret-up': !details.phone }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone2')">
							<div ng-click="sort('phone2')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone2" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone2, 'fa-caret-up': !details.phone2 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone3')">
							<div ng-click="sort('phone3')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone3" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone3, 'fa-caret-up': !details.phone3 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email')">
							<div ng-click="sort('email')" >
								<a class="sortable-column-name"><span><spring:message code="label.email" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email, 'fa-caret-up': !details.email }"></i>
							</div>
						</th>

						<th style="width: 20px;">&nbsp;</th>
						<th style="width: 20px;">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<!-- <tr ng-repeat="item in filteredInfoContactInformation = ( dataInfoContactInformation | filter:searchKeywordInfoContactInformation | orderBy: details.sortableColumn: details.sortableReverse )" -->
					<tr ng-repeat="item in filteredInfoContactInformation track by item.id"
						ng-click="setSelectedItem(item)"
						ng-dblclick="editModalItem(item.id)"
						ng-class="{ 'success' : selectedItem.id == item.id }">
					<c:if test="${debug}">
						<td>{{ ::item.id }}</td>
					</c:if>
						<td ng-if="::checkVisibility('contact')"><label>{{ ::item.contact }}</label></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('email3')"><label>{{ ::item.email3 }}</label></td>
						<td ng-if="::checkVisibility('email2')"><label>{{ ::item.email2 }}</label></td>
						<td ng-if="::checkVisibility('website')"><label>{{ ::item.website }}</label></td>
						<td ng-if="::checkVisibility('phone')"><label>{{ ::item.phone }}</label></td>
						<td ng-if="::checkVisibility('phone2')"><label>{{ ::item.phone2 }}</label></td>
						<td ng-if="::checkVisibility('phone3')"><label>{{ ::item.phone3 }}</label></td>
						<td ng-if="::checkVisibility('email')"><label>{{ ::item.email }}</label></td>
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
					<button type="button" class="btn btn-default" ng-click="searchKeywordInfoContactInformation = ''">
						<i class="fa fa-list-alt fa-lg"></i>
						<span> <spring:message code="default.total" />: {{ filteredInfoContactInformation.length }} / {{ dataInfoContactInformation.length }} </span>
					</button>
					<button type="button" class="btn btn-default btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="searchKeywordInfoContactInformation = ''"><spring:message code="default.ShowAll" /></a></li>
						<li><a ng-click="sort('createon', false)"><spring:message code="default.ShowLast" /></a></li>
					</ul>
				</div>
				<div class="btn-group" dropdown>
					<button type="button" class="btn btn-primary" ng-click="loadDataInfoContactInformation()">
						<i class="fa fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
						<span><spring:message code="default.loadMore" /></span>
					</button>
					<button type="button" class="btn btn-primary btn-splitter dropdown-toggle" dropdown-toggle>
						<span class="caret"></span>
						<span class="sr-only">Split button!</span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a ng-click="loadDataInfoContactInformation()"><spring:message code="default.loadMore" /></a></li>
						<li><a ng-click="loadAllDataInfoContactInformation()"><spring:message code="default.loadAll" /></a></li>
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
