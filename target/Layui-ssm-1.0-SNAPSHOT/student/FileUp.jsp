<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>文章查重</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <style type="text/css">
        html,body{
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }
        .div1{
            width: 600px;
            height: 70px;
        }
        .main{
            width: 600px;
            height: 420px;
            margin: 0 auto; /*水平居中*/
            border: 3px #e7f3f3 solid;
            position: relative;
            border-radius: 30px;
        }
        .main .title{
            padding: 5px 0 5px 30px;
            height: 30px;
            background-color: #e7f3f3;
            color: #333436;
            font-size: 18px;
            line-height: 30px;
            margin-bottom: 30px;
        }
        .main .button{
            height: 30px;
            color: #1cc09f;
            font-size: 18px;
            line-height: 30px;
            margin-top: 15px;
        }
        .main .button span{
            margin-right: 10px;
        }
        .main .c{
            height: 50px;
            margin-left: 180px;
        }
        .main .c1{
            color: red;
            margin-left: 180px;
            margin-top: 150px;
        }
        .classname{
            width: 160.8px;
            height: 22px;
        }
        a {
            font-size: 18px;
            text-decoration: none;
            color:#1cc09f;
            font-weight:bold;
        }
    </style>
</head>
<body>
<!--springmvc方式-->
<div class="div1"></div>
<div class="main">
    <div class="button" align="right">
        <a href="${pageContext.request.contextPath}/Check/compare"><span>比较</span></a>
    </div>
    <div class="title">
        文章在线查重<span style="margin-left: 10px; font-size: 14px;"></span>
    </div>
    <div class="c" style="margin-top: 10px;">
        <form action="${pageContext.request.contextPath}/Check/upload1" method="post" enctype="multipart/form-data">
            选择需要进行对比的文件：<input type="file" name="files"/>
            <br>
            <br>
            选择需要进行对比的文件：<input type="file" name="files"/>
            <br>
            <br>
            <input type="submit" value="上传">
            <br>
            <br>
            相似度(根据关键字进行相似度对比):${result}
        </form>
    </div>
    <div class="c1">${message}</div>
</div>

</div>
${tip}
<table border="1">
    <tr>
        <c:forEach items="${map1}" var="item">
        <td> ${item.key} : ${item.value} </td>
        </c:forEach><br>
   </tr>
    <tr>
        <c:forEach items="${map2}" var="item">
        <td> ${item.key} : ${item.value}</td>
        </c:forEach>
    </tr>
</table>
<script src="../layui/layui.js"></script>
<script>

</script>
</body>
</html>