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
  <script type="text/javascript" src="/js/jquery.js"></script>
  <script type="text/javascript">
    alert("ho");
//    $(document).ready(function(){
      alert("he+++");
      $("#hello").click(function(){
        alert("***");
        he = $.ajax({url:"/jingtai/hello.txt",async:false});
        $("#ajax").html(he.responseText);
      });
      $("p").append(" <b>Hello world!</b>");
//    });
  </script>
</head>
<body>
<div id="ajax"></div>
<p>This is a paragraph.</p>
<p>This is another paragraph.</p>
<button id="hello" type="button">改变内容</button>
</body>
</html>