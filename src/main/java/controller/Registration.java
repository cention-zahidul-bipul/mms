
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

@WebServlet("/registration")  
public class Registration extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		doPost(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
	
		res.setContentType("text/html"); 
		PrintWriter out=res.getWriter();
		String uname=(String)req.getParameter("uname");
		String password=(String)req.getParameter("password");
		String rpassword=(String)req.getParameter("rpassword");
		String fullName=(String)req.getParameter("fullName");
		
		if((rpassword.equals(password)) && (uname.trim() !="") && (fullName.trim() != "")){
			UserBean userbn=new UserBean();
			userbn.setUserName(uname);
			userbn.setPassword(password);
			userbn.setFullName(fullName);
			userbn.setRole("User");
			Database db=new Database();
			if(db.createUser(userbn)){
				out.print("Your registration has been successfully completed. Now you can login to the system.");  
				RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");  
				rd.include(req, res);
			}else{
				out.print("Error any how. Please try again!");  
				RequestDispatcher rd=req.getRequestDispatcher("/registration.jsp");  
				rd.include(req, res); 
			}
			 
		}
		else{
			out.print("Need to fill the form correctly!");  
			RequestDispatcher rd=req.getRequestDispatcher("/registration.jsp");  
			rd.include(req, res); 
		}
		
	}
}