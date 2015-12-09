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
    <script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            alert("hee");
            var he =${requestScope.user};
            $(".ids").append("<h1>hoooo</h1>");
            $("#id").append("<select>");
            for(var i=0;i<he.length;i++){
                var obj = he[i];
                alert(obj.id);
                $("#id").append("<option>"+obj.id+"</option>")
            }
            $("#id").append("</select>");
        });
    </script>
</head>
<body>
  <h1>成功登陆</h1>
     <%--${name}--%>
    <!--在前台获取后台通过modelandview传过来的数据-->
         ${requestScope.user}

<div class="ids">

</div>
</body>
</html>
