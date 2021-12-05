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
	private JTextField expiryDate;
	private JTextField cardNumber;
	private RegisteredUser user;

	public PaySubscriptionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Dynamic greeting that gets the user's first name.
		JLabel greeting = new JLabel("Hello " + user.getFirstName() + "!");
		greeting.setFont(new Font("Tahoma", Font.PLAIN, 20));
		greeting.setHorizontalAlignment(SwingConstants.CENTER);
		greeting.setBounds(90, 10, 213, 60);
		contentPane.add(greeting);
		
		JLabel expiryLabel = new JLabel("Your Subscription Expiry Date:");
		expiryLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		expiryLabel.setBounds(10, 44, 279, 104);
		contentPane.add(expiryLabel);
		
		JButton renewalButton = new JButton("Renew Subscription");
		renewalButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		renewalButton.setBounds(100, 183, 213, 40);
		contentPane.add(renewalButton);
		
		// Dynamic field that gets the user's subscription expiry.
		expiryDate = new JTextField();
		expiryDate.setText(user.getSubscriptionExpiry().toString());
		expiryDate.setBounds(273, 81, 124, 30);
		contentPane.add(expiryDate);
		expiryDate.setColumns(10);
		
		JLabel cardLabel = new JLabel("Card Number:");
		cardLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cardLabel.setBounds(10, 83, 279, 104);
		contentPane.add(cardLabel);
		
		// Dynamic field that gets the user's credit or debit card.
		cardNumber = new JTextField();
		if (user.getCreditNumber() != "") {
			cardNumber.setText(user.getCreditNumber());
		} else {
			cardNumber.setText(user.getDebitNumber());
		}
		cardNumber.setColumns(10);
		cardNumber.setBounds(273, 120, 124, 30);
		contentPane.add(cardNumber);
	}
	
	public void addRenewalListener(ActionListener renewalListener) {
		renewalButton.addActionListener(renewalListener);
	}
	
	public String getCardNumber() {
		return cardNumber.getText();
	}
	
	public String getExpiryDate() {
		return expiryDate.getText();
	}
	
	public void setExpiryDate(LocalDate updatedExpiry) {
		expiryDate.setText(updatedExpiry.toString());
	}
	
	public void setUser(RegisteredUser user) {
		this.user = user;
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
