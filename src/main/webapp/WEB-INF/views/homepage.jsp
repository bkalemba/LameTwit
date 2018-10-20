<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: benek
  Date: 20.10.18
  Time: 11:19
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
<jsp:include page="fragments/navbar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <form:form method="post" modelAttribute="tweet">
                <div class="form-group">
                    <form:textarea path="text" cssClass="form-control"/>
                    <form:errors path="text" cssClass="error"/>
                    <button type="submit" class="btn btn-primary">Post</button>
                </div>
            </form:form>
        </div>
        <div class="col-3"></div>
    </div>

    <div class="row">
        <div class="col-4"></div>
        <div class="col-4 text-center"><h3>Tweets</h3></div>
        <div class="col-4"></div>
    </div>
    <%--<div class="row"--%>
    <c:forEach items="${tweets}" var="t">
        <div class="container tweet rounded">
            <div class="row">
                <c:set var = "dateTime" value = "${fn:split(t.created,'T')}"/>
                <div class="col-6">${t.user.username}</div>
                <div class="col-6 text-right">${dateTime[0]} ${dateTime[1]}</div>
            </div>
            <div class="row">
                <div class="col-1"></div>
                <div class="col-9 tweetmsg rounded">${t.text}</div>
            </div>
        </div>
        <%--<c:set var = "dateTime" value = "${fn:split(t.created,'T')}"/>--%>

        <%--<div class="row">--%>
            <%--<div class="col-1"></div>--%>
            <%--<div class="col-1">${t.user.username}</div>--%>
            <%--<div class="col-6">${t.text}</div>--%>
            <%--<div class="col-2">${dateTime[0]}<br>${dateTime[1]}</div>--%>
            <%--<div class="col-2"></div>--%>
        <%--</div>--%>
    </c:forEach>

</div>
</body>
</html>
