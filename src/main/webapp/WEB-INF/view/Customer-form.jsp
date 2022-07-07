<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>

<body>

	<div class="container">

		<h2 class="bg-success text-white text-center">Customer
			Relationship Management</h2>


		<p class="h4 mb-4">Save Customer</p>

		<form action="/CustomerRelationshipManagement/customer/save"
			method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<label style="padding-right: 100px; height: 46px;">First
					Name: </label> <input style="height: 40px;" type="text" name="firstname"
					value="${Customer.firstName}" class="form-control mb-4 col-4"
					placeholder="firstname">

			</div>

			<div class="form-inline">
				<label style="padding-right: 100px; height: 46px;">Last
					Name:</label> <input style="height: 40px;" type="text" name="lastname"
					value="${Customer.lastName}" class="form-control mb-4 col-4"
					placeholder="lastname">
			</div>

			<div class="form-inline">
				<label style="padding-right: 140px; height: 46px;"> email: </label>
				<input style="padding-left: 30px; height: 40px" type="email"
					name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="email">
			</div>
			<br> <br>
			<button style="margin-left: 100;" type="submit"
				class="btn btn-info col-2">Save</button>

		</form>

		<a href="/CustomerRelationshipManagement/customer/list">Back to
			Students List</a>

	</div>
</body>

</html>










