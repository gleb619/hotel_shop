<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/favicon.png" type="image/x-icon">
<title>Error page</title>
</head>
<body>

<div class="scrollable">
	<div class="scrollable-content section myPanel">
	
	<div class="row">
			<div class="col-lg-8">
				<h2>Application Error, please contact support.</h2>
				<h3>Debug Information:</h3>
			</div>
			<div class="col-lg-8">

				Requested URL: ${url}<br><br>
				Exception: ${exception.message}<br><br> 
				<strong>Exception Stack Trace</strong><br>
			</div>
			<div class="col-lg-8">
				<c:forEach items="${exception.stackTrace}" var="ste">
				    ${ste}
				</c:forEach>
			</div>

		</div>
	
	</div>
</div>

</body>
</html>