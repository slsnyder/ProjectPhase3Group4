package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import student.CollegeTransfer;

/**
 * The Class CollegeTransferTest.
 * @author Teddy
 */
public class CollegeTransferTest {
	
	/** The my college trans. */
	CollegeTransfer myCollegeTrans = new CollegeTransfer("Wartburg",  3.2, "2012");
	
	/**
	 * Sets up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test college transfer.
	 */
	@Test
	public void testCollegeTransfer() {
		new CollegeTransfer("Wartburg",  3.2, "2012");
	}

	/**
	 * Test get school name.
	 */
	@Test
	public void testGetSchoolName() {
		myCollegeTrans.setSchoolName("Bob");
		assertEquals("failed on GetSchoolName", "Bob",
				myCollegeTrans.getSchoolName());
	}

	/**
	 * Test get gpa.
	 */
	@Test
	public void testGetGpa() {
		myCollegeTrans.setGpa(2.3);;
		assertNotNull(myCollegeTrans.getGpa());
	}

	/**
	 * Test get transfer year.
	 */
	@Test
	public void testGetTransferYear() {
		myCollegeTrans.setTransferYear("1994");
		assertEquals("failed on GetSchoolName", "1994",
				myCollegeTrans.getTransferYear());
	}

}
