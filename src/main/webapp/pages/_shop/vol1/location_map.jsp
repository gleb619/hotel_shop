<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="container">
	<div class="row">
		<%-- 
		<c:if test="${debug}">
			<div class="col-md-6 col-md-offset-4">
				yandexmappointx: {{ ::item.yandexmappointx }}<br>
				yandexmappointy: {{ ::item.yandexmappointy }}<br>
			</div>
			<div class="col-md-8 col-md-offset-2">
				<img alt="location" src="http://static-maps.yandex.ru/1.x/?l=map&ll=37.620070,55.753630&spn=0.03,0.03&z=10&size=600,450&pt=37.620070,55.753630,pm2dbl1" class="img-responsive center">
			</div>
		</c:if>
		<c:if test="${!debug}">
			<div class="col-md-12">
				<img alt="location" ng-src="http://static-maps.yandex.ru/1.x/?l=map&ll={{ ::item.yandexmappointx }},{{ ::item.yandexmappointy }}&spn=0.01,0.01&z=10&size=600,450&pt={{ ::item.yandexmappointx }},{{ ::item.yandexmappointy }},pm2dbl1" class="img-responsive center">
			</div>
		</c:if>
		--%>
		
		<div class="col-md-12">
			<!-- <img alt="location" ng-src="http://static-maps.yandex.ru/1.x/?l=map&ll={{ ::item.yandexmappointx }},{{ ::item.yandexmappointy }}&spn=0.01,0.01&z=7&size=600,450&pt={{ ::item.yandexmappointx }},{{ ::item.yandexmappointy }},pm2dbl1" class="img-responsive center"> -->
			<img alt="location" ng-src="http://static-maps.yandex.ru/1.x/?ll={{ ::item.yandexmappointx }},{{ ::item.yandexmappointy }}&z=9&l=map&size=600,450" class="img-responsive center">
		</div>
		
	</div>
</div>