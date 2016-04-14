<%--
  Created by IntelliJ IDEA.
  User: zhiyou
  Date: 15-11-30
  Time: 下午12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.6/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.6/themes/icon.css">
    <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
    <%--<script type="text/javascript" src="../vakata-jstree-2f630b4%20(2)/dist/jstree.js"></script>--%>
    <title></title>
  </head>
  <body>
  <h1 class="page-header">用户登陆</h1>
  <a href="hello">nihao</a>
  <%--用户名：<input type="text" />--%>
  <%--密码：<input type="pasword"/>--%>
  <%--<input type="submit" value="提交"/>--%>
    <form class="form-horizontal" action="/login/verify" method="post">
      <div class="form-group">
        <div class="col-sm-5">
          <input type="text" class="form-control" name="username" placeholder="用户名"/>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-5">
          <input type="password" class="form-control" name="password" placeholder="密码"/>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-5">
         <input type="submit" name="submit" value="提交">
        </div>
      </div>


      <table id="dg" title="班级信息" class="easyui-datagrid" fitColumns="true"  pagination="true"
             rownumbers="true" url="gratelist"  toolbar="#tb">
        <thead>
        <tr>
          <th field="cb" checkbox="true"></th>
          <th field="id" width="50">编号</th>
          <th field="gradeName" width="100">班级名称</th>
          <th field="gradeDesc" width="250">班级描述</th>
        </tr>
        </thead>
      </table>
    </form>
  </body>
</html>
