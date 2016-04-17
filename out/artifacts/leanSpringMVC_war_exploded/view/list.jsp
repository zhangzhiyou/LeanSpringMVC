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

    //todo 删除功能

    $(document).ready(function(){
      $("#delete").click(function(){
       var selecteRows = $("#dg").datagrid("getSelections");//创建一个对象，把你选中的对象放在数组里;
        if(selecteRows.length==0){
          $.messager.alert("系统提示","请选择要删除的的选项");
          return;
        }
        var strsIds=[];//定义一个数组，数组的内容是空 创建数组的方法  1, var strsIds= ["1","2"]   2. var arr = new Array(5)  3 var arr = new Arry([5]) ,
        for(var i =0;i<selecteRows.length;i++){//遍历selecteRows数组
          strsIds.push(selecteRows[i].id);//把selectRows中的数据存放在strIds中，并且会返回新字符串的长度
        }
       var ids = strsIds.join();//separator 分割符 以什么分割符进行分割，可选。指定要使用的分隔符。如果省略该参数，则使用逗号作为分隔符。
        $.messager.confirm("系统提示","您确定要删除<font color='red'>"+selecteRows.length+"</font>条信息吗",function(r){

          if(r){
            //post方法在本项目的bootstrap包下的jquery-2.1.4.js下面

            /**
             * $.post( "http://localhost/index.php?id=5", function(data, textStatus, jqXHR){
               data 是该请求返回的数据(可能经过处理)
               textStatus 可能是"success"、 "notmodified"等
               jqXHR 是经过jQuery封装的XMLHttpRequest对象(保留其本身的所有属性和方法)


               jquery.post()方法有四个参数，
               1. 请求的url地址，
               2. 传递的参数，可以传递多个参数，中间使用"," 分开，在后台可以使用request.getPareamate方法获取
               3. 后台执行完后的回回调函数，参数result就是后台传过来的值，键值对的形式，通过键获取值
               4. 请求返回的类型，指定请求返回值的类型，xml、 html、 script、 json、 jsonp、text
             * */
            $.post("deleteMange",{deiLds:ids},function(result){
              //这里的result就是后台处理完数据后返回的结果，类型是object类型
              if(result.success){
                $.messager.alert("系统提示","恭喜您已经成功删除<font color='red'>"+result.delNums+"<font>信息")
                $("#dg").datagrid("reload");//重新加载表
              }
              else{
                $.messager.alert("系统提示","<font color='red'>"+[result.errorindex].gradeName+"</font>"+result.errorMas)
              }
            },"json")
          }
        })
      })
    });

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
              return;
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
    });

      // todo 模糊查询


  </script>
</head>
  <body class="easyui-layout">
  <div region="north" style="height:80px" align="center">
      <h1>这是主界面</h1>
  </div>
  <div region="center">
        <table id="dg" title="班级信息" class="easyui-datagrid" fitColumns="true"  pagination="true"
               rownumbers="true" url="studentlist" toolbar="#td">
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
          <div>
              <a href="#" id="add" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
              <a href="#" id = "modification" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
              <a href="#" id="delete" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
          </div>
          <div>&nbsp;用户名: &nbsp;<input type="text" name="s_username" id="s_username">
              <a href="#" id="select" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
          </div>
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
    </div>
  <div region="west" style="width:150px" title="导航菜单" spit="true">
      <div class="easyui-accordion" style="width:150px;height:200px;">
          <div title="About Accordion" iconCls="icon-ok" style="overflow:auto;padding:10px;">
              <h3 style="color:#0099FF;">Accordion for jQuery</h3>
              <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>
          </div>
          <div title="About easyui" iconCls="icon-reload" selected="true" style="padding:10px;">
              easyui help you build your web page easily
          </div>
          <div title="Tree Menu">
              <ul id="tt1" class="easyui-tree">
                  <li>
                      <span>Folder1</span>
                      <ul>
                          <li>
                              <span>Sub Folder 1</span>
                              <ul>
                                  <li><span>File 11</span></li>
                                  <li><span>File 12</span></li>
                                  <li><span>File 13</span></li>
                              </ul>
                          </li>
                          <li><span>File 2</span></li>
                          <li><span>File 3</span></li>
                      </ul>
                  </li>
                  <li><span>File2</span></li>
              </ul>
          </div>
      </div>
  </div>
  <div region="south" style="height:30px" align="center">
      版权所属山东理工大学 <a href="http://www.sdut.edu.cn/">www.sdut.edu.cn</a>
  </div>
  </body>
</html>
