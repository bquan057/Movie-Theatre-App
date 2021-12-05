import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * View for entering user information
 * @author Aron Saengchan
 */
public class EnterInfoView extends JFrame {
    
	/**
	 * Text fields for input
	 */
	private JTextField firstNameTextField;
	
	private JTextField lastNameTextField;
	
	private JTextField emailTextField; 
	
	private JTextField phoneNumTextField; 
	
	/**
     * Button to continue the booking process
     */
    private JButton continueButton;
    
    /**
     * Constructor to initialize the view
     */
    public EnterInfoView() {
        // Set properties of frame
        this.setTitle("Movie Theatre Registration Application");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Insert top program header
        JLabel titleHeader = new JLabel("Book Ticket");
        titleHeader.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleHeader.setHorizontalAlignment(JLabel.CENTER);
        titleHeader.setVerticalAlignment(JLabel.CENTER);
        titleHeader.setBorder(new EmptyBorder(25, 0, 25, 0));
        this.add(titleHeader, BorderLayout.NORTH);

        // Format contents panel
        JPanel enterInfoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        this.add(enterInfoPanel, BorderLayout.CENTER);

        // Insert frame header
        JLabel frameHeader = new JLabel("Enter Information");
        frameHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.insets = new Insets(0, 0, 50, 0);
        enterInfoPanel.add(frameHeader, gbc);
        
		// Insert input fields
        JPanel inputFieldsPanel = new JPanel();
        inputFieldsPanel.setLayout(new GridLayout(0, 2, 15, 15));
        
        this.firstNameTextField = new JTextField("", 100);
        inputFieldsPanel.add(new JLabel("        First Name:"));
        inputFieldsPanel.add(this.firstNameTextField);
        
        this.lastNameTextField = new JTextField("", 100);
        inputFieldsPanel.add(new JLabel("        Last Name:"));
        inputFieldsPanel.add(this.lastNameTextField);
        
        this.emailTextField = new JTextField("", 100);
        inputFieldsPanel.add(new JLabel("        Email:"));
        inputFieldsPanel.add(this.emailTextField);
        
        this.phoneNumTextField = new JTextField("", 100);
        inputFieldsPanel.add(new JLabel("        Phone Number:"));
        inputFieldsPanel.add(this.phoneNumTextField);
        
        inputFieldsPanel.setPreferredSize(new Dimension(500, 400));
        gbc.gridy++;
        enterInfoPanel.add(inputFieldsPanel, gbc);

        // Insert the continue button
        this.continueButton = new JButton("Continue");
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 75, 0);
        enterInfoPanel.add(this.continueButton, gbc);
    }
    
    
    /**
     * Opens the book ticket frame
     */
    public void activate() {
        this.setVisible(true);
    }

    /**
     * Closes the book ticket frame
     */
    public void deactivate() {
        this.dispose();
    }


    /**
     * Adds action listeners to the controller
     * @param actionListener controller that controls the frame
     */
    public void addActionListeners(ActionListener actionListener) {
		this.continueButton.addActionListener(actionListener);
    }

    // Getter methods
    public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}


	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}


	public JTextField getEmailTextField() {
		return emailTextField;
	}


	public JTextField getPhoneNumTextField() {
		return phoneNumTextField;
	}


	public JButton getContinueButton() {
        return continueButton;
    }
}
