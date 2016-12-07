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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import student.Student;
import student.StudentCollection;
import user.User;
import user.UserCollection;

/**
 * The Class UserGUI. It allows to login or register a user
 * and then allows the user to either add student or run report.
 *
 * @author Teddy
 */
public class UserGUI extends JPanel implements ActionListener, TableModelListener{
	/**
	 * A serial ID.
	 */
	private static final long serialVersionUID = -4714234470560213087L;
	
	/** The user list. */
	private List<User> uList;
	
	/** The student list. */
	private List<Student> sList;
	private JPanel pnlLogin, pnlRegister, comboPanel;
	private JLabel[] txtLabel = new JLabel[2];
	private JTextField emailLoginField, emailRegField;
	/** The login pass field. */
	private JPasswordField loginPassField = new JPasswordField();
	/** The register pass field. */
	private JPasswordField[] regPassField = new JPasswordField[2];
	
	/** The cmb roles. */
	private JComboBox cmbRoles;
	private JButton btnRegisterUser, btnLoginUser;
	private JCheckBox showHide = new JCheckBox("Show/Hide");
	private JPanel pnlAdd, pnlReport, pnlContent;
	private BevelBorder border = new BevelBorder(1);
	private JLabel lblEmailLogin, lblEmailReg;
	
	/** The label password. */
	private String labelPassword[] = {"Enter Password: ",
					"Confirm Password: "};
	
	/** The label add. */
	private String labelAdd[] = {"Enter Last Name: ",
			"Enter First Name: ",
			"Enter Academic Program: ",
			"Enter Degree Level: ",
			"Enter Grad Term: ",
			"Enter Grad Year: ",
			"Enter GPA: ",
			"Enter UW Email: ",
			"Enter External Email: "};
	
	private JButton addCollegeTrans, addEmploy, addIntern, addStudent, generateReport;
	
	/** The txt add field. */
	private JTextField[] txtAddField;
	private JButton btnAddStudent, btnRunReport;
	/** The student data. */
	private Object[][] sData;
	/** The student column names. */
	private String[] studentColumnNames = { "lastName", "firstName", "academicProgram",
			"degreeLevel", "gradTerm", "gradYear", "GPA", "uwEmail", "externalEmail" };
	
	private JTable table;
	private JScrollPane scrollPane;
//	private String[] lastNames;
//	, firstNames, academicPrograms, degreeLevels
//	, gradTerms, gradYears, uwEmails, externalEmails = new String[10];
//	private Double[] GPAs = new Double[10];
	/**
	 * Use this for User administration. Contains all components.
	 */
	public UserGUI() {
		setLayout(new BorderLayout());
		getUserData(null);
		getStudentData(null);
		createComponents();
		setVisible(true);
		setSize(500, 500);
	}

	/**
	 * Gets the user data.
	 *
	 * @param searchKey the search key
	 * @return the user data
	 */
	private List<User> getUserData(String searchKey) {
		if (searchKey != null)
			uList = UserCollection.getUsers();
		else
			uList = UserCollection.getUsers();

		return uList;
	}
	
	/**
	 * Gets the student data.
	 *
	 * @param searchKey the search key
	 * @return the student data
	 */
	private List<Student> getStudentData(String searchKey) {
		if (searchKey != null)
			sList = StudentCollection.search(searchKey);
		else
			sList = StudentCollection.getStudents();

		if (sList != null) {
			sData = new Object[sList.size()][studentColumnNames.length];
			for (int i = 0; i < sList.size(); i++) {
				sData[i][0] = sList.get(i).getLastName();
				sData[i][1] = sList.get(i).getFirstName();
				sData[i][2] = sList.get(i).getAcademicProgram();
				sData[i][3] = sList.get(i).getDegreeLevel();
				sData[i][4] = sList.get(i).getGradTerm();
				sData[i][5] = sList.get(i).getGradYear();
				sData[i][6] = sList.get(i).getGpa();
				sData[i][7] = sList.get(i).getUwEmail();
				sData[i][8] = sList.get(i).getExternalEmail();
			}
		}
		return sList;
	}
	
