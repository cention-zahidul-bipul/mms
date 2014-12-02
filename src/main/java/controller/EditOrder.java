
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderBean;
import model.Database;

@WebServlet("/editOrder")
public class EditOrder extends HttpServlet{

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
				int orderId= Integer.parseInt(req.getParameter("orderId"));
				Database db = new Database();
				ArrayList<OrderBean> orderInfo = new ArrayList<OrderBean>();
				orderInfo=db.getOrderInfoById(orderId);
				req.setAttribute("orderInfo", orderInfo);
				RequestDispatcher rd1 = req.getRequestDispatcher("editOrder.jsp");			
				rd1.forward(req, res);
			}
		}catch(Exception e){
				out.print("Need to login first");
				RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
				rd.forward(req,res);
			}


		
	}
}