<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
<head>

<title>发信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script>
	$(function(){
		 alert(111);
             $("#email_title").validatebox({
                  required:true,
                  missingMessage:"标题必填",
                  validType:"email_titleLength[4,12]"
             });
			
			  $("#email_content").validatebox({
                  required:true,
                  missingMessage:"内容描述必填"
             });
			
			 $("#send").linkbutton({
                 iconCls:"icon-ok"
            });
        
        
             $("#send").click(function(){
                 
                   var flag=$("#form2").form("validate");
                   if(!flag)
                   {
                        $.messager.show({
                             title:"消息",
                             width:200,
                             height:100,
                             msg:"验证未通过"
                        });
                   }else{
                       //数据提交
                       
                       $.ajax({
                           type:"POST",
                           url:"${pageContext.request.contextPath}/test/test_save.action",
                           cache:false
		                });
		              };
		         });
	})
	
	</script>
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="${pageContext.request.contextPath}/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:信息箱>>发信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" enctype="multipart/form-data">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;发信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">收件人：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select><option value=1>张含馨--初级程序员</option><option value=1>张&nbsp;&nbsp;伟--中级程序员</option><option value=1>孙传杰--项目经理</option></select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="email_title" id="email_title"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">内容：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=15 cols=130 name="email_content" id="email_content"></textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >附件：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<input type="file" name="imageFile" width:300px height:25px>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:void(0)" id="send">保存</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>