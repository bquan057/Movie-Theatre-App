package Control;
import java.time.LocalDate;

import DataSource.FinancialService;
import DataSource.RegisteredUser;
import DataSource.UserService;
import Presentation.PaySubscriptionView;

/**
 * A controller class that interacts with the user and financial services for the pay subcription use case.
 * @author Brandon Quan
 *
 */
public class PaySubscriptionController {

	private PaySubscriptionView subscriptionView;
	private UserService userService;
	private FinancialService financialService;
	private RegisteredUser user;
	
	public PaySubscriptionController(PaySubscriptionView subscriptionView, UserService userService, FinancialService financialService) {
		this.subscriptionView = subscriptionView;
		this.userService = userService;
		this.financialService = financialService;
		handleRenewal();
	}
	
	/**
	 * Handles the renewal process upon the renew button being created.
	 */
	public void handleRenewal() {
		subscriptionView.addRenewalListener(e -> {
			
			// Retrives the card number.
			long cardNumber = Long.parseLong(subscriptionView.getCardNumber());
			
			// Verifies the funds for the card.
			financialService.initializeConnection();
			boolean funds = financialService.verifyFunds(String.valueOf(cardNumber), 20.00);
			
			// If funds are available, subscription transaction is made, and the user's expiry date is updated to be a year from the previous expiry.
			if (funds) {
				financialService.makeSubscriptionTransaction(cardNumber, 20.00);
				subscriptionView.setExpiryDate(LocalDate.parse(subscriptionView.getExpiryDate()).plusYears(1));
				userService.initializeConnection();
				userService.updateExpiry(LocalDate.parse(subscriptionView.getExpiryDate()));
				subscriptionView.displayErrorMessage("Subscription renewed! Your card has been charged.");
			}
			else {
				financialService.close();
				userService.close();
				subscriptionView.displayErrorMessage("Not enough funds.");
				return;
			}
			
			userService.close();
			financialService.close();
			
			return;
			
		});
	}
	
	// Used to set the user who is currently logged in to the app.
	public void setUser(RegisteredUser user) {
		
		this.user = user;
		subscriptionView.setGreeting(user.getFirstName());
		subscriptionView.setExpiryDate(user.getSubscriptionExpiry());
		
		if (!user.getCreditNumber().equals("")) {
			subscriptionView.setCardNumber(user.getCreditNumber());
		} else {
			subscriptionView.setCardNumber(user.getDebitNumber());
		}
	}
	
	public RegisteredUser getUser() {
		return user;
	}
	
	
}
