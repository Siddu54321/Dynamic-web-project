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
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <form action="<c:url value='/update'/>" method="post">
                    <h2>Edit Candidate</h2>
                    <c:if test="${candidate != null}">
                        <input type="hidden" name="id" value="<c:out value='${candidate.id}'/>" />
                    </c:if>
                    <fieldset class="form-group">
                        <label>Name</label>
                        <input type="text" value="<c:out value='${candidate.name}'/>" class="form-control" name="name">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Gender</label>
                        <input type="text" value="<c:out value='${candidate.gender}'/>" class="form-control" name="gender">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Email</label>
                        <input type="text" value="<c:out value='${candidate.email}'/>" class="form-control" name="email">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Qualification</label>
                        <input type="text" value="<c:out value='${candidate.qualification}'/>" class="form-control" name="qualification">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>State</label>
                        <input type="text" value="<c:out value='${candidate.state}'/>" class="form-control" name="state">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
