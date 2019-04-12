<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport</title>
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
			<th >
				
				</th>
			<th class="name">Hello, <c:out value="${Manager.getFirstName()}"></c:out> (Manager)
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
	<h2>
		Welcome
		<c:out value="${Manager.getFirstName() }"></c:out>
		<br> <br>
	</h2>
	
	<form action="/AirportManagement/app/checkhangarstatus">
	<input type="submit" name="submit" value="Hangar Status">
	</form><br><br>
	<form action="/AirportManagement/app/ViewUnassignedHangarPlane">
	<input type="submit" name="submit" value="Assign Hangars">
	</form>
</body>
</html>