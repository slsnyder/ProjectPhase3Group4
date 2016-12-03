package student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.StudentDB;
import employment.Company;

/**
 * 
 * @author Sarah Snyder
 *
 */
public class StudentCollection {
	public static StudentDB mStudentDB;

	/**
	 * Return a list of students with the matching name (first OR last).
	 * 
	 * @param name
	 *            student to look for
	 * @return a list of students that match
	 */
	public static List<Student> search(String name) {
		List<Student> list = new ArrayList<Student>();
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
			return mStudentDB.getStudents(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Modify the particular column of the student with the given data.
	 * 
	 * @param student
	 *            Student to modify
	 * @param column
	 *            the field in the table to modify
	 * @param data
	 *            the value for the field
	 * @return true or false
	 */
	public static boolean update(Student student, String column, Object data) {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		// TODO make sure they're not trying to update studentId?
		String message = mStudentDB.updateStudent(student, column, data);
		if (message.startsWith("Error updating student: ")) {
			return false;
		}
		return true;
	}

	public static boolean updateCompany(String company, String data) {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}

		String message = mStudentDB.updateCompany(company, data);
		if (message.startsWith("Error updating company: ")) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns all companies available.
	 * 
	 * @return an array of companies.
	 */
	public static Object[] getCompanies() {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}

		try {
			return mStudentDB.getCompanies();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Adds a new Student to the data.
	 * 
	 * @param student
	 * @return true or false
	 */
	public static boolean add(Student student) {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}

		String message = mStudentDB.addStudent(student);
		if (message.startsWith("Error adding student:")) {
			return false;
		}
		return true;
	}

	public static boolean addCompany(Company company) {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}

		String message = mStudentDB.addCompany(company);
		if (message.startsWith("Error adding company:")) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * Return a student with the given id, null otherwise.
	 * 
	 * @param id
	 *            student to look for
	 * @return student
	 */
	public static Student getStudent(String id) {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
			return mStudentDB.getStudent(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * Return all students in the list, null otherwise.
	 * 
	 * @return list of students
	 */
	public static List<Student> getStudents() {
		if (mStudentDB == null) {
			mStudentDB = new StudentDB();
		}
		try {
			return mStudentDB.getStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
