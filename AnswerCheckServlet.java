package demoexamportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.source.doctree.EndElementTree;


@WebServlet("/AnswerCheckServlet")
public class AnswerCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("<h1>TEST SCORE! </h1>");

		String[] enteredans=request.getParameterValues("testanswer");
		
		
		for(String s:enteredans)
		{
		System.out.println(s);
		}
		
		DatabaseConnect cd=new DatabaseConnect();
		int score=cd.checkScore(enteredans);
		out.println("YOUR SCORE FOR THE TEST IS:"+score);
		

		
		
		
	}

}
