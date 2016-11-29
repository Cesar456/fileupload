<%--
  Created by IntelliJ IDEA.
  User: Cesar
  Date: 2016/11/11
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件上传</title>

    <script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" type="text/css">
</head>
<body>

<div id="fileupload">
    <form enctype="multipart/form-data" action="<c:url value="/file/upload"/>" method="post">
        <input type="file" name="file">
        <input type="submit" value="提交">
    </form>

    <a href="./filelist?pagesize=1&pagenum=1">所有文件</a>
    <%--<input id="uploadfile" type="file" style="display:none">--%>
    <%--<div class="input-append">--%>
    <%--<label for="photoCover">--%>
    <%--<input id="photoCover" class="input-large" type="text" style="height:30px;">--%>
    <%--</label>--%>
    <%--<button class="btn" onclick="$('input[id=uploadfile]').click();">浏览文件</button>--%>
    <%--</div>--%>
    <%--<button class="btn" >上传</button>--%>

</div>
<%--<script type="text/javascript">--%>
<%--$('input[id=uploadfile]').change(function () {--%>
<%--$('#photoCover').val($(this).val());--%>
<%--});--%>
<%--</script>--%>

</body>
</html>