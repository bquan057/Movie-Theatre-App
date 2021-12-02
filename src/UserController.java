
/*
 * UserController() manages the interaction between the LoginView, Register View
 * with the UserDatabase
 */
public class UserController {
	private LoginView loginView;
	private RegisterView registerView;
	private UserService userService;
	
	public UserController(LoginView loginView, UserService userService) {
		this.loginView = loginView;
		this.registerView = registerView;
		this.userService = userService;
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
			
			RegisteredUser user = userService.validateUser(toValidate);
			// TODO what to do once valid user returned?
			// user validated
			if(user != null) {
				loginView.displayErrorMessage("LoggedIn");
			}
			// user not valid
			else {
				loginView.displayErrorMessage("Invalid Username or Password");
			}
		});
	}
}
