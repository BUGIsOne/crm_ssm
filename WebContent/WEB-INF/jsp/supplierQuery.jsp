<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.textSize {
	width: 100pt;
	height: 15pt
}
</style>
<title>查询画面</title>
<script type="text/javascript">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	
	function allIsNull() {
		var sname = document.queryForm.sname.value;
		if (sname == "") {
			alert("请输入供货商公司名称！");
			document.queryForm.sname.focus();
			return false;
		}
		document.queryForm.submit();		
		return true;
	}
</script>
</head>
<body>
	<a href="<%=basePath %>supplier/main" >返回</a>
	<form action="${pageContext.request.contextPath }/supplier/find"
		method="post" name="queryForm">
		<table border=1 bgcolor="lightblue" align="center">
			<tr>
				<td>供货商公司名称：</td>
				<td><input class="textSize" type="text" name="sname"
					value="${supplier.sname }" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button" value="查询"
					onclick="allIsNull()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>