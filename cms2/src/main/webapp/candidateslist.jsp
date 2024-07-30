<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
    <title>Candidate Management System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ccms.css">
    
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #1E2C76">
        <div>
            <img src="<c:url value='images/1.png'/>" alt="Logo">
        </div>
        <div class="navbar-brand">Candidate Management System</div>
        <div class="ml-auto">
            <a href="<c:url value='/new' />" class="btn btn-success">Add New Candidate</a>
        </div>
        <div class="ml-auto">
            <a href="<c:url value='/logout' />" class="btn btn-danger">Logout</a>
        </div>
    </nav>
</header>
<br>


    <div class="containertab">
        <h3 class="text-center">Candidates List</h3>
        <%-- <hr>
        <div class="container text-left">
            <a href="<c:url value='/new' />" class="btn btn-success">Add New Candidate</a>
        </div> --%>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Qualification</th>
                    <th>State</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="candidate" items="${listCandidate}">
                    <tr>
                        <td><c:out value="${candidate.id}" /></td>
                        <td><c:out value="${candidate.name}" /></td>
                        <td><c:out value="${candidate.gender}" /></td>
                        <td><c:out value="${candidate.email}" /></td>
                        <td><c:out value="${candidate.qualification}" /></td>
                        <td><c:out value="${candidate.state}" /></td>
                        <td>
                            <a href="<c:url value='/edit?id=${candidate.id}' />" class="btn btn-primary">Edit</a>
                            <a href="<c:url value='/delete?id=${candidate.id}' />" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


</body>
</html>
