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
    <h1>商品列表</h1>
    <a href="<%=basePath %>product/main" >返回</a>
    <table>
        <tr>
            <th>编号</th>
            <th>商品名称</th>
            <th>供货商id</th>
            <th>价格</th>
            <th>数量</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.pnum }</td>
                <%-- <td>
                	<c:forEach items="${product.ext.hobby }" var="hobby">
                		${hobby }&nbsp;
                	</c:forEach>
                </td>
                <td>
                	<c:forEach items="${product.ext.friends }" var="friend">
                		${friend }&nbsp;
                	</c:forEach>
                </td> --%>
                <td>${product.pname}</td>
                <td>${product.sid }</td>
                <td>${product.pprice }</td>
                <td>${product.pnumber }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
