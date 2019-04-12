<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
.input {
	border-radius: 20px;
	color:black;
	width: 10%;
	padding-left: 15px;
	border-width: 2px;
	border-style: solid black;
	font-size: 20px;
	height: 25px;
	margin-bottom: 5px;
	font-family: Arial, sans-serif;
}
.main {
	display: block;
	align: center;
	text-align: center;
	align-content: center;
	vertical-align: middle;
}
.name {
	width: 20;
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
.logoutbtn{
background-color:black;
color:white;
border-radius:10px;
width:20%;
border:solid black;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Airport</title>
</head>
<body class="main">
<table class="table">
		<tr>
			<th class="logo"><img src="../images/plane.png" class="logoimg"></th>
			<th >
				
				</th>
			<th class="name"> MANAGER REGISTRATION
			</th>
			<th class="logout">
				
			</th>
		</tr>
	</table>
	<br>
	<br>
<h1>Manager Register</h1><br>
	<form action="/AirportManagement/app/ManagerRegister" method="post">
		<input class="input" type="text" name="firstName" Placeholder="First Name" required>*
		<br><br>
		
		<input class="input"  type="text" name="lastName" Placeholder="last Name" required>*
		<br><br>
		
		<input class="input" type="number" name="age" Placeholder="Age" required>*
		<br><br>
		
		<input class="input"  type="date" name="dob" Placeholder="DOB" >
		<br><br>
		
		<input class="input"  name="email" Placeholder="email" type="email" >
		<br><br>
		
		<input name="gender" type="radio" value="male" checked >Male
		<input name="gender" type="radio" value="female">Female*
		<br><br>
		
		<input class="input"  name="contact" type="number" placeholder="Contact" required>*
		<br><br>
		
		<input class="input"  name="altcontact" type="number" placeholder="Alt Contact">
		<br><br>
		
		<input class="input"  type="password" name="password" Placeholder="password" required>*
		<br><br>
		
		<input class="input"  name="submit" value="Submit" type="submit">
		<br><br>
		</form>
		
		<form action="/AirportManagement/app/login">
		<input class="input"  name="submit" value="Back" type="submit">
			</form>
</body>
</html>