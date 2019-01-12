<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>View Account</title>

</head>
<body>

	<header><jsp:include page="header.html"></jsp:include> </header>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th><a href="sortByAccountNumber">Account Number</a></th>
					<th><a href="sortbyAccountHolderName">Holder Name</a></th>
					<th><a href="sortByAccountBalance">Account Balance </a></th>
					<th><a href="sortBySalary">Salary</a></th>
					<th>Over Draft Limit</th>
					<th>Type Of Account</th>
				</tr>

			</thead>
			<tbody>
				<jstl:forEach var="account" items="${accounts }">
					<tr>
						<td>${account.bankAccount.accountNumber}</td>
						<td>${account.bankAccount.accountHolderName}</td>
						<td>${account.bankAccount.accountBalance}</td>
						<td>${account.salary}</td>
					</tr>

				</jstl:forEach>
			</tbody>
		</table>
	</div>
	<footer> <jsp:include page="footer.html"></jsp:include> </footer>

</body>
</html>