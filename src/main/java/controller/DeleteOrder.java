
package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Database;

@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet{

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
				if(db.deleteOrderById(orderId)){
					out.print("Deleted");
				}else{
					out.print("Error !!! Try again please.");
				}
				RequestDispatcher rd = req.getRequestDispatcher("myOrder");
				rd.forward(req, res);
			}
		}
		catch(Exception e){
			out.print("Need to login first");
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
			rd.forward(req,res);
		}
	}
}