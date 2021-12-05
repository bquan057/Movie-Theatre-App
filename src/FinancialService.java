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
		try {
			String query = "SELECT * FROM CARDINFO WHERE CardNumber = ?";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setInt(1,cardNumber);
			results = myStmt.executeQuery();
			
			if(!results.next())
				return false;
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyFunds(int cardNumber) {
		
		try {
			String query = "SELECT * FROM CARDINFO WHERE CardNumber = ?";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setInt(1,cardNumber);
			results = myStmt.executeQuery();
			
			if(!results.next())
				return false;
			
			//TODO: update for ticket price
			if(Double.parseDouble(results.getString("Funds")) < 20)
				return false;
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void makeTransaction(int cardNumber) {
		 
	}
	
}
