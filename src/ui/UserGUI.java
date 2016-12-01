package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import user.User;
import user.UserCollection;

/**
 * 
 * @author Teddy
 *
 */
public class UserGUI extends JPanel implements ActionListener{
	/**
	 * A serial ID.
	 */
	private static final long serialVersionUID = -4714234470560213087L;
	private List<User> uList;

	private JPanel pnlLogin;
	private JPanel pnlRegister;
	private JPanel comboPanel;
	private JLabel[] txtLabel = new JLabel[2];
	private JTextField emailLoginField, emailRegField;
	private JPasswordField loginPassField = new JPasswordField();
	private JPasswordField[] regPassField = new JPasswordField[2];
	private JComboBox cmbRoles;
	private JButton btnRegisterUser, btnLoginUser;
	private JCheckBox showHide = new JCheckBox("Show/Hide");
	
	private JLabel lblEmailLogin, lblEmailReg;
	private String labelPassword[] = {"Enter Password: ",
					"Confirm Password: "};
	/**
	 * Use this for Item administration. Add components that contain the list,
	 * search and add to this.
	 */
	public UserGUI() {
		setLayout(new BorderLayout());
		getData(null);
		createComponents();
		setVisible(true);
		setSize(500, 500);
	}

	/**
	 * 
	 * @param searchKey
	 * @return
	 */
	private List<User> getData(String searchKey) {

		if (searchKey != null)
			uList = UserCollection.getUsers();
		else
			uList = UserCollection.getUsers();

		return uList;
	}
	
	/**
	 * 
	 */
	private void createComponents() {
		JLabel lblLogin = new JLabel("Login!");
		JPanel pnlLog = new JPanel();
		BevelBorder border = new BevelBorder(1);
		pnlLog.setBorder(border);
		pnlLog.add(lblLogin);
		add(pnlLog, BorderLayout.NORTH);
		
		pnlLogin = new JPanel();
		loginPanel();
		add(pnlLogin, BorderLayout.CENTER);
		
		pnlRegister = new JPanel();
		JLabel reg = new JLabel("Register!");
		JPanel pnlReg = new JPanel();
		pnlReg.add(reg);
		pnlReg.setBorder(border);
		pnlRegister.add(pnlReg);
		registerPanel();
		add(pnlRegister, BorderLayout.SOUTH);
	}
	/**
	 * 
	 */
	private void loginPanel() {
		pnlLogin.setLayout(new GridLayout(5, 0));
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new GridLayout(1, 3));
		lblEmailLogin = new JLabel ("Enter UW Email:");
		emailPanel.add(lblEmailLogin);
		emailLoginField = new JTextField(15);
		emailPanel.add(emailLoginField);
		JLabel empty = new JLabel(" ");
		emailPanel.add(empty);
		pnlLogin.add(emailPanel);
		
