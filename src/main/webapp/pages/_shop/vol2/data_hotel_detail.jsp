<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
<div class="row">
<!-- <table class="table table-hover table-striped table-bordered"> -->
<table>
	<thead>
		<tr>
			<th class="half"></th>
			<th class="half"></th>
		</tr>
	</thead>
	<tbody>
		
		<tr>
			<td><spring:message code="label.label" /></td>
			<td>{{ item.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.starcount" /></td>
			<td>
				<rating readonly="true" ng-model="item.starcount" max="5" class="rating-custom" tabindex="2"> </rating>
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.dictGlobalByQualityId" /></td>
			<td>{{ item.dictglobalbyquality.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.dictGlobalByServiceidId" /></td>
			<td>{{ item.dictglobalbyserviceid.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.dictGlobalByPlacementId" /></td>
			<td>{{ item.dictglobalbyplacement.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.dictGlobalByTypeId" /></td>
			<td>{{ item.dictglobalbytype.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.dictGlobalByCategoryId" /></td>
			<td>{{ item.dictglobalbycategory.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.locationCities" /></td>
			<td>{{ item.locationcities.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.locationCountries" /></td>
			<td>{{ item.locationcountries.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.currCurrency" /></td>
			<td>{{ item.currcurrency.label }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.roomsnumber" /></td>
			<td>{{ item.roomsnumber }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.storeys" /></td>
			<td>{{ item.storeys }}</td>
		</tr>
		<tr>
			<td><spring:message code="label.nameeng" /></td>
			<td>{{ item.nameeng }}</td>
		</tr>
	
	</tbody>
</table>
</div>
</div>