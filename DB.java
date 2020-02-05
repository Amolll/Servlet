package org.techamol;
import java.sql.*;
public class DB 
{
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public DB()throws Exception
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Miniproject1","root","Amol@2121");
	}
	public boolean isInsert(String name,String email,String contact)throws Exception
	{
		stmt=conn.prepareStatement("insert into register values('0',?,?,?)");
		stmt.setString(1, name);
		stmt.setString(2, email);
		stmt.setString(3, contact);
		int value=stmt.executeUpdate();
		
		if(value>0)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public ResultSet getAllStudentRecords()throws Exception
	{
		stmt=conn.prepareStatement("select *from register");
		rs=stmt.executeQuery();
		return rs;
	}
	
	public boolean isDelete(int regId)throws Exception
	{
 		stmt=conn.prepareStatement("delete from register where regid=?");
		stmt.setInt(1, regId);
		int value=stmt.executeUpdate();
		if(value>0)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	public ResultSet isSearch(int regId)throws Exception
	{
 		stmt=conn.prepareStatement("select * from register where regid=?");
		stmt.setInt(1, regId);
		rs=stmt.executeQuery();
		return rs;	
	}
	
}
