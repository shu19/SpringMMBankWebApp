<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

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
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>HDFC Bank</title>

<style type="text/css">
.error {
	color: red
}
</style>

</head>
<body>
	<header>
		<jsp:include page="header.html"></jsp:include>
	</header>
	<div class="container col-md-4 col-md-offset-4">

		<spring:form action="addNewSA" method="post" modelAttribute="account">
			<div class="form-group">
				<label>Name :</label>
				<spring:input class="form-control" placeholder="Name"
					path="bankAccount.accountHolderName" />
				<spring:errors path="bankAccount.accountHolderName" cssClass="error"></spring:errors>
			</div>

			<div class="form-group">
				<label>Initial Balance :</label>
				<spring:input class="form-control"
					placeholder="Enter initial number"
					path="bankAccount.accountBalance" />
				<spring:errors path="bankAccount.accountBalance" cssClass="error"></spring:errors>
			</div>

			<div class="form-group">
				<label>Salary Account:</label>
				<%-- <spring:input type="radio" path="salary" value="Yes" />
				Yes
				<spring:input  path="salary" value="No" /> --%>
				<%-- <spring:radiobuttons path="salary"/> --%>
				<spring:radiobutton path="salary" value="Yes"/>
				Yes
				<spring:radiobutton path="salary" value="No"/>
				No
				<spring:errors path="salary" cssClass="error"></spring:errors>
			</div>

			<div>
				<button type="submit" class="btn btn-default "
					style="margin-top: 16px;">Submit</button>
				<button type="reset" class="btn btn-danger"
					style="margin-top: 16px; float: right;">Reset</button>
			</div>

		</spring:form>

	</div>

	<footer>
		<jsp:include page="footer.html"></jsp:include>
	</footer>
</body>
</html>