<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ccms.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-light">
        <div>
            <img src="<c:url value='/images/1.png' />" alt="Logo">
        </div>
        <div class="navbar-brand">
            <h1 class="text-primary">
                Candidate Management System
            </h1>
        </div>
    </nav>
</header>
<br>
<div class="container">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <input type="submit" value="Login">
        </div>
    </form>

    <c:if test="${not empty loginFailed}">
        <p class="error-message">Login failed. Please check your credentials.</p>
    </c:if>
</div>
</body>
</html>
