
/**
 * RegistrationController() manages the interaction between
 * the RegistrationView and UserService when an ordinary
 * user is registering in the system.
 * @author Rohinesh Ram
 *
 */
public class RegistrationController {
	
	private RegistrationView registrationView;
	private UserService userService;
	
	public RegistrationController(RegistrationView theView, UserService theService) {
		this.registrationView = theView;
		this.userService = theService;
		
		handleRegistration();
	}
	
	private void handleRegistration() {
		registrationView.addRegisterListener(e->{
			String firstName = registrationView.getFirstName();
			String lastName = registrationView.getLastName();
			String email = registrationView.getEmail();
			String credit = registrationView.getCreditCard();
			String debit = registrationView.getDebitCard();
			String userName = registrationView.getUsername();
			String password = registrationView.getPassword();
			String passwordConfirm = registrationView.getConfirmPassword();
			
			// is user info entered
			if(!checkUserInfo(firstName, lastName, email)) {
				return;
			}
			// is user payment info entered
			if(!checkPaymentInfo(credit, debit)) {
				return;
			}
			// is credential info entered
			if(!checkCredentialInfo(userName, password, passwordConfirm)) {
				return;
			}
			

			
			
		});
	}
	
	/*
	 * Helper method to ensure user has filled information
	 */
	private boolean checkUserInfo(String fname, String lname, String email) {
		// user info must be entered
		if(fname.equals("") || lname.equals("") || email.equals("")) {
			registrationView.displayErrorMessage("Name and Email fields are Required");
			return false;
		}
		return true;
	}
	
	/*
	 * Helper method to ensure payment information has been entered
	 */
	private boolean checkPaymentInfo(String credit, String debit) {
		// either debit or credit must be entered
		if(credit.equals("") && debit.equals("")) {
			registrationView.displayErrorMessage("Credit or Debit are required");
			return false;
		}
		
		return true;
	}
	
	/*
	 * Helper method to ensure user credentials have been entered
	 */
	private boolean checkCredentialInfo(String uname, String pword, String cpword) {
		// credentials must be entered => TODO create helper method
		if(uname.equals("") || pword.equals("") || cpword.equals("")) {
			registrationView.displayErrorMessage("Must enter User Name and Password");
			return false;
		}
		
		// passwords must match
		if(!pword.equals(cpword)) {
			registrationView.displayErrorMessage("Passwords do not match");
			return false;
		}
		

		return true;
	}
	
}
