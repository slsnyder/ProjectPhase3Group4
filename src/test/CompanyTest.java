package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import employment.Company;

/**
 * The Class CompanyTest.
 * @author Teddy
 */
public class CompanyTest {

	Company myCompany = new Company("Wartburg");
	/**
	 * Set up the test class.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test company.
	 */
	@Test
	public void testCompany() {
		new Company("Wartburg");
	}

	/**
	 * Test get company name.
	 */
	@Test
	public void testGetCompanyName() {
		myCompany.setCompanyName("Don");
		assertEquals("failed on GetSchoolName", "Don",
				myCompany.getCompanyName());
	}

}
