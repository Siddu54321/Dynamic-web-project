<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Candidate Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ccms.css">

</head>

<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #1E2C76">
			<div>
				<img src="<c:url value='images/1.png'/>" alt="Logo">
			</div>
			<div class="navbar-brand">Candidate Management System</div>
			<div class="ml-auto">
				<a href="<%=request.getContextPath()%>/list" class="nav-link"
					style="color: #fff; font-weight: bold; background-color: #007bff; padding: 10px 20px; border-radius: 5px;">Candidates
					List</a>
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


				<form name="myform" action="insert" method="post"">


					<h1>
						Add New Candidate
					</h1>





					<fieldset class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							name="name" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Gender</label> <input type="text" class="form-control"
							name="gender" required>
					</fieldset>


					<fieldset class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Qualification</label> <input type="text"
							class="form-control" name="qualification" required>
					</fieldset>

					<fieldset class="form-group">
						<label>State</label> <input type="text" class="form-control"
							name="state" required>
					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>