<%@page import="bean.UserBean"%> 
<%@page import="java.util.*"%> 


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


			<span>User List:</span>

				<table border="1" align="center">
					<caption>Way 1:</caption>
					<tr>
						<th>Sl. No</th>
						<th>ID</th>
						<th>User Name</th>
						<th>Full Name</th>
						<th>Role</th>
					</tr>
					<% int i=1;
					ArrayList<UserBean> list = (ArrayList<UserBean>) request.getAttribute("userList");
					for(UserBean ub : list) {
					%>
					<tr>
						<td><%=i%></td>
						<td><%=ub.getUserID()%></td>
						<td><%=ub.getUserName()%></td>
						<td><%=ub.getFullName()%></td>
						<td><%=ub.getRole()%></td>
					</tr>
					
					<%i++;}%>

				</table>
				<br />
				<table border="1" align="center">
					<caption>Way 2:</caption>
					<tr>
						<th>Sl. No</th>
						<th>ID</th>
						<th>User Name</th>
						<th>Full Name</th>
						<th>Role</th>
					</tr>
					<% i=1;
					ArrayList<UserBean> li=new ArrayList<UserBean>();
					li=(ArrayList)request.getAttribute("userList");
					for (int j=0; j < li.size(); j++ ){
					%>
					<tr>
						<td><%=i%></td>
						<td><%=li.get(j).getUserID()%></td>
						<td><%=li.get(j).getUserName()%></td>
						<td><%=li.get(j).getFullName()%></td>
						<td><%=li.get(j).getRole()%></td>
					</tr>
					
					<%i++;}%>

				</table>
				
				<br />
				<table border="1" align="center">
					<caption>Way 3:</caption>
					<tr>
						<th>Sl. No</th>
						<th>ID</th>
						<th>User Name</th>
						<th>Full Name</th>
						<th>Role</th>
					</tr>
					<% i=1;
					UserBean ubn = new UserBean();
					for (int j=0; j < li.size(); j++ ){
					ubn=(UserBean)li.get(j);
					%>
					<tr>
						<td><%=i%></td>
						<td><%=ubn.getUserID()%></td>
						<td><%=ubn.getUserName()%></td>
						<td><%=ubn.getFullName()%></td>
						<td><%=ubn.getRole()%></td>
					</tr>
					
					<%i++;}%>

				</table>
		</div>
		<hr />
		<div id="footer"><p>Copyright &copy; Md. Zahidul Islam Bhuiyan-2014</p></div>
	</div>
	</body>
</html>