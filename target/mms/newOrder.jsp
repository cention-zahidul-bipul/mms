<html>
	<head>
		<title>Meal Management System</title>
		<link rel="stylesheet" type="text/css" href="resources/css/login_layout.css">
		
		<script>
        function getItems(){
            var option = document.getElementById("vendor").value;
			var items;
            if(option == "spice")
                  {
					items="<input type='checkbox' name='items' value='spice rice'>Rice&nbsp;<input type='checkbox' name='items' value='beef'>Beef&nbsp;<input type='checkbox' name='items' value='chicken'>Chicken&nbsp;<input type='checkbox' name='items' value='fish'>Fish";
                        
                  }
            else if(option == "star")
                  {
                       items="<input type='checkbox' name='items' value='star rice'>Star Rice&nbsp;<input type='checkbox' name='items' value='beef'>Beef&nbsp;<input type='checkbox' name='items' value='chicken'>Chicken&nbsp;<input type='checkbox' name='items' value='fish'>Fish";
                     
                  }
            else if(option == "kfc")
                  {
                        items="<input type='checkbox' name='items' value='kfc rice'>KFC Rice&nbsp;<input type='checkbox' name='items' value='beef'>Beef&nbsp;<input type='checkbox' name='items' value='chicken'>Chicken&nbsp;<input type='checkbox' name='items' value='fish'>Fish";
                     
                  }
			else
				{
				items="Need to Select a vendor";
				}
				
				document.getElementById("menu").innerHTML = items;
        }
    </script>

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
			<span>New Oprder</span>
			<form action="newOrder" method="post">
				<table border="0" align="center" width="550px">
					<tr height="50px">
						<td width="230px">Vendor:</td>
						<td>
							<select name="vendor" id="vendor" onChange="getItems()">
								<option>----Select----</option>
								<option value="spice">Spice</option>
								<option value="star">Star</option>
								<option value="kfc">KFC</option>
							</select>
						</td>
					</tr>
					<tr height="50px">
						<td width="230">Select Menu (Max 3 items):</td>
						<td><span id="menu">Need to Select a vendor</span></td>
					</tr>
					
					<tr height="50px">
						<td width="230px">Order schedule:</td>
						<td>
							<input type="radio" name="schedule" value="Lunch" checked>Lunch&nbsp;
							<input type="radio" name="schedule" value="Dinner">Dinner
						</td>
					</tr>
					<tr height="50px">
						<td width="230px">Date:</td>
						<td><input type="date" name="orderDate" /> </span></td>
					</tr>
					<tr height="50px">
						<td colspan="2" align="center"><input type="submit" value="Order Now"></td>
					</tr>
				</table>
			</form>
		</div>
		<hr />
		<div id="footer"><p>Copyright &copy; Md. Zahidul Islam Bhuiyan-2014</p></div>
	</div>
	</body>
</html>