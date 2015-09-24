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
					ng-click="createModalItemDictGlobal()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemDictGlobal(selectedItemdictGlobals.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('dictGlobals', 'DictGlobal', selectedItemdictGlobals.id, itemIndex)">
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
						<th ng-if="::checkVisibility('dicttype')">
							<div ng-click="sort('dicttype')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictType" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictType, 'fa-caret-up': !details.dictType }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictvalue')">
							<div ng-click="sort('dictvalue')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictValue" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictValue, 'fa-caret-up': !details.dictValue }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictvalueadditional')">
							<div ng-click="sort('dictvalueadditional')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictValueAdditional" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictValueAdditional, 'fa-caret-up': !details.dictValueAdditional }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.dictGlobals track by $index"
							ng-class="{ 'success' : selectedItemdictGlobals.id == item.id }"
							ng-dblclick="editModalItemDictGlobal(item.id)"
							ng-click="setSelected('selectedItemdictGlobals', item, $index)">
						<td ng-if="::checkVisibility('dicttype')"><label>{{ ::item.dicttype }}</label></td>
						<td ng-if="::checkVisibility('dictvalue')"><label>{{ ::item.dictvalue }}</label></td>
						<td ng-if="::checkVisibility('dictvalueadditional')"><label>{{ ::item.dictvalueadditional }}</label></td>
							<td>
								<a ng-click="editModalItemDictGlobal(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('dictGlobals', 'DictGlobal', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.dictGlobals.length }}
				</div>
			</div>
		</div>
	</div>
</div>