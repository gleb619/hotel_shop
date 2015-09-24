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
					ng-click="createModalItemTmAccountDetails()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemTmAccountDetails(selectedItemtmAccountDetailses.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('tmAccountDetailses', 'TmAccountDetails', selectedItemtmAccountDetailses.id, itemIndex)">
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
						<th ng-if="::checkVisibility('isbase')">
							<div ng-click="sort('isbase')" >
								<a class="sortable-column-name"><span><spring:message code="label.isBase" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.isBase, 'fa-caret-up': !details.isBase }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('isdetail')">
							<div ng-click="sort('isdetail')" >
								<a class="sortable-column-name"><span><spring:message code="label.isDetail" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.isDetail, 'fa-caret-up': !details.isDetail }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bankid')">
							<div ng-click="sort('bankid')" >
								<a class="sortable-column-name"><span><spring:message code="label.bankId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bankId, 'fa-caret-up': !details.bankId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('rnn')">
							<div ng-click="sort('rnn')" >
								<a class="sortable-column-name"><span><spring:message code="label.rnn" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.rnn, 'fa-caret-up': !details.rnn }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bik')">
							<div ng-click="sort('bik')" >
								<a class="sortable-column-name"><span><spring:message code="label.bik" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bik, 'fa-caret-up': !details.bik }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bin')">
							<div ng-click="sort('bin')" >
								<a class="sortable-column-name"><span><spring:message code="label.bin" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bin, 'fa-caret-up': !details.bin }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('bankaccount')">
							<div ng-click="sort('bankaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.bankaccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.bankaccount, 'fa-caret-up': !details.bankaccount }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.tmAccountDetailses track by $index"
							ng-class="{ 'success' : selectedItemtmAccountDetailses.id == item.id }"
							ng-dblclick="editModalItemTmAccountDetails(item.id)"
							ng-click="setSelected('selectedItemtmAccountDetailses', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('isbase')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.isBase, 'fa fa-lg fa-circle-o': !item.isBase}"></i></td>
						<td ng-if="::checkVisibility('isdetail')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.isDetail, 'fa fa-lg fa-circle-o': !item.isDetail}"></i></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount.label }}</label></td>
						<td ng-if="::checkVisibility('bank')"><label>{{ ::item.bank }}</label></td>
						<td ng-if="::checkVisibility('rnn')"><label>{{ ::item.rnn }}</label></td>
						<td ng-if="::checkVisibility('bik')"><label>{{ ::item.bik }}</label></td>
						<td ng-if="::checkVisibility('bin')"><label>{{ ::item.bin }}</label></td>
						<td ng-if="::checkVisibility('bankaccount')"><label>{{ ::item.bankaccount }}</label></td>
							<td>
								<a ng-click="editModalItemTmAccountDetails(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('tmAccountDetailses', 'TmAccountDetails', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.tmAccountDetailses.length }}
				</div>
			</div>
		</div>
	</div>
</div>