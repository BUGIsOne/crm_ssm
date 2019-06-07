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
		var pnum = document.profileForm.pnum.value;
		var pname = document.profileForm.pname.value;
		var sid = document.profileForm.sid.value;
		var pprice = document.profileForm.pprice.value;
		var pnumber = document.profileForm.pnumber.value;
		if (pnum == "") {
			alert("请输入编号！");
			document.profileForm.pnum.focus();
			return false;
		}
		if (pname == "") {
			alert("请输入商品名称！");
			document.profileForm.pname.focus();
			return false;
		}
		if (sid == "") {
			alert("请输入供货商id！");
			document.profileForm.sid.focus();
			return false;
		}
		if (pprice == "") {
			alert("请输入数量！");
			document.profileForm.pprice.focus();
			return false;
		}
		if (pnumber == "") {
			alert("请输入价格！");
			document.profileForm.pnumber.focus();
			return false;
		}
		alert("添加成功！");
		document.profileForm.submit();
		return true;
	}
</script>
<title>产品资料</title>
</head>
<body>
	<h1 align="center">添加产品</h1>
	<form action="${pageContext.request.contextPath }/product/profile"
		method="post" name="profileForm">
 	<table border=1 bgcolor="lavender" align="center">
		<tr>
			<td>编号：</td>
			<td><input class="textSize" type="text" name="pnum"
				value="${product.pnum }" /></td>
		</tr>
		<tr>
			<td>商品名称：</td>
			<td><input class="textSize" type="text" name="pname"
				value="${product.pname }" /></td>
		</tr>
		<tr>
			<td>供货商id：</td>
			<td><input class="textSize" type="text" name="sid"
				value="${product.sid }" /></td>
		</tr>
		<tr>
			<td>数量：</td>
			<td><input class="textSize" type="text" name="pprice"
				value="${product.pprice }" /></td>
		</tr>
		<tr>
			<td>价格：</td>
			<td><input class="textSize" type="text" name="pnumber"
				value="${product.pnumber }" /></td>
		</tr>
        
        <tr>
			<td colspan="2" align="center"><input type="button" value="添加新产品"
					onclick="allIsNull()" /></td>
		</tr>
	</table>
	</form>
</body>
</html>
