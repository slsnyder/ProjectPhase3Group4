/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import employment.Company;
import employment.Employment;
import employment.Employment.EmploymentSkill;

/**
 * @author Teddy
 *
 */
public class EmploymentTest {
	Company myCompany = new Company("Bill");
	Employment myEmployment = new Employment(myCompany, true);
	EmploymentSkill myEmploymentSkill;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link employment.Employment#Employment(employment.Company, boolean)}.
	 */
	@Test
	public void testEmployment() {
		new Employment(myCompany, true);
	}

	/**
	 * Test method for {@link employment.Employment#getEmploymentId()}.
	 */
	@Test
	public void testGetEmploymentId() {
		myEmployment.setEmploymentId("21");
		assertEquals("failed on GetEmploymentId", "21",
				myEmployment.getEmploymentId());
	}

	/**
	 * Test method for {@link employment.Employment#getCompany()}.
	 */
	@Test
	public void testGetCompany() {
		myEmployment.setCompany(myCompany);
		assertEquals("failed on GetCompany", myCompany,
				myEmployment.getCompany());
	}

	/**
	 * Test method for {@link employment.Employment#isCurrent()}.
	 */
	@Test
	public void testIsCurrent() {
		myEmployment.setCurrent(true);
		assertEquals("failed on IsCurrent", true,
				myEmployment.isCurrent());
	}
	
	/**
	 * Test method for {@link employment.Employment#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		myEmployment.setDescription("new");
		assertEquals("failed on GetDescription", "new",
				myEmployment.getDescription());
	}

	/**
	 * Test method for {@link employment.Employment#getSalary()}.
	 */
	@Test
	public void testGetSalary() {
		myEmployment.setSalary(15);
		assertEquals("failed on GetSalary", 15,
				myEmployment.getSalary());
	}
}
