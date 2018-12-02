<%@include file="Header.jsp" %>

<h1>Product Display</h1>
<div class="row">
<c:forEach items="${productList}" var="product">
		<div class="row">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<h4>
						<span data-toggle="tooltip" title="Bootstrap version">
							${product.productName }&nbsp; Rs. ${product.productPrice } </span>
					</h4>
					<img
						src="<c:url value="/resources/images/product/${product.code}.jpg"/>"
						height="550" width="500" alt="Image not supported" /> 
						<a
						href="<c:url value="/productTotalInfo/${product.productId}"/>"
						class="btn btn-primary col-xs-12" role="button">Click To Large</a>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
</body>
</html>