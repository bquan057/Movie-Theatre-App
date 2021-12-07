import java.sql.*;

/**
 * A service class used as an interface for the financial database.
 * @author Ammaar Raihan, Brandon Quan
 *
 */
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
	
	public boolean validateCard(String cardNumber) {
		try {
			String query = "SELECT * FROM CARDINFO WHERE CardNumber = ?";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1,cardNumber);
			results = myStmt.executeQuery();
			
			if(!results.next())
				return false;
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyFunds(String cardNumber, double transactionAmount) {
		
		try {
			String query = "SELECT * FROM CARDINFO WHERE CardNumber = ?";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1,cardNumber);
			results = myStmt.executeQuery();
			
			if(!results.next())
				return false;
			
			//TODO: update for ticket price
			if(Double.parseDouble(results.getString("Funds")) < transactionAmount)
				return false;
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void makeTicketTransaction(long cardNumber, PaymentEntity payment) {
		 
	}
	
	/**
	 * Makes a transaction to a card, subtracting the amount for a year-long subscription.
	 * @param cardNumber, the card number to be charged.
	 * @param transactionAmount, the transaction amount of the subscription.
	 */
	public void makeSubscriptionTransaction(long cardNumber, double transactionAmount) {
		 
		try {
			String query = "SELECT Funds FROM CARDINFO WHERE CardNumber=?";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, Long.toString(cardNumber));
			
			results = myStmt.executeQuery();
			
			String query2 = "UPDATE CARDINFO SET Funds=? WHERE CardNumber=? AND Funds=?";
			
			PreparedStatement myStmt2 = dbConnect.prepareStatement(query2);
			
			myStmt2.setString(1, Double.toString(Double.parseDouble(results.getString("Funds")) - transactionAmount));
			myStmt2.setString(2, Long.toString(cardNumber));
			myStmt2.setString(3, results.getString("Funds"));
			
			myStmt2.executeUpdate();
			
			myStmt.close();
			myStmt2.close();
			
		} catch (Exception e) {
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
