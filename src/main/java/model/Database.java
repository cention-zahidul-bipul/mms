
package model;
import java.sql.*;
import java.util.*;

import bean.*;

public class Database{

final String driverClass="com.mysql.jdbc.Driver";
final String conString="jdbc:mysql://localhost:3306/mms";
final String dbUser="root";
final String dbPassword="";

	public String getPasswordByUser(String uname){
	
		String password="";

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement(); 
			String sql="select password from users where uName='"+uname+"'";
			ResultSet rs=stmt.executeQuery(sql);    
			while(rs.next())  
				password=rs.getString("password");
			con.close(); 
		}catch(Exception e){ password="";}  
		
		return password;

	}
	
	public UserBean getUserInfo(String uname){
		
		UserBean userbn=new UserBean();

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement();
	
			String sql="select uName,password,fullName,role from users where uName='"+uname+"'";
			ResultSet rs=stmt.executeQuery(sql);    
			while(rs.next()){  
				userbn.setUserName(rs.getString("uName"));
				userbn.setPassword(rs.getString("password"));
				userbn.setFullName(rs.getString("fullName"));
				userbn.setRole(rs.getString("role"));
			}
			con.close(); 
		}catch(Exception e){ }  
		
		return userbn;

	}
	
	public ArrayList getAllUserInfo(){
		
		ArrayList<UserBean> li = new ArrayList<UserBean>();

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement();
	
			String sql="select uid,uName,password,fullName,role from users";
			ResultSet rs=stmt.executeQuery(sql);    
			while(rs.next()){  
				UserBean userbn=new UserBean();
				userbn.setUserID(rs.getInt("uid"));
				userbn.setUserName(rs.getString("uName"));
				userbn.setPassword(rs.getString("password"));
				userbn.setFullName(rs.getString("fullName"));
				userbn.setRole(rs.getString("role"));
				li.add(userbn);
			}
			con.close(); 
		}catch(Exception e){ }  
		
		return li;

	}
	
	public boolean createUser(UserBean userbn){
	
		boolean isCreate=false;

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement(); 
			String sql="insert into users(uName,password,fullName,role) "+
			"values('"+userbn.getUserName()+"','"+userbn.getPassword()+"','"+userbn.getFullName()+"','"+userbn.getRole()+"')";
			int r=stmt.executeUpdate(sql); 
			if(r>0){
				isCreate=true;
			}
			con.close(); 
		}catch(Exception e){ isCreate=false;}  
		
		return isCreate;

	}
	
	public boolean createOrder(OrderBean ob){
	
		boolean isCreate=false;

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement(); 
			String sql="insert into orders(orderby,vendor,item,schedule,orderdate) "+
			"values('"+ob.getUserName()+"','"+ob.getVendor()+"','"+ob.getItem()+"','"+ob.getSchedule()+"','"+ob.getOrderDate()+"')";
			int r=stmt.executeUpdate(sql); 
			if(r>0){
				isCreate=true;
			}
			con.close(); 
		}catch(Exception e){ isCreate=false;}  
		
		return isCreate;

	}
	
	public ArrayList getMyOrderList(String uname){
		
		ArrayList<OrderBean> myorders = new ArrayList<OrderBean>();

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement();
	
			String sql="select orderid,vendor,item,schedule,orderdate from orders where orderby='"+uname+"'";
			ResultSet rs=stmt.executeQuery(sql);    
			while(rs.next()){  
				OrderBean ob=new OrderBean();
				ob.setOrderId(rs.getInt("orderid"));
				ob.setVendor(rs.getString("vendor"));
				ob.setItem(rs.getString("item"));
				ob.setSchedule(rs.getString("schedule"));
				ob.setOrderDate(rs.getString("orderdate"));
				myorders.add(ob);
			}
			con.close(); 
		}catch(Exception e){ }  
		
		return myorders;

	}
	
	public boolean deleteOrderById(int orderId){
		boolean isDelete=false;
		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement();
	
			String sql="delete from orders where orderid="+orderId;
			int r=stmt.executeUpdate(sql); 
			if(r>0){
				isDelete=true;
			}
			con.close(); 
		}catch(Exception e){ }
		return isDelete;
	}
	
	public ArrayList getOrderInfoById(int orderId){
		
		ArrayList<OrderBean> orderInfo = new ArrayList<OrderBean>();

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement();
	
			String sql="select orderid,vendor,item,schedule,orderdate from orders where orderid="+orderId;
			ResultSet rs=stmt.executeQuery(sql);    
			while(rs.next()){  
				OrderBean ob=new OrderBean();
				ob.setOrderId(rs.getInt("orderid"));
				ob.setVendor(rs.getString("vendor"));
				ob.setItem(rs.getString("item"));
				ob.setSchedule(rs.getString("schedule"));
				ob.setOrderDate(rs.getString("orderdate"));
				orderInfo.add(ob);
			}
			con.close(); 
		}catch(Exception e){ }  
		
		return orderInfo;

	}
	
	public boolean updateOrder(OrderBean ob){
	
		boolean isUpdate=false;

		try{
			Class.forName(driverClass);
			Connection con=DriverManager.getConnection(conString,dbUser,dbPassword);
			Statement stmt=con.createStatement(); 
			
			String sql= "update orders set vendor='"+ob.getVendor()+"', item='"+ob.getItem()+"', schedule='"+ob.getSchedule()+"', orderdate='"+ob.getOrderDate()+"' where orderid="+ob.getOrderId();
			int r=stmt.executeUpdate(sql); 
			if(r>0){
				isUpdate=true;
			}
			con.close(); 
		}catch(Exception e){ isUpdate=false;}  
		
		return isUpdate;

	}
	
	

}