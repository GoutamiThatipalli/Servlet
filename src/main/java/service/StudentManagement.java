package service;
import java.sql.*;
import java.util.Set;

import model.Student;
public class StudentManagement 
{
        Boolean status = false; 
        static Connection con;
	static PreparedStatement ps;
	ResultSet rs;
	//static student s;
	public StudentManagement() 
	{
		try{
			con = util.connection.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public Boolean searchStudent(Student s) throws SQLException
        {
        	con = util.connection.getConnection();
            ps = con.prepareStatement("select * from Register where userid=? and password=?");
            ps.setString(1, s.getUserid());
            ps.setString(2, s.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                 status = true;
            } 
            return status;
            
            
	 }
        
        public Boolean insertStudent(Student s) throws SQLException
        {
        	con = util.connection.getConnection();
            ps = con.prepareStatement("insert into Register values(?,?,?,?,?,?)");
            ps.setString(1,s.getUserid());
            ps.setString(2,s.getPassword());
            ps.setString(3,s.getMobileno());
            ps.setString(4,s.getEmail());
            ps.setString(5,s.getCity());
            ps.setString(6,s.getPincode());
            int a = ps.executeUpdate();
            if (a == 1)
            {
                status = true;
            }	
	return status;		
        }
        
        public ResultSet selectStudent(Student s) throws SQLException
        {
        	con = util.connection.getConnection();
        	PreparedStatement pstmt = con.prepareStatement("select * from Register");
        	rs = pstmt.executeQuery();
            return rs;    
        }
        
        public static Student getDetails(String userid)
        {
        	Student s=new Student();
        	try {
				con = util.connection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from Register where userid=?"); 
				ps.setString(1,userid);
				ResultSet rs=ps.executeQuery();  
				if(rs.next()){  
	                s.setUserid(rs.getString(1));  
	                s.setPassword(rs.getString(2));  
	                s.setMobileno(rs.getString(3));  
	                s.setEmail(rs.getString(4));  
	                s.setCity(rs.getString(5));  
	                s.setPincode(rs.getString(6));
	               // System.out.println(rs.getString(6));
	            }  
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
        	
        }
      public static int updateStudent(Student s) throws SQLException
        {
        	
       
        	con = util.connection.getConnection();
            ps = con.prepareStatement("update Register set password=?,mobileno=?,email=?,city=?,pincode=? where userid=?");
            
           
            ps.setString(1,s.getPassword());
            ps.setString(2,s.getMobileno());
            ps.setString(3,s.getEmail());
            ps.setString(4,s.getCity());
            ps.setString(5,s.getPincode());
            ps.setString(6,s.getUserid());
            
            int status1 = ps.executeUpdate();
            
          //  System.out.println(s.getUserid());
            return status1;
        }
      
      public static int deleteStudent(String userId) throws SQLException
      {
     
      	  con = util.connection.getConnection();
          ps = con.prepareStatement("delete from Register where userid=?");
          
         
          ps.setString(1,userId);
          
          int status1 = ps.executeUpdate();
          
          return status1;
      }
        
        
}
