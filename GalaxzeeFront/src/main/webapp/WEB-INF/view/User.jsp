<%@ include file="Header.jsp" %>
<div class="cont">

<table align="center" class="table">
    <tr class="danger">
       <td colspan="3">Product Detail</td>
       </tr>
     <tr class="info">
<c:forEach items="${productList}" var="product">

   <td>
			 <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="100" height="100"/>
			<br/>
			<a href="<c:url value="ProductTotalInfo/${product.productId}"/>">${product.productName}</a>
			<br/>INR. ${product.productPrice} /-
		</td>

</c:forEach>
</tr>
</table> 
</div> 