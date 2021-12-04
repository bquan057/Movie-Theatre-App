

/**
 * RegisteredUser is an Entity class to represent a registered user
 * @author Rohinesh Ram
 *
 */
public class RegisteredUser {
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private String creditNumber;
	private String debitNumber;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCreditNumber() {
		return creditNumber;
	}
	
	public void setCreditNumber(String l) {
		this.creditNumber = l;
	}
	
	public String getDebitNumber() {
		return debitNumber;
	}
	
	public void setDebitNumber(String debitNumber) {
		this.debitNumber = debitNumber;
	}
		
}
