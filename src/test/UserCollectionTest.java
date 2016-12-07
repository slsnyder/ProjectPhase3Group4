/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.UserDB;
import user.User;
import user.UserCollection;

/**
 * This is a test class for User collection and UserDB class.
 * @author Teddy
 */
public class UserCollectionTest {

	 private UserDB userDB;
	 private List<User> uList;
	 @SuppressWarnings("unused")
	private static UserCollection myCollection;
	 /**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Test method for {@link user.UserCollection#add(user.User)}.
	 */
	@Test
	public void testAdd() {
		myCollection = new UserCollection();
		User myUser = new User("Elsa", "Fede", "Faculty");
		assertEquals("Failed on add user", true, UserCollection.add(myUser));
		assertNotNull(UserCollection.add(myUser));
	}
	
	/**
	 * Test method for {@link user.UserCollection#add(user.User)}.
	 */
	@Test
	public void testAddNull() {
		User myUser = new User(null, null, null);
		assertEquals("Failed on add client", false, UserCollection.add(myUser));
	}
	
	/**
	 * Test method for {@link user.UserCollection#getUsers()}.
	 * @throws SQLException 
	 */
	@Test 
	public void testGetUsers() throws SQLException {		
		uList = UserCollection.getUsers();
		assertNotNull(uList);
	    
	}
	
	/**
	 * Test method for {@link data.UserDB#addUser()}.
	 * @throws SQLException 
	 */
	@Test 
	public void testAddUserDB() throws SQLException {		
		User myUser = new User("Elsa", "Nesh", "Faculty");
		userDB = new UserDB();
		assertEquals("Failed at add user from userDB", 
				"Added User Successfully", userDB.addUser(myUser));
	    
	}
}
