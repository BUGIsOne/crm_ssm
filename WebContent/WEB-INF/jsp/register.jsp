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
	//注册时检查输入项
	function allIsNull() {
		var lgname = document.registForm.loginname.value;
		var pwd = document.registForm.psd.value;
		var repwd = document.registForm.repassword.value;
		var name = document.registForm.aname.value;
		if (lgname == "") {
			alert("请输入登陆名！");
			document.registForm.loginname.focus();
			return false;
		}
		if (name == "") {
			alert("请输入真实姓名！");
			document.registForm.aname.focus();
			return false;
		}
		if (pwd == "") {
			alert("请输入密码！");
			document.registForm.psd.focus();
			return false;
		}
		if (repwd == "") {
			alert("请输入确认密码！");
			document.registForm.repassword.focus();
			return false;
		}
		if (pwd != repwd) {
			alert("2次密码不一致，请重新输入！");
			document.registForm.psd.value = "";
			document.registForm.repassword.value = "";
			document.registForm.psd.focus();
			return false;
		}
		document.registForm.submit();
		return true;
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admin/register"
		method="post" name="registForm">
		<table border=1 bgcolor="lightblue" align="center">
			<tr>
				<td>姓名：</td>
				<td><input class="textSize" type="text" name="loginname"
					value="${admin.loginname }" /></td>
			</tr>

			<tr>
				<td>密码：</td>
				<td><input class="textSize" type="password" maxlength="20"
					name="psd" value="${admin.psd }" /></td>
			</tr>

			<tr>
				<td>确认密码：</td>
				<td><input class="textSize" type="password" maxlength="20"
					name="repassword" /></td>
			</tr>
			
			<tr>
				<td>真实姓名：</td>
				<td><input class="textSize" type="text" name="aname"
					value="${admin.aname }" /></td>
			</tr>
					
			<tr>
				<td>身份（“普通用户填写2”或“管理员填写1”）：</td>
				<td><input class="textSize" type="text" name="identity"
					value="${admin.identity }" /></td>
			</tr>
			
			<tr>
				<td>联系电话：</td>
				<td><input class="textSize" type="text" name="phonenumber"
					value="${admin.phonenumber }" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="button" value="注册"
					onclick="allIsNull()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>