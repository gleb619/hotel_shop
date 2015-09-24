<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="modal-dialog">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" ng-click="cancel()">&times;</button>
      <h4 class="modal-title">Modal title</h4>
    </div>
    <div class="modal-body">
      <ul>
        <li ng-repeat="item in items">
          <a ng-click="selected.item=item">{{item}}</a>
        </li>
      </ul>
      <div>Selected Item: {{selected.item}}</div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" ng-click="cancel()">Close</button>
      <button type="button" class="btn btn-primary" ng-click="ok()">Save changes</button>
    </div>
  </div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</body>
</html>