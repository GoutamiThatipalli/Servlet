package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentManagement;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		Student s = new Student();
        PrintWriter out = response.getWriter();
        String n = request.getParameter("userid");
        String p = request.getParameter("password");
        String m = request.getParameter("mobile");
        String e = request.getParameter("email");
        String c = request.getParameter("city");
        String pi = request.getParameter("pincode");
        
        s.setUserid(n);
        s.setPassword(p);
        s.setMobileno(m);
        s.setEmail(e);
        s.setCity(c);
        s.setPincode(pi);
        
        try {
        	StudentManagement sd=new StudentManagement();
			if(sd.insertStudent(s))
			{
			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<title>Success</title>");
			    out.println("<body>");
			    out.println("<fieldset>");
			    out.println("<legend align='center'>Success</legend><br/>");
			    out.println("<h1> Your Resitration is successful!</h1>");
			    out.println("<form action='index.jsp'>");
			    out.println("<input type='submit' value='Back To Login Page'>");
			    out.println("</fieldset>");
			    out.println("</form>");
			    out.println("</body>");
			    out.println("</html>");   
			}
			else
			{
			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<title>Unsuccessful</title>");            
			    out.println("</head>");
			    out.println("<body>");
			    out.println("<center><h1>You Registration was unsuccessful/h1></center>");
			    out.println("</body>");
			    out.println("</html>");
			    request.getRequestDispatcher("Register.html").include(request, response);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
