<%--
  Created by IntelliJ IDEA.
  User: fubai
  Date: 2016/11/30
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"></script>
    <script src="<c:url value="/static/js/wangEditor.min.js"/>"></script>

    <link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/static/css/wangEditor.min.css"/>" type="text/css">
    <title>编辑</title>
</head>
<body>

<!--用父容器来控制宽度-->
<div style="width:60%;margin-left: 20%; margin-top: 10%">
    <div id="editor" style="height:400px;max-height:500px;">
        <p>请输入内容...</p>
    </div>
    <button class="btn" id="btn1">提交</button>
</div>

<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">
    var editor = new wangEditor('editor');
    editor.config.pasteFilter = false;
    editor.config.uploadImgUrl = '/file/uploadImg';
    editor.config.uploadImgFileName = 'imgFile';
    editor.create();
    $('#btn1').click(function () {
        // 获取编辑器区域完整html代码
        var html = editor.$txt.html();
        $.ajax({
            type: "POST",
            url: "/article/save",
            data: {"content": html},
            success: function (data) {
                alert(data);
            }
        });
    });
</script>

</body>
</html>
