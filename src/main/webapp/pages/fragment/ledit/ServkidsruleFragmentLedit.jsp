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
					ng-click="createModalItemServKidsRule()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemServKidsRule(selectedItemservKidsRules.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('servKidsRules', 'ServKidsRule', selectedItemservKidsRules.id, itemIndex)">
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
						<th ng-if="::checkVisibility('startage')">
							<div ng-click="sort('startage')" >
								<a class="sortable-column-name"><span><spring:message code="label.startAge" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.startAge, 'fa-caret-up': !details.startAge }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('endage')">
							<div ng-click="sort('endage')" >
								<a class="sortable-column-name"><span><spring:message code="label.endAge" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.endAge, 'fa-caret-up': !details.endAge }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('synopsys')">
							<div ng-click="sort('synopsys')" >
								<a class="sortable-column-name"><span><spring:message code="label.synopsys" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.synopsys, 'fa-caret-up': !details.synopsys }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.servKidsRules track by $index"
							ng-class="{ 'success' : selectedItemservKidsRules.id == item.id }"
							ng-dblclick="editModalItemServKidsRule(item.id)"
							ng-click="setSelected('selectedItemservKidsRules', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('startage')"><label>{{ ::item.startage }}</label></td>
						<td ng-if="::checkVisibility('endage')"><label>{{ ::item.endage }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('synopsys')"><label>{{ ::item.synopsys }}</label></td>
							<td>
								<a ng-click="editModalItemServKidsRule(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('servKidsRules', 'ServKidsRule', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.servKidsRules.length }}
				</div>
			</div>
		</div>
	</div>
</div>