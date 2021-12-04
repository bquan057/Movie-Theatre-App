

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JLabel lblNewLabel_1;
	private JButton loginButton; 
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 */
	public LoginView() {

		setBounds(100, 100, 315, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userNameField = new JTextField();
		userNameField.setBounds(124, 47, 123, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setBounds(34, 50, 74, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(34, 97, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(138, 136, 87, 23);
		contentPane.add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 94, 123, 20);
		contentPane.add(passwordField);
	}
	
	/*
	 * Get the input for username
	 */
	public String getUserName() {
		return userNameField.getText();
	}
	
	/*
	 * Get input for password
	 */
	public String getPassword() {
		return passwordField.getText();
	}
	
	/*
	 * Listener for login
	 */
	public void addLoginListener(ActionListener listenForLogin) {
		loginButton.addActionListener(listenForLogin);
	}
	
	/*
	 * Display error message dialog box
	 */
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	/*
	 * clears fields on login view
	 */
	public void clearFields() {
		userNameField.setText("");
		passwordField.setText("");
	}
	
	
}
