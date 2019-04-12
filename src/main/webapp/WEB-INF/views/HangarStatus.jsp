<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport|Hangar Status</title>
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
			<th class="name">HANGAR STATUS</th>
			<th class="name"><%=session.getAttribute("Name")%>(MANAGER)</th>
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

	<h2>Assigned Hangars</h2>
	<h3>Click 'Unassign' Button to change status</h3>
	<br>
	<br>
	<c:if test="${empty assignedHangarList}"><b style="color:red;">ALL HANGARS ARE AVAILABLE</b></c:if>
	<table>
		<tr>
			<th>Hangar Id</th>
			<th>Status</th>
			<th>Available From</th>
			<th>Available To</th>
			<th>Occupancy From</th>
			<th>Occupancy To</th>
			<th></th>
		</tr>

		<c:forEach items="${assignedHangarList}" var="ul">
			<tr>
				<td><c:out value="${ul.hangarDetails.hangarId }"></c:out></td>
				<td><c:out value="${ul.status }"></c:out></td>
				<td><c:out value="${ul.availableFD }"></c:out></td>
				<td><c:out value="${ul.availableTD }"></c:out></td>
				<td><c:out value="${ul.occupancyFD }"></c:out></td>
				<td><c:out value="${ul.occupancyTD }"></c:out></td>
				<td><form action="/AirportManagement/app/unassignHangar"
						method="post">
						<input type="text" value="${ul.hangarDetails.hangarId }" name="hangarId" hidden>
						<input type="Submit" value="Unassign" name="submit">
					</form>
			</tr>

		</c:forEach>
	</table>
	<br>
	<br>

	<h2>Unassigned Hangars</h2>
	<c:if test="${empty unassignedHangarList }"><b style="color:red;">NO AVAILABLE HANGARS</b></c:if>
	<table>
		<tr>
			<th>Hangar Id</th>
			<th>Status</th>
			<th>Available From</th>
			<th>Available To</th>
			<th>Occupancy From</th>
			<th>Occupancy To</th>
		</tr>

		<c:forEach items="${unassignedHangarList}" var="ul">
			<tr>
				<td><c:out value="${ul.hangarDetails.hangarId }"></c:out></td>
				<td><c:out value="${ul.status }"></c:out></td>
				<td><c:out value="${ul.availableFD }"></c:out></td>
				<td><c:out value="${ul.availableTD }"></c:out></td>
				<td><c:out value="${ul.occupancyFD }"></c:out></td>
				<td><c:out value="${ul.occupancyTD }"></c:out></td>
			</tr>

		</c:forEach>
	</table>
	<br>
	<br>
	<form action="/AirportManagement/app/ViewUnassignedHangarPlane">
		<input type="submit" name="submit" value="Assign Hangars">
	</form>
	<br>
	<br>
	<form action="/AirportManagement/app/Home" method="get">
		<input type="Submit" value="Home" name="submit">
	</form>
</body>
</html>