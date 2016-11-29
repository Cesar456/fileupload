<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 2016/11/11
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>" type="text/css">
<link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" type="text/css">

<head>
    <title>登录</title>
</head>
<body>

<div id="login">
    <div class="jumbotron">
        <h1>登录</h1>
        <form role="form" action="<c:url value="/user/login"/>" method="post">
            <div class="form-group">
                <label for="username">Email address</label>
                <input type="text" class="form-control" name="name" id="username"
                       placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" name="password" id="exampleInputPassword1"
                       placeholder="Password">
            </div>
            <button type="submit" class="btn btn-default">确定</button>
        </form>
    </div>
</div>

</body>
</html>
