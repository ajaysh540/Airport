<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport|Add Hangar</title>
</head>
<body>
<body>
<%		session = request.getSession(false);		%>
		<%if(session.getAttribute("Name")==null){
			
			%>
			 <c:redirect url = "/app/login"/>
		<%}%>
		
<table class="table">
		<tr>
			<th class="logo"><img src="../images/plane.png" class="logoimg"></th>
		<th class="name">
				ADD HANGARS
				</th>
			<th class="name"> <%=session.getAttribute("Name") %>(ADMIN)
			</th>
			<th class="logout">
				<form action="/AirportManagement/app/index" method="post">
					<input class="logoutbtn" type="submit" value="Logout" class="btnlogout">
				</form>
			</th>
		</tr>
	</table>
	<br>
	<br>
	<form action="/AirportManagement/app/addhangardetails" method="post">
		<table>

			<tr>
				<td>Manager ID</td>
				<td><input class="textfield" type="text" name="managerId" placeholder="Manager Id"
					required><br></td>
			</tr>
			<tr>
				<td>Manager Address1</td>
				<td><input class="textfield" type="text" name="managerAddress1"placeholder="Address1"
					required><br></td>
			</tr>
			<tr>
				<td>Manager Address2</td>
				<td><input class="textfield" type="text" name="managerAddress2" placeholder="Address2"
					required><br></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input class="textfield" type="text" name="city" placeholder="City" required><br></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input class="textfield" placeholder="State" type="text" name="state" required><br></td>
			</tr>
			<tr>
				<td>Zipcode</td>
				<td><input class="textfield" type="text" name="zipCode" placeholder="Zipcode"
					required><br></td>
			</tr>
		</table>
		<input name="Submit" value="Submit" type="Submit"><br> <br>
		<input name="Reset" value="Reset" type="Reset">
	</form>
	<br>
	<br>

	<form action="/AirportManagement/app/viewAllHangars">
		<input type="submit" value="Cancel" name="home">
	</form>
</body>
</html>