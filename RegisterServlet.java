package demoexamportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("<h1>REGISTER </h1>");
		int prn=Integer.parseInt(request.getParameter("studentPrn"));
		String user=request.getParameter("userName");
		String pass=request.getParameter("userPassword");
		
		DatabaseConnect dc=new DatabaseConnect();
		dc.openConnection();	
		out.println("DB connected");
		
		dc.openConnection();	
		dc.enterRegistrationDetails(prn, user, pass);
		out.println("Details stored in DB");
	}

}
