<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<title>HDFC Bank</title>
<style type="text/css">
nav {
	margin-top: -70px;
}

header {
	padding: 10px;
}

.footer-bottom {
	padding: 25px 0 25px;
	border-top: 1px solid #666;
	background: #1e1e1e;
}

.copyright-text p {
	color: #ccc;
	margin-top: 0px;
	margin-bottom: 0;
	text-align: center;
}

footer {
	position: relative;
	margin-top: 538px;
	margin-bottom: 0px;
}
</style>


</head>
<body>

	<header>
		<jsp:include page="header.html"></jsp:include>
	</header>


	<div class="container-fluid" style="text-align: center;">

		<h1>Welcome to HDFC Bank !!!</h1>
<!-- 		<a href="signIn.html">Sign In</a>
 -->
	</div>

	<footer>
		<jsp:include page="footer.html"></jsp:include>
	</footer>



	<!-- <div>
		<ul>
			<li><a href="addNewSA.mm">Add New Savings Account</a></li>
			<li><a href="closeSA.mm">Close Saving Account</a></li>
		</ul>
	</div> -->

</body>
</html>