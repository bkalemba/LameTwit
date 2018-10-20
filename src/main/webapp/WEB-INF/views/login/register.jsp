<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 20.10.18
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/resources/style/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/style/main.css" rel="stylesheet">
    <title>LameTwit</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <form:form method="post" modelAttribute="user">
                <div class="form-group">
                    <label>email:</label>
                    <form:input path="email" cssClass="form-control"/>
                    <form:errors path="email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label>username:</label>
                    <form:input path="username" cssClass="form-control"/>
                    <form:errors path="username" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label>password:</label>
                    <form:password path="password" cssClass="form-control"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
                <button type="submit" class="btn btn-primary">Register</button>
            </form:form>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>
</html>
