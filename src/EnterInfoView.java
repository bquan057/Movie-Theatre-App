import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Aron Saengchan
 * @version 1.0
 * @since December 1, 2021
 */
public class EnterInfoView extends JFrame {
    /**
     * Button to continue the booking process
     */
    JButton continueButton;
	
	
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
        this.add(enterInfoPanel, BorderLayout.CENTER);
        
        // Insert frame header
        JLabel frameHeader = new JLabel("Enter Information");
        frameHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.insets = new Insets(0, 0, 25, 0);
        enterInfoPanel.add(frameHeader, gbc);
        gbc.gridx = gbc.gridy = 0;

        // Insert the first name field
        JLabel nameLabel = new JLabel("First Name:");
        JTextField nameTextField = new JTextField(10);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 3, 0);
        enterInfoPanel.add(nameLabel, gbc);
        gbc.gridx++;
        enterInfoPanel.add(nameTextField, gbc);

        // Insert the theatre label
        JLabel theatreLabel = new JLabel("Select a theatre:");
        theatreLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 3,0);
        enterInfoPanel.add(theatreLabel, gbc);

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

    
    public JButton getContinueButton() {
        return continueButton;
    }
}
