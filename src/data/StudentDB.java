package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employment.Employment;
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
				Student student = new Student(lastName, firstName,
						academicProgram, degreeLevel, gradTerm, yearStr, gpa,
						uwEmail, externalEmail);
				student.setId(new Integer(id).toString());

				setupCollegeTransfers(student);
				setupEmployment(student);
				setupInternships(student);

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

	/**
	 * Returns all students that contain the search keyword in the first name or
	 * last name.
	 * 
	 * @param name
	 * @return list of students that match.
	 * @throws SQLException
	 */
	public List<Student> getStudents(String name) throws SQLException {
		List<Student> filterList = new ArrayList<Student>();
		if (mStudentList == null) {
			getStudents();
		}
		name = name.toLowerCase();
		for (Student student : mStudentList) {
			if (student.getFirstName().toLowerCase().contains(name)) {
				filterList.add(student);
			} else if (student.getLastName().toLowerCase().contains(name)) {
				filterList.add(student);
			}
		}
		return filterList;
	}

	private void setupCollegeTransfers(Student student) throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}

		Statement stmt = null;
		String query;

		try {
			query = "select * " + "from CollegeTransfer where studentId =  "
					+ student.getId();
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String schoolName = rs.getString("schoolName");
				double gpa = rs.getDouble("transferGpa");
				String year = new Integer(rs.getInt("transferYear")).toString();

				CollegeTransfer ct = new CollegeTransfer(schoolName, gpa, year);

				student.addCollegeTransfer(ct);
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

	private void setupEmployment(Student student) throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}

		Statement stmt = null;
		String query;

		try {
			query = "select * " + "from Employment where studentId =  "
					+ student.getId() + " and internship = 0";
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String companyName = rs.getString("companyName");
				boolean current = true;
				if (rs.getShort("current") == 0) {
					current = false;
				}
				Employment e = new Employment(new Company(companyName), current);

				String desc = rs.getString("positionDescription");
				int salary = rs.getInt("salary");
				if (desc != null) {
					e.setDescription(desc);
				}
				if (salary != 0) {
					e.setSalary(salary);
				}

				student.addJob(e);
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

	private void setupInternships(Student student) throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}

		Statement stmt = null;
		String query;

			try {
				query = "select * " + "from Employment where studentId =  "
						+ student.getId() + " and internship <> 0";
				stmt = mConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String companyName = rs.getString("companyName");
					boolean current = true;
					if (rs.getShort("current") == 0) {
						current = false;
					}
					Employment e = new Employment(new Company(companyName),
							current);

					String desc = rs.getString("positionDescription");
					int salary = rs.getInt("salary");
					if (desc != null) {
						e.setDescription(desc);
					}
					if (salary != 0) {
						e.setSalary(salary);
					}

					student.addInternship(e);
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

	/**
	 * Adds a new student to the Student table.
	 * 
	 * @param student
	 * @return Returns "Added Student successfully" or "Error adding Student: "
	 *         with the sql exception.
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
			preparedStatement
					.setInt(6, Integer.parseInt(student.getGradYear()));
			preparedStatement.setDouble(7, student.getGpa());
			preparedStatement.setString(8, student.getUwEmail());
			preparedStatement.setString(9, student.getExternalEmail());
			preparedStatement.executeUpdate();
			// TODO college transfer / employment / internship ?
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error adding student: " + e.getMessage();
		}
		return "Added Student Successfully";
	}

	/**
	 * Modifies the data on a Student // TODO transfers, employment, internships
	 * cannot be changed here
	 * 
	 * @param row
	 * @param columnName
	 * @param data
	 * @return Returns a message with success or failure.
	 */
	public String updateStudent(Student student, String columnName, Object data) {

		int id = Integer.parseInt(student.getId());
		String sql = "update Student set `" + columnName
				+ "` = ?  where studentId = ? ";
		// For debugging - System.out.println(sql);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = mConnection.prepareStatement(sql);
			if (data instanceof String)
				preparedStatement.setString(1, (String) data);
			else if (data instanceof Double)
				preparedStatement.setDouble(1, (Double) data);
			preparedStatement.setInt(2, id); // for id = ?
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return "Error updating student: " + e.getMessage();
		}
		return "Updated Student Successfully";

	}

	/**
	 * Retrieves all companies from the Company table.
	 * 
	 * @return list of companies
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
				Company company = new Company(name);
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

	/**
	 * Modifies the data on an Company - Only name can be modified.
	 * 
	 * @param company
	 *            to modify
	 * @param data
	 * @return Returns a message with success or failure.
	 */
	public String updateCompany(String company, String data) {
		String sql = "update Company set companyName= ?  where companyName= ?";
		// For debugging - System.out.println(sql);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = mConnection.prepareStatement(sql);
			preparedStatement.setString(1, data);
			preparedStatement.setString(2, company);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return "Error updating category: " + e.getMessage();
		}
		return "Updated Category Successfully";
	}

	/**
	 * Adds a new company to the Company table. 
	 * @param company
	 * @return Returns "Added Company Successfully" or "Error adding company: " with the sql exception.
	 */
	public String addCompany(Company company) {
		String sql = "insert into Company values "
				+ "(?); ";

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
			preparedStatement
					.setString(1, company.getCompanyName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error adding company: " + e.getMessage();
		}
		return "Added Company Successfully";
	}

	/**
	 * Retrieve the student with the given id or null if not found.
	 * 
	 * @param id
	 * @return student
	 * @throws SQLException
	 */
	public Student getStudent(String id) throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "select * " + "from Student where studentId = " + id;

		try {
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
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
				Student student = new Student(lastName, firstName,
						academicProgram, degreeLevel, gradTerm, yearStr, gpa,
						uwEmail, externalEmail);
				student.setId(new Integer(id).toString());

				setupCollegeTransfers(student);
				setupEmployment(student);
				setupInternships(student);
				
				return student;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return null;
	}
}
