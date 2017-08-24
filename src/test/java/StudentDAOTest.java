import org.eclipse.jdt.internal.compiler.batch.Main;

import service.StudentDAO;

public class StudentDAOTest {

public static void main (String[] args){
	
	StudentDAOTest test = new StudentDAOTest();
	test.TestgetDetails();
}

	public void TestgetDetails() {

		try {
			StudentDAO dao = new StudentDAO();
			dao.getDetails("nikhil");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
