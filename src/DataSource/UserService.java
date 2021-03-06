package DataSource;

import java.sql.*;
import java.time.LocalDate;

/**
 * UserService represents the interface to the UserDatabase
 * @author Rohinesh Ram, Brandon Quan
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
				validUser.setCreditNumber(results.getString("Credit"));
				validUser.setDebitNumber(results.getString("Debit"));
				validUser.setSubscriptionExpiry(LocalDate.parse(results.getString("Expiry")));
				myStmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return validUser;
	}
	
	/*
	 * Checks if user exists in the database
	 */
	public boolean userExists(String uname, String email) {
		
		String query = "SELECT * FROM RUSER WHERE username=? OR email=?";
		
		try {
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, uname);
			myStmt.setString(2, email);
			
			results = myStmt.executeQuery();
			
			if(!results.next()) {
				return true;
			}
			
			myStmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/*
	 * adds a new user to the database
	 */
	public void addUser(RegisteredUser newUser) {
		
		String query = "INSERT INTO RUSER (FName, LName, UserName, Password, Email, Credit, Debit, Expiry)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, newUser.getFirstName());
			myStmt.setString(2, newUser.getLastName());
			myStmt.setString(3, newUser.getUserName());
			myStmt.setString(4, newUser.getPassWord());
			myStmt.setString(5, newUser.getEmail());
			myStmt.setString(6, newUser.getCreditNumber());
			myStmt.setString(7, newUser.getDebitNumber());
			
			
			// get expiration date
			LocalDate expiration = generateExpiration();
			myStmt.setString(8, expiration.toString());
			
			int rowCount = myStmt.executeUpdate();
			
			myStmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Helper to generate expiration date
	 */
	private LocalDate generateExpiration() {
		LocalDate today = LocalDate.now();
		return today.plusDays(365);
	}
	
	/**
	 * Updates the expiry date to one year from the previous expiry date.
	 * @param oldExpiryDate, the previous expiry date.
	 */
	public void updateExpiry(LocalDate oldExpiryDate) {
		String query = "UPDATE RUSER SET EXPIRY=? WHERE EXPIRY=?";
		
		try {
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
					
			myStmt.setString(1, oldExpiryDate.toString());
			myStmt.setString(2, oldExpiryDate.plusYears(1).toString());
			
			myStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
