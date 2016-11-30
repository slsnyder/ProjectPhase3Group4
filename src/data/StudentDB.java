package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.Student;

public class StudentDB {
	
	private Connection mConnection;
	private List<Student> mStudentList;
	
	/**
	 * Retrieves all items from the Item table.
	 * 
	 * @return list of items
	 * @throws SQLException
	 */
	public List<Student> getStudents() throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "select * " + "from Student ";

		mStudentList = new ArrayList<Student>();
		try {
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("studentId");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String academicProgram = rs.getString("academicProgram");
				String degreeLevel = rs.getString("degreeLevel");
				String gradTerm = rs.getString("gradTerm");
				int gradYear = rs.getInt("gradYear");
				double gpa = rs.getDouble("gpa");
				String uwEmail = rs.getString("uwEmail");
				String externalEmail = rs.getString("externalEmail");
				
				Student student = null;
				// TODO create student
				// TODO include tranfer/ internship/ employment ?
				/*if (desc == null) {
					item = new Item(name, new ItemCategory(category));
					item.setId(new Integer(id).toString());
				} else {
					item = new Item(name, desc, price, condition,
							new ItemCategory(category));
					item.setId(new Integer(id).toString());
				}*/
				mStudentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return mStudentList;
	}
}
