<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListCustomers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">

			<!-- put new button:: Add Customer -->
			<input type='button' value='Add Customer'
				onclick="window.location.href='${pageContext.request.contextPath}/customer/showForm'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers}">

					<!-- Creating the url to edit form before update -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<!--Passing the customer id along with link queryString , for any clicks-->
						<!-- this id can be  auatomatically binded to handler method using @RequestParam-->
						<!--Customer object is accessed from request scope, no need of Spring Trag Library for 1 way binding-->
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<!-- Creating url for deleting while submit -->
					<c:url var="deleteLink" value="/customer/performDelete">
						<!-- passing the customer id for deletion -->
						<c:param name="customerId" value="${customer.id}"/>
					</c:url>

					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>

						<!--passing update link variable -->						
						<td>
						<a href='${updateLink}'>UPDATE</a>
						<!-- passing delete link as varaible -->
						             | 
						<a href='${deleteLink}' 
			onclick="if(!(confirm('Are you sure u want to delete this customer?')))return false;">
						DELETE </a>
						</td>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>