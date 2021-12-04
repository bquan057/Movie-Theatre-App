import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;

/**
 * @author Aron Saengchan
 * @version 1.0
 * @since December 1, 2021
 */
public class ConfirmReservationView extends JFrame {
	
    /**
     * Button to continue the booking process
     */
    private JButton continueButton;

	
    /**
     * Constructor to initialize the contents of the book ticket frame
     */
    public ConfirmReservationView() {
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
        JPanel confirmReservationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        this.add(confirmReservationPanel, BorderLayout.CENTER);

        // Insert frame header
        JLabel frameHeader = new JLabel("Confirm Reservation");
        frameHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.insets = new Insets(0, 0, 25, 0);
        confirmReservationPanel.add(frameHeader, gbc);

        // Insert the registered courses text area
        JTextArea reservationInfoTextArea = new JTextArea(14, 25);
        reservationInfoTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        reservationInfoTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        reservationInfoTextArea.setEditable(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 30, 0);
        confirmReservationPanel.add(reservationInfoTextArea, gbc);

        // Insert the continue button
        this.continueButton = new JButton("Continue");
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 75, 0);
        confirmReservationPanel.add(this.continueButton, gbc);
        
       
       // Remove dummy data 
        reservationInfoTextArea.setText("\n Movie: Inception\n Theatre: AMC\n Showtime: 2021-12-12 at 2:30 pm\n Seat: 12\n\n Total Price:\n  $17.50");
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
