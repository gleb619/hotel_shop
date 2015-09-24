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
						<th ng-if="::checkVisibility('contact')">
							<div ng-click="sort('contact')" >
								<a class="sortable-column-name"><span><spring:message code="label.contact" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.contact, 'fa-caret-up': !details.contact }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('label')">
							<div ng-click="sort('label')" >
								<a class="sortable-column-name"><span><spring:message code="label.label" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.label, 'fa-caret-up': !details.label }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email3')">
							<div ng-click="sort('email3')" >
								<a class="sortable-column-name"><span><spring:message code="label.email3" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email3, 'fa-caret-up': !details.email3 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email2')">
							<div ng-click="sort('email2')" >
								<a class="sortable-column-name"><span><spring:message code="label.email2" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email2, 'fa-caret-up': !details.email2 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('website')">
							<div ng-click="sort('website')" >
								<a class="sortable-column-name"><span><spring:message code="label.website" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.website, 'fa-caret-up': !details.website }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone')">
							<div ng-click="sort('phone')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone, 'fa-caret-up': !details.phone }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone2')">
							<div ng-click="sort('phone2')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone2" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone2, 'fa-caret-up': !details.phone2 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('phone3')">
							<div ng-click="sort('phone3')" >
								<a class="sortable-column-name"><span><spring:message code="label.phone3" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.phone3, 'fa-caret-up': !details.phone3 }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('email')">
							<div ng-click="sort('email')" >
								<a class="sortable-column-name"><span><spring:message code="label.email" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.email, 'fa-caret-up': !details.email }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.infoContactInformations track by $index">
						<td ng-if="::checkVisibility('contact')"><label>{{ ::item.contact }}</label></td>
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('email3')"><label>{{ ::item.email3 }}</label></td>
						<td ng-if="::checkVisibility('email2')"><label>{{ ::item.email2 }}</label></td>
						<td ng-if="::checkVisibility('website')"><label>{{ ::item.website }}</label></td>
						<td ng-if="::checkVisibility('phone')"><label>{{ ::item.phone }}</label></td>
						<td ng-if="::checkVisibility('phone2')"><label>{{ ::item.phone2 }}</label></td>
						<td ng-if="::checkVisibility('phone3')"><label>{{ ::item.phone3 }}</label></td>
						<td ng-if="::checkVisibility('email')"><label>{{ ::item.email }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredInfoContactInformation.length }}/{{ selectedItem.infoContactInformations.length }}
				</div>
			  </div>
		</div>
	</div>
</div>