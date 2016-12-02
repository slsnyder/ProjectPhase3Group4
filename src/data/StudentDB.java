package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employment.Company;
import student.CollegeTransfer;
import student.Student;

public class StudentDB {
	
	private Connection mConnection;
	private List<Student> mStudentList;
	
	/**
	 * Retrieves all students from the Student table.
	 * 
	 * @return list of students
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
				
				String yearStr = new Integer(gradYear).toString();
				Student student = new Student(lastName, firstName, academicProgram,
						degreeLevel, gradTerm, yearStr, gpa, uwEmail, externalEmail);
				student.setId(new Integer(id).toString());
				
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
		
		setCollegeTransfers();
		// TODO include internship/ employment
		
		return mStudentList;
	}
	
	private void setCollegeTransfers() throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
		
		Statement stmt = null;
		String query;
		
		for( Student student : mStudentList) {
			try {
				query = "select * " + "from CollegeTransfer where studentId =  " + student.getId();
				stmt = mConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String schoolName = rs.getString("schoolName");
					double gpa = rs.getDouble("transferGpa");
					String year = new Integer(rs.getInt("transferYear")).toString();
					
					CollegeTransfer ct = new CollegeTransfer(schoolName, gpa, year);
					
					student.setCollegeTransfer(ct);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			} finally {
				if (stmt != null) {
					stmt.close();
				}
			}
		}
	}
	
	/**
	 * Adds a new student to the Student table. 
	 * @param student
	 * @return Returns "Added Student successfully" or "Error adding Student: " with the sql exception.
	 */
	public String addStudent(Student student) {
		String sql = "insert into Student(lastName, firstName, academicProgram, "
				+ "degreeLevel, gradTerm, gradYear, gpa, uwEmail, externalEmail) values "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?); ";

		if (mConnection == null) {
			try {
				mConnection = DataConnection.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = mConnection.prepareStatement(sql);
			preparedStatement.setString(1, student.getLastName());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getAcademicProgram());
			preparedStatement.setString(4, student.getDegreeLevel());
			preparedStatement.setString(5, student.getGradTerm());
			preparedStatement.setInt(6, Integer.parseInt(student.getGradYear()));
			preparedStatement.setDouble(7, student.getGpa());
			preparedStatement.setString(8, student.getUwEmail());
			preparedStatement.setString(9, student.getExternalEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error adding Student: " + e.getMessage();
		}
		return "Added Student successfully";
	}
	
	//TODO
	/**
	 * Retrieves all categories from the ItemCategory table.
	 * 
	 * @return list of categories
	 * @throws SQLException
	 */
	public Object[] getCompanies() throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "select * " + "from Company ";

		List<Company> list = new ArrayList<Company>();
		try {
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("companyName");
				String id = new Integer(rs.getInt("companyId")).toString();
				Company company = new Company(name);
				company.setCompanyId(id);
				list.add(company);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return list.toArray();
	}
}
