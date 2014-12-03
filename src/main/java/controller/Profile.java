
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
import bean.*;

@WebServlet("/profile")  
public class Profile extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		doPost(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
	
		res.setContentType("text/html"); 
		PrintWriter out=res.getWriter();
		
		try{

			String uname=(String)req.getSession().getAttribute("uname"); 
			String sid=(String)req.getSession().getAttribute("sid");
			
			if(!sid.equals(req.getSession().getId())){
				out.print("Need to login!");  
				RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");  
				rd.include(req, res); 
			}
			else{
				Database db=new Database();
				UserBean users=db.getUserInfo(uname);
				req.setAttribute("uName", users.getUserName());
				req.setAttribute("password", users.getPassword());
				req.setAttribute("fullName", users.getFullName());
				req.setAttribute("role", users.getRole());

				RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
				rd.forward(req, res);
			}
		} catch(Exception e){
			out.print("Need to Login first!");  
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");  
			rd.include(req, res);
		}

	}
}