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
  <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.js"></script>
  <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.min.js"></script>
  <script type="text/javascript" src="../jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="../jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript" src="../vakata-jstree-2f630b4%20(2)/dist/jstree.js"></script>
  <script type="text/javascript">


    // todo 添加用户
    var url;
   $(document).ready(function(){
    $("#add").click(function(){
        $("#dlg").dialog("open").dialog("setTitle","添加学生信息");
      url="saveUser";
    })
   });

    //关闭对话框
    $(document).ready(function(){
      $("#close").click(function(){
        $("#dlg").dialog("close");//关闭对话框
        clear();
      })
    });
    function clear(){
      $("#stuNo").val("");//清空对话框中所填内容
      $("#userNo").val("");
    }

    $(document).ready(function(){
      $("#save").click(function(){
        $("#fm").form("submit",{
          url:url,
          onSubmit:function(){
            return $(this).form("validate");
          },
          success:function(results){
            if(results){
              $.messager.alert("系统信息","保存成功");
              clear();
              $("#dlg").dialog("close");
              $("#dg").datagrid("reload"); //reload方法会重新加载表格，进行更新
            }else{
              $.messager.alert("系统信息","保存失败");
              return
            }
          }
        })
      })
    });

    //todo 修改用户更改用户和添加用户是相关联的，
    $(document).ready(function(){
      $("#modification").click(function(){
        var selectRows = $("#dg").datagrid('getSelections'); //创建一个对象，对象的内容就是你选的内容
        if(selectRows.length<1){
          $.messager.alert("系统提示","请选择一条要修改的数据");
          return;
        }
        else if(selectRows>1){
          $.messager.alert("系统提示","一次只能修改一条");
        return;
        }
        var row = selectRows[0];//取出selectRows中的第一条数据

        $("#dlg").dialog("open").dialog("setTitle","修改用户信息");
        $("#fm").form("load",row);//load方法会把row的值添加到form表单中
        url="changeManage?id="+row.id;
      })
    })

  </script>
</head>
  <body style="margin: 5px">
    <table id="dg" title="班级信息" class="easyui-datagrid" fitColumns="true"  pagination="true"
           rownumbers="true" url="studentlist"  toolbar="#tb">

      <div>
        <a href="#" id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="#" id = "modification" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#" id="delete" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
      </div>
      <thead>
        <tr>
          <th field="cb" checkbox="true"></th>
          <th field="id" width="10" align="center">编号</th>
          <th field="username" width="10" align="center">学号</th>
          <th field="password" width="25" align="center">姓名</th>
        </tr>
      </thead>
    </table>
      <div id="td">
        <!--todo 添加删除查询更改-->
        <div id="dlg" class="easyui-dialog" style="width:300px;height:200px;padding:20px 40px;"
             closed="true"  buttons="#dlg-button">
          <form id="fm" method="post">
            <table>
              <tr>
                <td>
                  用户名：<input type="text" name="username" id="stuNo" class="easyui-validatebox" size="10" required="true">
                </td>
              </tr>
              <tr>
                <td>
                  密码：<input type="test" name="password" id="userNo" class="easyui-validatebox" size="10" required="true"/>
                </td>
              </tr>
            </table>
          </form>
        </div>
        <div id="dlg-button">
          <a href="javascript:gradeSave()" class="easyui-linkbutton" id="save" iconCls="icon-ok">保存</a>
          <a href="javascript:gradeclose()" id="close" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
        </div>
      </div>
  </body>
</html>
