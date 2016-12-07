/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import user.User;

/** 
 * This class tests methods in User class.
 * @author Teddy
 */
public class UserTest {

	private User myUser;
	private String myEmail = "email@uw.edu";
	private String myPassword = "1234";
	private String myRole = "Advisor";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link user.User#User(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUser() {
		new User(myEmail, myPassword, myRole);
	}

	/**
	 * Test method for {@link user.User#getuUWemail()}.
	 */
	@Test
	public void testGetuUWemail() {
		myUser = new User(myEmail, myPassword, myRole);
		myUser.setuUWemail("ant");
		assertEquals("failed on getUWEmail", "ant", myUser.getuUWemail());
	}

	/**
	 * Test method for {@link user.User#getuPassword()}.
	 */
	@Test
	public void testGetuPassword() {
		myUser = new User(myEmail, myPassword, myRole);
		myUser.setuPassword("pass");
		assertEquals("failed on getuPassword", "pass", myUser.getuPassword());
	}
	
	/**
	 * Test method for {@link user.User#getuRole()}.
	 */
	@Test
	public void testGetuRole() {
		myUser = new User(myEmail, myPassword, myRole);
		myUser.setuRole("Administrator");
		assertEquals("failed on getuRole", "Administrator", myUser.getuRole());
	}
}
