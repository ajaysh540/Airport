<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport| Pilots</title>
</head>
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
				VIEW All PILOTS
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
	<table>
		<tr>
			<th>PilotID</th>
			<th>licenceNnumber</th>
			<th>address1</th>
			<th>address2</th>
			<th>city</th>
			<th>state</th>
			<th>zipcode</th>
			<th>ssn</th>


		</tr>

		<c:forEach items="${pilotList}" var="pl">
			<tr>
				<td><c:out value="${pl.pilotId}">
					</c:out></td>
				<td><c:out value="${pl.licNo}">
					</c:out></td>
				<td><c:out value="${pl.address1}">
					</c:out></td>
				<td><c:out value="${pl.address2}">
					</c:out></td>
				<td><c:out value="${pl.city}">
					</c:out></td>
				<td><c:out value="${pl.state}">
					</c:out></td>
				<td><c:out value="${pl.zipcode}">
					</c:out></td>
				<td><c:out value="${pl.ssn}">
					</c:out></td>


				<td>
					<form action="/AirportManagement/app/editpilotdet" method="post">
						<input type="text" value="${pl.pilotId}" name="pilotid" hidden>
						<input type="submit" value="edit">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="/AirportManagement/app/Addpilot" method="get">
		<input type="Submit" value="Add Pilot" name="submit">
	</form>
	<br>

	<form action="/AirportManagement/app/Home" method="get">
		<input type="Submit" value="Home" name="submit">
	</form>
</body>
</html>