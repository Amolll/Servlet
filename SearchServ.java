package org.techamol;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServ
 */
@WebServlet("/search")
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServ() {
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
		
		out.println("<form name='frm' action='' method='GET'/>");
		out.println("<table border='0' width='50%' align='center'/>");
		out.println("<tr><td><input type='text' name='number' placeholder='Enter Student ID' value=''/></td></tr>");
		out.println("<tr><td><input type='submit' name='s' value='Search Student'/></td></tr>");
		out.println("</table>");
		out.println("</form>");

	    //int regId=17;
	    String btn=request.getParameter("s");
		if(btn!=null)
		{
			int regId=request.getLocalPort();
			out.println(regId);
			out.println("<table border='4' align='center' width='70%'/>");
			out.println("<tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th></tr>");

			
			try
			{
				DB db=new DB();
				java.sql.ResultSet rs=db.isSearch(regId);
				while(rs.next())
				{
					
					out.println("<tr>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("</tr>");
					
				}
			}
			catch(Exception e)
			{
				out.println("Error is "+e);
			}

			out.println("</table>");


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
