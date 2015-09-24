<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/favicon.png" type="image/x-icon">
<title>Generate Data</title>
</head>
<body>

	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h4 class="modal-title">Generate Data</h4>
	</div>
	<div class="modal-body">
		<div class="te">${result}</div>
	</div>
	<div class="modal-footer">
		<!-- data-dismiss="modal" -->
		<a class="btn btn-default"  href="javascript:history.go(0)">Close</a>
		<!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
	</div>

</body>
</html>
