package Presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PaymentView extends JFrame{

	//private JFrame this;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtEmail;
	private JTextField txtCCN;
	private JButton btnSubmit;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PaymentView window = new PaymentView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PaymentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		this = new JFrame();
		this.setTitle("Ticket Payment");
		this.setBounds(100, 100, 582, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblPayment = new JLabel("Ticket Payment");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPayment.setBounds(162, 10, 225, 59);
		this.getContentPane().add(lblPayment);
		
		txtFName = new JTextField();
		txtFName.setBounds(310, 104, 213, 19);
		this.getContentPane().add(txtFName);
		txtFName.setColumns(10);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFName.setBounds(54, 94, 116, 31);
		this.getContentPane().add(lblFName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(54, 265, 116, 31);
		this.getContentPane().add(lblEmail);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(54, 180, 116, 31);
		this.getContentPane().add(lblLastName);
		
		txtLName = new JTextField();
		txtLName.setColumns(10);
		txtLName.setBounds(310, 190, 213, 19);
		this.getContentPane().add(txtLName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(310, 275, 213, 19);
		this.getContentPane().add(txtEmail);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		lblCreditCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreditCardNumber.setBounds(54, 353, 185, 31);
		this.getContentPane().add(lblCreditCardNumber);
		
		txtCCN = new JTextField();
		txtCCN.setColumns(10);
		txtCCN.setBounds(310, 363, 213, 19);
		this.getContentPane().add(txtCCN);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(210, 421, 124, 21);
		this.getContentPane().add(btnSubmit);
	}
	
	
	public void activate() {
        this.initialize();
       
		this.setVisible(true);
    }

    /**
     * Closes the book ticket frame
     */
    public void deactivate() {
        this.dispose();
    }
    

    /* Adds action listeners to the controller
    * @param actionListener controller that controls the frame
    */
   public void addActionListener(ActionListener actionListener) {
		this.btnSubmit.addActionListener(actionListener);
   }
   
   public String getTxtFName() {
		return txtFName.getText();
	}

//	public void setTxtFName(JTextField txtFName) {
//		this.txtFName = txtFName;
//	}

	public String getTxtLName() {
		return txtLName.getText();
	}

//	public void setTxtLName(JTextField txtLName) {
//		this.txtLName = txtLName;
//	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

//	public void setTxtEmail(JTextField txtEmail) {
//		this.txtEmail = txtEmail;
//	}

	public String getTxtCCN() {
		return txtCCN.getText();
	}

//	public void setTxtCCN(JTextField txtCCN) {
//		this.txtCCN = txtCCN;
//	}



}
