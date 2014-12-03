<%@page import="bean.OrderBean"%> 
<%@page import="java.util.*"%> 


<html>
	<head>
		<title>Meal Management System</title>
		<link rel="stylesheet" type="text/css" href="resources/css/login_layout.css">
		<style type="text/css">		
			input[type="button"]{
			background: #222;
			border: none;
			text-shadow: 0 -1px 0 rgba(0,0,0,0.3);
			color: #eee;
			cursor: pointer;

			}
		</style>
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

				<table border="1" align="center" style="border-collapse: collapse;" width="700px">
					<caption>My Orders</caption>
					<tr>
						<th>Sl. No</th>
						<th>Order ID</th>
						<th>Vendor Name</th>
						<th>Item</th>
						<th>Schedule</th>
						<th>Order Date</th>
						<th>Action</th>
					</tr>
					<% int i=1;
					ArrayList<OrderBean> list = (ArrayList<OrderBean>) request.getAttribute("myorders");
					for(OrderBean ob : list) {
					int orderId=ob.getOrderId();
					if(i%2==0){
					%>
					<tr class="even"> <%} else{%>
					<tr class="odd"><% } %>
					
						<td><%=i%></td>
						<td><%=orderId%></td>
						<td><%=ob.getVendor()%></td>
						<td><%=ob.getItem()%></td>
						<td><%=ob.getSchedule()%></td>
						<td><%=ob.getOrderDate()%></td>		
 						
						<td><a href="editOrder?orderId=<%=orderId%>"/> <input type="button" value="Edit" /></a>&nbsp;&nbsp;&nbsp; 
						<a href="deleteOrder?orderId=<%=orderId%>"/> <input type="button" value="Delete" /></a></td>
					</tr>
					
					<%i++;}%>

				</table>

		</div>
		<hr />
		<div id="footer"><p>Copyright &copy; Md. Zahidul Islam Bhuiyan-2014</p></div>
	</div>
	</body>
</html>