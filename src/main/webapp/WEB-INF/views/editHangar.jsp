<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport</title>
</head>
<body>
	<%
		session = request.getSession(false);
	%>
	<%
		if (session.getAttribute("Name") == null) {
	%>
	<c:redirect url="/app/login" />
	<%
		}
	%>
	<table class="table">
		<tr>
			<th class="logo"><img src="../images/plane.png" class="logoimg"></th>
			<th class="name">EDIT HANGAR</th>
			<th class="name"><%=session.getAttribute("Name")%>(ADMIN)</th>
			<th class="logout">
				<form action="/AirportManagement/app/index" method="post">
					<input class="logoutbtn" type="submit" value="Logout"
						class="btnlogout">
				</form>
			</th>
		</tr>
	</table>
	<br>
	<br>
	<form action="/AirportManagement/app/edithangar" method="post">

		<input class="textfield" type="text" name="hangarId"
			value="${hangar.hangarId }" hidden><br>
		<table>
			<tr>
				<td>Manager ID</td>
				<td><input class="textfield" type="text" name="managerId"
					value="${hangar.managerId }" required><br></td>
			</tr>
			<tr>
				<td>Manager Address1</td>
				<td><input class="textfield" type="text" name="managerAddress1"
					value="${hangar.managerAddress1}" required><br></td>
			</tr>
			<tr>
				<td>Manager Address2</td>
				<td><input class="textfield" type="text" name="managerAddress2"
					value="${hangar.managerAddress2 }" required><br></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input class="textfield" type="text" name="city"
					value="${hangar.city }" required><br></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input class="textfield" type="text" name="state"
					value="${hangar.state }" required><br></td>
			</tr>
			<tr>
				<td>Zipcode</td>
				<td><input class="textfield" type="text" name="zipCode"
					value="${hangar.zipCode }" required><br></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Submit"><br> <input
			type="reset" value="Reset">
	</form>
	<br>
	<br>
	<form action="/AirportManagement/app/viewAllHangars">
		<input type="submit" value="Cancel" name="home">
	</form>
</body>
</html>