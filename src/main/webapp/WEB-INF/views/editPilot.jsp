<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport| Pilots</title>
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
			<th class="name">EDIT PILOTS</th>
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

	<form action="/AirportManagement/app/saveEditpilotdet" method="post">
		<table style="width: 60%; align-text:left";>

			<tr style="align-text:left">
				<td><input class="textfield" type="text" name="pilotId"
					value="${pilot.pilotId }" hidden><br></td>
				<td></td>
			</tr>
			<tr style="align-text:left">
				<td>License Number:</td>
				<td><input class="textfield" type="text" name="licNo"
					value="${pilot.licNo }" required><br></td>
			</tr>
			<tr style="align-text:left">
				<td>Address1</td>
				<td><input class="textfield" type="text" name="address1"
					value="${pilot.address1}" required><br></td>
			</tr>
			<tr style="align-text:left">
				<td>Address2</td>
				<td><input class="textfield" type="text" name="address2"
					value="${pilot.address2 }" required><br></td>
			</tr>
			<tr style="align-text:left">
				<td>City</td>
				<td><input class="textfield" type="text" name="city"
					value="${pilot.city }" required><br></td>
			</tr>
			<tr style="align-text:left">
				<td>State</td>
				<td><input class="textfield" type="text" name="state"
					value="${pilot.state }" required><br></td>
			</tr>
			<tr style="align-text:left">
				<td>Zipcode</td>
				<td><input class="textfield" type="text" name="zipcode"
					value="${pilot.zipcode }" required><br></td>
			</tr>
			<tr style="align-text:left"><td>SSN</td>
				<td><input class="textfield" type="text" name="ssn"
					value="${pilot.ssn }" required><br></td>
			</tr>

		</table>
		<input class="Buttons" type="submit" name="submit" value="Submit"><br>
		<input class="Buttons" type="reset" value="Reset">
	</form>
	<br>
	<br>
	<form action="/AirportManagement/app/viewAllPilots">
		<input type="submit" value="Cancel" name="home">
	</form>
</body>
</html>