package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.User;

/**
 * @author Teddy
 *
 */
public class UserDB {
	private Connection mConnection;
	private List<User> userList;

	/**
	 * Retrieves all users from the User table.
	 * 
	 * @return list of users
	 * @throws SQLException
	 */
	public List<User> getUsers() throws SQLException {
		if (mConnection == null) {
			mConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "select * " + "from User ";

		userList = new ArrayList<User>();
		try {
			stmt = mConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String email = rs.getString("uwEmail");
				String password = rs.getString("password");
				String role = rs.getString("role");
				User user = new User(email, password, role);				
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return userList;
	}
	
	public String addUser(User user) {
		String sql = "insert into User(uwEmail, password, role) values "
				+ "(?, ?, ?); ";

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
			preparedStatement.setString(1, user.getuUWemail());
			preparedStatement.setString(2, user.getuPassword());
			preparedStatement.setString(3, user.getuRole());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error adding user: " + e.getMessage();
		}
		return "Added User Successfully";
	}
}