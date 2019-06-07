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
		var pid = document.profileForm.pid.value;
		var cid = document.profileForm.cid.value;
		var fitem = document.profileForm.fitem.value;
		var period = document.profileForm.period.value;
		if (pid == "") {
			alert("请输入商品id号！");
			document.profileForm.pid.focus();
			return false;
		}
		if (cid == "") {
			alert("请输入顾客id号！");
			document.profileForm.cid.focus();
			return false;
		}
		if (fitem == "") {
			alert("请输入信息细节！");
			document.profileForm.fitem.focus();
			return false;
		}
		if (period == "") {
			alert("请输入处理状态！");
			document.profileForm.period.focus();
			return false;
		}

		document.profileForm.submit();
		alert("添加成功！");
		return true;
	}
</script>
</head>
<body>
	<h1 align="center">添加服务信息</h1>
	<form action="${pageContext.request.contextPath }/feedback/profile"
		method="post" name="profileForm">
		<table border=1 bgcolor="lavender" align="center">
			<tr>
				<td>商品id号：</td>
				<td><input class="textSize" type="text" name="pid"
					value="${feedback.pid }" /></td>
			</tr>

			<tr>
				<td>顾客id号：</td>
				<td><input class="textSize" type="text" maxlength="20"
					name="cid" value="${feedback.cid }" /></td>
			</tr>

			<tr>
				<td>信息细节：</td>
				<td><input class="textSize" type="text" maxlength="20"
					name="fitem" value="${feedback.fitem }" /></td>
			</tr>
			
			<tr>
				<td>处理状态：</td>
				<td><input class="textSize" type="text" name="period"
					value="${feedback.period }" /></td>
			</tr>

			
			<tr>
				<td colspan="2" align="center"><input type="button" value="添加新服务信息"
					onclick="allIsNull()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>