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
    <h1>物资查询列表</h1>
    <a href="<%=basePath %>product/main" >返回</a>
    <form action="${pageContext.request.contextPath }/product/delete"
		method="post" name="deleteForm">
	    <table>
	        <tr>        
	            <th>编号</th>
	            <th>商品名称</th>
	            <th>供货商id</th>
	            <th>价格</th>
	            <th>数量</th>
	        </tr>
	        <!-- JSTL标签，请参考本书的相关内容 -->
	        
	        <tr>
	            <td>${findProduct.pnum }</td>
	            <td>${findProduct.pname }</td>
	            <td>${findProduct.sid }</td>
	            <td>${findProduct.pprice }</td>
	            <td>${findProduct.pnumber }</td>
				<td colspan="2" align="center"><input type="button" value="删除"
					onclick="areUsure()" />
				</td>
	        </tr>
	      
	    </table>
    </form>
</body>
</html>

