<%--
  Created by IntelliJ IDEA.
  User: fubai
  Date: 2016/11/29
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>所有上传文件</title>

    <script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" type="text/css">
</head>

<body>
<table>
    <c:forEach items="${files}" var="file">
        <tr>
            <td><a href="/file/download/${file.id}">${file.filename}</a></td>
            <td>${file.uploadtime}</td>
        </tr>
    </c:forEach>
    <image src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRJy-sE915K8zIheI7UQRIY3OHgwMp0RHyALx4td9InEWU-4yML5Q"></image>
    <image src="/file/download/5" title="访问我的空间" style="max-width:90%" height="400px"></image>
</table>


</body>
</html>
