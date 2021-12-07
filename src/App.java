public class App {

    public static void main(String[] args){
    	
    	// set up interface to database
    	TheatreService theatreService = new TheatreService("jdbc:mysql://localhost/theatredb", "Quan", "*Youshallnotpassword69");
    	FinancialService financialService = new FinancialService("jdbc:mysql://localhost/financialdb", "Quan", "*Youshallnotpassword69");
    	UserService userService = new UserService("jdbc:mysql://localhost/userdb", "Quan", "*Youshallnotpassword69");
    	userService.initializeConnection();
    
    	// gui for booking ticket
    	BookTicketController bookTicketController = new BookTicketController(theatreService);
    	
    	// gui for canceling ticket
    	CancelTicketView cancel = new CancelTicketView();
    	
    	// gui for registration
    	RegistrationView register = new RegistrationView();
    	    	
    	// registration controller
    	RegistrationController registrationController = new RegistrationController(register, userService);
    	    	
    	// gui for login
    	LoginView login = new LoginView();
    	
    	// View movie news user case.
    	MovieNewsController movieNewsController = new MovieNewsController(theatreService);
    	MovieNewsView movieNews = new MovieNewsView(movieNewsController);
    	
    	// Pay subscription use case.
    	PaySubscriptionView subscriptionView = new PaySubscriptionView();
    	PaySubscriptionController subscriptionController = new PaySubscriptionController(subscriptionView, userService, financialService);
    	
    	// Main menu
    	MainMenu window = new MainMenu(login, register, cancel, movieNews, subscriptionView, theatreService, bookTicketController);
    	
    	// user controller
    	UserController userController = new UserController(login, userService, subscriptionController, window);
    	
		window.frame.setVisible(true);
		

    }
}
