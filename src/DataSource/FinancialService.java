package DataSource;
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
	
	
	/**
	 * This method checks if the credit card number exists in database
	 * @param cardNumber
	 * @return true if card number exists in database, else False
	 */
	public boolean validateCard(String cardNumber) {
		try {
			String query = "SELECT * FROM CARDINFO WHERE CardNumber = ?";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1,cardNumber);
			results = myStmt.executeQuery();
			
			if(!results.next()) {
				return false;
			}
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * This method checks if the specified card has enough funds to pay for the ticket or subscription
	 * @param cardNumber
	 * @param transactionAmount: amount to be deducted
	 * @return true if funds available in database, else false
	 */
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
	
	/**
	 * This method inserts a new entry into the transaction table as well as deduct funds from the cardInfo table
	 * @param cardNumber
	 * @param payment : Object containing most of the attributes required for the database
	 */
	public void makeTicketTransaction(String cardNumber, PaymentEntity payment) {
		
		String query = "INSERT INTO TRANSACTIONS (TicketID,Amount,Email,FName,LName) values (?,?,?,?,?)";
		
		try {
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, Integer.toString(payment.getTicketID()));
			myStmt.setString(2, Double.toString(payment.getPrice()));
			myStmt.setString(3, payment.getEmail());
			myStmt.setString(4, payment.getFname());
			myStmt.setString(5, payment.getlName());
			
			myStmt.executeUpdate();
			myStmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		double funds = 0;
		
		String query2 = "SELECT Funds FROM CARDINFO WHERE CardNumber=?";
		try {
			PreparedStatement myStmt = dbConnect.prepareStatement(query2);
			
			myStmt.setString(1, cardNumber);
			
			results = myStmt.executeQuery();
			results.next();
			funds = Double.parseDouble(results.getString("Funds"));
			
			myStmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String query3 = "UPDATE CARDINFO SET Funds=? WHERE CardNumber=? AND Funds=?";
		try {
			
			PreparedStatement myStmt2 = dbConnect.prepareStatement(query3);
			
			myStmt2.setDouble(1, funds - payment.getPrice());
			myStmt2.setString(2, cardNumber);
			myStmt2.setDouble(3, funds);
			
			myStmt2.executeUpdate();
			
			myStmt2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Makes a transaction to a card, subtracting the amount for a year-long subscription.
	 * @param cardNumber, the card number to be charged.
	 * @param transactionAmount, the transaction amount of the subscription.
	 */
	public void makeSubscriptionTransaction(long cardNumber, double transactionAmount) {
		
		double funds = 0;
		
		String query = "SELECT Funds FROM CARDINFO WHERE CardNumber=?";
		try {
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, Long.toString(cardNumber));
			
			results = myStmt.executeQuery();
			results.next();
			funds = Double.parseDouble(results.getString("Funds"));
			
			myStmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String query2 = "UPDATE CARDINFO SET Funds=? WHERE CardNumber=? AND Funds=?";
		try {
			
			PreparedStatement myStmt2 = dbConnect.prepareStatement(query2);
			
			myStmt2.setDouble(1, funds - transactionAmount);
			myStmt2.setString(2, Long.toString(cardNumber));
			myStmt2.setDouble(3, funds);
			
			myStmt2.executeUpdate();
			
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
