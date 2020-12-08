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


@WebServlet("/StudentOperations")
public class StudentOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("<h1>UPDATE STUDENT PROFILE </h1>");
		String user1=request.getParameter("oldpassword");
		String pass1=request.getParameter("newpassword");
		String deluser=request.getParameter("uname");
		String oldpass=request.getParameter("oldpassword");
		String newpass=request.getParameter("newpassword");

		DatabaseConnect cd=new DatabaseConnect();
		Connection conn=cd.openConnection();
		
		String delquery="Delete from studentregister where username=?";
		String updquery="Update studentregister set password=? where password=?";
		
		try 
		{
			PreparedStatement p=conn.prepareStatement(delquery);
			p.setString(1, deluser);
			boolean rowdel=p.executeUpdate()>0;
			PreparedStatement p1=conn.prepareStatement(updquery);
			p1.setString(1, newpass);
			p1.setString(2, oldpass);
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
		
	}
	

}
