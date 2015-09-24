<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div>
	<div class="container-fluid">
		<div class="page-header">
			<h3 id="timeline">
				<spring:message code="default.timeline" />
				&nbsp;&nbsp;{{ datesettings.date }}
			</h3>
			<button type="button" class="btn btn-default" ng-click="customDate('last-day')">
				<span>
					<spring:message code="default.last-day" />
				</span>
			</button>
			<button type="button" class="btn btn-default" ng-click="customDate('last-week')">
				<span>
					<spring:message code="default.last-week" />
				</span>
			</button>
			<button type="button" class="btn btn-default" ng-click="customDate('last-month')">
				<span>
					<spring:message code="default.last-month" />
				</span>
			</button>
			<button type="button" class="btn btn-default" ng-click="customDate('last-ten')">
				<span>
					<spring:message code="default.last-ten" />
				</span>
			</button>
		</div>

		<div class="col-sm-3 col-md-2 sidebar-right">

			<div class="row">
					<div class="form-group">
						<input type="checkbox" ng-model="datesettings.isRange">
						<label ng-hide="datesettings.isRange"><spring:message code="default.day" /></label>
						<label ng-show="datesettings.isRange"><spring:message code="default.range" /></label>
					</div>

					<div ng-show="datesettings.isRange">
						<div class="form-group margin-top-5">
							<div class="input-group picker-item">
								<input type="text" class="form-control" ng-model="datesettings.rangeStart" datepicker-popup="yyyy-MM-dd"
									ng-change="convertDateAndTime(datesettings.rangeStart, 'rangeStart')" is-open="details.rangeStartFlag"
									close-text="X" tabindex="3" />
								<span class="input-group-btn">
									<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'rangeStartFlag')">
										<i class="glyphicon glyphicon-calendar"></i>
									</button>
								</span>
							</div>
						</div>
						<div class="form-group margin-top-5">
							<div class="input-group picker-item">
								<input type="text" class="form-control input-white" ng-model="datesettings.rangeEnd" datepicker-popup="yyyy-MM-dd"
									ng-change="convertDateAndTime(datesettings.rangeEnd, 'rangeEnd')" is-open="details.rangeEndFlag" close-text="X"
									tabindex="3" />
								<span class="input-group-btn">
									<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'rangeEndFlag')">
										<i class="glyphicon glyphicon-calendar"></i>
									</button>
								</span>
							</div>
						</div>

					</div>
					<div ng-hide="datesettings.isRange">
						<div class="form-group margin-top-5">
							<div class="input-group picker-item">
								<input type="text" class="form-control" ng-model="datesettings.date" datepicker-popup="yyyy-MM-dd"
									ng-change="convertDateAndTime2(datesettings.date, 'date')" is-open="details.dateFlag" close-text="X"
									tabindex="3" />
								<span class="input-group-btn">
									<button type="button" class="btn btn-default picker-open-button" ng-click="open($event, 'dateFlag')">
										<i class="glyphicon glyphicon-calendar"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
					
					<div class="form-group margin-top-5">
						<button type="button" class="btn btn-default col-md-offset-1 col-md-10 btn-default-submit" ng-click="search()">
							<span>
								<spring:message code="default.search" />
							</span>
						</button>
					</div>
			</div>

		</div>
		
		<div class="without-padding col-sm-9 col-md-10" ng-show="data.length > 0">
			<div class="has-feedback filterBar">
				<input type="text" ng-model="searchKeywordTimeline" class="form-control"
						placeholder="<spring:message code="default.filterKeyword" />"
						tabindex="1"/>
                   	<i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
		
		<div class="col-sm-9 col-md-10 main" ng-hide="datesettings.loading">
			
			<ul class="timeline" ng-show="data.length > 0">
				<li ng-repeat="item in data | filter: searchKeywordTimeline" ng-class="{ 'timeline-inverted' : item.invert }">
					<div class="timeline-badge" ng-class="item.badge">
						<i class="timeline-icon {{ item.icon }}"></i>
					</div>
					<div class="timeline-panel">
						<!-- 
						<div ng-class="{ 'timeline-group': !item.invert, 'timeline-group-invert': item.invert }">
							 <span class="timeline-group-label">{{ item.module }}</span>
						</div>
						-->
						<div class="timeline-panel-body">
							<div class="timeline-heading">
								<h4 class="timeline-title">{{ item.title }}</h4>
								<p><small class="text-muted"><i class="glyphicon glyphicon-time"></i> {{ item.gone }} </small></p>
								<p><small class="text-muted"><i class="glyphicon glyphicon-time"></i> {{ item.createon }} date of creation</small></p>
								<p><small class="text-muted"><i class="glyphicon glyphicon-time"></i> {{ item.modifyon }} last modification</small></p>
							</div>
							<hr>
							<div class="timeline-body">
								<p>{{ item.label }}</p>
							</div>
						</div>
					</div>
				</li>
			</ul>
			
			<!--  
			<div ng-show="data.length > 0">
				<div ng-repeat="item in data | filter: searchKeywordTimeline" >
					{{ item }}<br><br><br>
				</div>
			</div>
			 -->
			<div ng-hide="data.length > 0">
				<label><spring:message code="default.timeline.empty" /></label>
			</div>
		</div>
		<div class="col-sm-9 col-md-10 main" ng-show="datesettings.loading">
			<div id="loadingBar" ng-show="loading" class="app-content-loading">
				<i class="glyphicon glyphicon-refresh fa-spin loading-spinner"></i>
			</div>
		</div>
	</div>
</div>