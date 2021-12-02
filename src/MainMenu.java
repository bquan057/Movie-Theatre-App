import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBookTicket = new JButton("Book Ticket");
		btnBookTicket.setBounds(39, 29, 149, 66);
		frame.getContentPane().add(btnBookTicket);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/resized-image-Promo.jpeg")));
		lblNewLabel.setBounds(239, 30, 100, 82);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCancelTicket = new JButton("Cancel Ticket");
		btnCancelTicket.setBounds(39, 123, 149, 66);
		frame.getContentPane().add(btnCancelTicket);
		
		JButton btnMovieNews = new JButton("Movie News");
		btnMovieNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMovieNews.setBounds(369, 29, 149, 66);
		frame.getContentPane().add(btnMovieNews);
		
		JButton btnPaySubscription = new JButton("Pay Subscription");
		btnPaySubscription.setBounds(369, 123, 149, 66);
		frame.getContentPane().add(btnPaySubscription);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(369, 209, 149, 66);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(39, 209, 149, 66);
		frame.getContentPane().add(btnRegister);
	}
}
