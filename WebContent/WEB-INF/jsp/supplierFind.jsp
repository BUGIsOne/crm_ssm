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
    <h1>供货商查询列表</h1>
    <a href="<%=basePath %>supplier/main" >返回</a>
    <form action="${pageContext.request.contextPath }/supplier/delete"
		method="post" name="deleteForm">
	    <table>
	        <tr>        
	            <th>编号</th>
	            <th>公司名</th>
	            <th>地址</th>
	            <th>电话</th>
	        </tr>
	        <!-- JSTL标签，请参考本书的相关内容 -->
	        
	        <tr>
	            <td>${findSupplier.snum }</td>
	            <td>${findSupplier.sname }</td>
	            <td>${findSupplier.saddr }</td>
	            <td>${findSupplier.snumber }</td>
				<td colspan="2" align="center"><input type="button" value="删除"
					onclick="areUsure()" />
				</td>
	        </tr>
	      
	    </table>
    </form>
</body>
</html>