	/**
	 * Creates the components.
	 */
	private void createComponents() {
		pnlLogin = new JPanel();
		JLabel lblLogin = new JLabel("Login!");
		JPanel pnlLogi = new JPanel();
		pnlLogi.add(lblLogin);
		pnlLogi.setBorder(border);
		pnlLogin.add(pnlLogi);
		loginPanel();
		add(pnlLogin, BorderLayout.NORTH);
		
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
	 * Login panel.
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
	 * Register panel.
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
	 * Make the buttons work!.
	 *
	 * @param e the event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLoginUser) {			
			getUserData(null);
			performLogin();
			this.repaint();

		} else if (e.getSource() == btnRegisterUser) {
			getUserData(null);
			performRegister();			
			this.repaint();
		} else if (e.getSource() == showHide) {
			if (showHide.isSelected())
				loginPassField.setEchoChar((char)0);
			else
				loginPassField.setEchoChar('*');
			this.repaint();
		}
		else if (e.getSource() == addCollegeTrans) {
			collegeTransfer();
			this.repaint();
		}
		else if (e.getSource() == addEmploy) {
			employmentHistory();
			this.repaint();
		}
		else if (e.getSource() == addIntern) {
			internHistory();
			this.repaint();
		}
		else if (e.getSource() == addStudent) {
			performAddStudent();
			this.repaint();
		}
		else if (e.getSource() == btnRunReport) {
			getStudentData(null);
			pnlContent.removeAll();	
			runReport();
			pnlContent.revalidate();
			add(pnlContent, BorderLayout.CENTER);
			this.repaint();
		}
		else if (e.getSource() == btnAddStudent) {
			getStudentData(null);
			pnlContent.removeAll();	
			addPanel();
			pnlContent.revalidate();
			add(pnlContent, BorderLayout.CENTER);
			this.repaint();
		}
	}

	
	/**
	 * Perform login.
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
				checkLoginPass(theUser, passwordString);
				return; 
			} else if (uList.get(i).getuUWemail().contentEquals(email.toLowerCase() + "@uw.edu")) {
				
				theUser = new User(uList.get(i).getuUWemail(), uList.get(i).getuPassword(), 
						uList.get(i).getuRole());
				checkLoginPass(theUser, passwordString);
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
	 * Checks the login password.
	 *
	 * @param theUser the the user
	 * @param passwordString the password string
	 */
	public void checkLoginPass(User theUser, String passwordString) {
		if(theUser.getuPassword().contentEquals(passwordString)) {
			if(theUser.getuRole().contentEquals("Advisor") || 
					theUser.getuRole().contentEquals("Administrator")) {
				pnlContent = new JPanel();
				afterLogin();
				add(pnlContent, BorderLayout.CENTER);
			} else if (theUser.getuRole().contentEquals("Faculty")) {
				pnlContent = new JPanel();
				afterLogin();
				btnRunReport.setVisible(false);
				add(pnlContent, BorderLayout.CENTER);
			} else // Just in case
				JOptionPane.showMessageDialog(null, "Please contact the system administrator.");			
			return;
		} else if (!passwordString.equals(theUser.getuPassword())){
			JOptionPane.showMessageDialog(null, " Wrong Password!"
					+ "\n Please try again or contact the "
					+ "\n system administrator to reset your password.");
			loginPassField.setFocusable(true);
			return; 
		} else //Just in case
			JOptionPane.showMessageDialog(null, "The system has failed."
				+ "Please contact the system administrator.");
	}
	
	/**
	 * Coordinates what to do After login.
	 */
	private void afterLogin() {
		pnlLogin.removeAll();
		remove(pnlLogin);
		pnlRegister.removeAll();
		remove(pnlRegister);
		pnlContent = new JPanel();
		btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(this);
		btnRunReport = new JButton("Run Report");
		btnRunReport.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(btnAddStudent);
		panel.add(btnRunReport);
		add(panel, BorderLayout.NORTH);
		addPanel();		
	}
	
	
	
	/**
	 * Contains a content of register panel.
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
	
	
	/**
	 * Contains the content to add student.
	 */
	public void addPanel() {
		pnlAdd = new JPanel();
		pnlAdd.add(new JSeparator(SwingConstants.HORIZONTAL));
		JLabel[] txtLabe = new JLabel[10];
		txtAddField = new JTextField[10];
			// Add Panel
		pnlAdd.setLayout(new GridLayout(15, 0));
		for (int i = 0; i < labelAdd.length; i++) {
			JPanel npanel = new JPanel();
			npanel.setLayout(new GridLayout(1, 0));
			txtLabe[i] = new JLabel(labelAdd[i]);
		    txtAddField[i] = new JTextField(15);
			
			npanel.add(txtLabe[i]);
			npanel.add(txtAddField[i]);
			pnlAdd.add(npanel);
		}
		addCollegeTrans = new JButton("Add College Transfer");
		addCollegeTrans.addActionListener(this);
		pnlAdd.add(addCollegeTrans);
		addEmploy = new JButton("Add Employment");
		addEmploy.addActionListener(this);
		pnlAdd.add(addEmploy);
		addIntern = new JButton("Add Internship");
		addIntern.addActionListener(this);
		pnlAdd.add(addIntern);
		addStudent = new JButton("Add Student");
		addStudent.addActionListener(this);
		pnlAdd.add(addStudent);
		pnlContent.add(pnlAdd);
	}
	
	/**
	 * Employment history.
	 */
	public void employmentHistory() {
        JTextField field1 = new JTextField(" ");
        JTextField field2 = new JTextField(" ");
        JTextField field3 = new JTextField(" ");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        //panel.add(combo);
        panel.add(new JLabel("Company Name:"));
        panel.add(field1);
        panel.add(new JLabel("Position Description:"));
        panel.add(field2);
        panel.add(new JLabel("Salary:"));
        panel.add(field3);
		 int result = JOptionPane.showConfirmDialog(null, panel, "Employment",
		            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(
            field1.getText() + " " + field2.getText()
                + " " + field3.getText());
        } else {
            System.out.println("Cancelled");
        }
	}
	
	/**
	 * Intern history.
	 */
	public void internHistory() {
		JTextField field1 = new JTextField(" ");
        JTextField field2 = new JTextField(" ");
        JTextField field3 = new JTextField(" ");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        //panel.add(combo);
        panel.add(new JLabel("Company Name:"));
        panel.add(field1);
        panel.add(new JLabel("Position Description:"));
        panel.add(field2);
        panel.add(new JLabel("Salary:"));
        panel.add(field3);
		 int result = JOptionPane.showConfirmDialog(null, panel, "Internship",
		            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if (result == JOptionPane.OK_OPTION) {
		            System.out.println(
		            		//combo.getSelectedItem() + "  " + 
		            field1.getText() + " " + field2.getText()
		                + " " + field3.getText());
		        } else {
		            System.out.println("Cancelled");
		        }
	}
	
	/**
	 * College transfer.
	 */
	public void collegeTransfer() {
        JTextField field1 = new JTextField(" ");
        JTextField field2 = new JTextField(" ");
        JTextField field3 = new JTextField(" ");
        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("College Name:"));
        panel.add(field1);
        panel.add(new JLabel("GPA:"));
        panel.add(field2);
        panel.add(new JLabel("Transfer Year:"));
        panel.add(field3);
		 int result = JOptionPane.showConfirmDialog(null, panel, "College Transfer",
		            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		        if (result == JOptionPane.OK_OPTION) {
		            System.out.println(
		            		//combo.getSelectedItem() + "  " + 
		            field1.getText() + " " + field2.getText()
		                + " " + field3.getText());
		        } else {
		            System.out.println("Cancelled");
		        }
	}
	
	/**
	 * Perform add student.
	 */
	public void performAddStudent() {
		String lastName = txtAddField[0].getText();
		if (lastName.length() < 2 || lastName.length() > 25) {
			JOptionPane.showMessageDialog(null, "Enter Student`s Last Name (2 chars min)");
			txtAddField[0].setFocusable(true);
			return;
		}		
		String firstName = txtAddField[1].getText();
		if (firstName.length() < 2 || firstName.length() > 25) {
			JOptionPane.showMessageDialog(null, "Enter Student`s First Name (2 chars min)");
			txtAddField[1].setFocusable(true);
			return;
		}
		String acaProg = txtAddField[2].getText();
		if (acaProg.length() < 1 ||
				acaProg.length() > 3) {
			JOptionPane.showMessageDialog(null, "Enter Student`s Academic Program (1-3 chars)");
			txtAddField[2].setFocusable(true);
			return;
		}
		String degLevel = txtAddField[3].getText();
		if (degLevel.length() < 2 ||
				acaProg.length() > 3) {
			JOptionPane.showMessageDialog(null, "Enter Student`s Degree Level (2-3 chars)");
			txtAddField[3].setFocusable(true);
			return;
		}
		String gradTerm = txtAddField[4].getText();
		if (gradTerm.length() != 6) {
			JOptionPane.showMessageDialog(null, "Enter Student`s Graduation Term \n"
					+ "(6 chars) e.g Autumn, Winter, Spring, or Summer.");
			txtAddField[4].setFocusable(true);
			return;
		}
		String gradYearString = txtAddField[5].getText();
		
		if (gradYearString.length() != 4) {
			JOptionPane.showMessageDialog(null, "Enter Student`s Graduation Year (4 chars)");
			txtAddField[5].setFocusable(true);
			return;
		}
		//int gradYear = 0;
//		if (gradYearString.length() == 4) {
//			try {
//				gradYear = Integer.parseInt(gradYearString);
//			} catch (NumberFormatException e) {
//				JOptionPane.showMessageDialog(null, "Enter Graduation Year as int.");
//				txtAddField[5].setText("");
//				txtAddField[5].setFocusable(true);
//				return;
//			}
//		}
		
		String gpaString = txtAddField[6].getText();
		double gpa = 0.0;
		if (gpaString.length() == 0) {
			JOptionPane.showMessageDialog(null, "Enter Student`s GPA");
			txtAddField[6].setFocusable(true);
			return;
		}
		if (gpaString.length() != 0) {
			try {
				gpa = Double.parseDouble(gpaString);
				if (gpa < 0.0 || gpa > 4.0) {
					JOptionPane.showMessageDialog(null, "Enter a GPA between 0.0 to 4.0");
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Enter GPA as decimal");
				txtAddField[6].setText("");
				txtAddField[6].setFocusable(true);
				return;
			}
		}
		
		String uwEmail = txtAddField[7].getText();
		if (uwEmail.length() < 8 || uwEmail.length() > 15 ||
				!uwEmail.endsWith("@uw.edu")) {
			JOptionPane.showMessageDialog(null, "Enter Student`s UW Email ending with "
					+ "\n '@uw.edu'");
			txtAddField[7].setFocusable(true);
			return;
		}
		
		String externalEmail = txtAddField[8].getText();
		if (externalEmail.length() < 3 || externalEmail.length() > 254 ||
				!externalEmail.contains("@")) {
			JOptionPane.showMessageDialog(null, "Enter Student`s External Email containing '@'");
			txtAddField[8].setFocusable(true);
			return;
		}
		
		Student student = new Student(lastName, firstName, acaProg, degLevel,
				gradTerm, gradYearString, gpa, uwEmail, externalEmail);
		
		String message = "Student add failed";
		if (StudentCollection.add(student)) {
			message = "Student added";
		}
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * Runs a report.//not complete
	 */
	public void runReport() {
		pnlReport = new JPanel();
		JLabel label = new JLabel("Look for..."); 
		pnlReport.add(label);
		generateReport = new JButton("Generate Report");
		generateReport.addActionListener(this);
		pnlReport.add(generateReport);
		
		JPanel panel = new JPanel();
		table = new JTable(sData, studentColumnNames);
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		//pnlReport.add(panel);
		table.getModel().addTableModelListener(this);
		
		pnlContent.add(pnlReport);
		pnlContent.add(panel);
	}

	/**
	 * Listen to the cell changes on the table.
	 *
	 * @param e the event
	 */
	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel) e.getSource();
		String columnName = model.getColumnName(column);
		Object data = model.getValueAt(row, column);
		if (data != null && ((String) data).length() != 0) {
			Student student = sList.get(row);
			if (!StudentCollection.update(student, columnName, data)) {
				JOptionPane.showMessageDialog(null, "Update failed");
			}
		}
	}
}