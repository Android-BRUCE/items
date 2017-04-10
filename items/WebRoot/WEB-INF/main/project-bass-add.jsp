<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加项目信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.2.6/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>

</head>
<script type="text/javascript">
 $(function(){
	          $.ajax({
	             type:"POST",
	             url:"${pageContext.request.contextPath}/project/project-getCompanyName.do",
	             cache:false,
	             dataType:"json",
	             success:function(results){
	             var c_id=0;
	                for(var i=0;i<results.length;i++)
	                 {
	                    var c_companyname=results[i].c_companyname;
	                    var c_linkman=results[i].c_linkman;
	                    c_id=results[i].c_id;
	                    $("#c_companyname").append("<option value='"+c_id+"'>"+c_companyname+"</option>");
	                   	if(i==results.length-1){
	                   	var c_linkman1=results[0].c_linkman;
	                   	var c_id1=results[0].c_id;
	                   	document.getElementById("c_linkman").value=c_linkman1;
	                   	document.getElementById("c_id").value=c_id1;
	                   	}
	                 }
	             }
	         });
	         
	        // /project_getPosition.do
	         $.ajax({
	             type:"POST",
	             url:"${pageContext.request.contextPath}/project/project_getPosition.do",
	             cache:false,
	             dataType:"json",
	             success:function(results){
	                for(var i=0;i<results.length;i++)
	                 {
	                    var e_name=results[i].e_name;
	                    var e_id=results[i].e_id;
	                    $("#e_id").append("<option value='"+e_id+"'>"+e_name+"</option>");
	                 }
	             }
	         });
	    });
	    $(function (){
  
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
             $("#i_name").validatebox({
                  required:true,
                  missingMessage:"项目名称必填",
                  validType:"usernameLength[2,12]"
             });
               $("#i_number").numberbox({
                  required:true,
                  missingMessage:"人数必填",
                  min:7,
                  max:200,
             });
             $("#i_startdate").datebox({
                  required:true,
                  missingMessage:"日期必填",
                  editable:false,
             });
             $("#i_builddate").datebox({
                  required:true,
                  missingMessage:"日期必填",
                  editable:false,
             });
              $("#i_cost").numberbox({
                  required:true,
                  missingMessage:"预估成本必填",
                  min:1,
                  max:20000,
             });
              $("#i_finishdate").datebox({
                  required:true,
                  missingMessage:"日期必填",
                  editable:false,
             });
 
});
	    function getlinkName(){
	    	var c_id = document.getElementById("c_companyname").value;
	    	$.ajax({
	    		type:"POST",
	    		url:"${pageContext.request.contextPath}/project/project-getCompanyName.do",
	    		cache:false,
	    		dataType:"json",
	    		success:function(results){
	    		 for(var i=0;i<results.length;i++)
	             {
	             	   var c_id2=results[i].c_id;
	             	   if(c_id==c_id2){
	             	   	var c_linkman=results[i].c_linkman;
	             	   	document.getElementById("c_linkman").value=c_linkman;
	             	   	document.getElementById("c_id").value=c_id2;
	             	   }
	             }
	    		}
	    	});
	    }
	    
	    function save(){
	    document.getElementById("form2").submit();
	    }
</script>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="${pageContext.request.contextPath}/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>添加项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/project/project-saveProject.do" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;添加新项目信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<input id="i_name" name="i_name"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<select id="c_companyname" name="c_companyname" onchange="getlinkName();">
	</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">
	客户方负责人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" value="无" id="c_linkman" disabled="disabled" name="c_linkman">
		<input type="text" id="c_id" readonly="readonly" name="c_id" value="00" hidden="hidden">
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
<select id="e_id" name="e_id">
</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="i_number" id="i_number"/>人</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="i_startdate" id="i_startdate"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="i_builddate" id="i_builddate"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="i_cost" id="i_cost"/>万</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select name="i_grade" id="i_grade"><option value=1>紧急</option><option value=2>一般</option><option value=3>暂缓</option></select></td>
	<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="i_finishdate" id="i_finishdate" /></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=15 cols=130 name="i_comment"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a  class="coolbg" id="save" onclick="save()">保存</a>
	<a href="project-base.html" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>