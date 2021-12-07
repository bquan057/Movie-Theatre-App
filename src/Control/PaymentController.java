package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD:src/PaymentController.java
import javax.swing.JFrame;
import javax.swing.JOptionPane;
=======
import DataSource.FinancialService;
import DataSource.PaymentEntity;
import Presentation.PaymentView;
>>>>>>> 231c85ae8e7325fc4c39913ca898950b968953b7:src/Control/PaymentController.java

public class PaymentController {
	
	private PaymentView theView;
	private FinancialService theModel;
	private PaymentEntity payment;
	
	public PaymentController(FinancialService model, Ticket ticket) {
		theView = new PaymentView();
		theModel = model;
		
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
			
			//TODO get from ticket object passed from BookTicket
			int ticketID = 1234;
			
			if(checkEmptyFields(fName,lName,email,creditNum)) {
				JOptionPane.showMessageDialog(new JFrame(), "All fields should be filled", "Error",
				        JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			payment.setStatus("pending");
			
			if(theModel.validateCard(creditNum)) {
				payment.setStatus("processed");
				//TODO FIX WITH TICKET PRICE
				if(theModel.verifyFunds(creditNum, 123)){
					
				}
			}
			
		}
	}
	
	private boolean checkEmptyFields(String fname, String lname, String email, String creditNum) {
		if(fname.equals("") || lname.equals("") || email.equals("") || creditNum.equals(""))
			return true;
		
		return false;
		
	}
}
