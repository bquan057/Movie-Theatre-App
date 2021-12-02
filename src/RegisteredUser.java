
/*
 * RegisteredUser is an Entity class to represent a registered user
 */
public class RegisteredUser {
	private String firstName;
	private String lastName;
	private String email;
	private int creditNumber;
	private int debitNumber;
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCredit(int credit) {
		creditNumber = credit;
	}
	
	public void setDebit(int debit) {
		debitNumber = debit;
	}
	
	
}
