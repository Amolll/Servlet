package org.techamol;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllStudent
 */
@WebServlet("/view")
public class ViewAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher r=request.getRequestDispatcher("master.html");
		r.include(request, response);
		out.println("<br><br>");
		

		out.println("<table border='5' align='center' width='70%'/>");
		out.println("<tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>DELETE</th><th>UPDATE</th></tr>");

		
		try
		{
			DB db=new DB();
			java.sql.ResultSet rs=db.getAllStudentRecords();
			while(rs.next())
			{
				int regid=rs.getInt(1);
				
				out.println("<tr>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td><a href='delete?userid="+regid+"'>Delete</td>");
				out.println("<td><a href=''>Update</td>");
				out.println("</tr>");
				
			}
		}
		catch(Exception e)
		{
			out.println("Error is "+e);
		}

		out.println("</table>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
