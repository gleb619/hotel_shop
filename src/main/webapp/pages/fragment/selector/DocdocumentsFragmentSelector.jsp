<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="edit-form">
	<div ng-if="!loading">
		<div class="modal-header">
			<button type="button" class="close round-button" ng-click="cancel()">&times;</button>
			<h4 class="modal-title">
				<spring:message code="default.listof" /> <spring:message code="label.DocDocuments" />
			<h4>
		</div>
		<div class="row modal-body padding-top-0">
		<c:if test="${debug}">
			<div class="row">
				<div class="margin-left-30">
					<a href="../data/docdocumentsview?initLists=true&initDicts=true" target="_blank" class="btn btn-default">JSON DATA</a>
				</div>
			</div>
		</c:if>
			<div class="row">
				<div class="col-md-12 filterBar">
					<div class="fill-content has-feedback modal-title">
						<input type="text" ng-model="searchKeywordDocDocuments" class="form-control"
								ng-model-options="{ debounce: 300 }"
								placeholder="<spring:message code="default.filterKeyword" />"
								tabindex="1"  /> 
						<i class="form-control-feedback glyphicon glyphicon-search"></i>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive margin-bottom-5 table-body ledit-scroll scrollable-content-500"
					when-scrolled="loadDataDocDocuments()">
					<table class="table table-hover table-striped table-bordered margin-bottom-5 padding-all-2">
						<thead>
							<tr>
								<th class="picker-th"></th>
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('realfile')">
							<div ng-click="sort('realfile')" >
								<a class="sortable-column-name"><span><spring:message code="label.realfile" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.realfile, 'fa-caret-up': !details.realfile }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('extension')">
							<div ng-click="sort('extension')" >
								<a class="sortable-column-name"><span><spring:message code="label.extension" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.extension, 'fa-caret-up': !details.extension }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('contenttype')">
							<div ng-click="sort('contenttype')" >
								<a class="sortable-column-name"><span><spring:message code="label.contenttype" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contenttype, 'fa-caret-up': !details.contenttype }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('path')">
							<div ng-click="sort('path')" >
								<a class="sortable-column-name"><span><spring:message code="label.path" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.path, 'fa-caret-up': !details.path }"></i>
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
						<th ng-if="::checkVisibility('text')">
							<div ng-click="sort('text')" >
								<a class="sortable-column-name"><span><spring:message code="label.text" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.text, 'fa-caret-up': !details.text }"></i>
							</div>
						</th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="item in filteredDocDocuments = ( dataDocDocuments | filter:searchKeywordDocDocuments ) track by $index"
								ng-class="{ 'success': item.checked }">
								<td class="picker-td"><input type="checkbox" ng-model="item.checked" ng-change="onSelectionChanged(item)" class="picker-input"/></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('realfile')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.realfile, 'fa fa-lg fa-circle-o': !item.realfile}"></i></td>
						<td ng-if="::checkVisibility('extension')"><label>{{ ::item.extension }}</label></td>
						<td ng-if="::checkVisibility('contenttype')"><label>{{ ::item.contenttype }}</label></td>
						<td ng-if="::checkVisibility('path')"><label>{{ ::item.path }}</label></td>
						<td ng-if="::checkVisibility('originalfilename')"><label>{{ ::item.originalfilename }}</label></td>
						<td ng-if="::checkVisibility('size')"><label>{{ ::item.size }}</label></td>
						<td ng-if="::checkVisibility('text')"><label>{{ ::item.text }}</label></td>
							</tr>
						</tbody>
					</table>
				  </div>
			</div>
			<div class="col-md-12 margin-bottom-10">
				<div class="btn-toolbar">
	  				<div class="btn-group">
						<button type="button" class="btn btn-default">
							<i class="fa fa-list-alt fa-lg"></i>
							<span><spring:message code="default.total" />:{{ selectedItems.length }} / {{ filteredDocDocuments.length }} / {{ dataDocDocuments.length }}</span>
						</button>
						<button type="button" ng-disabled="scrollable.dataLoading" class="btn btn-primary" ng-click="loadDataDocDocuments()">
							<i class="fa fa-database fa-lg" ng-class="{'fa-refresh fa-spin': scrollable.dataLoading, 'fa-database': !scrollable.dataLoading}"></i>
							<span><spring:message code="default.loadMore" /></span>
						</button>
	  				</div>
	  			</div>
			</div>
		</div>
		<div class="modal-footer">
			<div class="col-xs-6 col-md-6">
				<a ng-click="cancel()" class="btn btn-default btn-block btn-lg">
					<spring:message code="default.cancel" />
				</a>
			</div>
			<div class="col-xs-6 col-md-6">
				<a ng-click="submitFunc()"
					class="btn btn-success btn-block btn-lg"> <spring:message
						code="default.submit" />
				</a>
			</div>
		</div>
	</div>
	 <div ng-show="loading" class="loading-bar-holder border-none">
		<div class="loading-bar">
			<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
		</div>
	</div>
</div>
