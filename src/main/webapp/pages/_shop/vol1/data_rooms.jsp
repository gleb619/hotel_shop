<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="content">
	<div class="row">
		<!-- <div ng-repeat="room in item.rooms" ng-if="(room.tariffOriginalRate.length > 0 && room.tariffCorporateRate.length > 0)"> -->
		<div ng-repeat="room in item.rooms">
			<%@ include file="data_room.jsp" %>
		</div>
		<%-- 
		<div ng-repeat="room in hotel.servHotelRooms" ng-if="room.paymentTariffs.length > 0">
			<%@ include file="data_room.jsp" %>
		</div>
		--%>
	</div>
</div>