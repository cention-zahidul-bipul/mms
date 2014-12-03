
package controller;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;   

import model.*;

@WebServlet("/logout")  
public class Logout extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		doPost(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
	
		res.setContentType("text/html"); 
		PrintWriter out=res.getWriter();
		String uname=(String)req.getAttribute("username");
		String password=(String)req.getAttribute("password");
		HttpSession se=req.getSession();	
		se.invalidate();
		RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");  
		rd.include(req, res); 
	}
}