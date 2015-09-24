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
						<th ng-if="::checkVisibility('servkidsrule')">
							<div ng-click="sort('servkidsrule')" >
								<a class="sortable-column-name"><span><spring:message code="label.servKidsRule" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servKidsRule, 'fa-caret-up': !details.servKidsRule }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('servhotel')">
							<div ng-click="sort('servhotel')" >
								<a class="sortable-column-name"><span><spring:message code="label.servHotel" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.servHotel, 'fa-caret-up': !details.servHotel }"></i>
							</div>
						</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in selectedItem.relServHotelServKidsRules track by $index">
						<td ng-if="::checkVisibility('servkidsrule')"><label>{{ ::item.servkidsrule }}</label></td>
						<td ng-if="::checkVisibility('servhotel')"><label>{{ ::item.servhotel }}</label></td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ filteredRelServHotelServKidsRule.length }}/{{ selectedItem.relServHotelServKidsRules.length }}
				</div>
			  </div>
		</div>
	</div>
</div>