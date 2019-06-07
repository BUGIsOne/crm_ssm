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
    <h1>客户列表</h1>
    <a href="<%=basePath %>customer/main" >返回</a>
    <table>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>电话</th>
            <th>地址</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.cnum }</td>
                <%-- <td>
                	<c:forEach items="${customers.ext.hobby }" var="hobby">
                		${hobby }&nbsp;
                	</c:forEach>
                </td>
                <td>
                	<c:forEach items="${customers.ext.friends }" var="friend">
                		${friend }&nbsp;
                	</c:forEach>
                </td> --%>
                <td>${customer.cname}</td>
                <td>${customer.cnumber }</td>
                <td>${customer.caddr }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
