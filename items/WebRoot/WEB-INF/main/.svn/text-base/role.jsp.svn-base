<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<html>
<head>

<title>角色管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>

<script>
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
                url:"${pageContext.request.contextPath}/forward/forward_query_roles.do",
                striped:true,
                columns:[[
                     {field:"ck",checkbox:true, width:50},
                     {field:"r_id",title:"主键", width:0,hidden:true},
                     {field:"r_number",title:"角色编号",width:50,align:"center"},
                     {field:"r_name",title:"角色名称",width:50,align:"center",
                     	    editor:{
                            type:"validatebox",
                            options:{
                               required:true,
                               validType:"usernameLength[4,12]",
                               missingMessage:"角色名称必填"
                            }
                        }
                     },
                     {field:"r_state",title:"状态",width:80,align:"center",
                     	formatter:function(value,rowData,rowIndex){
                           if(value==1)
                           {
                              return "开启";
                           }else if(value==0){
                              return "禁用";
                           }
                       },
/*                        editor:{
                            type:"combobox",
                            options:{
                               url:"${pageContext.request.contextPath}/city_data.json",
						       valueField:"id",
						       textField:"text"
                            }
                       } */         
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
	                                   ids=ids+rows[i].r_id+",";
	                                }
	                                	ids=ids.substring(0,ids.length-1);
	                               		var path = "${pageContext.request.contextPath}/role/role_edit.do?r_id="+ids;
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
	                      var cid = document.getElementById("cid").value;
         					$("#tt").datagrid(
         						{
         							url:"${pageContext.request.contextPath}/role/dimRole.do?keyword="+keyword+"&cid="+cid
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
			                       		 var id=rows[0].r_id;
	                               		var path = "${pageContext.request.contextPath}/role/role_look.do?r_id="+id;
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
	                                   ids=ids+rows[i].r_id+",";
	                                }
	                                ids=ids.substring(0,ids.length-1);
	                                $.messager.confirm("确认框","您确定要删除吗?",function(b){
	                                     if(b)
	                                     {
	                                           $.post("${pageContext.request.contextPath}/role/role_delete.do","r_id="+ids,function(data){
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
 <td height="26" background="${pageContext.request.contextPath}/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:权限管理>>角色管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/forward/forward_role-add.do';" value='添加角色' />
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
          	<option value='1'>角色编号</option>
          	<option value='2'>角色名称</option>
          	<option value='3'>角色状态</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' style='width:120px' id="keyword"/>
        </td>
        <%-- <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td> --%>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form id="tt">


<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
 <tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;角色列表&nbsp;</td>
</tr>
<%--
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">角色编号</td>
	<td width="10%">角色名称</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>
<% int a = 0; %>
<c:forEach items="${roles }" var="pr"> --%>

<%-- <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="${pr.r_id }" type="checkbox" id="${pr.r_id }" value="${pr.r_id }" class="np"></td>
	<td><%=a+1 %></td>
	<%a+=1;%>
	<td>${pr.r_number}</td>
	<td align="center">${pr.r_name }</td>
	<td><c:choose><c:when test="${pr.r_state==1 }">开启</c:when> <c:otherwise>关闭</c:otherwise></c:choose> </td>
	<td><a href="${pageContext.request.contextPath}/role/role_delete.do?r_id=${pr.r_id} " >删除</a> |<a href="${pageContext.request.contextPath}/role/role_edit.do?r_id=${pr.r_id}">编辑</a> | <a href="${pageContext.request.contextPath}/role/role_look.do?r_id=${pr.r_id}">查看详情</a></td>
</tr>

 
 
 
</c:forEach>
 --%>


<!-- <tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;禁用&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center">翻页代码</td>
</tr>
</table> -->

</form>
</body>
</html>