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
    <h1>出货列表</h1>
    <a href="<%=basePath %>stock_out/main" >返回</a>
    <table>
        <tr>
            <th>产品编号</th>
            <th>顾客编号</th>
            <th>数量</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${stock_outs}" var="stock_out">
            <tr>
                <td>${stock_out.pnum }</td>
                <td>${stock_out.cid}</td>
                <td>${stock_out.numberOut }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
