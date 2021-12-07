public class App {

    public static void main(String[] args){
    	

    	TheatreService theatreService = new TheatreService("jdbc:mysql://localhost/theatredb", "Quan", "*Youshallnotpassword69");
    	FinancialService financialService = new FinancialService("jdbc:mysql://localhost/financialdb", "Quan", "*Youshallnotpassword69");
    	
    	MovieNewsController movieNewsController = new MovieNewsController(theatreService);
    	MovieNewsView movieNews = new MovieNewsView(movieNewsController);
    
    	
    	// gui for login
    	LoginView login = new LoginView();
		// set up interface to database
		UserService userService = new UserService("jdbc:mysql://localhost/userdb", "Quan", "*Youshallnotpassword69");
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
    	
    	BookTicketController bookTicketController = new BookTicketController(theatreService);
    	
    	MainMenu window = new MainMenu(login, register, cancel, movieNews, subscriptionView, theatreService, bookTicketController);
		window.frame.setVisible(true);
		

    }
}
