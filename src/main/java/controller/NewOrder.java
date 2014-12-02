
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderBean;
import model.Database;

@WebServlet("/newOrder")
public class NewOrder extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
			String uname= (String)req.getSession().getAttribute("uname");
			try{
				if(uname == null){
					out.print("Need to login first");
					RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
					rd.forward(req,res);
				}
				else{
					String vendor = (String)req.getParameter("vendor");
					String[] items = req.getParameterValues("items");
					String schedule = (String)req.getParameter("schedule");
					String orderDate = (String)req.getParameter("orderDate");
					
					//SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					//Date date;
					//date = f.parse(orderDate);
					//String s = f.format(date);
					String item="";
					for(int i=0;i<items.length;i++){
					item = item + "," + items[i];
					}
					item=item.substring(1);
					
					OrderBean ob = new OrderBean();
					ob.setVendor(vendor);
					ob.setItem(item);
					ob.setSchedule(schedule);
					ob.setOrderDate(orderDate);
					ob.setUserName(uname);
					
					Database db=new Database();
					if(db.createOrder(ob)){
						out.print("Order Saved.");  
						RequestDispatcher rd=req.getRequestDispatcher("/newOrder.jsp");  
						rd.include(req, res);
					}else{
						out.print("Error any how. Please try again!");  
						RequestDispatcher rd=req.getRequestDispatcher("/newOrder.jsp");  
						rd.include(req, res); 
					}
					
				}
			}catch(Exception e){
				out.print("Need to login first");
				RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
				rd.forward(req,res);
			}
		

		
	}
}