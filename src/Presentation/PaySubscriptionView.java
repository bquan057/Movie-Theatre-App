package Presentation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JTextField;

/**
 * A GUI view for the pay subscription use case.
 * @author Brandon Quan
 *
 */
public class PaySubscriptionView extends JFrame {

	private JPanel contentPane;
	private JButton renewalButton;
	private JLabel greeting;
	private JTextField expiryDate;
	private JTextField cardNumber;

	public PaySubscriptionView() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Dynamic greeting that gets the user's first name.
		greeting = new JLabel("Hello!");
		greeting.setFont(new Font("Tahoma", Font.PLAIN, 20));
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setBounds(90, 10, 213, 60);
		contentPane.add(greeting);
		
		JLabel expiryLabel = new JLabel("Your Subscription Expiry Date:");
		expiryLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		expiryLabel.setBounds(10, 44, 279, 104);
		contentPane.add(expiryLabel);
		
		renewalButton = new JButton("Renew Subscription");
		renewalButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		renewalButton.setBounds(100, 183, 213, 40);
		contentPane.add(renewalButton);
		
		// Dynamic field that gets the user's subscription expiry.
		expiryDate = new JTextField();
		expiryDate.setText("");
		expiryDate.setBounds(273, 81, 124, 30);
		contentPane.add(expiryDate);
		expiryDate.setColumns(10);
		
		JLabel cardLabel = new JLabel("Card Number:");
		cardLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cardLabel.setBounds(10, 83, 279, 104);
		contentPane.add(cardLabel);
		
		// Dynamic field that gets the user's credit or debit card.
		cardNumber = new JTextField();
		cardNumber.setText("");
		cardNumber.setColumns(10);
		cardNumber.setBounds(273, 120, 124, 30);
		contentPane.add(cardNumber);
	}
	
	public void addRenewalListener(ActionListener renewalListener) {
		renewalButton.addActionListener(renewalListener);
	}
	
	public void setGreeting(String name) {
		greeting.setText("Hello " + name + "!");
	}
	
	public String getCardNumber() {
		return cardNumber.getText();
	}
	
	public void setCardNumber(String card) {
		cardNumber.setText(card);
	}
	
	public String getExpiryDate() {
		return expiryDate.getText();
	}
	
	public void setExpiryDate(LocalDate updatedExpiry) {
		expiryDate.setText(updatedExpiry.toString());
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
