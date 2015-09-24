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
					ng-click="createModalItemServHotel()">
					<i class="fa fa-file-o pull-left"></i>
					<i class="fa fa-file pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.create" /></span>
				</button>
				<button type="button" class="btn btn-default btn-edit"
					ng-click="editModalItemServHotel(selectedItemservHotels.id)">
					<i class="glyphicon glyphicon-pencil pull-left"></i>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="default.edit" /></span>
				</button>
				<button type="button" class="btn btn-default btn-delete"
					ng-click="deleteSubItem('servHotels', 'ServHotel', selectedItemservHotels.id, itemIndex)">
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
						<th ng-if="::checkVisibility('starcount')">
							<div ng-click="sort('starcount')" >
								<a class="sortable-column-name"><span><spring:message code="label.starcount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.starcount, 'fa-caret-up': !details.starcount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('showonline')">
							<div ng-click="sort('showonline')" >
								<a class="sortable-column-name"><span><spring:message code="label.showonline" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.showonline, 'fa-caret-up': !details.showonline }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('problem')">
							<div ng-click="sort('problem')" >
								<a class="sortable-column-name"><span><spring:message code="label.problem" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.problem, 'fa-caret-up': !details.problem }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('credit')">
							<div ng-click="sort('credit')" >
								<a class="sortable-column-name"><span><spring:message code="label.credit" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.credit, 'fa-caret-up': !details.credit }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('workonprepayment')">
							<div ng-click="sort('workonprepayment')" >
								<a class="sortable-column-name"><span><spring:message code="label.workonprepayment" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.workonprepayment, 'fa-caret-up': !details.workonprepayment }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('blacklist')">
							<div ng-click="sort('blacklist')" >
								<a class="sortable-column-name"><span><spring:message code="label.blacklist" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.blacklist, 'fa-caret-up': !details.blacklist }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('freesale')">
							<div ng-click="sort('freesale')" >
								<a class="sortable-column-name"><span><spring:message code="label.freesale" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.freesale, 'fa-caret-up': !details.freesale }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('favorite')">
							<div ng-click="sort('favorite')" >
								<a class="sortable-column-name"><span><spring:message code="label.favorite" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.favorite, 'fa-caret-up': !details.favorite }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyqualityid')">
							<div ng-click="sort('dictglobalbyqualityid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByQualityId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByQualityId, 'fa-caret-up': !details.dictGlobalByQualityId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationaddress')">
							<div ng-click="sort('locationaddress')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationAddress" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationAddress, 'fa-caret-up': !details.locationAddress }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyserviceidid')">
							<div ng-click="sort('dictglobalbyserviceidid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByServiceidId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByServiceidId, 'fa-caret-up': !details.dictGlobalByServiceidId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyplacementid')">
							<div ng-click="sort('dictglobalbyplacementid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByPlacementId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByPlacementId, 'fa-caret-up': !details.dictGlobalByPlacementId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('tmaccount')">
							<div ng-click="sort('tmaccount')" >
								<a class="sortable-column-name"><span><spring:message code="label.tmAccount" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.tmAccount, 'fa-caret-up': !details.tmAccount }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('paymentdetails')">
							<div ng-click="sort('paymentdetails')" >
								<a class="sortable-column-name"><span><spring:message code="label.paymentDetails" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.paymentDetails, 'fa-caret-up': !details.paymentDetails }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbyreserveticketstypeid')">
							<div ng-click="sort('dictglobalbyreserveticketstypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByReserveticketstypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByReserveticketstypeId, 'fa-caret-up': !details.dictGlobalByReserveticketstypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbytypeid')">
							<div ng-click="sort('dictglobalbytypeid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByTypeId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByTypeId, 'fa-caret-up': !details.dictGlobalByTypeId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('dictglobalbycategoryid')">
							<div ng-click="sort('dictglobalbycategoryid')" >
								<a class="sortable-column-name"><span><spring:message code="label.dictGlobalByCategoryId" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.dictGlobalByCategoryId, 'fa-caret-up': !details.dictGlobalByCategoryId }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcities')">
							<div ng-click="sort('locationcities')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCities" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCities, 'fa-caret-up': !details.locationCities }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('infocontactinformation')">
							<div ng-click="sort('infocontactinformation')" >
								<a class="sortable-column-name"><span><spring:message code="label.infoContactInformation" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.infoContactInformation, 'fa-caret-up': !details.infoContactInformation }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationcountries')">
							<div ng-click="sort('locationcountries')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationCountries" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationCountries, 'fa-caret-up': !details.locationCountries }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('currcurrency')">
							<div ng-click="sort('currcurrency')" >
								<a class="sortable-column-name"><span><spring:message code="label.currCurrency" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.currCurrency, 'fa-caret-up': !details.currCurrency }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('locationtypeplacement')">
							<div ng-click="sort('locationtypeplacement')" >
								<a class="sortable-column-name"><span><spring:message code="label.locationTypePlacement" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.locationTypePlacement, 'fa-caret-up': !details.locationTypePlacement }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('roomsnumber')">
							<div ng-click="sort('roomsnumber')" >
								<a class="sortable-column-name"><span><spring:message code="label.roomsnumber" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.roomsnumber, 'fa-caret-up': !details.roomsnumber }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('storeys')">
							<div ng-click="sort('storeys')" >
								<a class="sortable-column-name"><span><spring:message code="label.storeys" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.storeys, 'fa-caret-up': !details.storeys }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('whereroomsarebooked')">
							<div ng-click="sort('whereroomsarebooked')" >
								<a class="sortable-column-name"><span><spring:message code="label.whereroomsarebooked" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.whereroomsarebooked, 'fa-caret-up': !details.whereroomsarebooked }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('nameeng')">
							<div ng-click="sort('nameeng')" >
								<a class="sortable-column-name"><span><spring:message code="label.nameeng" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.nameeng, 'fa-caret-up': !details.nameeng }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('timedeparture')">
							<div ng-click="sort('timedeparture')" >
								<a class="sortable-column-name"><span><spring:message code="label.timedeparture" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.timedeparture, 'fa-caret-up': !details.timedeparture }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('timerace')">
							<div ng-click="sort('timerace')" >
								<a class="sortable-column-name"><span><spring:message code="label.timerace" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.timerace, 'fa-caret-up': !details.timerace }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descrinternal')">
							<div ng-click="sort('descrinternal')" >
								<a class="sortable-column-name"><span><spring:message code="label.descrInternal" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descrInternal, 'fa-caret-up': !details.descrInternal }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('conditiontext')">
							<div ng-click="sort('conditiontext')" >
								<a class="sortable-column-name"><span><spring:message code="label.conditionText" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.conditionText, 'fa-caret-up': !details.conditionText }"></i>
							</div>
						</th>
						<th ng-if="::checkVisibility('descr')">
							<div ng-click="sort('descr')" >
								<a class="sortable-column-name"><span><spring:message code="label.descr" /></span></a>
								<i class="fa" ng-class="{ 'fa-caret-down': details.descr, 'fa-caret-up': !details.descr }"></i>
							</div>
						</th>

							<th style="width: 20px;">&nbsp;</th>
							<th style="width: 20px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in item.servHotels track by $index"
							ng-class="{ 'success' : selectedItemservHotels.id == item.id }"
							ng-dblclick="editModalItemServHotel(item.id)"
							ng-click="setSelected('selectedItemservHotels', item, $index)">
						<td ng-if="::checkVisibility('label')"><label>{{ ::item.label }}</label></td>
						<td ng-if="::checkVisibility('starcount')"><label>{{ ::item.starcount }}</label></td>
						<td ng-if="::checkVisibility('showonline')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.showonline, 'fa fa-lg fa-circle-o': !item.showonline}"></i></td>
						<td ng-if="::checkVisibility('problem')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.problem, 'fa fa-lg fa-circle-o': !item.problem}"></i></td>
						<td ng-if="::checkVisibility('credit')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.credit, 'fa fa-lg fa-circle-o': !item.credit}"></i></td>
						<td ng-if="::checkVisibility('workonprepayment')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.workonprepayment, 'fa fa-lg fa-circle-o': !item.workonprepayment}"></i></td>
						<td ng-if="::checkVisibility('blacklist')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.blacklist, 'fa fa-lg fa-circle-o': !item.blacklist}"></i></td>
						<td ng-if="::checkVisibility('freesale')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.freesale, 'fa fa-lg fa-circle-o': !item.freesale}"></i></td>
						<td ng-if="::checkVisibility('favorite')" class="switch-td"><i ng-class="::{'fa fa-lg fa-check': item.favorite, 'fa fa-lg fa-circle-o': !item.favorite}"></i></td>
						<td ng-if="::checkVisibility('dictglobalbyquality')"><label>{{ ::item.dictglobalbyquality.label }}</label></td>
						<td ng-if="::checkVisibility('locationaddress')"><label>{{ ::item.locationaddress.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyserviceid')"><label>{{ ::item.dictglobalbyserviceid.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyplacement')"><label>{{ ::item.dictglobalbyplacement.label }}</label></td>
						<td ng-if="::checkVisibility('tmaccount')"><label>{{ ::item.tmaccount.label }}</label></td>
						<td ng-if="::checkVisibility('paymentdetails')"><label>{{ ::item.paymentdetails.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbyreserveticketstype')"><label>{{ ::item.dictglobalbyreserveticketstype.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbytype')"><label>{{ ::item.dictglobalbytype.label }}</label></td>
						<td ng-if="::checkVisibility('dictglobalbycategory')"><label>{{ ::item.dictglobalbycategory.label }}</label></td>
						<td ng-if="::checkVisibility('locationcities')"><label>{{ ::item.locationcities.label }}</label></td>
						<td ng-if="::checkVisibility('infocontactinformation')"><label>{{ ::item.infocontactinformation.label }}</label></td>
						<td ng-if="::checkVisibility('locationcountries')"><label>{{ ::item.locationcountries.label }}</label></td>
						<td ng-if="::checkVisibility('currcurrency')"><label>{{ ::item.currcurrency.label }}</label></td>
						<td ng-if="::checkVisibility('locationtypeplacement')"><label>{{ ::item.locationtypeplacement.label }}</label></td>
						<td ng-if="::checkVisibility('roomsnumber')"><label>{{ ::item.roomsnumber }}</label></td>
						<td ng-if="::checkVisibility('storeys')"><label>{{ ::item.storeys }}</label></td>
						<td ng-if="::checkVisibility('whereroomsarebooked')"><label>{{ ::item.whereroomsarebooked }}</label></td>
						<td ng-if="::checkVisibility('nameeng')"><label>{{ ::item.nameeng }}</label></td>
						<td ng-if="::checkVisibility('timedeparture')"><label>{{ ::item.timedeparture }}</label></td>
						<td ng-if="::checkVisibility('timerace')"><label>{{ ::item.timerace }}</label></td>
						<td ng-if="::checkVisibility('descrinternal')"><label>{{ ::item.descrinternal }}</label></td>
						<td ng-if="::checkVisibility('conditiontext')"><label>{{ ::item.conditiontext }}</label></td>
						<td ng-if="::checkVisibility('descr')"><label>{{ ::item.descr }}</label></td>
							<td>
								<a ng-click="editModalItemServHotel(item.id)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon-pencil"></i> 
								</a>
							</td>
							<td>
								<a ng-click="deleteSubItem('servHotels', 'ServHotel', item.id, $index)" class="btn">
									<i class="glyphicon glyphicons-lg glyphicon glyphicon-trash"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<spring:message code="default.total" />: {{ item.servHotels.length }}
				</div>
			</div>
		</div>
	</div>
</div>