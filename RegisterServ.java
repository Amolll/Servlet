package org.techamol;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/reg")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor . 
     */
    public RegisterServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		
		try {
			
			com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstServlet","root","Amol@2121");
			
			if(conn!=null)
			{
				PreparedStatement stmt=conn.prepareStatement("insert into register values(?,?,?)");
				stmt.setString(1,name);
				stmt.setString(2,email);
				stmt.setString(3,contact);
				int value=stmt.executeUpdate();
				
				
			if(value>0)
				{
					out.println("Registeration sucess............");
				}
				else
				{
					out.println("Registration Failed..............");
				}
			}
			else
			{
				out.println("NOT Connected");
			}	
		}
		catch(Exception e)
		{
			out.println("Error is"+e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
