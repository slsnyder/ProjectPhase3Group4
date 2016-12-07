package ui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * 
 * @author mAbraham
 *
 */
public class MainGUI extends JFrame {
	
	/**
	 * A serial ID.
	 */
	private static final long serialVersionUID = -3265543391773320184L;

	public static void main(String[] args) {
		new MainGUI();
	}
	
	/**
	 * Launches the GUI.
	 */
	public MainGUI() {
		super("Group 4 Project");
		createComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700, 600);
	}


	/**
	 * Create the tabs for each part of the system. 
	 */
	private void createComponents()
	{
		JTabbedPane tabbedPane = new JTabbedPane();
		JComponent itemPanel = makeTextPanel("User");
		tabbedPane.addTab("User", itemPanel);
		add(tabbedPane);
		
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	private JComponent makeTextPanel(String type) {
		JPanel panel = new JPanel();
		if (type.equalsIgnoreCase("User")) {
			panel.add(new UserGUI());
		} else {
			panel.add(new JLabel("Needs to be implemented!"));
		}
		return panel;
	}
}
