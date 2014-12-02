<%@page import="bean.OrderBean"%> 
<%@page import="java.util.*"%> 

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

<%!   
boolean isExist(String s, String[] itemset1){  
boolean is_exist=false;
for(int i=0;i<itemset1.length;i++){
	if(s.equals(itemset1[i])){
		is_exist=true;
		break;
	}
}	
return  is_exist;
}  
%>	
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
			<% 
			
		ArrayList<OrderBean> list = (ArrayList<OrderBean>) request.getAttribute("orderInfo");
		for(OrderBean ob : list) {
		int orderId=ob.getOrderId();
		String vendor=ob.getVendor();
		String item=ob.getItem();
		String schedule=ob.getSchedule();
		String orderDate=ob.getOrderDate();	
		String[] itemset = item.split(",");
	%>
			<span>New Oprder</span>
			<form action="updateOrder" method="post">
			
				<input type="hidden" name="orderId" value="<%=orderId%>">
				<table border="0" align="center" width="550px">
					<tr height="50px">
						<td width="230px">Vendor:</td>
						<td>
							<select name="vendor" id="vendor" onChange="getItems()">
								<option>----Select----</option>
								<%if(vendor.equals("spice")){%>
								<option value="spice" selected>Spice</option>
								<%}else{%>
								<option value="spice">Spice</option>
								<%}if(vendor.equals("star")){%>
								<option value="star" selected>Star</option>
								<%}else{%>
								<option value="star">Star</option>
								<%}if(vendor.equals("kfc")){%>
								<option value="kfc" selected>KFC</option>
								<%}else{%>
								<option value="kfc">KFC</option>
								<%}%>
								
								
								
							</select>
						</td>
					</tr>
					<tr height="50px">
						<td width="230">Select Menu (Max 3 items):</td>
						<td><span id="menu">
						
						<%if(vendor.equals("spice")){
							if(isExist("spice rice",itemset)){
						%>
								<input type='checkbox' name='items' value='spice rice' checked>Rice&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='spice rice'>Rice&nbsp;
							<%}if(isExist("beef",itemset)){%>
								<input type='checkbox' name='items' value='beef' checked>Beef&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='beef'>Beef&nbsp;
							<%}if(isExist("chicken",itemset)){%>
								<input type='checkbox' name='items' value='chicken' checked>Chicken&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='chicken'>Chicken&nbsp;
							<%}if(isExist("fish",itemset)){%>
								<input type='checkbox' name='items' value='fish' checked>Fish
							<%}else{%>
								<input type='checkbox' name='items' value='fish'>Fish
							<%}%>	
						
						<%}else if(vendor.equals("star")){
							if(isExist("star rice",itemset)){
						%>
							<input type='checkbox' name='items' value='star rice' checked>Star Rice&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='star rice'>Star Rice&nbsp;
							<%}if(isExist("beef",itemset)){%>
								<input type='checkbox' name='items' value='beef' checked>Beef&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='beef'>Beef&nbsp;
							<%}if(isExist("chicken",itemset)){%>
								<input type='checkbox' name='items' value='chicken' checked>Chicken&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='chicken'>Chicken&nbsp;
							<%}if(isExist("fish",itemset)){%>
								<input type='checkbox' name='items' value='fish' checked>Fish
							<%}else{%>
								<input type='checkbox' name='items' value='fish'>Fish
							<%}%>	
				
						<%}else{
							if(isExist("kfc rice",itemset)){
						%>
							<input type='checkbox' name='items' value='kfc rice' checked>KFC Rice&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='kfc rice'>KFC Rice&nbsp;
							<%}if(isExist("beef",itemset)){%>
								<input type='checkbox' name='items' value='beef' checked>Beef&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='beef'>Beef&nbsp;
							<%}if(isExist("chicken",itemset)){%>
								<input type='checkbox' name='items' value='chicken' checked>Chicken&nbsp;
							<%}else{%>
								<input type='checkbox' name='items' value='chicken'>Chicken&nbsp;
							<%}if(isExist("fish",itemset)){%>
								<input type='checkbox' name='items' value='fish' checked>Fish
							<%}else{%>
								<input type='checkbox' name='items' value='fish'>Fish
							<%}%>
						
						<%}%>
						
						
						</span></td>
					</tr>
					
					<tr height="50px">
						<td width="230px">Order schedule:</td>
						<td>
						<%if(schedule.equals("Lunch")){%>
							<input type="radio" name="schedule" value="Lunch" checked>Lunch&nbsp;
							<input type="radio" name="schedule" value="Dinner">Dinner
						<%}else{%>
							<input type="radio" name="schedule" value="Lunch">Lunch&nbsp;
							<input type="radio" name="schedule" value="Dinner" checked>Dinner
						<%}%>
						</td>
					</tr>
					<tr height="50px">
						<td width="230px">Date:</td>
						<td><input type="date" name="orderDate" value="<%=orderDate%>"/> </span></td>
					</tr>
					<tr height="50px">
						<td colspan="2" align="center"><input type="submit" value="Order Now"></td>
					</tr>
				</table>
			</form>
			
			<%}%>
		</div>
		<hr />
		<div id="footer"><p>Copyright &copy; Md. Zahidul Islam Bhuiyan-2014</p></div>
	</div>
	</body>
</html>