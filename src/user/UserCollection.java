package user;

import java.sql.SQLException;
import java.util.List;

import data.UserDB;

/**
 * 
 * @author Teddy
 *
 */
public class UserCollection {
	private static UserDB uUserDB;
	
	/**
	 * 
	 * @return
	 */
	public static List<User> getUsers() {
		if (uUserDB == null) {
			uUserDB = new UserDB();
		}
		try {
			return uUserDB.getUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Adds a new user to the data.
	 * 
	 * @param user
	 * @return true or false
	 */
	public static boolean add(User user) {
		if (uUserDB == null) {
			uUserDB = new UserDB();
		}

		String message = uUserDB.addUser(user);
		if (message.startsWith("Error adding user:")) {
			return false;
		}
		return true;
	}
}