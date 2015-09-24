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
					ng-click="createModalItemUsers()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemUsers(selectedItemuserses.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('userses', 'Users', selectedItemuserses.id, itemIndex)">
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
						<th ng-if="::checkVisibility('enabled')">
							<div ng-click="sort('enabled')" >
								<a class="sortable-column-name"><span><spring:message code="label.enabled" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.enabled, 'fa-caret-up': !details.enabled }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('activated')">
							<div ng-click="sort('activated')" >
								<a class="sortable-column-name"><span><spring:message code="label.activated" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.activated, 'fa-caret-up': !details.activated }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmimage')">
							<div ng-click="sort('tmimage')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmImage" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmImage, 'fa-caret-up': !details.tmImage }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('firstname')">
							<div ng-click="sort('firstname')" >
								<a class="sortable-column-name"><span><spring:message code="label.firstname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.firstname, 'fa-caret-up': !details.firstname }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('landingpage')">
							<div ng-click="sort('landingpage')" >
								<a class="sortable-column-name"><span><spring:message code="label.landingpage" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.landingpage, 'fa-caret-up': !details.landingpage }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('activationkey')">
							<div ng-click="sort('activationkey')" >
								<a class="sortable-column-name"><span><spring:message code="label.activationkey" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.activationkey, 'fa-caret-up': !details.activationkey }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('lastname')">
							<div ng-click="sort('lastname')" >
								<a class="sortable-column-name"><span><spring:message code="label.lastname" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.lastname, 'fa-caret-up': !details.lastname }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('password')">
							<div ng-click="sort('password')" >
								<a class="sortable-column-name"><span><spring:message code="label.password" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.password, 'fa-caret-up': !details.password }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('langkey')">
							<div ng-click="sort('langkey')" >
								<a class="sortable-column-name"><span><spring:message code="label.langkey" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.langkey, 'fa-caret-up': !details.langkey }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email')">
							<div ng-click="sort('email')" >
								<a class="sortable-column-name"><span><spring:message code="label.email" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email, 'fa-caret-up': !details.email }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('username')">
							<div ng-click="sort('username')" >
								<a class="sortable-column-name"><span><spring:message code="label.username" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.username, 'fa-caret-up': !details.username }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.userses track by $index"
							ng-class="{ 'success' : selectedItemuserses.id == item.id }"
							ng-dblclick="editModalItemUsers(item.id)"
							ng-click="setSelected('selectedItemuserses', item, $index)">
						<td ng-if="::checkVisibility('enabled')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.enabled, 'fa fa-lg fa-circle-o': !item.enabled}"></i></td>
						<td ng-if="::checkVisibility('activated')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.activated, 'fa fa-lg fa-circle-o': !item.activated}"></i></td>
						<td ng-if="::checkVisibility('tmimage')"><label>{{ ::item.tmimage.label }}</label></td>
						<td ng-if="::checkVisibility('firstname')"><label>{{ ::item.firstname }}</label></td>
						<td ng-if="::checkVisibility('landingpage')"><label>{{ ::item.landingpage }}</label></td>
						<td ng-if="::checkVisibility('activationkey')"><label>{{ ::item.activationkey }}</label></td>
						<td ng-if="::checkVisibility('lastname')"><label>{{ ::item.lastname }}</label></td>
						<td ng-if="::checkVisibility('password')"><label>{{ ::item.password }}</label></td>
						<td ng-if="::checkVisibility('langkey')"><label>{{ ::item.langkey }}</label></td>
						<td ng-if="::checkVisibility('email')"><label>{{ ::item.email }}</label></td>
						<td ng-if="::checkVisibility('username')"><label>{{ ::item.username }}</label></td>
							<td>
								<a ng-click="editModalItemUsers(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('userses', 'Users', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.userses.length }}
				</div>
			</div>
		</div>
	</div>
</div>