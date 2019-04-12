<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport|Assign Hangar</title>
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
				Assign Hangars
				</th>
			<th class="name"> <%=session.getAttribute("Name") %>(MANAGER)
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
<form action="/AirportManagement/app/AssignHangarPlane" method="post">
<table>
<tr>
<td>
Unassigned planes: </td><td>
<select style="width:20%; height:25px;  border-radius:20px; padding-left:20px; background-color:black; color:white"  name="planeId" required>
<option value="">Select Plane</option>
    <c:forEach items="${planeList}" var="list">
        <option value="${list.planeId}">${list.planeId}</option>
    </c:forEach>
</select>
</td></tr>
<tr>
<td>
Unassigned hangar:</td><td> 
<select style="width:20%; height:25px; border-radius:20px; padding-left:20px; background-color:black; color:white" name="hangarId" required>
<option value="">Select Hangar</option>
    <c:forEach items="${hangarList}" var="list">
        <option value="${list.hangarDetails.hangarId}">${list.hangarDetails.hangarId}</option>
    </c:forEach>
</select>
</td></tr>
<tr><td>
Available From date:</td><td><input type="date" name="availableFD" placeholder="Available From date"></td>
</tr><tr><td>
Available To date:</td><td><input type="date" name="availableTD" placeholder="Available To date"></td></tr>
<tr><td>
Occupancy From date:</td><td><input type="date" name="occupancyFD" placeholder="Occupancy From date"></td></tr>
<tr><td>
Occupancy To date:</td><td><input type="date" name="occupancyTD" placeholder="Occupancy To date"></td></tr>
</table><br>
<input type="submit" name="assign" value="Assign">
</form>
<br>
	<form action="/AirportManagement/app/Home" method="get">
		<input type="Submit" value="Home" name="submit">
	</form>
</body>
</html>