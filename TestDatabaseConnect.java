package demoexamportal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDatabaseConnect {
	Connection conn;
	ResultSet rs;
	PreparedStatement ps;
	public static void main(String[] args) {
		DatabaseConnect c=new DatabaseConnect();
		//c.parseLoginDetails("mrunalmetkar", "mrunal");
		
			Connection conn=null;
			Statement st;
			PreparedStatement ps = null;
			
			
			try 
			{
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				try
				{
					conn=DriverManager.getConnection("jdbc:derby://localhost:1527/myDB;create=true");
					st=conn.createStatement();
					Statement st1 = conn.createStatement();
					
					 
					
					
					
					ResultSet rs=st.executeQuery("select * from studentregister");
					//ResultSet rs1=st1.executeQuery("select * from questiontable");
					ResultSet rs1=ps.executeQuery("select * from questiontable");
					while(rs.next())
					{
						System.out.println(rs.getString(2)+" "+rs.getString(3));
						
					}
					while(rs1.next())
					{
						System.out.println(rs1.getString(2)+" "+rs1.getString(3));
						
					}
					System.out.println("Data Fetched successfully!!");
					conn.close();
				} catch (SQLException e) 
				{
					
					e.printStackTrace();
				}

			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		
			
	}

}
