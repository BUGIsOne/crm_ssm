<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</script>
</head>
<body>
<%-- <%=basePath %> --%>
    <h1>用户列表</h1>
    <a href="<%=basePath %>admin/main" >返回</a>
    <table>
        <tr>
            <th>登录名</th>
            <th>密码</th>
            <th>用户名</th>
            <th>身份</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${admins}" var="admin">
            <tr>
                <td>${admin.loginname }</td>
                <%-- <td>
                	<c:forEach items="${admin.ext.hobby }" var="hobby">
                		${hobby }&nbsp;
                	</c:forEach>
                </td>
                <td>
                	<c:forEach items="${admin.ext.friends }" var="friend">
                		${friend }&nbsp;
                	</c:forEach>
                </td> --%>
                <td>${admin.psd}</td>
                <td>${admin.aname }</td>
                <td>${admin.identity }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
