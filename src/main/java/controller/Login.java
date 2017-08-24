package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.student;
import service.StudentDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
student s = new student();
response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
            String n = request.getParameter("userid");
            String p = request.getParameter("password");
            s.setUserid(n);
            s.setPassword(p);
     
            	StudentDAO sd;
				try {
					sd = new StudentDAO();
            if(sd.searchStudent(s))
            {
            	response.sendRedirect("ViewServlet");
            }
            else
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Unauthorized Access</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>You are Unauthorised</h1></center>");
            out.println("</body>");
            out.println("</html>");
            request.getRequestDispatcher("index.jsp ").include(request, response);
            }
            
	}
				catch (SQLException e) {
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
