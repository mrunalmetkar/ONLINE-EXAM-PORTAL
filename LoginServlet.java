package demoexamportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("<h1>LOGIN </h1>");
		String user1=request.getParameter("studusername");
		String pass1=request.getParameter("studuserpassword");
		
		
		
		
		DatabaseConnect cd=new DatabaseConnect();
		Connection conn=cd.openConnection();
		ResultSet rs ;
		
		try 
		{
			Statement st = conn.createStatement();
			rs = st.executeQuery("select * from studentregister");
			while(rs.next())
			{
				int flag;
			
				if(rs.getString(2).equals(user1) && rs.getString(3).equals(pass1))
				{
					 flag=1;
				//	out.println("LOGIN VALID");
				}
				else
				{
					 flag=0;
					//out.println("INVALID LOGIN..Register to Login");
				}
				
				if(flag==1)
				{
					out.println("LOGIN VALID");
					RequestDispatcher rs1= request.getRequestDispatcher("ValidStudLogin.jsp");
		            rs1.forward(request, response);
					break;
				}
				
			}
			
		} 
		
		catch (SQLException e)
		{
				e.printStackTrace();
		}
		
		
		
		
	

		
	}

}
