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
<script type="text/javascript">
	function allIsNull() {
		var cnum = document.profileForm.cnum.value;
		var cname = document.profileForm.cname.value;
		var cnumber = document.profileForm.cnumber.value;
		var caddr = document.profileForm.caddr.value;
		if (cnum == "") {
			alert("请输入编号！");
			document.profileForm.cnum.focus();
			return false;
		}
		if (cname == "") {
			alert("请输入姓名！");
			document.profileForm.cname.focus();
			return false;
		}
		if (cnumber == "") {
			alert("请输入电话！");
			document.profileForm.cnumber.focus();
			return false;
		}
		if (caddr == "") {
			alert("请输入地址！");
			document.profileForm.caddr.focus();
			return false;
		}
		alert("添加成功！");
		document.profileForm.submit();
		return true;
	}
</script>
<title>客户资料</title>
</head>
<body>
	<h1 align="center">添加客户</h1>
	<form action="${pageContext.request.contextPath }/customer/profile"
		method="post" name="profileForm">
 	<table border=1 bgcolor="lavender" align="center">
		<tr>
			<td>编号：</td>
			<td><input class="textSize" type="text" name="cnum"
				value="${customer.cnum }" /></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input class="textSize" type="text" name="cname"
				value="${customer.cname }" /></td>
		</tr>
		<tr>
			<td>电话：</td>
			<td><input class="textSize" type="text" name="cnumber"
				value="${customer.cnumber }" /></td>
		</tr>
        <tr>
			<td>地址：</td>
			<td><input class="textSize" type="text" name="caddr"
				value="${customer.caddr }" /></td>
		</tr>
		
        <tr>
			<td colspan="2" align="center"><input type="button" value="添加新客户"
					onclick="allIsNull()" /></td>
		</tr>
	</table>
	</form>
</body>
</html>
