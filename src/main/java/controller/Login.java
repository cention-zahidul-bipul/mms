
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

@WebServlet("/login")  
public class Login extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		doPost(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
	
		res.setContentType("text/html"); 
		PrintWriter out=res.getWriter();
		
		try{
			String suname=(String)req.getSession().getAttribute("uname"); 
			out.print(suname);
			if(suname==null){
				String uname=(String)req.getParameter("uname");
				String password=(String)req.getParameter("password");
				
				Database db=new Database();
				if(password.equals(db.getPasswordByUser(uname))){
				
					HttpSession session=req.getSession();  
					session.setAttribute("uname",uname);  
					session.setAttribute("sid",session.getId());
					RequestDispatcher rd=req.getRequestDispatcher("profile");  
					rd.forward(req, res); 
				}
				else{
					out.print("Sorry UserName or Password Error!");  
					RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");  
					rd.include(req, res); 
				}			
			
			}
			else{
				RequestDispatcher rd=req.getRequestDispatcher("profile");  
				rd.include(req, res); 
				
			}

			
		}catch(Exception e){
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");  
			rd.include(req, res); 
		}
	}
}