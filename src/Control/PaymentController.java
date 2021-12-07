package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import DataSource.FinancialService;
import DataSource.PaymentEntity;
import DataSource.Ticket;
import Presentation.PaymentView;

/**
 * A controller class used to communicate between the FinancialDB and the PaymentView.
 * @author Ammaar Raihan
 *
 */

public class PaymentController {
	
	private PaymentView theView;
	private FinancialService theModel;
	private PaymentEntity payment;
	private Ticket ticket;
	
	public PaymentController(FinancialService model, Ticket ticket) {
		
		theView = new PaymentView();
		theModel = model;
		this.ticket = ticket;
		
		payment = new PaymentEntity();
		
		theView.addActionListener(new PaymentSubmitListener());
		theView.activate();
	}
	
	class PaymentSubmitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//TODO: MAYBE ADD ERROR HANDLING FOR EMPTY FIELDS
			
			String fName = theView.getTxtFName();
			String lName = theView.getTxtLName();
			String email = theView.getTxtEmail();
			String creditNum = theView.getTxtCCN();

			int ticketID = ticket.getTicketId();
			
			payment.setEmail(email);
			payment.setFname(fName);
			payment.setItems(ticket.getMovie());
			payment.setlName(lName);
			payment.setPrice(17.5);
			payment.setTicketID(ticketID);
			
			
			 if(checkEmptyFields(fName,lName,email,creditNum)) {
				 JOptionPane.showMessageDialog(new JFrame(), "All fields should be filled",
				 "Error", JOptionPane.ERROR_MESSAGE); 
				 return; 
			 }
			
			payment.setStatus("pending");
			
			if(theModel.validateCard(creditNum)) {
				
				payment.setStatus("processed");

				if(theModel.verifyFunds(creditNum, 17.5)){
					
					payment.setStatus("approved");
					
					theModel.makeTicketTransaction(creditNum, payment);
					
					JOptionPane.showMessageDialog(new JFrame(), "Payment successfully completed. Receipt emailed",
							 "Success", JOptionPane.INFORMATION_MESSAGE);
					
					theView.deactivate();
				}
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Error with credit card",
						 "Error", JOptionPane.ERROR_MESSAGE); return; 
			}
			
		}
	}
	
	private boolean checkEmptyFields(String fname, String lname, String email, String creditNum) {
		if(fname.equals("") || lname.equals("") || email.equals("") || creditNum.equals(""))
			return true;
		
		return false;
		
	}
}
