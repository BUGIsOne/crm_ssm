<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户资料</title>
</head>
<body>
<form:form modelAttribute="supplier"  method="post" action=" ${pageContext.request.contextPath }/supplier/profile">
    <fieldset>
        <legend>添加供货商信息</legend>
        <p>
            <label>编号:</label>
            <form:input path="snum"/>
        </p>
        <p>
            <label>公司名:</label>
            <form:input path="sname"/>
        </p>
        <p>
            <label>地址:</label>
            <form:input path="saddr"/>
        </p>
        <p>
            <label>电话:</label>
            <form:input path="snumber"/>
        </p>
       
        
        <p id="buttons">
            <input id="reset" type="reset">
            <input id="submit" type="submit" value="保存">
        </p>
        <form:input type="hidden" path="id" />
        <%-- <form:input type="hidden" path="ext.id" /> --%>
    </fieldset>
</form:form>
</body>
</html>
