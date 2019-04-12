<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport| Pending Requests</title>
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
				PENDING REQUESTS
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
	<h2>Pending Admin Requests</h2>
	<c:if test="${not empty adminList}">

		<c:forEach items="${ adminList}" var="al">

			<form action="AdminApproveRequest" method="post">
				<table>
					<tr style="border-bottom: 1px solid grey">
						<td><c:out value="${al.getFirstName()}"></c:out></td>
						<td><c:out value="${al.getLastName()}"></c:out></td>
						<td><c:out value="${al.getEmail()}"></c:out></td>
						<td><c:out value="${al.getContact()}"></c:out></td>
						<td><input type="submit" name="submit" value="submit">
							<input type="text" name="adminid" value="${al.getAdminId()}"
							hidden>
					</tr>
				</table>
			</form>
		</c:forEach>
	</c:if>
	<c:if test="${empty adminList}">NO PENDING REQUEST FOR ADMIN</c:if>
	<hr>
	<br>
	<br>
	<br>
	<h2>Pending Manager Requests</h2>
	<hr>
	<c:if test="${not empty managerList}">
		<c:forEach items="${managerList}" var="ml">
			<form action="ManagerApproveRequest" method="post">
				<table style="border: 1px solid black">
					<tr style="border-bottom: 1px solid grey">
						<td><c:out value="${ml.getFirstName()}"></c:out></td>
						<td><c:out value="${ml.getLastName()}"></c:out></td>
						<td><c:out value="${ml.getEmail()}"></c:out></td>
						<td><c:out value="${ml.getContact()}"></c:out></td>
						<td><input class="input" type="submit" name="submit" value="submit">
							<input type="text" name="managerid" value="${ml.getManagerId()}"
							hidden>
					</tr>
				</table>
			</form>
		</c:forEach>
	</c:if>
	<c:if test="${empty managerList}">NO PENDING REQUEST FOR MANAGER</c:if>

	<br>
	<br>
	<form action="/AirportManagement/app/Home" method="get">
		<input type="Submit" value="Home" name="submit">
	</form>
</body>
</html>