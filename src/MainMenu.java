import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainMenu {

	public JFrame frame;
	public MovieNewsView movieNews;

	/**
	 * Create the application.
	 */
	public MainMenu(MovieNewsView movieNews) {
		initialize();
		this.movieNews = movieNews;
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
		lblNewLabel.setBounds(239, 30, 100, 82);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCancelTicket = new JButton("Cancel Ticket");
		btnCancelTicket.setBounds(39, 123, 149, 66);
		frame.getContentPane().add(btnCancelTicket);
		
		JButton btnMovieNews = new JButton("Movie News");
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
		
		btnMovieNews.addActionListener(e -> {

			movieNews.setVisible(true);

		});
		
	}
}
