<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport</title>
</head>
<body>
<table class="table">
		<tr>
			<th class="logo"><img src="../images/plane.png" class="logoimg"></th>
			<th >
				
				</th>
			<th class="name"> 
			SUCCESSFULLY REGISTERED
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
<b>Your login Id is :<c:out value="${message}"></c:out></b>
Please use this ID to login to your account once your details are verified.

<br>
<br>
<form action="/AirportManagement/app/index">
<input name="home" value="GO BACK" type="Submit">
</form>
</body>
</html>