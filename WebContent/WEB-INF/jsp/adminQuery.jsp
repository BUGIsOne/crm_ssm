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
<title>注册画面</title>
<script type="text/javascript">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	//注册时检查输入项
	function allIsNull() {
		var aname = document.queryForm.aname.value;
		if (aname == "") {
			alert("请输入用户名！");
			document.queryForm.aname.focus();
			return false;
		}
		document.queryForm.submit();
		return true;
	}
</script>
</head>
<body>
	<a href="<%=basePath %>admin/main" >返回</a>
	<form action="${pageContext.request.contextPath }/admin/find"
		method="post" name="queryForm">
		<table border=1 bgcolor="lightblue" align="center">
			<tr>
				<td>用户名（真实姓名）：</td>
				<td><input class="textSize" type="text" name="aname"
					value="${admin.aname }" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button" value="查询"
					onclick="allIsNull()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>