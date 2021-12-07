
/**
 * UserController() manages the interaction between the LoginView
 * with the UserDatabase
 * @author Rohinesh Ram
 *
 */
public class UserController {
	private LoginView loginView;
	private UserService userService;
	private RegisteredUser user;
	private PaySubscriptionController subscriptionController;
	private MainMenu window;
	
	public UserController(LoginView loginView, UserService userService, PaySubscriptionController subscriptionController, MainMenu window) {
		this.loginView = loginView;
		this.userService = userService;
		this.subscriptionController = subscriptionController;
		this.window = window;
		handleLogin();
	}
	
	/*
	 * handles the log in process
	 */
	public void handleLogin() {
		loginView.addLoginListener(e ->{
			String userName = loginView.getUserName();
			String passWord = loginView.getPassword();
			
			// user name and password required
			if(userName.equals("") || passWord.equals("")) {
				loginView.displayErrorMessage("You must enter userName and Password");
				return;
			}
			
			// validate the user
			RegisteredUser toValidate = new RegisteredUser();
			toValidate.setUserName(userName);
			toValidate.setPassWord(passWord);
			
			// TODO this may not be dependency
			user = userService.validateUser(toValidate);
			
			// user validated
			if(user != null) {
				loginView.displayErrorMessage("Successfully Logged In");
				loginView.clearFields();
				loginView.setVisible(false);
				subscriptionController.setUser(user);
				window.toggleBtnMovieNews();
				window.toggleBtnPaySubscription();
			}
			// user not valid
			else {
				loginView.displayErrorMessage("Invalid Username or Password");
			}
			
		});
	}
	
	public RegisteredUser getUser() {
		return user;
	}
}
