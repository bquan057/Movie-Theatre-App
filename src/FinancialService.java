import java.sql.*;

public class FinancialService {
	
	private final String DBURL;
	private final String USERNAME;
	private final String PASSWORD;
	
	private Connection dbConnect;
	private ResultSet results;
	
	public FinancialService(String url, String username, String password) {
		DBURL = url;
		USERNAME = username;
		PASSWORD = password;
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
	
	//TODO Implement method
	
//	public Ticket searchTicketID(int ticketID) {
//		
//	}
	
	public boolean validateCard(int cardNumber) {
		return true;
	}
	
	public boolean verifyCard(int cardNumber) {
		return true;
	}
	
	public void makeTransaction(int cardNumber) {
		
	}
	
}
