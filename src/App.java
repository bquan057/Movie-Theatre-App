import Control.BookTicketController;
import Control.CancelTicketController;
import Control.LoginController;
import Control.MovieNewsController;
import Control.PaySubscriptionController;
import Control.RegistrationController;
import DataSource.FinancialService;
import DataSource.TheatreService;
import DataSource.UserService;
import Presentation.CancelTicketView;
import Presentation.LoginView;
import Presentation.MainMenu;
import Presentation.MovieNewsView;
import Presentation.PaySubscriptionView;
import Presentation.RegistrationView;

public class App {

    public static void main(String[] args){
    	
    	String UNAME = "root";
    	String PWORD = "password";
    	
    	// set up interface to database
    	TheatreService theatreService = new TheatreService("jdbc:mysql://localhost/theatredb", UNAME, PWORD);
    	FinancialService financialService = new FinancialService("jdbc:mysql://localhost/financialdb", UNAME, PWORD);
    	UserService userService = new UserService("jdbc:mysql://localhost/userdb", UNAME, PWORD);
    	userService.initializeConnection();
    	financialService.initializeConnection();
    
    	// gui for booking ticket
    	BookTicketController bookTicketController = new BookTicketController(theatreService, financialService);
    	
    	// gui for canceling ticket
    	CancelTicketView cancel = new CancelTicketView();
    	CancelTicketController cancelController = new CancelTicketController(cancel, theatreService);
    	
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
    	LoginController loginController = new LoginController(login, userService, subscriptionController, window, cancelController);
    	
		window.frame.setVisible(true);
		

    }
}
