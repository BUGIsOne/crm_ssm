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
    <h1>活动列表</h1>
    <a href="<%=basePath %>activity/main" >返回</a>
    <table>
        <tr>
            <th>活动名称</th>
            <th>细节</th>
            <th>客户</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${activitys}" var="activity">
            <tr>
                <td>${activity.aitem }</td>
                <%-- <td>
                	<c:forEach items="${activitys.ext.hobby }" var="hobby">
                		${hobby }&nbsp;
                	</c:forEach>
                </td>
                <td>
                	<c:forEach items="${activitys.ext.friends }" var="friend">
                		${friend }&nbsp;
                	</c:forEach>
                </td> --%>
                <td>${activity.adetail}</td>
                <td>${activity.cus }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
