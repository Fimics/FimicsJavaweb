<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@include file="top.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>$title$</title>
</head>
<body>
<h1><%= "Hello World!" %>
    <% List list = new ArrayList();
//     int i = 3/0;
    %>
</h1>

<!--
    <h1>hello</h1>
-->
<%--
    <%
        System.out.println("hi~~~~");
    %>
--%>
<br/>
<a href="/hello">Hello Servlet</a>
<br/>
<a href="post.html">post</a>

<br/>
<a href="/req">Request</a>

<%
%>
</body>
</html>