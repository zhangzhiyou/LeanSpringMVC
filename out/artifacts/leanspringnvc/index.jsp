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
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
    <title></title>
  </head>
  <body>
  <h1 class="page-header">用户登陆</h1>

    <form class="form-horizontal" action="/login/verify" method="post">

      <div class="form-group">
        <div class="col-sm-5">
          <input type="text" class="form-control" name="username" placeholder="用户名/邮箱"/>
        </div>
      </div>
      <!--form-control代表一个form控件-->
      <div class="form-group">
        <div class="col-sm-5">
          <input type="password" class="form-control" name="password" placeholder="密码"/>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-5">
          <%--<button class="btn btn-primary">提交</button>--%>
         <input type="submit" name="submit" value="提交"/>
        </div>
      </div>

    </form>
  </body>
</html>
