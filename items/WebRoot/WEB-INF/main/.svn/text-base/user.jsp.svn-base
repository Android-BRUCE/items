<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>
<script type="text/javascript">
 $(function(){
             var editing;
             var flag;
             $("#tt").datagrid({
                width:1010,
                height:215,
                collapsible:true,
                //idField:"id",只能选中一个行
                fitColumns:true,
               	rownumbers:true,
                loadMsg:"正在加载中....",
                url:"${pageContext.request.contextPath}/forward/forward_query_user.do",
                striped:true,
                columns:[[
                     {field:"ck",checkbox:true, width:50},
                     {field:"e_id",title:"主键", width:0,hidden:true},
                     {field:"e_name",title:"姓名",width:50,align:"center"},
                     {field:"allRole",title:"具有的角色",width:50,align:"center"},
                     {field:"position_id",title:"职位",width:50,align:"center",
                      formatter:function(value,rowData,rowIndex){
                           if(value==1)
                           {
                              return "初级开发程序员";
                           }else if(value==2){
                              return "中级开发程序员";
                           }else if(value==3){
                              return "高级开发程序员";
                           }else if(value==4){
                              return "项目经理";
                           }else if(value==5){
                              return "其它";
                           }
                           }
                     },
                     {field:"e_sex",title:"性别",width:80,align:"center",
                     	 formatter:function(value,rowData,rowIndex){
                           if(value==1)
                           {
                              return "男";
                           }else if(value==0){
                              return "女";
                           }
                       } 
                     },
                     {field:"e_phone",title:"联系电话", width:80},
                     {field:"e_startdate",title:"入职时间", width:80},
                     {field:"e_state",title:"状态", width:50,
                     	 formatter:function(value,rowData,rowIndex){
                           if(value==1)
                           {
                              return "正常";
                           }else if(value==0){
                              return "离职";
                           }
                       } 
                     
                     },
                                   
                  ]],
                  pagination:true,
                  pageNumber:1,
                  pageSize:5,
                  pageList:[5,10,15,20],
                  toolbar:[
                   {
	                      iconCls:"icon-add",
	                      text:"编辑详情",
	                      handler:function(){
	                           if(editing==undefined)
	                           {
	                           		var rows=$("#tt").datagrid("getSelections");
	                           		//getChecked;
	                               if(rows.length!=1)
	                               {
	                                    $.messager.show({
				                             title:"消息",
				                             width:200,
				                             height:100, 
				                             msg:"只能选择一行记录进行修改"
			                             });
			                             
	                               }else{
			                        var ids="";
	                               	for(var i=0;i<rows.length;i++)
	                                {
	                                   ids=ids+rows[i].e_id+",";
	                                }
	                                	ids=ids.substring(0,ids.length-1);
	                               		var path = "${pageContext.request.contextPath}/role/jumpEditEmployee.do?e_id="+ids;
			                             window.location=path;
	                               }      
/* 	                              //增加一行
		                           $("#tt").datagrid("getRowIndex",rows[0]);
		                           editing=$("#tt").datagrid("getRows").length-1;
		                           //开启编辑状态
		                           $("#tt").datagrid("beginEdit",editing); */
	                           }   
	                      }
                   },
                    {
	                      iconCls:"icon-add",
	                      text:"查询",
	                      handler:function(){ 
	                      var keyword = document.getElementById("keyword").value;
	                      var keyword2 = document.getElementById("time").value;
	                      var cid = document.getElementById("cid").value;
         					$("#tt").datagrid(
         						{
         							url:"${pageContext.request.contextPath}/role/dimEmployee.do?keyword="+keyword+"&eid="+cid+"&time="+keyword2
         						}
         					);
	                      }
                   },
                   
                   
                   {
	                      iconCls:"icon-add",
	                      text:"查看详情",
	                      handler:function(){
	                      	  if(editing==undefined)
	                           {
	                           		var rows=$("#tt").datagrid("getSelections");
	                           		//getChecked;
	                               if(rows.length!=1)
	                               {
	                                    $.messager.show({
				                             title:"消息",
				                             width:200,
				                             height:100, 
				                             msg:"只能选择一行记录进行查看"
			                             });
			                             
	                               }else{
			                        var ids="";
	                               	for(var i=0;i<rows.length;i++)
	                                {
	                                   ids=ids+rows[i].e_id+",";
	                                }
	                                	ids=ids.substring(0,ids.length-1);
	                               		var path = "${pageContext.request.contextPath}/role/employee_look.do?e_id="+ids;
			                             window.location=path;
	                               }      
/* 	                              //增加一行
		                           $("#tt").datagrid("getRowIndex",rows[0]);
		                           editing=$("#tt").datagrid("getRows").length-1;
		                           //开启编辑状态
		                           $("#tt").datagrid("beginEdit",editing); */
	                           }  
	                      	  
	                      	  
	                      	  
	                      	  
	                      }
                   },
                   {
                        iconCls:"icon-remove",
                        text:"删除",
                        handler:function(){
                              var rows=$("#tt").datagrid("getSelections");
                              if(rows.length>0){
                                    var ids="";
	                                for(var i=0;i<rows.length;i++)
	                                {
	                                   ids=ids+rows[i].e_id+",";
	                                }
	                                ids=ids.substring(0,ids.length-1);
	                                $.messager.confirm("确认框","您确定要删除吗?",function(b){
	                                     if(b)
	                                     {
	                                           $.post("${pageContext.request.contextPath}/role/employee_delete.do","e_id="+ids,function(data){
			                                       $.messager.show({
						                             title:"消息",
						                             width:200,
						                             height:100,
						                             msg:data.message
						                           });
						                           //刷新datagrid
								                   $("#tt").datagrid("reload",{});
						                           //取消所选中的行
					                               $("#tt").datagrid("unselectAll");
			                                   },"json");
 	                                     }
	                                });
	                                
                              }else{
                                   $.messager.show({
		                             title:"消息",
		                             width:200,
		                             height:100,
		                             msg:"至少要选择一条记录进行删除"
		                           });
                              }
                        }
                   }, 
              ]   
             });
              
         });


</script>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:权限管理>>用户管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/forward/forward_user-add.do';" value='添加用户' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' method='post'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='${pageContext.request.contextPath}/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150' id="cid">
          <option value='0'>选择类型...</option>
          	<option value='1'>姓名</option>
          	<option value='2'>职位</option>
          	<option value='3'>性别</option>
          	<option value='4'>状态</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' id="keyword"/>
        </td>
        <td width='110'>
    		<select name='time' style='width:120px' id="time" >
            <option value='0'>排序...</option>
            <option value='1'>添加时间</option>
            <option value='2'>修改时间</option>
      	</select>
        </td>
<%--         <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td> --%>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>


<!--  内容列表   -->
<form name="tt" id="tt">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;用户列表&nbsp;</td>
</tr>
<!--  
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">姓名</td>
	<td width="10%">职位</td>
	<td width="10%">性别</td>
	<td width="10%">年龄</td>
	<td width="10%">联系电话</td>
	<td width="8%">入职时间</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td>1</td>
	<td>李晓明</td>
	<td align="center">初级开发工程师</td>
	<td>男</td>
	<td>24</td>
	<td>13288888888</td>
	<td>2015-01-03</td>
	<td>正常</td>
	<td><a >删除</a> | <a href="${pageContext.request.contextPath}/forward/forward_user-edit.do">编辑</a> | <a href="${pageContext.request.contextPath}/forward/forward_user-look.do">查看详情</a></td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;注销&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>

</tr>-->
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>