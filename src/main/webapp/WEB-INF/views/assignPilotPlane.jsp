<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport|Assign Pilot</title>
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
Unassigned Planes:
<form action="/AirportManagement/app/AssignPilotPlane" method="post">
<select name="planeId">
    <c:forEach items="${planeList}" var="list">
        <option value="${list.getPlaneId()}">${list.getPlaneId()}</option>
    </c:forEach>
</select>
<br/>
Unassigned pilots:
<select name="pilotId">
    <c:forEach items="${pilotList}" var="list">
        <option value="${list.getPilotId()}">${list.getPilotId()}</option>
    </c:forEach>
</select>
<br/>
<input type="submit" name="assign" value="Assign">
</form>

</body>
</html>