public class App {

    public static void main(String[] args){
    	

    	TheatreService theatreService = new TheatreService("jdbc:mysql://localhost/theatredb", "dummyRootUser", "password");
    	FinancialService financialService = new FinancialService("jdbc:mysql://localhost/financialdb", "dummyRootUser", "password");
    	
    	MovieNewsController movieNewsController = new MovieNewsController(theatreService);
    	MovieNewsView movieNews = new MovieNewsView(movieNewsController);
    
    	
    	// gui for login
    	LoginView login = new LoginView();
		// set up interface to database
		UserService userService = new UserService("jdbc:mysql://localhost/userdb", "dummyRootUser", "password");
		userService.initializeConnection();
		
		// gui for registration
		RegistrationView register = new RegistrationView();
    	
    	// registration controller
    	RegistrationController registrationController = new RegistrationController(register, userService);
    	
    	// gui for canceling ticket
    	CancelTicketView cancel = new CancelTicketView();
    	
    	// Pay subscription use case.
    	PaySubscriptionView subscriptionView = new PaySubscriptionView();
    	PaySubscriptionController subscriptionController = new PaySubscriptionController(subscriptionView, userService, financialService);
    	
    	// user controller
    	UserController userController = new UserController(login, userService, subscriptionController);
    	
    	BookTicketController bookTicketController = new BookTicketController(theatreService, financialService);
    	
    	MainMenu window = new MainMenu(login, register, cancel, movieNews, subscriptionView, theatreService, bookTicketController);
		window.frame.setVisible(true);
		

    }
}
