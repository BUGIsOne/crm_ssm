<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
<div>

<a href="${pageContext.request.contextPath }/admin/list">用户列表</a><br>
<a href="${pageContext.request.contextPath }/index/admin/find">查找用户</a><br>
<!-- 由原先的修改信息变为添加信息  -->
<a href="${pageContext.request.contextPath }/index/admin/profile">添加用户</a><br><br>

<a href="${pageContext.request.contextPath }/customer/list">客户列表</a><br>
<a href="${pageContext.request.contextPath }/index/customer/find">查找客户</a><br>
<a href="${pageContext.request.contextPath }/index/customer/profile">添加客户</a><br><br>

<a href="${pageContext.request.contextPath }/supplier/list">供应商列表</a><br>
<a href="${pageContext.request.contextPath }/index/supplier/find">查找供应商</a><br>
<a href="${pageContext.request.contextPath }/index/supplier/profile">添加供应商</a><br><br>

<a href="${pageContext.request.contextPath }/product/list">物资列表</a><br>
<a href="${pageContext.request.contextPath }/stock_in/list">进货列表</a><br>
<a href="${pageContext.request.contextPath }/stock_out/list">出货列表</a><br>
<a href="${pageContext.request.contextPath }/index/product/find">查找物资</a><br>
<a href="${pageContext.request.contextPath }/index/product/profile">添加物资</a><br><br>

<a href="${pageContext.request.contextPath }/activity/list">活动信息列表</a><br>
<a href="${pageContext.request.contextPath }/index/activity/find">查找活动</a><br>
<a href="${pageContext.request.contextPath }/index/activity/profile">添加活动信息</a><br><br>

<a href="${pageContext.request.contextPath }/feedback/list">服务信息列表</a><br>
<a href="${pageContext.request.contextPath }/index/feedback/find">查找服务</a><br>
<a href="${pageContext.request.contextPath }/index/feedback/profile">添加服务信息</a><br><br>

<a href="${pageContext.request.contextPath }/admin/logout">注销</a>
</div>
</body>
</html>