<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="header">
    <ul>
        <li><a href="${pageContext.request.contextPath}/home" class="<c:if test='${activePage == "/home" }'>active</c:if>">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/student" class="<c:if test='${activePage =="/student" }'>active</c:if>">Student</a></li>
        <li><a href="${pageContext.request.contextPath}/course" class="<c:if test='${activePage == "/course"}'>active</c:if>">Course</a></li>
        <li><a href="${pageContext.request.contextPath}/login" class="<c:if test='${activePage == "/login"}'>active</c:if>">Login</a></li>
        <li><a href="${pageContext.request.contextPath}/help" class="<c:if test='${activePage == "/help" }'>active</c:if>">Help</a></li>
    </ul>
</nav>