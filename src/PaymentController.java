import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PaymentController {
	
	private PaymentView theView;
	private FinancialService theModel;
	private PaymentEntity payment;
	
	public PaymentController(PaymentView view, FinancialService model) {
		theView = view;
		theModel = model;
		
		payment = new PaymentEntity();
		
		view.addActionListener(new PaymentSubmitListener());
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
