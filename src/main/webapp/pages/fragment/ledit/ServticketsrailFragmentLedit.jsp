<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div>
	<div class="row">
		<div class="padding-left-right-15">
			<div class="btn-group without-padding display-block toolbar-panel margin-bottom-5">
				<button type="button" class="btn btn-default btn-create"
					ng-click="createModalItemServTicketsRail()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemServTicketsRail(selectedItemservTicketsRails.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('servTicketsRails', 'ServTicketsRail', selectedItemservTicketsRails.id, itemIndex)">
					<i class="glyphicon glyphicon-trash pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.delete" /></span>
				</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive margin-bottom-5 table-body ledit-scroll">
				<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
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
						<th ng-if="::checkVisibility('datestartdep')">
							<div ng-click="sort('datestartdep')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateStartDep" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateStartDep, 'fa-caret-up': !details.dateStartDep }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dateendarrival')">
							<div ng-click="sort('dateendarrival')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateEndArrival" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateEndArrival, 'fa-caret-up': !details.dateEndArrival }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dateenddep')">
							<div ng-click="sort('dateenddep')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateEndDep" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateEndDep, 'fa-caret-up': !details.dateEndDep }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('datestartarrival')">
							<div ng-click="sort('datestartarrival')" >
								<a class="sortable-column-name"><span><spring:message code="label.dateStartArrival" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dateStartArrival, 'fa-caret-up': !details.dateStartArrival }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('railcompanydepid')">
							<div ng-click="sort('railcompanydepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.railCompanyDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.railCompanyDepId, 'fa-caret-up': !details.railCompanyDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citybackarrivalid')">
							<div ng-click="sort('citybackarrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityBackArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityBackArrivalId, 'fa-caret-up': !details.cityBackArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citytherearrivalid')">
							<div ng-click="sort('citytherearrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityThereArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityThereArrivalId, 'fa-caret-up': !details.cityThereArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('railcompanyarrivalid')">
							<div ng-click="sort('railcompanyarrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.railCompanyArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.railCompanyArrivalId, 'fa-caret-up': !details.railCompanyArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numtraindep')">
							<div ng-click="sort('numtraindep')" >
								<a class="sortable-column-name"><span><spring:message code="label.numTrainDep" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numTrainDep, 'fa-caret-up': !details.numTrainDep }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('classtrainarrivalid')">
							<div ng-click="sort('classtrainarrivalid')" >
								<a class="sortable-column-name"><span><spring:message code="label.classTrainArrivalId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.classTrainArrivalId, 'fa-caret-up': !details.classTrainArrivalId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citytheredepid')">
							<div ng-click="sort('citytheredepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityThereDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityThereDepId, 'fa-caret-up': !details.cityThereDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('classtraindepid')">
							<div ng-click="sort('classtraindepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.classTrainDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.classTrainDepId, 'fa-caret-up': !details.classTrainDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('citybackdepid')">
							<div ng-click="sort('citybackdepid')" >
								<a class="sortable-column-name"><span><spring:message code="label.cityBackDepId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.cityBackDepId, 'fa-caret-up': !details.cityBackDepId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('numtrainarrival')">
							<div ng-click="sort('numtrainarrival')" >
								<a class="sortable-column-name"><span><spring:message code="label.numTrainArrival" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.numTrainArrival, 'fa-caret-up': !details.numTrainArrival }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('railname')">
							<div ng-click="sort('railname')" >
								<a class="sortable-column-name"><span><spring:message code="label.railName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.railName, 'fa-caret-up': !details.railName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.servTicketsRails track by $index"
							ng-class="{ 'success' : selectedItemservTicketsRails.id == item.id }"
							ng-dblclick="editModalItemServTicketsRail(item.id)"
							ng-click="setSelected('selectedItemservTicketsRails', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('price')"><label>{{ ::item.price }}</label></td>
						<td ng-if="::checkVisibility('datestartdep')"><label>{{ ::item.datestartdep }}</label></td>
						<td ng-if="::checkVisibility('dateendarrival')"><label>{{ ::item.dateendarrival }}</label></td>
						<td ng-if="::checkVisibility('dateenddep')"><label>{{ ::item.dateenddep }}</label></td>
						<td ng-if="::checkVisibility('datestartarrival')"><label>{{ ::item.datestartarrival }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency.label }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount.label }}</label></td>
						<td ng-if="::checkVisibility('railcompanydep')"><label>{{ ::item.railcompanydep }}</label></td>
						<td ng-if="::checkVisibility('citybackarrival')"><label>{{ ::item.citybackarrival }}</label></td>
						<td ng-if="::checkVisibility('citytherearrival')"><label>{{ ::item.citytherearrival }}</label></td>
						<td ng-if="::checkVisibility('railcompanyarrival')"><label>{{ ::item.railcompanyarrival }}</label></td>
						<td ng-if="::checkVisibility('numtraindep')"><label>{{ ::item.numtraindep }}</label></td>
						<td ng-if="::checkVisibility('classtrainarrival')"><label>{{ ::item.classtrainarrival }}</label></td>
						<td ng-if="::checkVisibility('citytheredep')"><label>{{ ::item.citytheredep }}</label></td>
						<td ng-if="::checkVisibility('classtraindep')"><label>{{ ::item.classtraindep }}</label></td>
						<td ng-if="::checkVisibility('citybackdep')"><label>{{ ::item.citybackdep }}</label></td>
						<td ng-if="::checkVisibility('numtrainarrival')"><label>{{ ::item.numtrainarrival }}</label></td>
						<td ng-if="::checkVisibility('railname')"><label>{{ ::item.railname }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
							<td>
								<a ng-click="editModalItemServTicketsRail(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('servTicketsRails', 'ServTicketsRail', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.servTicketsRails.length }}
				</div>
			</div>
		</div>
	</div>
</div>