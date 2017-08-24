package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.student;
import service.StudentDAO;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student</h1>");  
        String userid=request.getParameter("userid");  
        try{ 
        student st= service.StudentDAO.getDetails(userid);
        out.println("<html>");
	    out.println("<head>");
	    out.println("<body>");
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='userid' value='"+st.getUserid()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+st.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Mobileno:</td><td><input type='text' name='mobileno' value='"+st.getMobileno()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+st.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>City</td><td><input type='text' name='city' value='"+st.getCity()+"'/></td></tr>");  
        out.print("<tr><td>Pincode:</td><td><input type='text' name='pincode' value='"+st.getPincode()+"'/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
	    out.println("</body>");
	    out.println("</html>");
        }
        catch (NullPointerException e) {
        	System.out.println("hiee");
			// TODO Auto-generated catch block
			e.printStackTrace();
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
