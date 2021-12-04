import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

/**
 * @author Aron Saengchan
 * @version 1.0
 * @since December 1, 2021
 */
public class SeatAvailabilityView extends JFrame {
	
	private JButton[] seats;
		

	/**
	 * Create the frame.
	 */
	public SeatAvailabilityView() {
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
        titleHeader.setBorder(new EmptyBorder(25, 0, 0, 0));
        this.add(titleHeader, BorderLayout.NORTH);
		
        // Format contents panel
        JPanel seatAvailabilityPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        this.add(seatAvailabilityPanel, BorderLayout.CENTER);

        // Insert frame header
        JLabel frameHeader = new JLabel("Seat Availability");
        frameHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.insets = new Insets(0, 0, 25, 0);
        seatAvailabilityPanel.add(frameHeader, gbc);
		
		// Displays the graphical seat view using buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 5, 10, 10));
        
        this.seats = new JButton[30];
        
        for (int i = 0; i < this.seats.length; i++) {
        	this.seats[i] = new JButton("" + (i + 1));
        	
        	if (i % 3 == 0) {
        		this.seats[i].setEnabled(false);
        	}
        	
            buttonPanel.add(this.seats[i]);
        }
        
        buttonPanel.setPreferredSize(new Dimension(300, 400));
        gbc.gridy++;
        seatAvailabilityPanel.add(buttonPanel, gbc);

		
	}
	
    /**
     * Opens the seat availability frame
     */
    public void activate() {
        this.setVisible(true);
    }

    /**
     * Closes the seat availability frame
     */
    public void deactivate() {
        this.dispose();
    }
    
    /**
     * Adds action listeners to the controller
     * @param actionListener controller that controls the frame
     */
    public void addActionListeners(ActionListener actionListener) {
        for (int i = 0; i < this.seats.length; i++) {
        	this.seats[i].addActionListener(actionListener);
        }
    }

    
    // Getters for the input fields
    public JButton[] getSeats() {
    	return this.seats;
    }
}
