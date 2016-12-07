/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import employment.Employment;
import student.CollegeTransfer;
import student.Student;

/**
 * This class tests the Student class.
 * @author Teddy
 *
 */
public class StudentTest {
	private Student myStudent;
	private String mylastName = "Abebe";
	private String myFirstName = "Beso";
	private String myAcademicProgram = "Cs";
	private String myDegreeLevel = "BS";
	private String myGradTerm = "Spring";
	private String myGradYear = "1999";
	private Double myGPA = 3.4;
	private String myuwEmail = "email@uw.edu";
	private String myExternalEmail = "be@yahoo.com";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myStudent = new Student(mylastName, myFirstName, myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#Student(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testStudent() {
		new Student(mylastName, myFirstName, myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getId()}.
	 */
	@Test
	public void testGetId() {
		myStudent.setId("12");
		assertEquals("failed on getId", "12", myStudent.getId());
	}

	/**
	 * Test method for {@link student.Student#setId(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetIdIllegal() {
		myStudent.setId("-1");
	}

	/**
	 * Test method for {@link student.Student#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		myStudent.setLastName("ben");
		assertEquals("failed on GetLastName", "ben", myStudent.getLastName());
	}

	/**
	 * Test method for {@link student.Student#setLastName(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetLastNameIllegal() {
		myStudent = new Student("a", myFirstName, myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		myStudent.setFirstName("ed");
		assertEquals("failed on GetFirstName", "ed", myStudent.getFirstName());
	}

	/**
	 * Test method for {@link student.Student#setFirstName(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetFirstNameIllegal() {
		myStudent = new Student(mylastName, "B", myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getAcademicProgram()}.
	 */
	@Test
	public void testGetAcademicProgram() {
		myStudent.setAcademicProgram("CSS");
		assertEquals("failed on GetAcademicProgram", 
				"CSS", myStudent.getAcademicProgram());
	}

	/**
	 * Test method for {@link student.Student#setAcademicProgram(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetAcademicProgramNull() {
		myStudent = new Student(mylastName, mylastName, null,
				myDegreeLevel, myGradTerm, myGradYear, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getDegreeLevel()}.
	 */
	@Test
	public void testGetDegreeLevel() {
		myStudent.setDegreeLevel("BA");;
		assertEquals("failed on GetDegreeLevel", 
				"BA", myStudent.getDegreeLevel());
	}

	/**
	 * Test method for {@link student.Student#setDegreeLevel(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetDegreeLevelNull() {
		myStudent = new Student(mylastName, mylastName, myAcademicProgram,
				null, myGradTerm, myGradYear, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getGradTerm()}.
	 */
	@Test
	public void testGetGradTerm() {
		myStudent.setGradTerm("Autumn");
		assertEquals("failed on GetGradTerm", 
				"Autumn", myStudent.getGradTerm());
	}

	/**
	 * Test method for {@link student.Student#setGradTerm(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetGradTermNull() {
		myStudent = new Student(mylastName, mylastName, myAcademicProgram,
				myDegreeLevel, null, myGradYear, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getGradYear()}.
	 */
	@Test
	public void testGetGradYear() {
		myStudent.setGradYear("1924");
		assertEquals("failed on GetGradYear", 
				"1924", myStudent.getGradYear());
	}

	/**
	 * Test method for {@link student.Student#setGradYear(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetGradYearNull() {
		myStudent = new Student(mylastName, mylastName, myAcademicProgram,
				myDegreeLevel, myGradTerm, null, 
				myGPA, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getGpa()}.
	 */
	@Test
	public void testGetGpa() {
		myStudent.setGpa(3.2);
		assertNotNull(myStudent.getGpa());
	}

	/**
	 * Test method for {@link student.Student#setGpa(double)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetGpaIllegalNeg() {
		myStudent = new Student(mylastName, mylastName, myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				-2, myuwEmail, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#setGpa(double)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetGpaIllegalPos() {
		myStudent = new Student(mylastName, mylastName, myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				22, myuwEmail, myExternalEmail);
	}
	/**
	 * Test method for {@link student.Student#getUwEmail()}.
	 */
	@Test
	public void testGetUwEmail() {
		myStudent.setUwEmail("asdf@uw.edu");
		assertEquals("failed on GetUwEmail", 
				"asdf@uw.edu", myStudent.getUwEmail());
	}

	/**
	 * Test method for {@link student.Student#setUwEmail(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetUwEmailNull() {
		myStudent = new Student(mylastName, mylastName, myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				myGPA, null, myExternalEmail);
	}

	/**
	 * Test method for {@link student.Student#getExternalEmail()}.
	 */
	@Test
	public void testGetExternalEmail() {
		myStudent.setExternalEmail("asdf@yahoo.com");
		assertEquals("failed on GetExternalEmail", 
				"asdf@yahoo.com", myStudent.getExternalEmail());
	}

	/**
	 * Test method for {@link student.Student#setExternalEmail(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetExternalEmailNull() {
		myStudent = new Student(mylastName, mylastName, myAcademicProgram,
				myDegreeLevel, myGradTerm, myGradYear, 
				myGPA, myuwEmail, null);
	}

	/**
	 * Test method for {@link student.Student#addCollegeTransfer(student.CollegeTransfer)}.
	 */
	@Test
	public void testAddCollegeTransfer() {
		CollegeTransfer ct = null;
		myStudent.addCollegeTransfer(ct);
	}

	/**
	 * Test method for {@link student.Student#getJobs()}.
	 */
	@Test
	public void testGetJobs() {
		Employment job = null;
		myStudent.addJob(job);;
		
		assertNotNull(myStudent.getJobs());
	}

	/**
	 * Test method for {@link student.Student#getInternships()}.
	 */
	@Test
	public void testGetInternships() {
		Employment internship = null;
		myStudent.addInternship(internship);
		
		assertNotNull(myStudent.getInternships());
	}
}
