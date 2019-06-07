<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户资料</title>
</head>
<body>
<form:form modelAttribute="feedback"  method="post" action=" ${pageContext.request.contextPath }/feedback/profile">
    <fieldset>
        <legend>添加服务信息</legend>
        <p>
            <label>商品id号:</label>
            <form:input path="pid"/>
        </p>
        <p>
            <label>顾客id号:</label>
            <form:input path="cid"/>
        </p>
        <p>
            <label>信息细节:</label>
            <form:input path="fitem"/>
        </p>
        <p>
            <label>处理状态:</label>
            <form:input path="period"/>
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
