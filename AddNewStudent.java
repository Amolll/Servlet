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
 * Servlet implementation class AddNewStudent
 */
@WebServlet("/add")
public class AddNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewStudent() {
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
			out.println("<table border='0' align='center'/>");
			out.println("<tr><td>NAME</td><td><input type='text' name='name' value=''/></td></tr>");
			out.println("<tr><td>EMAIL</td><td><input type='text' name='email' value=''/></td></tr>");
			out.println("<tr><td>CONTACT</td><td><input type='text' name='contact' value=''/></td></tr>");
			out.println("<tr><td colspan='2' align='center'><input type='submit' name='s' value='Add New Student'/></td></tr>");
			out.println("</table>");
			out.println("</form>");
			
			String btn=request.getParameter("s");
			if(btn!=null)
			{
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String contact=request.getParameter("contact");
				
				try
				{
					DB db=new DB();
					boolean b=db.isInsert(name, email, contact);
					if(b)
					{
						out.println("Registration Success....................");
					}
					else
					{
						out.println("Registration Failed....................");
					}
	
					
				}
				catch(Exception e)
				{
					out.println(e);
				}
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
