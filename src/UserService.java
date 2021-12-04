
import java.sql.*;

/**
 * UserService represents the interface to the UserDatabase
 * @author Rohinesh Ram
 * 
 */
public class UserService {
	
	private final String DBURL;
	private final String USERNAME;
	private final String PASSWORD;
	
	private Connection dbConnect;
	private ResultSet results;

	
	public UserService(String url, String username, String password) {
		this.DBURL = url;
		this.USERNAME = username;
		this.PASSWORD = password;
	}
	
	/*
	 * creates connection to the sql database
	 */
	public void initializeConnection() {
		try {
			dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * method to validate a user, if user is valid, return the users
	 * stored information
	 */
	public RegisteredUser validateUser(RegisteredUser user) {
		// credentials of user to validate
		String userName = user.getUserName();
		String password = user.getPassWord();
		
		// valid user
		RegisteredUser validUser = new RegisteredUser();
		
		// username and password must exist
		if(!userName.equals("") && !password.equals("")) {
			// make query
			try {
				String query = "SELECT * FROM RUSER where username=? AND password=?";
				
				// prep statement for security
				PreparedStatement myStmt = dbConnect.prepareStatement(query);
				
				// add uname and pword to query
				myStmt.setString(1, userName);
				myStmt.setString(2, password);
				
				// get results
				results = myStmt.executeQuery();
				
				if(!results.next()) {
					return null;
				}
				
				// build the user
				validUser.setUserName(results.getString("username"));
				validUser.setPassWord(results.getString("password"));
				validUser.setFirstName(results.getString("Fname"));
				validUser.setLastName(results.getString("LName"));
				validUser.setEmail(results.getString("Email"));
				validUser.setCreditNumber(results.getLong("Credit"));
				validUser.setDebitNumber(results.getLong("Debit"));
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return validUser;
	}
}
