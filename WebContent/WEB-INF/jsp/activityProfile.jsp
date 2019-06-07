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
	//注册时检查输入项
	function allIsNull() {
		var aitem = document.profileForm.aitem.value;
		var adetail = document.profileForm.adetail.value;
		var cus = document.profileForm.cus.value;
		if (aitem == "") {
			alert("请输入活动名称！");
			document.profileForm.aitem.focus();
			return false;
		}
		if (adetail == "") {
			alert("请输入细节！");
			document.profileForm.adetail.focus();
			return false;
		}
		if (cus == "") {
			alert("请输入客户！");
			document.profileForm.cus.focus();
			return false;
		}
		alert("添加成功！");
		document.profileForm.submit();
		return true;
	}
</script>
<title>活动资料</title>
</head>
<body>
	<h1 align="center">添加活动</h1>
	<form action="${pageContext.request.contextPath }/activity/profile"
		method="post" name="profileForm">
 	<table border=1 bgcolor="lavender" align="center">
		<tr>
			<td>活动名称：</td>
			<td><input class="textSize" type="text" name="aitem"
				value="${activity.aitem }" /></td>
		</tr>
		<tr>
			<td>细节：</td>
			<td><input class="textSize" type="text" name="adetail"
				value="${activity.adetail }" /></td>
		</tr>
		<tr>
			<td>客户：</td>
			<td><input class="textSize" type="text" name="cus"
				value="${activity.cus }" /></td>
		</tr>
        
        <tr>
			<td colspan="2" align="center"><input type="button" value="添加新活动"
					onclick="allIsNull()" /></td>
		</tr>
	</table>
	</form>
</body>
</html>
