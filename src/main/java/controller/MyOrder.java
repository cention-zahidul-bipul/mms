
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderBean;
import model.Database;

@WebServlet("/myOrder")
public class MyOrder extends HttpServlet{

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
					
					
					Database db=new Database();
					ArrayList<OrderBean> myorders = new ArrayList<OrderBean>();
					myorders=db.getMyOrderList(uname);
					req.setAttribute("myorders", myorders);
				
					RequestDispatcher rd = req.getRequestDispatcher("myOrderList.jsp");
					rd.forward(req, res);
					
				}
			}catch(Exception e){
				out.print("Need to login first");
				RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
				rd.forward(req,res);
			}
		

		
	}
}