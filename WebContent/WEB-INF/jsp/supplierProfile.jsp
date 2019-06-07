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
<title>添加画面</title>
<script type="text/javascript">

	function allIsNull() {
		var snum = document.profileForm.snum.value;
		var sname = document.profileForm.sname.value;
		var saddr = document.profileForm.saddr.value;
		var snumber = document.profileForm.snumber.value;
		if (snum == "") {
			alert("请输入编号！");
			document.profileForm.snum.focus();
			return false;
		}
		if (sname == "") {
			alert("请输入公司名！");
			document.profileForm.sname.focus();
			return false;
		}
		if (saddr == "") {
			alert("请输入地址！");
			document.profileForm.saddr.focus();
			return false;
		}
		if (snumber == "") {
			alert("请输入电话！");
			document.profileForm.snumber.focus();
			return false;
		}

		document.profileForm.submit();
		alert("添加成功！");
		return true;
	}
</script>
</head>
<body>
	<h1 align="center">添加供货商</h1>
	<form action="${pageContext.request.contextPath }/supplier/profile"
		method="post" name="profileForm">
		<table border=1 bgcolor="lavender" align="center">
			<tr>
				<td>编号：</td>
				<td><input class="textSize" type="text" name="snum"
					value="${supplier.snum }" /></td>
			</tr>

			<tr>
				<td>公司名：</td>
				<td><input class="textSize" type="text" maxlength="20"
					name="sname" value="${supplier.sname }" /></td>
			</tr>

			<tr>
				<td>地址：</td>
				<td><input class="textSize" type="text" maxlength="20"
					name="saddr" value="${supplier.saddr }" /></td>
			</tr>
			
			<tr>
				<td>电话：</td>
				<td><input class="textSize" type="text" name="snumber"
					value="${supplier.snumber }" /></td>
			</tr>

			
			<tr>
				<td colspan="2" align="center"><input type="button" value="添加新供应商"
					onclick="allIsNull()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>