		for (int i = 0; i < labelPassword.length-1; i++) {
			JPanel panel = new JPanel();
			txtLabel[i] = new JLabel(labelPassword[i]);
			loginPassField = new JPasswordField(15);	
			showHide.addActionListener(this);
			loginPassField.setEchoChar('*');

			panel.add(txtLabel[i]);		
			panel.setLayout(new GridLayout(1, 3));
			panel.add(loginPassField);
			panel.add(showHide);
			
			pnlLogin.add(panel);
		}
		
		
		JPanel panel = new JPanel();
		btnLoginUser = new JButton("Login");
		btnLoginUser.addActionListener(this);
		panel.add(btnLoginUser);		
		pnlLogin.add(panel);
		pnlLogin.add(new JSeparator(SwingConstants.HORIZONTAL));
		
	}
	/**
	 * 
	 */
	private void registerPanel() {
		pnlRegister.setLayout(new GridLayout(6, 0));
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new GridLayout(1, 3));
		lblEmailReg = new JLabel ("Enter UW Email:");
		emailPanel.add(lblEmailReg);
		emailRegField = new JTextField(15);
		emailPanel.add(emailRegField);
		pnlRegister.add(emailPanel);
		
		for (int i = 0; i < labelPassword.length; i++) {
			JPanel newPanel = new JPanel();
			newPanel.setLayout(new GridLayout(1, 0));
			txtLabel[i] = new JLabel(labelPassword[i]);
			regPassField[i] = new JPasswordField(15);
			newPanel.add(txtLabel[i]);
			newPanel.add(regPassField[i]);
			pnlRegister.add(newPanel);
		}

		comboPanel = new JPanel();
		comboPanel.setLayout(new GridLayout(1, 1));
		String[] roles = {"Advisor", "Faculty", "Administrator"};
		if (roles != null) {
			cmbRoles = new JComboBox(roles);
			comboPanel.add(new JLabel("Select category:"));
			comboPanel.add(cmbRoles);
			pnlRegister.add(comboPanel);
		}

		JPanel panel = new JPanel();
		btnRegisterUser = new JButton("Register");
		btnRegisterUser.addActionListener(this);
		panel.add(btnRegisterUser);
		pnlRegister.add(panel);
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLoginUser) {			
			getData(null);
			performLogin();
			this.repaint();

		} else if (e.getSource() == btnRegisterUser) {
			getData(null);
			performRegister();			
			this.repaint();
		} else if (e.getSource() == showHide) {
			if (showHide.isSelected())
				loginPassField.setEchoChar((char)0);
			else
				loginPassField.setEchoChar('*');
			this.repaint();
		}
	}

	/**
	 * 
	 */
	private void performLogin() {
		String email = emailLoginField.getText();		
		User theUser = null;
		char[] password = loginPassField.getPassword();
		String passwordString = new String(password);
		email.toLowerCase();

		for (int i = 0; i < uList.size(); i++) {
			if (uList.get(i).getuUWemail().contentEquals(email.toLowerCase())) {
				
				theUser = new User(uList.get(i).getuUWemail(), uList.get(i).getuPassword(), 
						uList.get(i).getuRole());
				
				if(theUser.getuPassword().contentEquals(passwordString)) {
					if(theUser.getuRole().contentEquals("Advisor") || 
							theUser.getuRole().contentEquals("Administrator")) {
						JOptionPane.showMessageDialog(null, "Logged in Successfully as admin/advisor");
					} else if (theUser.getuRole().contentEquals("Faculty")) {
						JOptionPane.showMessageDialog(null, "Logged in Successfully as faculty");
					}
					return;
				} else if (!password.equals(theUser.getuPassword())){
					JOptionPane.showMessageDialog(null, "Wrong Password");
					loginPassField.setFocusable(true);
					return; 
				} else //Just in case
					JOptionPane.showMessageDialog(null, "The system has failed."
						+ "Please contact the system administrator.");
				return; 
			} 
		}
		
		if (theUser == null) {
			JOptionPane.showMessageDialog(null, "Can't find Email");
			emailLoginField.setFocusable(true);
			return;
		}
	}
	
	
	
	/**
	 * 
	 */
	private void performRegister() {
		String email = emailRegField.getText();
		
		// min and max email length required
		if (email.length() < 8 || email.length() > 15 || email.contains(" ") ||
				!email.toLowerCase().endsWith("@uw.edu")) {
			JOptionPane.showMessageDialog(null, "Enter proper email address "
					+ "ending with '@uw.edu' \n   "
					+ "    Maximum email character allowed is 15.");
			emailRegField.setFocusable(true);
			return;
		}
		
		for (int i = 0; i < uList.size(); i++) {
			if (uList.get(i).getuUWemail().contentEquals(email.toLowerCase())) {
				JOptionPane.showMessageDialog(null, " You already have an account."
						+ "\n Contact the system administrator if you forgot your password.");
				emailRegField.setFocusable(true);
				return;
			}
		}
		
		char[] password = regPassField[0].getPassword();
		String passString = new String(password);
		char[] confirmPass = regPassField[1].getPassword();
		String confirmPassString = new String(confirmPass);
		// min password length required
		if (passString.length() < 4 || passString.length() > 20) {
			JOptionPane.showMessageDialog(null, "Enter a password between 4 to 20 characters");
			regPassField[0].setFocusable(true);
			return;
		}
		if (!passString.contentEquals(confirmPassString)) {
			JOptionPane.showMessageDialog(null, "Your password did not match.");
			regPassField[0].setFocusable(true);
			regPassField[1].setFocusable(true);
			regPassField[1].setText("");
			return;
		}
		//Just in case
		String role = (String) cmbRoles.getSelectedItem();
		if (role == null) {
			JOptionPane.showMessageDialog(null,"Please add your Role.");
			cmbRoles.setFocusable(true);
			return;
		}

		User user = new User (email.toLowerCase(), passString, role);	
		String message = "User add failed.";
		if (UserCollection.add(user)) {
			message = "User added.";
		}
		JOptionPane.showMessageDialog(null, message);

		regPassField[0].setText("");
		regPassField[1].setText("");
		emailRegField.setText("");
	}
}