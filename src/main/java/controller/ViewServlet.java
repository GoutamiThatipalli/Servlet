package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentManagement;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
        Student s=new Student();
        StudentManagement sd;
        try {
			sd = new StudentManagement();
        ResultSet rs = sd.selectStudent(s);
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Home Page</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<center><h1>Welcome "+" You are authorised!"+"</h1></center><br/>");
        out.println("<center><form>");
        out.println("<table border='1' cellspacing='3' cellpadding='2'>");
        out.println("<tr><td> UserID </td> <td>Password</td> <td>Mobileno</td><td>Email</td><td>City</td><td>Pincode</td>");
        while(rs.next())
    	{
        out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>");
        out.println("<td> <a href='EditServlet?userid="+rs.getString(1)+"'>edit</a></td>"
        		+ " <td><a href='DeleteServlet?userid="+rs.getString(1)+"'>delete</a></td></tr>");
    	}
        
    out.println("</table>");
    out.println("</form>");
    out.println("</center>");
    out.println("</body>");
    out.println("</html>");
        } catch (SQLException e) {
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
