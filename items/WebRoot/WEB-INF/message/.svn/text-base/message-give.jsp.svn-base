<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>收件箱</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<script>
	function deletes(){
		if(confirm("您确定要删除吗？")){
    		return true;
    	}else{
    		return false;
    	} 
	}
</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:信息箱>>收件箱</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<!--  搜索表单  -->
	<form name='form3' action='' method='get'>
		<input type='hidden' name='dopost' value='' />
		<table width='98%' border='0' cellpadding='1' cellspacing='1'
			bgcolor='#CBD8AC' align="center" style="margin-top:8px">
			<tr bgcolor='#EEF4EA'>
				<td background='skin/images/wbg.gif' align='center'>
					<table border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td width='90' align='center'>搜索条件：</td>
							<td width='160'><select name='cid' style='width:150'>
									<option value='0'>选择类型...</option>
									<option value='1'>标题</option>
							</select></td>
							<td width='70'>关键字：</td>
							<td width='160'><input type='text' name='keyword' value=''
								style='width:120px' /></td>
							<td width='110'><select name='orderby' style='width:120px'>
									<option value='id'>排序...</option>
									<option value='pubdate'>发送时间</option>
							</select></td>
							<td>&nbsp;&nbsp;&nbsp;<input name="imageField" type="image"
								src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20"
								border="0" class="np" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<!--  内容列表   -->
	<form name="form2">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;收件箱&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">选择</td>
				<td width="6%">序号</td>
				<td width="10%">标题</td>
				<td width="10%">内容</td>
				<td width="10%">发件人</td>
				<td width="8%">收件时间</td>
				<td width="8%">操作</td>
			</tr>
			<c:forEach items="${listEmail }" var="listEmail" varStatus="st">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><input name="" type="checkbox" id="id" value="" class="np"></td>
					<td>${(pageView.currentPage-1)*pageView.pageSize+st.index+1}</td>
					<td>${listEmail.email_title }</td>
					<td>${listEmail.email_content }</td>
					<td>${listEmail.sendman }</td>
					<td>${listEmail.email_senDate }</td>
					<td><a href="${pageContext.request.contextPath}/Email/Email_delete.action?email_id=${listEmail.email_id }" id="remove" onclick="return deletes()">删除</a><a href="${pageContext.request.contextPath}/Email/Email_replybox.action?email_sendman=${listEmail.email_sendman }">回复</a></td>
				</tr>
			</c:forEach>
			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="12">&nbsp; <a href="" class="coolbg">全选</a>
					<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="" class="coolbg">&nbsp;删除&nbsp;</a> <a href=""
					class="coolbg">&nbsp;导出Excel&nbsp;</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="12" align="center"><span
					class="STYLE1">共${pageView.totalRecords}条纪录，当前第${pageView.currentPage}/${pageView.totalPages}页，每页${pageView.pageSize}条纪录</span>
					<span style="font-size:12px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${pageView.currentPage>1}">
							<a href="${pageContext.request.contextPath}/Email/Email_receive.action?currentPage=${pageView.currentPage-1}">上一页</a>
						</c:if> <c:forEach var="i" begin="1" end="${pageView.totalPages}"
							step="1">
							<c:choose>
								<c:when test="${pageView.currentPage==i}">${i}&nbsp;&nbsp;</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath}/Email/Email_receive.action?currentPage=${i}">${i}</a>&nbsp;&nbsp;</c:otherwise>
							</c:choose>
						</c:forEach> <c:if test="${pageView.currentPage<pageView.totalPages}">
							<a href="${pageContext.request.contextPath}/Email/Email_receive.action?currentPage=${pageView.currentPage+1}">下一页</a>
						</c:if>
				</span></td>
			</tr>
		</table>
	</form>
</body>
</html>