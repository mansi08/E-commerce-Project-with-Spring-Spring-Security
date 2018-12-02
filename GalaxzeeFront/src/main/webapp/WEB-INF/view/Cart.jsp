<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<table>
		<tr class="danger">
			<td colspan="4"><center><h3>Your Cart</h3></center></td>
		</tr>
		<c:if test="${grandTotal!=0}">
			<tr>
				
				<td>Product ID</td>
				<td>Product Name</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>SubTotal</td>
				<td>Operation</td>
			</tr>
		</c:if>

		<c:if test="${grandTotal==0}">
			<tr>
				<td>
					<h1>Your cart is empty please add atleast one product</h1>
				</td>
			</tr>
		</c:if>

		<c:forEach items="${cartItems}" var="cartItem">
			<form
				action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>"
				method="get">
			<tr>
				<td>${cartItem.productId}</td>
				<td>${cartItem.productName}</td>
				<td><input type="text" name="quantity" value="${cartItem.quantity}"/></td>
				<td>${cartItem.productPrice}</td>
				<td>${cartItem.subtotal}</td>
				<td><input type="submit" value="Update" class="btn btn-info" />
					<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>"
					class="btn btn-danger">Delete</a></td>
			</tr>

			</form>
		</c:forEach>

<c:if test="${grandTotal!=0}">	

	<tr bgcolor="orange">
	
	    <td col span="2">grand Total</td>
	    <td col span="2">Rs.${grandTotal}/-</td>
	    </tr>
	    </c:if>
	    
	    <tr bgcolor="lightblue">
	   <td col span="2"><center><a href="<c:url value="/"/>" class="btn btn-primary">Continue Shopping</a></center></td>
	   <c:if test="${grandTotal!=0}">	
	  <td col span="2"><center><a href="<c:url value="/ConfirmOrder"/>" class="btn btn-primary">Check Out</a></center>
	  </c:if>
	  </td>
	  
</tr>
	</table>
</div>