<%@ page import="java.util.List" %>
<%@ page import="com.you.model.User" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: zhiyou
  Date: 15-11-30
  Time: 下午8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript">

            <%--var dataObject = eval(${requestScope.user});--%>
            <%--var he =${requestScope.user};--%>
            <%--alert(he.length);--%>
            <%--for(var i=0;i<he.length;i++){--%>
                <%--var obj = he[i];--%>
                <%--alert(obj.id+obj.username);--%>
                <%--alert(obj.password);--%>
            <%--}--%>

    </script>
</head>
<body>
  <h1>成功登陆</h1>
     <%--${name}--%>
    <!--在前台获取后台通过modelandview传过来的数据-->
         <%--${requestScope.user}--%>

<div id="ids">
    <table id="tables">
        <tr>
        <th>id</th>
        <th>姓名</th>
        <th>密码</th>
        </tr>
        <c:forEach items="${user}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.username}</td>
                <td>${student.password}</td>
            </tr>
            </c:forEach>
    </table>
    <p>你好</p>
</div>
</body>
</html>
