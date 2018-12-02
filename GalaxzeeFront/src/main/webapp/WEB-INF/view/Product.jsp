<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="Header.jsp"%>

<h1>Product</h1>
<hr />

<!-- TOGGLE BUTTONS -->
<c:if test="${UserClickedEdit==true }">
	<c:set var="url" value="UpdateProrduct" />
</c:if>

<c:if test="${UserClickedEdit!=true }">
	<c:set var="url" value="SaveProduct" />
</c:if>

<!--  FORM FOR ENTERING DETAILS -->

<form:form action="${pageContext.request.contextPath}/${url }"
	method="post" enctype="multipart/form-data" modelAttribute="product">

	<!-- HIDDING PRODUCT ID SO NO ONE CAN EDIT -->
	<c:if test="${UserClickedEdit==true}">
		<form:hidden path="productId" />
	</c:if>

<table>
<tr>
<td>PRODUCT NAME</td>
<td><form:input path="productName" placeholder="ProductName" /></td>
</tr>

<tr>
<td>PRODUCT DESCRIPTION </td>	
<td> <form:input path="productDescription" placeholder="productDescription" /></td>
</tr>

<tr>
<td>PRODUCT PRICE:</td>
<td> <form:input path="productPrice" placeholder="productPrice" /></td>
</tr>


<tr>
<td>PRODUCT BRAND</td>
<td><form:input path="brand" placeholder="ProductName" /></td>
</tr>

<tr>
<td>COLOUR</td>
<td><form:input path="colour" placeholder="Colour" /> </td>
</tr>

<tr>
<td>SIZE:</td>	
<td> <form:input path="size" placeholder="Size" /></td>
</tr>

<tr>
<td>STOCK</td>
<td><form:input path="stock" placeholder="Stock" /></td>
</tr>

<tr>
<td>CATEGORY ID</td>	
<td><form:select path="categoryId" items="${categoryList}" itemLabel="categoryName" itemValue="categoryId" /></td>
</tr>

<tr>
<td>SUPPLIER ID</td>	
<td><form:select path="supplier_Id" items="${supplierList}" itemLabel="supplier_Name" itemValue="supplier_Id" /></td>
</tr>

<tr>
<td>IMAGE</td>
<td><form:input path="file" type="file" /></td>
</tr>
	</table>
	
	<!-- Button -->
	<c:if test="${UserClickedEdit==true}">
		<input type="submit" value="Update Product" />
	</c:if>

	<c:if test="${UserClickedEdit!=true}">
		<input type="submit" value="Save Product" />
	</c:if>
</form:form>

<!-- DISPLAYING THE CONTENT -->

<table align="center" border="1">
	<thead bgcolor="pink">
		<tr>
			<th>ID</th>
			<th>IMAGE</th>
			<th>NAME</th>
			<th>Brand</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			<th>COLOUR</th>
			<th>SIZE</th>
			<th>STOCK</th>
			<th>CATEGORY ID</th>
			<th>SUPPLIER ID</th>
			<th>ACTION</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.productId}</td>
				<td><img src="resources/images/product/${product.code}.jpg"
							height="500px" width="300px" /></td>
				<td>${product.productName}</td>
				<td>${product.productDescription}</td>
				<td>${product.productPrice}</td>
				<td>${product.brand}</td>
				<td>${product.colour}</td>
				<td>${product.size}</td>
				<td>${product.stock}</td>
				<td>${product.categoryId}</td>
				<td>${product.supplier_Id}</td>
				<td><a
					href="${pageContext.request.contextPath}/editProduct/${product.productId}" class="btn btn-info">Edit</a>
					<a
					href="${pageContext.request.contextPath}/deleteProduct/${product.productId}" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>