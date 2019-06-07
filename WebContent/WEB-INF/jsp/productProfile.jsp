<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户资料</title>
</head>
<body>
<form:form modelAttribute="product"  method="post" action=" ${pageContext.request.contextPath }/product/profile">
    <fieldset>
        <legend>添加物资信息</legend>
        <p>
            <label>编号:</label>
            <form:input path="pnum"/>
        </p>
        <p>
            <label>商品名称:</label>
            <form:input path="pname"/>
        </p>
        <p>
            <label>供货商id:</label>
            <form:input path="sid"/>
        </p>
        <p>
            <label>价格:</label>
            <form:input path="pprice"/>
        </p>
        <p>
            <label>数量:</label>
            <form:input path="pnumber"/>
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
