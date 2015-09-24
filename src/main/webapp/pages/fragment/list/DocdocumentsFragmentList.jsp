<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div class="padding-top-10">
	<div class="row">
			<div class="col-md-12">
			  <div class="table-responsive">
				<table class="table table-hover table-striped table-bordered">
					<thead>
						<tr>
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
						<tr ng-repeat="item in selectedItem.docDocumentses track by $index">
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
				<div>
					<spring:message code="default.total" />: {{ filteredDocDocuments.length }}/{{ selectedItem.docDocumentses.length }}
				</div>
			  </div>
		</div>
	</div>
</div>