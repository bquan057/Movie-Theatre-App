package Presentation;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * View for canceling a ticket
 * @author Rohinesh Ram
 *
 */
public class CancelTicketView extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JTextField idField;
	private JButton submitBtn;


	/**
	 * Create the frame.
	 */
	public CancelTicketView() {
		setTitle("Cancel Ticket");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email Address:");
		lblNewLabel.setBounds(64, 75, 92, 14);
		contentPane.add(lblNewLabel);
		
		emailField = new JTextField();
		emailField.setBounds(155, 72, 142, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Id:");
		lblNewLabel_1.setBounds(64, 127, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		idField = new JTextField();
		idField.setBounds(155, 124, 142, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(183, 174, 87, 23);
		contentPane.add(submitBtn);
	}
	
	/*
	 * Returns email input
	 */
	public String getEmail() {
		return emailField.getText();
	}
	
	/*
	 * Returns id input
	 */
	public String getId() {
		return idField.getText();
	}
	
	/*
	 * creates listener for the submit button
	 */
	public void addSubmitListener(ActionListener listenForSubmit) {
		submitBtn.addActionListener(listenForSubmit);
	}
	
	/*
	 * shows message to user
	 */
	public void displayErrorMessage(String error) {
		JOptionPane.showMessageDialog(this, error);
	}
	
	/*
	 * clears fields on cancel view
	 */
	public void clearFields() {
		emailField.setText("");
		idField.setText("");
	}
}
