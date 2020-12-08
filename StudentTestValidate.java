package demoexamportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentTestValidate")
public class StudentTestValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("WeLCOME TO THE TEST");
		DatabaseConnect cd=new DatabaseConnect();
		Connection conn=cd.openConnection();
		ResultSet rs;
		
		List questionlist=new ArrayList();
		String query="select question,option1,option2,option3,option4 from questiontable";
		try 
		{
			Statement s=conn.createStatement();
			s.executeQuery(query);
			rs=s.getResultSet();
			while(rs.next())
			{
				questionlist.add(rs.getString("question"));
				System.out.println(rs.getString("question"));
				questionlist.add(rs.getString("option1"));
				questionlist.add(rs.getString("option2"));
				questionlist.add(rs.getString("option3"));
				questionlist.add(rs.getString("option4"));
			}
			
			rs.close();
			s.close();
		}
		catch (SQLException e)
		{
		
			e.printStackTrace();
		}
		
		request.setAttribute("Questions", questionlist);
		RequestDispatcher d=request.getRequestDispatcher("TestPage.jsp");
		
		if(d!=null)
		{
			d.forward(request, response);
		}
		
		
		
		
	}

}
