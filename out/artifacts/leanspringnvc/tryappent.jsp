<%--
  Created by IntelliJ IDEA.
  User: zhiyou
  Date: 15-12-5
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script type="text/javascript" src="${pageContext.request.contextPath}js/jquery.js"></script>
  <script type="text/javascript">
    $(document).ready(function(){
        alert("****");
        $("p").append("<h1>Hello world!</h1>");
    });
  </script>
</head>
<body>
<p>This is a paragraph.</p>
<p>This is another paragraph.</p>
<button>在每个 p 元素的结尾添加内容</button>
</body>
</html>
