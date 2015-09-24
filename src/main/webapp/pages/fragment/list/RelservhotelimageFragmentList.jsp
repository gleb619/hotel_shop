<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>    
<div>
	<div class="row list-gallery">
	  	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4 without-margin" 
	  		 ng-repeat="item in selectedItem.relServHotelImages track by $index">
			<img ng-src="../images/{{ ::item.image }}?size=300" class="img-responsive gallery-item">
		</div>
	</div>
</div>