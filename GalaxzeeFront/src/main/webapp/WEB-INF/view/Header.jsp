
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	
</script>
<style type="text/css">
#mycontainer {
	background-color: orange;
}
</style>
</head>
<body>
	<div id="mycontainer" class="container">social icon</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Galaxzee</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/">Home</a></li>
				<c:if test="${!sessionScope.loggedIn}">
					<li><a href="login">Login</a></li>
					<li><a href="Register">Register</a></li>
					<li><a href="ContactUs">Contact Us</a></li>
					<li><a href="AboutUs">About Us</a></li>
				</c:if>
				<c:if test="${sessionScope.loggedIn}">
					<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
						<li><a href="Category">Category</a></li>
						<li><a href="Product">Product</a></li>
						<li><a href="Supplier">Supplier</a></li>
					</c:if>
					<c:if test="${sessionScope.role=='ROLE_USER'}">
						
						<li><a href="ProductDisplay">Display Product</a></li>
						<li><a 	href="Cart">Cart</a></li>
					</c:if>
				</c:if>
			</ul>
		</div>
		<div class="nav navbar-nav navbar-right">
			<c:if test="${sessionScope.loggedIn}"> 
				<font color="white" face="calibri" size="3">Welcome
					:${username}</font>
				<a href="perform_logout"><font color="white" face="calibri" size="2">LOGOUT</font></a>


			</c:if>

		</div>





	</nav>





</body>
</html>