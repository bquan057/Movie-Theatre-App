
/*
 * UserController() manages the interaction between the LoginView, Register View
 * with the UserDatabase
 */
public class UserController {
	private LoginView loginView;
	private RegisterView registerView;
	
	public UserController(LoginView loginView) {
		this.loginView = loginView;
		this.registerView = registerView;
		
		handleLogin();
	}
	
	public void handleLogin() {
		loginView.addLoginListener(e ->{
			String userName = loginView.getUserName();
			String passWord = loginView.getPassword();
			
			// user name and password required
			if(userName.equals("") || passWord.equals("")) {
				loginView.displayErrorMessage("You must enter userName and Password");
				return;
			}
			
			
		});
	}
}
