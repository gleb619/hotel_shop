<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>

<div class="btn-group" role="group">
	<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
		<i class="fa fa-list-alt fa-lg"></i>
		<spring:message code="default.total" /> : {{ filtered.length }} / {{ data.length }} 
		<span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu">
		<li>
			<a href="#/shop_landscape">Landscape</a>
		</li>
		<li>
			<a href="#/shophotel-big">Big layout</a>
		</li>
		<li>
			<a href="#/shophotel-medium">Medium layout</a>
		</li>
		<li>
			<a href="#/shophotel-small">Small layout</a>
		</li>
		<li>
			<a href="#/shophotel-small-2">Small layout 2</a>
		</li>
	</ul>
</div>