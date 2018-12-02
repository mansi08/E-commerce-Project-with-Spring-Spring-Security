<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="Header.jsp"%>

<h1>Supplier</h1>
<hr />

<!-- TOGGLE BUTTONS -->
<c:if test="${UserClickedEdit==true }">
	<c:set var="url" value="UpdateSupplier" />
</c:if>

<c:if test="${UserClickedEdit!=true }">
	<c:set var="url" value="SaveSupplier" />
</c:if>

<!--  FORM FOR ENTERING DETAILS -->
<form:form action="${pageContext.request.contextPath}/${url }"
	method="post" modelAttribute="supplier">

	<!-- HIDDING supplier SO NO ONE CAN EDIT -->
	<c:if test="${UserClickedEdit==true}">
		<form:hidden path="supplier_Id" />
	</c:if>
<table align="center" >
<tr>
<td>Supplier Name</td>
<td><form:input path="supplier_Name" placeholder="SupplierName" /></td>
</tr>


<tr>
<td>pan No</td>
<td><form:input path="pan_No" placeholder="panNo" /></td>
</tr>

<tr>
<td>aadharNo</td>
<td><form:input path="aadhar_No" placeholder="aadharNo" /></td>
</tr>

<tr>
<td>email</td>
<td><form:input path="email" placeholder="email" /></td>
</tr>

<tr>
<td>mobile</td>
<td><form:input path="mobile" placeholder="mobile" /></td>
</tr>

<tr>
<td>gstin no</td>
<td><form:input path="gstin_No" placeholder="gstin_No" /></td>
</tr>

<tr>
<td>company name</td>
<td><form:input path="supplier_Company_Name" placeholder="supplierCompanyName" /></td>
</tr>

<tr>
<td>quantity</td>
<td><form:input path="quantity" placeholder="quantity" /></td>
</tr>
</table>
	 </br>
	
	<!-- Button -->
	<c:if test="${UserClickedEdit==true}">
		<input type="submit" value="Update supplier" />
	</c:if>

	<c:if test="${UserClickedEdit!=true}">
		<input type="submit" value="Save supplier" />
	</c:if>
</form:form>

<!-- DISPLAYING THE CONTENT -->

<table align="center" border="1">
	<thead bgcolor="Pink">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PAN NO</th>
			<th>AADHAR NO</th>
			<th>EMAIL</th>
			<th>MOBILE</th>
			<th>GSTIN NO</th>
			<th>SUPPIER COMPANY NAME</th>
			<th>QUANTITY</th>
			<th>ACTION</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${supplierList}" var="supplier">
			<tr>
				<td>${supplier.supplier_Id}</td>
				<td>${supplier.supplier_Name}</td>
				<td>${supplier.pan_No}</td>
				<td>${supplier.aadhar_No}</td>
				<td>${supplier.email}</td>
				<td>${supplier.mobile}</td>
				<td>${supplier.gstin_No}</td>
				<td>${supplier.supplier_Company_Name}</td>
				<td>${supplier.quantity}</td>
				<td><a
					href="${pageContext.request.contextPath}/editSupplier/${supplier.supplier_Id}" class="btn btn-info">Edit</a>
					<a
					href="${pageContext.request.contextPath}/deleteSupplier/${supplier.supplier_Id}" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>