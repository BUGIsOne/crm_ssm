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
    <h1>进货列表</h1>
    <a href="<%=basePath %>stock_in/main" >返回</a>
    <table>
        <tr>
            <th>产品编号</th>
            <th>供应商编号</th>
            <th>数量</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${stock_ins}" var="stock_in">
            <tr>
                <td>${stock_in.pnum }</td>
                <td>${stock_in.sid}</td>
                <td>${stock_in.numberIn }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
