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


@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<h1>EXAM QUESTIONS UPDATE </h1>");
		String ques=request.getParameter("question");
		String o1=request.getParameter("op1");
		String o2=request.getParameter("op2");
		String o3=request.getParameter("op3");
		String o4=request.getParameter("op4");
		String answer=request.getParameter("ans");
		
		DatabaseConnect cd=new DatabaseConnect();
		Connection conn=cd.openConnection();
		
		
		cd.openConnection();
		cd.createExamTable(ques, o1, o2, o3, o4, answer);
		cd.openConnection();
		cd.viewQuestion();
		out.println("<h3>TEST DATABASE UPDATED </h3>");
		
		String delq=request.getParameter("delquestion");
		cd.delQuestion(delq);
		cd.viewQuestion();

		}
		
		
	}


