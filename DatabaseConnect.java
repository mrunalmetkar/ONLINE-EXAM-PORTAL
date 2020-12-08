package demoexamportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
	Connection conn;
	Statement st;
	PreparedStatement ps;

	public Connection openConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;create=true");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection() {
		DatabaseConnect cd = new DatabaseConnect();
		Connection conn = cd.openConnection();

		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Statement getStatement() {
		DatabaseConnect cd = new DatabaseConnect();

		try {
			st = cd.openConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;

	}

	public PreparedStatement getPreparedStatement(String sqlQuery) {
		try {
			ps = this.openConnection().prepareStatement(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	public void enterRegistrationDetails(int prn, String username, String password) {
		DatabaseConnect cd = new DatabaseConnect();
		Connection conn = cd.openConnection();
		try {
			st = conn.createStatement();
			// st.execute("create table studentregister(prn int,username
			// varchar(30),password varchar(30))");
			System.out.println("TABLE CREATED.");

			ps = conn.prepareStatement("insert into studentregister values(?,?,?) ");
			ps.setInt(1, prn);
			ps.setString(2, username);
			ps.setString(3, password);
			/*
			 * ResultSet rs=ps.executeQuery("select * from studentregister"); //rs =
			 * st.executeQuery("select * from studentregister"); while(rs.next()) {
			 * System.out.println(rs.getString(2)+"  "+rs.getString(3)); }
			 */
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		

	}
	
	public void createExamTable(String q,String o1,String o2,String o3,String o4,String ans)
	{
		DatabaseConnect cd = new DatabaseConnect();
		Connection conn = cd.openConnection();
		try {
			Statement st1 = conn.createStatement();
		//	st.execute("create table questiontable(question varchar(100),option1 varchar(20),option2 varchar(20),option3 varchar(100),option4 varchar(20),answer varchar(20))");
			System.out.println("TABLE CREATED.");

			PreparedStatement ps1 = conn.prepareStatement("insert into questiontable values(?,?,?,?,?,?) ");
			ps1.setString(1, q);
			ps1.setString(2, o1);
			ps1.setString(3, o2);
			ps1.setString(4, o3);
			ps1.setString(5, o4);
			ps1.setString(6, ans);
			ps1.executeUpdate();
			System.out.println("record question inserted");

			
			 //ResultSet rs=ps.executeQuery("select * from questiontable"); 
				/*
				 * ResultSet rs1 = st1.executeQuery("select * from questiontable");
				 * while(rs1.next()) {
				 * System.out.println(rs1.getString(2)+"  "+rs1.getString(3)); }
				 */
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void viewQuestion()
	{
		
		DatabaseConnect cd = new DatabaseConnect();
		Connection conn = cd.openConnection();
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from questiontable"); 
			 while(rs.next())
			 {
				 System.out.println("In examtable");
			  System.out.println(rs.getString(1)+"  "+rs.getString(6)); 
			  }
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	public void delQuestion(String q)
	{
		DatabaseConnect cd=new DatabaseConnect();
		Connection conn=cd.openConnection();
		
		String delquery="Delete from questiontable where q=?";
		//String updquery="Update studentregister set password=? where password=?";
		
		try 
		{
			
			PreparedStatement p=conn.prepareStatement(delquery);
			p.setString(1, q);
			boolean rowdel=p.executeUpdate()>0;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public int checkScore(String[] enteredans)
	{
		String ansquery="select answer from questiontable";
		int score = 0;
		int i=0;
		try 
		{
			DatabaseConnect cd=new DatabaseConnect();
			Connection conn=cd.openConnection();
			ResultSet rs;
			Statement s=conn.createStatement();
			s.executeQuery(ansquery);
			rs=s.getResultSet();
			
			while(rs.next())
			{
				
				if(rs.getString(1).equals(enteredans[i]))
				{
					score=score+1;
					
					System.out.println(rs.getString(1));
					System.out.println(i);
				}
				i=i+1;
			}
			
			rs.close();
			s.close();
		}
		catch (SQLException e)
		{
		
			e.printStackTrace();
		
	}
		return score;
}
}
