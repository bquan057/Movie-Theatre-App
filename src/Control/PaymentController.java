package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DataSource.FinancialService;
import DataSource.PaymentEntity;
import Presentation.PaymentView;

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
			int creditNum = Integer.parseInt(theView.getTxtCCN());
			
			
		}
	}
}
