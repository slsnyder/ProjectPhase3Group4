package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.StudentDB;
import employment.Company;
import student.Student;
import student.StudentCollection;

/**
 * This Class tests the student collection class.
 * @author Teddy
 *
 */
public class StudentCollectionTest {

	 private StudentDB studentDB;
	 private List<Student> sList;
	 @SuppressWarnings("unused")
	private static StudentCollection myCollection;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link student.StudentCollection#search(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	public void testSearch() throws SQLException {
		myCollection = new StudentCollection();
		String name = "name";
		studentDB = new StudentDB();
		sList = new ArrayList<Student>();
		sList = studentDB.getStudents(name);
		assertEquals("Failed on search", sList, StudentCollection.search(name));
	}

	/**
	 * Test method for {@link student.StudentCollection#update(student.Student, java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		Student myStudent = new Student("David", "matt", "CSS",
				"BA", "spring", "1234", 0, "fs@uw.edu", "dsd@yah.Ov");
		myStudent.setId("15");
		Object data = new Object();
		assertEquals(false,StudentCollection.update(myStudent, "lastName", data));
	}

	/**
	 * Test method for {@link student.StudentCollection#updateCompany(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUpdateCompany() {
		@SuppressWarnings("unused")
		Company myCompany = new Company("Apple");
		assertEquals(true,StudentCollection.updateCompany("Apple", "new"));
	}

	/**
	 * Test method for {@link student.StudentCollection#getCompanies()}.
	 * @throws SQLException 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetCompanies() throws SQLException {
		studentDB = new StudentDB();
		Object[] getCom = studentDB.getCompanies();
		assertEquals("Failed on get categories", 
				getCom, StudentCollection.getCompanies());
		assertNotNull(StudentCollection.getCompanies());
	}

	/**
	 * Test method for {@link student.StudentCollection#add(student.Student)}.
	 */
	@Test
	public void testAdd() {
		Student myStudent = new Student("David", "matt", "CSS",
				"BA", "spring", "1234", 0, "fs@uw.edu", "dsd@yah.Ov");
		studentDB = new StudentDB();
		assertEquals("Failed on add Student", true, StudentCollection.add(myStudent));
		assertNotNull(StudentCollection.add(myStudent));
	}

	/**
	 * Test method for {@link student.StudentCollection#addCompany(employment.Company)}.
	 */
	@Test
	public void testAddCompany() {
		Company myCompany = new Company("Apple");
		studentDB = new StudentDB();
		assertEquals("Failed on add Student", false, StudentCollection.addCompany(myCompany));
		assertNotNull(StudentCollection.addCompany(myCompany));
	}

	/**
	 * Test method for {@link student.StudentCollection#getStudent(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	public void testGetStudent() throws SQLException {
		studentDB = new StudentDB();
		sList = studentDB.getStudents();
		String id = "2";
		assertNotNull(StudentCollection.getStudent(id  ));
	}

	/**
	 * Test method for {@link student.StudentCollection#getStudents()}.
	 * @throws SQLException 
	 */
	@Test
	public void testGetStudents() throws SQLException {
		studentDB = new StudentDB();
		sList = studentDB.getStudents();
		assertNotNull(StudentCollection.getStudents());
	}

}
