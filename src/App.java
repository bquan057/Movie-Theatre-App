public class App {

    public static void main(String[] args){
    	
    	// gui for login
    	LoginView login = new LoginView();
		// set up interface to database
		UserService userService = new UserService("jdbc:mysql://localhost/userdb", "", "");
		userService.initializeConnection();
		
    	UserController controller = new UserController(login, userService);
    	
    	MainMenu window = new MainMenu(login);
		window.frame.setVisible(true);
		

    }
}
