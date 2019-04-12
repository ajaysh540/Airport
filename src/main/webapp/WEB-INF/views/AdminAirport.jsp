<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	width: 100%;
	display: block;
	height: 100%;
	align: center;
	text-align: center;
	align-content: center;
	vertical-align: middle;
}

.name {
	width: 20;
}
input {
	border-radius: 20px;
	background-color: black;
	width: 10%;
	padding-left: 15px;
	color: white;
	border: none;
	border-width: 0px;
	border-style: solid;
	font-size: 20px;
	height: 25px;
	margin-bottom: 5px;
	font-family: Arial, sans-serif;
}
.logo {
	width: 20%;
}

.logoimg {
	width: 100%;
}

.table {
	width: 100%;
	broder: 0px solid;
	padding: 0px 0px 0px 0px;
	border: none;
	background-color: grey;
	margin: 0px 0px 0px 0px;
}

.logout {
	width: 20%;
}



</style>

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
			<th></th>
			<th class="name">Hello, <c:out value="${Admin.getFirstName()}"></c:out>
				(ADMIN)
			</th>
			<th class="logout">
				<form action="/AirportManagement/app/index" method="post">
					<input Style="width:25%" type="submit" value="Logout"
						class="btnlogout">
				</form>
			</th>
		</tr>
	</table>
	<br>
	<br>


	<form action="/AirportManagement/app/RequestList">
		<input name="Submit" type="Submit" value="Pending Request">
	</form>
	<br>
	<br>
	<form action="/AirportManagement/app/viewAllPlanes">
		<input name="Submit" type="Submit" value="Manage Planes">
	</form>
	<br>
	
	<form action="/AirportManagement/app/viewAllPilots">
		<input name="Submit" type="Submit" value="Manage Pilots">
	</form>
	<br>
	<form action="/AirportManagement/app/viewAllHangars">
		<input name="Submit" type="Submit" value="Manage Hangars">
	</form>

	<br>
	<br>
</body>
</html>