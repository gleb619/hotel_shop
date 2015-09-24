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
					ng-click="createModalItemServHotelRoom()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemServHotelRoom(selectedItemservHotelRooms.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('servHotelRooms', 'ServHotelRoom', selectedItemservHotelRooms.id, itemIndex)">
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
						<th ng-if="::checkVisibility('breakfast')">
							<div ng-click="sort('breakfast')" >
								<a class="sortable-column-name"><span><spring:message code="label.breakfast" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.breakfast, 'fa-caret-up': !details.breakfast }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyfoodid')">
							<div ng-click="sort('dictglobalbyfoodid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByFoodId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByFoodId, 'fa-caret-up': !details.dictGlobalByFoodId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyroomtypeid')">
							<div ng-click="sort('dictglobalbyroomtypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByRoomTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByRoomTypeId, 'fa-caret-up': !details.dictGlobalByRoomTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('groupglobal')">
							<div ng-click="sort('groupglobal')" >
								<a class="sortable-column-name"><span><spring:message code="label.groupGlobal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.groupGlobal, 'fa-caret-up': !details.groupGlobal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roomnumber')">
							<div ng-click="sort('roomnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.roomNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roomNumber, 'fa-caret-up': !details.roomNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('guestnumber')">
							<div ng-click="sort('guestnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.guestNumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.guestNumber, 'fa-caret-up': !details.guestNumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('category')">
							<div ng-click="sort('category')" >
								<a class="sortable-column-name"><span><spring:message code="label.category" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.category, 'fa-caret-up': !details.category }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descriptioncollapsed')">
							<div ng-click="sort('descriptioncollapsed')" >
								<a class="sortable-column-name"><span><spring:message code="label.descriptioncollapsed" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descriptioncollapsed, 'fa-caret-up': !details.descriptioncollapsed }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.servHotelRooms track by $index"
							ng-class="{ 'success' : selectedItemservHotelRooms.id == item.id }"
							ng-dblclick="editModalItemServHotelRoom(item.id)"
							ng-click="setSelected('selectedItemservHotelRooms', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('breakfast')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.breakfast, 'fa fa-lg fa-circle-o': !item.breakfast}"></i></td>
						<td ng-if="::checkVisibility('dictglobalbyfood')"><label>{{ ::item.dictglobalbyfood.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyroomtype')"><label>{{ ::item.dictglobalbyroomtype.label }}</label></td>
						<td ng-if="::checkVisibility('groupglobal')"><label>{{ ::item.groupglobal.label }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel.label }}</label></td>
						<td ng-if="::checkVisibility('roomnumber')"><label>{{ ::item.roomnumber }}</label></td>
						<td ng-if="::checkVisibility('guestnumber')"><label>{{ ::item.guestnumber }}</label></td>
						<td ng-if="::checkVisibility('category')"><label>{{ ::item.category }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						<td ng-if="::checkVisibility('descriptioncollapsed')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.descriptioncollapsed, 'fa fa-lg fa-circle-o': !item.descriptioncollapsed}"></i></td>
							<td>
								<a ng-click="editModalItemServHotelRoom(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('servHotelRooms', 'ServHotelRoom', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.servHotelRooms.length }}
				</div>
			</div>
		</div>
	</div>
</div>