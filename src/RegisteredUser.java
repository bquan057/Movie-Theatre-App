
/*
 * RegisteredUser is an Entity class to represent a registered user
 */
public class RegisteredUser {
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private long creditNumber;
	private long debitNumber;
	
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
	
	public long getCreditNumber() {
		return creditNumber;
	}
	
	public void setCreditNumber(long l) {
		this.creditNumber = l;
	}
	
	public long getDebitNumber() {
		return debitNumber;
	}
	
	public void setDebitNumber(long debitNumber) {
		this.debitNumber = debitNumber;
	}
		
}
