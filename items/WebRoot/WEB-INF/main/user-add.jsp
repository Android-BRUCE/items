<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">

 	    $(function(){
	        
	          $.ajax({
	             type:"POST",
	             url:"${pageContext.request.contextPath}/role/position_names.do",
	             cache:false,
	             dataType:"json",
	             success:function(results){
 	                 for(var i=0;i<results[0].positions.length;i++)
	                 {	
	                    var positionName=results[0].positions[i].position_name;
	                    var positionId=results[0].positions[i].position_id;
	                   	$("#position_id").append("<option value='"+positionId+"'>"+positionName+"</option>");
	                 }
	             }
	          });
	    });
	     
	     
	     
	     
	     $(function(){
		     $.extend($.fn.validatebox.defaults.rules,{
                 usernameLength:{
                    validator:function(value,param){
                        return value.length>=param[0] && value.length<=param[1];
                    },
                    message:"用户名最少{0}个字符,最多{1}个字符"
                 }
             });
             $.extend($.fn.validatebox.defaults.rules,{
                 passwordRegex:{
                    validator:function(value,param){
                        var passRegex=/^[a-zA-Z](\w|\d){5,11}$/;
                        return passRegex.test(value);
                    },
                    message:"密码必须以字母开头,至少6个字符,最多12个字符"
                 }
                 
             });
             $("#e_name").validatebox({
                  required:true,
                  missingMessage:"用户姓名必填",
                  validType:"usernameLength[2,12]"
             });
              $("#e_age").numberbox({
                  required:true,
                  missingMessage:"年龄必填",
                  min:0,
                  max:200,
             });
             $("#e_phone").numberbox({
                  required:true,
                  missingMessage:"电话必填",
                  validType:"usernameLength[6,11]"
             });
             $("#e_startdate").datebox({
                  required:true,
                  missingMessage:"入职时间必填",
                  editable:false,
             });
              $("#e_idcard").numberbox({
                  required:true,
                  missingMessage:"身份证号必填",
                 validType:"usernameLength[18,18]"
             });
             $("#e_comment").validatebox({
                  required:false,
                  validType:"usernameLength[0,120]"
             });
             $("#submit").click(function (){
             
             var flag=$("#form2").form("validate");
             
             if(!flag){
             $.messager.show({
             	title:"消息1",
                width:200,
                height:100,
                msg:"验证未通过!!"
             }); }else{
             	document.getElementById("form2").submit();
             }
             });
	});
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
    当前位置:权限管理>>添加用户信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" name="form2" action="${pageContext.request.contextPath}/role/saveUser.do" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;添加用户&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<select name="position_id" id="position_id">
 <%--  	<option value=1>初级开发工程师</option>
	<option value=2>中级开发工程师</option>
	<option value=3>高级开发工程师</option>
	<option value=4>项目经理</option>
	<option value=5>其它</option> --%>
	</select></td>
</tr>
<tr>
	<td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input type="text" name="e_name" id="e_name"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select  name="e_sex"><option value='1'>男</option><option value='0'>女</option></select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="e_age" id="e_age"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="e_phone" id="e_phone"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="e_startdate" id="e_startdate"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="e_idcard" id="e_idcard"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<div id="rolediv">
	<!-- <input type="checkbox" />管理员
	<input type="checkbox"/>项目经理
	<input type="checkbox" checked/>程序员 -->
	<c:forEach items="${roles }" var="pr">
		<input type="checkbox" name="r_id" id="r_id" value="${pr.r_id }"/>${pr.r_name}
	</c:forEach>
	</div>
	</td>
	
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="e_comment" id="e_comment"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	 <a  class="coolbg" id="submit">保存</a>
<!-- 	<input type="submit" value="提交"> -->
	<a href="user.html" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>