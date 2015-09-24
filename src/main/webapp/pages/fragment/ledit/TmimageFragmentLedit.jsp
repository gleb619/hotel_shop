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
					ng-click="createModalItemTmImage()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemTmImage(selectedItemtmImages.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('tmImages', 'TmImage', selectedItemtmImages.id, itemIndex)">
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
						<th ng-if="::checkVisibility('path')">
							<div ng-click="sort('path')" >
								<a class="sortable-column-name"><span><spring:message code="label.path" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.path, 'fa-caret-up': !details.path }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('extension')">
							<div ng-click="sort('extension')" >
								<a class="sortable-column-name"><span><spring:message code="label.extension" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.extension, 'fa-caret-up': !details.extension }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('originalfilename')">
							<div ng-click="sort('originalfilename')" >
								<a class="sortable-column-name"><span><spring:message code="label.originalfilename" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.originalfilename, 'fa-caret-up': !details.originalfilename }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('size')">
							<div ng-click="sort('size')" >
								<a class="sortable-column-name"><span><spring:message code="label.size" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.size, 'fa-caret-up': !details.size }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('name')">
							<div ng-click="sort('name')" >
								<a class="sortable-column-name"><span><spring:message code="label.name" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.name, 'fa-caret-up': !details.name }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('contenttype')">
							<div ng-click="sort('contenttype')" >
								<a class="sortable-column-name"><span><spring:message code="label.contenttype" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contenttype, 'fa-caret-up': !details.contenttype }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.tmImages track by $index"
							ng-class="{ 'success' : selectedItemtmImages.id == item.id }"
							ng-dblclick="editModalItemTmImage(item.id)"
							ng-click="setSelected('selectedItemtmImages', item, $index)">
						<td ng-if="::checkVisibility('path')"><label>{{ ::item.path }}</label></td>
						<td ng-if="::checkVisibility('extension')"><label>{{ ::item.extension }}</label></td>
						<td ng-if="::checkVisibility('originalfilename')"><label>{{ ::item.originalfilename }}</label></td>
						<td ng-if="::checkVisibility('size')"><label>{{ ::item.size }}</label></td>
						<td ng-if="::checkVisibility('name')"><label>{{ ::item.name }}</label></td>
						<td ng-if="::checkVisibility('contenttype')"><label>{{ ::item.contenttype }}</label></td>
							<td>
								<a ng-click="editModalItemTmImage(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('tmImages', 'TmImage', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.tmImages.length }}
				</div>
			</div>
		</div>
	</div>
</div>