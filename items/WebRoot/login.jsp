<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>欢迎登陆项目平台管理系统</TITLE>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<script type="text/javascript" src="jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script> 
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.2.6/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>

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
             $("#name").validatebox({
                  required:true,
                  missingMessage:"用户名必填",
                  validType:"usernameLength[2,10]"
             });
             
             $("#password").validatebox({
                  required:true,
                  missingMessage:"密码必填",
                  validType:"passwordRegex"
             });
             
             $("#send").click(function(){
                   var flag=$("#userForm").form("validate");
                   if(!flag)
                   {
                        $.messager.show({
                             title:"消息1",
                             width:200,
                             height:100,
                             msg:"验证未通过!!"
                        });
                   }else{
                   // window.location.href="${pageContext.request.contextPath}/login/Login_check.do";
/*                    	 $.ajax({
                           type:"POST",
                           url:"${pageContext.request.contextPath}/login/Login_check.do",
                           data:$("#userForm").serialize(),
                           dataType:"json",
                           cache:false,
                       }); */
                       
                       document.getElementById("userForm").submit();
                   }
             });
	});


</script>

</HEAD>



<BODY bgColor=#eef8e0 leftMargin=0 topMargin=0 MARGINWIDTH="0" MARGINHEIGHT="0">
<form id="userForm" method="post" name="userForm" action="${pageContext.request.contextPath}/login/Login_check.do">
<TABLE cellSpacing=0 cellPadding=0 width=1004 border=0 align="center">
  
  <TR>
    <TD colSpan=6><IMG height=92 alt="" src="images/crm_1.gif" 
    width=345></TD>
    <TD colSpan=4><IMG height=92 alt="" src="images/crm_2.gif" 
    width=452></TD>
    <TD><IMG height=92 alt="" src="images/crm_3.gif" width=207></TD></TR>
  <TR>
    <TD colSpan=6><IMG height=98 alt="" src="images/crm_4.gif" 
    width=345></TD>
    <TD colSpan=4><IMG height=98 alt="" src="images/crm_5.gif" 
    width=452></TD>
    <TD><IMG height=98 alt="" src="images/crm_6.gif" width=207></TD></TR>
  <TR>
  
    <TD rowSpan=5><IMG height=370 alt="" src="images/crm_7.gif" 
    width=59></TD>
    <TD colSpan=5><IMG height=80 alt="" src="images/crm_8.gif" 
    width=286></TD>
    <TD colSpan=4><IMG height=80 alt="" src="images/crm_9.gif" 
    width=452></TD>
    <TD><IMG height=80 alt="" src="images/crm_10.gif" width=207></TD></TR>
  <TR >
    <TD><IMG height=110 alt="" src="images/crm_11.gif" width=127></TD>
    <TD background=images/crm_12.gif colSpan=6>
      <TABLE id=table1 cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
          <TD>
            <TABLE id=table2 cellSpacing=1 cellPadding=0 width="100%" 
              border=0><TBODY>
              <TR>
                <TD align=middle width=81><FONT color=#ffffff>用户名：</FONT></TD>
                <TD><INPUT maxLength=16 size=16 
                  value=admin name="name" id="name"></TD></TR>
              <TR>
                <TD align=middle width=81><FONT color=#ffffff>密&nbsp; 
                码：</FONT></TD>
                <TD><INPUT type="password" maxLength=16 
                  size=16  name="password" id="password"></TD></TR>
              <TR>
                <TD align=middle width=81><FONT color=#ffffff>验证码：</FONT></TD>
                <TD><INPUT maxLength=50 size=16 
                  value=8756 name="path"> <INPUT type=hidden value=check 
                  name=login>&nbsp;&nbsp;8756</TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
    <TD colSpan=2 rowSpan=2><IMG height=158 alt="" 
      src="images/crm_13.gif" width=295></TD>
    <TD rowSpan=2><IMG height=158 alt="" src="images/crm_14.gif" 
      width=207></TD></TR>
  <TR>
    <TD rowSpan=3><IMG height=180 alt="" src="images/crm_15.gif" 
      width=127></TD>
    <TD rowSpan=3><IMG height=180 alt="" src="images/crm_16.gif" 
    width=24></TD>
    <TD> <IMG class=regtxt height=48 alt="" width=86 
      src="images/crm_17.gif" name=image id="send"></TD>
    <TD><IMG height=48 alt="" src="images/crm_18.gif" width=21>
	<%--<input type="button" value="提交" id="send"> --%>
    </TD>
    <TD colSpan=2><A ><IMG 
      height=48 alt="" src="images/crm_19.gif" width=84 
      border=0></A></TD>
    <TD><IMG height=48 alt="" src="images/crm_20.gif" width=101></TD></TR>
  <TR>
    <TD colSpan=5 rowSpan=2><IMG height=132 alt="" 
      src="images/crm_21.gif" width=292></TD>
    <TD rowSpan=2><IMG height=132 alt="" src="images/crm_22.gif" 
      width=170></TD>
    <TD colSpan=2><IMG height=75 alt="" src="images/crm_23.gif" 
    width=332></TD></TR>
  <TR>
    <TD colSpan=2><IMG height=57 alt="" src="images/crm_24.gif" 
    width=332></TD></TR>
  <TR>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=59></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=127></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=24></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=86></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=21></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=28></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=56></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=101></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=170></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=125></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=207></TD>
    </TR>
    </TABLE></FORM></BODY></HTML>