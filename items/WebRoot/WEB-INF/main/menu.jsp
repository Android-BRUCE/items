<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>menu</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/skin/css/menu.css" type="text/css" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	
     
     <c:forEach items="${menus }" var="pr">
     	<c:if test="${pr.menu_location==-1}">
     	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items${pr.menu_id}_1")'><b>${pr.menu_name}</b></dt>
       	 <dd style='display:block' class='sitem' id='items${pr.menu_id}_1'>
          <ul class='sitemu'>
           
           <c:forEach items="${menus }" var="pri">
           	<c:if test="${pri.menu_location==pr.menu_id }">
           		<li><a href='${pageContext.request.contextPath}${pri.menu_url}' target='main'>${pri.menu_name}</a></li>
           	</c:if>
           </c:forEach>
           
          </ul>
        </dd>
      </dl>
       <!-- Item  End -->
      </c:if>
      </c:forEach>
      
    <%-- 
     
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>任务管理</b></dt>
        <dd style='display:none' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='task-add.html' target='main'>创建任务</a> </li>
            <li><a href='task.html' target='main'>任务信息</a> </li>
            <li><a href='task-my.html' target='main'>我的任务</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items3_1")'><b>信息箱</b></dt>
        <dd style='display:none' class='sitem' id='items3_1'>
          <ul class='sitemu'>
            <li><a href='message-seed.html' target='main'>发信息</a> </li>
            <li><a href='message.html' target='main'>发件箱</a> </li>
            <li><a href='message-give.html' target='main'>收件箱</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items4_1")'><b>客户信息管理</b></dt>
        <dd style='display:none' class='sitem' id='items4_1'>
          <ul class='sitemu'>
            <li><a href='customer.html' target='main'>客户信息</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items5_1")'><b>权限管理</b></dt>
        <dd style='display:none' class='sitem' id='items5_1'>
          <ul class='sitemu'>
            <li><a href='user.html' target='main'>人员管理</a> </li>
            <li><a href='role.html' target='main'>角色管理</a> </li>
            <li><a href='resources.html' target='main'>菜单资源管理</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items6_1")'><b>我的信息</b></dt>
        <dd style='display:none' class='sitem' id='items6_1'>
          <ul class='sitemu'>
            <li><a href='info.html' target='main'>信息查看</a> </li>
            <li><a href='modpassword.html' target='main'>修改密码</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
    --%>  
	  </td>
  </tr>
</table>
</body>
</html>