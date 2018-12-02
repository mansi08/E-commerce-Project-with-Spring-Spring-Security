<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="Header.jsp"%>

	<div class="container">
		<table class="table" border="1">

			<tr>
				<td rowspan="15"><img
					src="<c:url value="/resources/images/product/${product.code}.jpg"/>"
					width="600" height="300" /></td>
			</tr>

			<tr>
				<td>Product ID</td>
				<td>${product.productId}</td>
			</tr>

			<tr>
				<td>Product Name</td>
				<td>${product.productName}</td>
			</tr>
<tr>
				<td>Product Brand</td>
				<td>${product.brand}</td>
			</tr>

			<tr>
				<td>Product Price</td>
				<td>${product.productPrice}</td>
			</tr>

			<tr>
				<td>Product Colour</td>
				<td>${product.colour}</td>
			</tr>

			<tr>
				<td>Product Size</td>
				<td>${product.size}</td>
			</tr>

			<tr>
				<td>Product Stock</td>
				<td>${product.stock}</td>
			</tr>
			<tr>
				<td>Supplier ID</td>
				<td>${product.supplier_Id}</td>
			</tr>

			<tr>
				<td>Category</td>
				<td>${categoryname}</td>
			</tr>

			<form action="<c:url value="/AddToCart/${product.productId}"/>"
				method="get">

				<tr>
					<td>Quantity</td>

					<td> <select name="quantity" class="form-control btn-block">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
					</select> </td>
				</tr>

				<tr>
					<td colspan="3"><input type="submit" value="AddToCart"
						class="btn btn-info btn-block" /></td>
				</tr>
			</form>
		</table>
	</div>
