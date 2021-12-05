public class App {

    public static void main(String[] args){
    	

    	TheatreService theatreService = new TheatreService("jdbc:mysql://localhost/theatredb", "YOUR USERNAME", "YOUR PASSWORD");
    	FinancialService financialService = new FinancialService("jdbc:mysql://localhost/financialdb", "YOUR USERNAME", "*YOUR PASSWORD");
    	
    	MovieNewsController movieNewsController = new MovieNewsController(theatreService);
    	MovieNewsView movieNews = new MovieNewsView(movieNewsController);
    	
    	
    	// gui for login
    	LoginView login = new LoginView();
		// set up interface to database
		UserService userService = new UserService("jdbc:mysql://localhost/userdb", "YOUR USERNAME", "YOUR PASSWORD");
		userService.initializeConnection();
		
		// gui for registration
		RegistrationView register = new RegistrationView();
		
		// user controller
    	UserController userController = new UserController(login, userService);
    	
    	// registration controller
    	RegistrationController registrationController = new RegistrationController(register, userService);
    	
    	// gui for canceling ticket
    	CancelTicketView cancel = new CancelTicketView();
    	
    	// Pay subscription use case.
    	PaySubscriptionView subscriptionView = new PaySubscriptionView();
    	PaySubscriptionController subscriptionController = new PaySubscriptionController(subscriptionView, userService, financialService);
    	
    	MainMenu window = new MainMenu(login, register, cancel, movieNews, subscriptionView);
		window.frame.setVisible(true);
		

    }
}
