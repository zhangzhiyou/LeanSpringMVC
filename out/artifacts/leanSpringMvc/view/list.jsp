<%--
  Created by IntelliJ IDEA.
  User: zhiyou
  Date: 16-4-13
  Time: 上午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.6/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.6/themes/icon.css">
  <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.min.js"></script>
  <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="../jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="../vakata-jstree-2f630b4%20(2)/dist/jstree.js"></script>
</head>
<body>
<table id="dg" title="班级信息" class="easyui-datagrid" fitColumns="true"  pagination="true"
       rownumbers="true" url="studentlist"  toolbar="#tb">
  <thead>
  <tr>
    <th field="cb" checkbox="true"></th>
    <th field="id" width="10" align="center">编号</th>
    <th field="username" width="10" align="center">学号</th>
    <th field="password" width="25" align="center">姓名</th>
  </tr>
  </thead>
</table>
</body>
</html>
