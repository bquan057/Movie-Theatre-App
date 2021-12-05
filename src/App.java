public class App {

    public static void main(String[] args){
    	

    	TheatreService theatreService = new TheatreService("jdbc:mysql://localhost/theatredb", "USERNAME HERE", "PASSWORD HERE");
    	MovieNewsController movieNewsController = new MovieNewsController(theatreService);
    	MovieNewsView movieNews = new MovieNewsView(movieNewsController);
    	

    	// gui for login
    	LoginView login = new LoginView();
		// set up interface to database
		UserService userService = new UserService("jdbc:mysql://localhost/userdb", "root", "");
		userService.initializeConnection();
		
		// gui for registration
		RegistrationView register = new RegistrationView();
		
		// user controller
    	UserController userController = new UserController(login, userService);
    	
    	// registration controller
    	RegistrationController registrationController = new RegistrationController(register, userService);
    	
    	// gui for canceling ticket
    	CancelTicketView cancel = new CancelTicketView();
    	
    	MainMenu window = new MainMenu(login, register, cancel, movieNews);
		window.frame.setVisible(true);
		

    }
}
