package Presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import Control.BookTicketController;
import DataSource.TheatreService;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;


public class MainMenu {

	public JFrame frame;
	public MovieNewsView movieNews;
	private LoginView login;
	private RegistrationView register;
	private CancelTicketView cancel;
	public PaySubscriptionView subscriptionView;
	private BookTicketController bookTicketController;
	private JButton btnMovieNews;
	private JButton btnPaySubscription;

	/**
	 * Create the application.
	 */
	public MainMenu(LoginView login, RegistrationView register, CancelTicketView cancel, MovieNewsView movieNews,
			PaySubscriptionView subscriptionView, TheatreService theatreService, BookTicketController bookTicketController) {
		this.login = login;
		this.register = register;
		this.cancel = cancel;
		this.movieNews = movieNews;
		this.subscriptionView = subscriptionView;
		this.bookTicketController = bookTicketController;
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
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/resized-image-Promo.jpeg")));
//
//		lblNewLabel.setBounds(239, 30, 100, 82);
//		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCancelTicket = new JButton("Cancel Ticket");
		btnCancelTicket.setBounds(39, 123, 149, 66);
		frame.getContentPane().add(btnCancelTicket);
		
		btnCancelTicket.addActionListener(e -> {
			cancel.setVisible(true);
		});
		
		
		btnMovieNews = new JButton("Movie News");
		btnMovieNews.setEnabled(false);
		btnMovieNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnMovieNews.setBounds(369, 29, 149, 66);
		frame.getContentPane().add(btnMovieNews);
		
		btnPaySubscription = new JButton("Pay Subscription");
		btnPaySubscription.setEnabled(false);
		btnPaySubscription.setBounds(369, 123, 149, 66);
		frame.getContentPane().add(btnPaySubscription);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(369, 209, 149, 66);
		frame.getContentPane().add(btnLogin);
		
		btnLogin.addActionListener(e -> {

			login.setVisible(true);

		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(39, 209, 149, 66);
		frame.getContentPane().add(btnRegister);
		

		btnMovieNews.addActionListener(e -> {

			movieNews.setVisible(true);

		});
		

		btnRegister.addActionListener(e -> {
			
			register.setVisible(true);
		});

		btnPaySubscription.addActionListener(e -> {
			
			subscriptionView.setVisible(true);
			
		});
		
		btnBookTicket.addActionListener(e -> {
			bookTicketController.displaySearchMoviesView();
		});

	}
	
	public void toggleBtnMovieNews() {
		btnMovieNews.setEnabled(true);
	}
	
	public void toggleBtnPaySubscription() {
		btnPaySubscription.setEnabled(true);
	}
	
}
