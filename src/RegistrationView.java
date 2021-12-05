import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

public class RegistrationView extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField creditField;
	private JTextField debitField;
	private JButton registerButton;
	private JLabel lblNewLabel_5;
	private JTextField userNameField;
	private JLabel lblNewLabel_6;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_7;
	private JPasswordField passwordFieldConfirm;

	/**
	 * Create the frame.
	 */
	public RegistrationView() {
		setTitle("New User Registration");
		setBounds(100, 100, 475, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(75, 48, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(75, 84, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email Address:");
		lblNewLabel_2.setBounds(75, 120, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Credit Card Number:");
		lblNewLabel_3.setBounds(75, 159, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Debit Card Number:");
		lblNewLabel_4.setBounds(75, 204, 117, 14);
		contentPane.add(lblNewLabel_4);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(213, 45, 150, 20);
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(213, 81, 150, 20);
		contentPane.add(lastNameField);
		lastNameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(213, 117, 150, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		creditField = new JTextField();
		creditField.setBounds(213, 156, 150, 20);
		contentPane.add(creditField);
		creditField.setColumns(10);
		
		debitField = new JTextField();
		debitField.setBounds(213, 201, 150, 20);
		contentPane.add(debitField);
		debitField.setColumns(10);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(245, 381, 87, 23);
		contentPane.add(registerButton);
		
		lblNewLabel_5 = new JLabel("User Name:");
		lblNewLabel_5.setBounds(75, 245, 128, 14);
		contentPane.add(lblNewLabel_5);
		
		userNameField = new JTextField();
		userNameField.setBounds(213, 242, 150, 20);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setBounds(75, 288, 141, 14);
		contentPane.add(lblNewLabel_6);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 285, 150, 20);
		contentPane.add(passwordField);
		
		lblNewLabel_7 = new JLabel("Confirm Password:");
		lblNewLabel_7.setBounds(75, 337, 135, 14);
		contentPane.add(lblNewLabel_7);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(213, 334, 150, 20);
		contentPane.add(passwordFieldConfirm);
	}
	
	
	/*
	 * returns the input for first name
	 */
	public String getFirstName() {
		return firstNameField.getText();
	}
	
	/*
	 * returns the input for last name
	 */
	public String getLastName() {
		return lastNameField.getText();
	}
	
	/*
	 * returns the input for email
	 */
	public String getEmail() {
		return emailField.getText();
	}
	
	/*
	 * returns the input for credit card
	 */
	public String getCreditCard() {
		return creditField.getText();
	}
	
	/*
	 * returns input for debit card
	 */
	public String getDebitCard() {
		return debitField.getText();
	}
	
	/*
	 * returns input for username
	 */
	public String getUsername() {
		return userNameField.getText();
	}
	
	/*
	 * returns input for password
	 */
	public String getPassword() {
		return passwordField.getText();
	}
	
	/*
	 * returns input for confirmation password
	 */
	public String getConfirmPassword() {
		return passwordFieldConfirm.getText();
	}
	
	/*
	 * listen for register button click
	 */
	public void addRegisterListener(ActionListener listenForRegister) {
		registerButton.addActionListener(listenForRegister);
	}
	
	/*
	 * display errors in dialog box
	 */
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
