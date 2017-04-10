<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<title>添加角色</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>

<script>

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
             $("#r_number").validatebox({
                  required:true,
                  missingMessage:"角色编号必填",
                  validType:"usernameLength[4,12]"
             });
              $("#r_name").validatebox({
                  required:true,
                  missingMessage:"角色名称必填",
                  validType:"usernameLength[2,6]"
             });
             $("#r_comment").validatebox({
                  required:true,
                  missingMessage:"最多120个字数",
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
             	var a= document.getElementById("form2").submit();
             }
             });
	});


	function allcheck(num) {
 			var list = document.getElementsByName(num);
 			for(var i=1;i<list.length;i++){
 				if(list[i].checked){
 					list[i].checked=false;
 				}else{
 				 	list[i].checked=true;
 				}
 			}
 		
	}

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
    当前位置:权限管理>>添加角色信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" action="${pageContext.request.contextPath}/role/role_add.do" method="post" id="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;添加角色&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">角色编号：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="r_number" id="r_number"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="r_name" id="r_name"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select name="r_state" ><option value=1 >启用</option><option value=0>禁用</option></select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	
	<c:forEach items="${menus }" var="pr">
	<c:if test="${pr.menu_location ==-1 }">
		<input type="checkbox" name="${pr.menu_id  }" value="${pr.menu_id }" id="${pr.menu_id  }" onclick="allcheck(${pr.menu_id  })"/>${pr.menu_name }<br/>
			<c:forEach items="${menus }" var="pri">
				<c:if test="${pri.menu_location==pr.menu_id }">
					&nbsp;&nbsp;&nbsp;<input type="checkbox" name="${pr.menu_id }" value="${pri.menu_id }"/>${pri.menu_name }<br/>
				</c:if>	
			</c:forEach>
	</c:if>
	</c:forEach>
	
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="r_comment" id="r_comment"></textarea>

	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:#0" id="submit" class="coolbg">保存</a>
	<a href="${pageContext.request.contextPath}/forward/forward_role.do" class="coolbg">返回</a>
</td>
</tr>
</table>
</form>
</body>
</html>