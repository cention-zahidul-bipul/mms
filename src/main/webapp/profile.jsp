<html>
	<head>
		<title>Meal Management System</title>
		<link rel="stylesheet" type="text/css" href="resources/css/login_layout.css">
	</head>
	<body>

	
	
	<div id="container">
		<div id="header"></div>
		<hr />
			<table border="0" width="780px">
				<tr>
					<td align="center"><a href="profile">Profile</a></td>
					<td align="center"><a href="newOrder.jsp">New Order</a></td>
					<td align="center"><a href="myOrder">My Order</a></td>
					<td align="center"><a href="userList">User List</a></td>
					<td align="center"><a href="logout">Logout</a></td>
				</tr>
			</table>
		<hr />
		<div id="content">
			<span>Profile: </span>

				<table border="0" align="center">
					<tr>
						<td>User Name:</td>
						<td><%=request.getAttribute("uName")%></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><%=request.getAttribute("password")%></td>
					</tr>
					<tr>
						<td>Full Name:</td>
						<td><%=request.getAttribute("fullName")%></td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><%=request.getAttribute("role")%></td>
					</tr>

				</table>
		</div>
		<hr />
		<div id="footer"><p>Copyright &copy; Md. Zahidul Islam Bhuiyan-2014</p></div>
	</div>
	</body>
</html>