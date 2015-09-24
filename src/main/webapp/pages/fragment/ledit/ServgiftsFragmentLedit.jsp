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
					ng-click="createModalItemServGifts()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemServGifts(selectedItemservGiftses.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('servGiftses', 'ServGifts', selectedItemservGiftses.id, itemIndex)">
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
						<th ng-if="::checkVisibility('giftscost')">
							<div ng-click="sort('giftscost')" >
								<a class="sortable-column-name"><span><spring:message code="label.giftsCost" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.giftsCost, 'fa-caret-up': !details.giftsCost }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobal')">
							<div ng-click="sort('dictglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobal, 'fa-caret-up': !details.dictGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('giftsname')">
							<div ng-click="sort('giftsname')" >
								<a class="sortable-column-name"><span><spring:message code="label.giftsName" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.giftsName, 'fa-caret-up': !details.giftsName }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('giftsdescr')">
							<div ng-click="sort('giftsdescr')" >
								<a class="sortable-column-name"><span><spring:message code="label.giftsDescr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.giftsDescr, 'fa-caret-up': !details.giftsDescr }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.servGiftses track by $index"
							ng-class="{ 'success' : selectedItemservGiftses.id == item.id }"
							ng-dblclick="editModalItemServGifts(item.id)"
							ng-click="setSelected('selectedItemservGiftses', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('giftscost')"><label>{{ ::item.giftscost }}</label></td>
						<td ng-if="::checkVisibility('dictglobal')"><label>{{ ::item.dictglobal.label }}</label></td>
						<td ng-if="::checkVisibility('giftsname')"><label>{{ ::item.giftsname }}</label></td>
						<td ng-if="::checkVisibility('giftsdescr')"><label>{{ ::item.giftsdescr }}</label></td>
							<td>
								<a ng-click="editModalItemServGifts(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('servGiftses', 'ServGifts', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.servGiftses.length }}
				</div>
			</div>
		</div>
	</div>
</div>