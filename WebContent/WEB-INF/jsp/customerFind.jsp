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
function areUsure() {
	document.deleteForm.submit();
	alert("删除成功！");
	return true;
}
</script>
</head>
<body>
<%-- <%=basePath %> --%>
    <h1>客户查询列表</h1>
    <a href="<%=basePath %>customer/main" >返回</a>
    <form action="${pageContext.request.contextPath }/customer/delete"
		method="post" name="deleteForm">
	    <table>
	        <tr>        
	            <th>编号</th>
	            <th>姓名</th>
	            <th>电话</th>
	            <th>地址</th>
	        </tr>
	        <!-- JSTL标签，请参考本书的相关内容 -->
	        
	        <tr>
	            <td>${findCustomer.cnum }</td>
	            <td>${findCustomer.cname }</td>
	            <td>${findCustomer.cnumber }</td>
	            <td>${findCustomer.caddr }</td>
				<td colspan="2" align="center"><input type="button" value="删除"
					onclick="areUsure()" />
				</td>
	        </tr>
	      
	    </table>
    </form>
</body>
</html>

