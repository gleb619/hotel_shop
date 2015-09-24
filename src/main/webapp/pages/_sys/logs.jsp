<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<div>
	<div class="row">
		<div class="btn-toolbar col-md-6 display-block toolbar-panel" role="toolbar">
			<div class="btn-group">
				<button type="button" class="btn btn-primary"
					ng-click="reloadData()">
					<i class="glyphicon fa-2x glyphicon-repeat pull-left"></i>
					<spring:message code="default.reload" />
				</button>
				<button type="button" 
					class="btn btn-success fa-spin-hover-holder">
					<i class="fa fa-2x fa-circle-o-notch pull-left fa-spin-hover"></i>
					<spring:message code="default.sync" />
				</button>
				<a href="../data/logs" target="_blank" class="btn btn-default">
					JSON DATA
				</a>
			</div>
		</div>
		<div class="col-md-6">
			<div class="has-feedback filterBar">
				<input type="text" id="searchKeyword" name="searchKeyword"
						ng-model="searchKeyword" class="form-control"
						placeholder="<spring:message code="default.searchKeyword" />"
						tabindex="1"/>
                <i class="form-control-feedback glyphicon glyphicon-search"></i>
            </div>
		</div>
	</div>
	<div>
		<div class="row">
			<br>
			<div id="main-panel" class="col-md-12">
				<div class="table-responsive">
					<table class="table table-hover table-striped table-bordered">
						<thead>
							<tr>
							    <th ng-repeat="header in headers">{{ header }}</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="row in filtered = ( filteredLogs | filter:searchKeyword )">
								<!-- <td>{{ item }}</td> -->
								<!-- <td ng-repeat="col in row">{{ col }}</td> -->
								<td ng-repeat="header in headers">{{ row[header] }}</td>
							</tr>
						</tbody>
					</table>
					<div>
						<spring:message code="default.total" />: {{ filtered.length }} / {{ filteredLogs.length }} / {{ total }}
					</div>
				</div>
				
				<pagination boundary-links="true" 
								total-items="totalItems" 
								ng-model="currentPage" 
								previous-text="&lsaquo;" 
								next-text="&rsaquo;" 
								first-text="&laquo;" 
								last-text="&raquo;"
								ng-change="pageChanged()">
				</pagination>
				
			</div>
		</div>
	</div>
</div>