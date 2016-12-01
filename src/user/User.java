package user;
/**
 * 
 * @author Teddy
 *
 */
public class User {
	private String uUWemail;
	private String uPassword;
	private String uRole;

	/**
	 *  Create a user with the given UW email, password and role.
	 */
	public User(String uwEmail, String password, String role) {
		this.setuUWemail(uwEmail);
		this.setuPassword(password);
		this.setuRole(role);
	}

	/**
	 * @return the uUWemail
	 */
	public String getuUWemail() {
		return uUWemail;
	}

	/**
	 * @param uwEmail the uwEmail to set
	 */
	public void setuUWemail(String uwEmail) {
		this.uUWemail = uwEmail;
	}

	/**
	 * @return the uPassword
	 */
	public String getuPassword() {
		return uPassword;
	}

	/**
	 * @param uPassword the uPassword to set
	 */
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	/**
	 * @return the uRole
	 */
	public String getuRole() {
		return uRole;
	}

	/**
	 * @param uRole the uRole to set
	 */
	public void setuRole(String uRole) {
		this.uRole = uRole;
	}

}
