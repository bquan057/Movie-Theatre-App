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

public class RegisterUserView extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField creditField;
	private JTextField debitField;
	private JButton registerButton;

	/**
	 * Create the frame.
	 */
	public RegisterUserView() {
		setTitle("New User Registration");
		setBounds(100, 100, 475, 396);
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
		lblNewLabel_3.setBounds(75, 165, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Debit Card Number:");
		lblNewLabel_4.setBounds(75, 210, 117, 14);
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
		creditField.setBounds(213, 162, 150, 20);
		contentPane.add(creditField);
		creditField.setColumns(10);
		
		debitField = new JTextField();
		debitField.setBounds(213, 207, 150, 20);
		contentPane.add(debitField);
		debitField.setColumns(10);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(245, 262, 87, 23);
		contentPane.add(registerButton);
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
	public int getCreditCard() {
		return Integer.parseInt(creditField.getText());
	}
	
	/*
	 * returns input for debit card
	 */
	public int getDebitCard() {
		return Integer.parseInt(debitField.getText());
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
