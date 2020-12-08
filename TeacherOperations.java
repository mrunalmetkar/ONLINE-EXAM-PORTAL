package demoexamportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TeacherOperations")
public class TeacherOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("<h1>TEACHER OPERATIONS </h1>");
		String op1=request.getParameter("studoperation");
		if(op1.equals("update"))
		{
			DatabaseConnect cd=new DatabaseConnect();
			Connection conn=cd.openConnection();
			
			//String delquery="Delete from studentregister where username=?";
			String updquery="Update studentregister set username=? where username=?";
			
			try 
			{
				String old=request.getParameter("oldopusername");
				String newp=request.getParameter("newopusername");
				PreparedStatement p1=conn.prepareStatement(updquery);
				p1.setString(1, newp);
				p1.setString(2, old);
				boolean rowupd=p1.executeUpdate()>0;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			try
			{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from studentregister");
			while(rs.next())
			{
				System.out.println(rs.getString(2)+" "+rs.getString(3));
			}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			out.println("PROFILE UPDATED SUCCESSFULLY!!");
			
		}
		
		if(op1.equals("delete"))
		{
			DatabaseConnect cd=new DatabaseConnect();
			Connection conn=cd.openConnection();
			
			String delquery="Delete from studentregister where username=?";
			//String updquery="Update studentregister set password=? where password=?";
			
			try 
			{
				String delu=request.getParameter("oldopusername");
				PreparedStatement p=conn.prepareStatement(delquery);
				p.setString(1, delu);
				boolean rowdel=p.executeUpdate()>0;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			try
			{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from studentregister");
			while(rs.next())
			{
				System.out.println(rs.getString(2)+" "+rs.getString(3));
			}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			out.println("PROFILE UPDATED SUCCESSFULLY!!");

		}


		}
		
		
	}


