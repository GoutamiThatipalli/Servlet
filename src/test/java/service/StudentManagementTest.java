
package service;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import model.Student;
public class StudentManagementTest extends TestCase {
	@Test
	public void testInsertStudent(){
		
		StudentManagement dao = new StudentManagement();
		Student expected = new Student();
		expected.setEmail("test@test.com");
		expected.setCity("hyd");
		expected.setMobileno("11111");
		expected.setUserid("1111");
		try {
			dao.insertStudent(expected);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		Student actual1 = dao.getDetails("1111");
		Student actual = dao.getDetails("goutami");
		Assert.assertEquals(expected.getEmail(), actual1.getEmail());
		Assert.assertEquals(expected.getCity(), actual1.getCity());
		Assert.assertNotSame(expected.getEmail(), actual.getUserid());
		try {
			dao.deleteStudent("1111");
		} catch (Exception e) {
		}
		
	}
	@Test
	public void testupdate(){
		StudentManagement dao = new StudentManagement();
		Student expected = new Student();
		expected.setEmail("test@test.com");
		expected.setCity("hyd");
		expected.setMobileno("11111");
		expected.setUserid("goutami");
		expected.setPassword("goutami");
		try {
			dao.updateStudent(expected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student actual=dao.getDetails("goutami");
		//System.out.println(expected);
		Assert.assertEquals(expected.getUserid(), actual.getUserid());
	}
	@Test
	public void testSearchStudent(){
		StudentManagement dao = new StudentManagement();
		Student expected = new Student();
		expected.setUserid("goutami");
		try {
			dao.searchStudent(expected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(expected);
		Assert.assertEquals(expected.getUserid(),"goutami");
		Assert.assertNotSame(expected.getEmail(), "goutami");
	}

}
