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
    <h1>服务信息列表</h1>
    <a href="<%=basePath %>feedback/main" >返回</a>
    <table>
        <tr>
            <th>商品id号</th>
            <th>顾客id号</th>
            <th>信息细节</th>
            <th>处理状态</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${feedbacks}" var="feedback">
            <tr>
                <td>${feedback.pid }</td>
                <%-- <td>
                	<c:forEach items="${feedbacks.ext.hobby }" var="hobby">
                		${hobby }&nbsp;
                	</c:forEach>
                </td>
                <td>
                	<c:forEach items="${feedbacks.ext.friends }" var="friend">
                		${friend }&nbsp;
                	</c:forEach>
                </td> --%>
                <td>${feedback.cid}</td>
                <td>${feedback.fitem }</td>
                <td>${feedback.period }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
