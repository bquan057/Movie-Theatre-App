package Presentation;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;

/**
 * View to select a movie
 * @author Aron Saengchan
 */
public class SearchMoviesView extends JFrame {
	
    /**
     * Combo boxes to select a movie, theatre, and showtime
     */
    private JComboBox<String> movieComboBox;

    private JComboBox<String> theatreComboBox;

    private JComboBox<LocalDateTime> showtimeComboBox;

    /**
     * Button to continue the booking process
     */
    private JButton continueButton;

    /**
     * Constructor to initialize the contents of the book ticket view
     */
    public SearchMoviesView() {
        // Set properties of frame
        this.setTitle("Movie Theatre Registration Application");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Insert top program header
        JLabel titleHeader = new JLabel("Book Ticket");
        titleHeader.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleHeader.setHorizontalAlignment(JLabel.CENTER);
        titleHeader.setVerticalAlignment(JLabel.CENTER);
        titleHeader.setBorder(new EmptyBorder(25, 0, 25, 0));
        this.add(titleHeader, BorderLayout.NORTH);

        // Format contents panel
        JPanel searchMoviesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        this.add(searchMoviesPanel, BorderLayout.CENTER);

        // Insert frame header
        JLabel frameHeader = new JLabel("View Movies & Showtimes");
        frameHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
        gbc.insets = new Insets(0, 0, 25, 0);
        searchMoviesPanel.add(frameHeader, gbc);

        // Insert the movie label
        JLabel movieLabel = new JLabel("Select a movie:");
        movieLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 3, 0);
        searchMoviesPanel.add(movieLabel, gbc);

        // Insert the movie combo box
        this.movieComboBox = new JComboBox<>();
        this.movieComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 25, 0);
        searchMoviesPanel.add(this.movieComboBox, gbc);

        // Insert the theatre label
        JLabel theatreLabel = new JLabel("Select a theatre:");
        theatreLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 3, 0);
        searchMoviesPanel.add(theatreLabel, gbc);

        // Insert the theatre combo box
        this.theatreComboBox = new JComboBox<>();
        this.theatreComboBox.setEnabled(false);
        this.theatreComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 25,0);
        searchMoviesPanel.add(this.theatreComboBox, gbc);

        // Insert the showtime label
        JLabel showtimeLabel = new JLabel("Select a showtime:");
        showtimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 3, 0);
        searchMoviesPanel.add(showtimeLabel, gbc);

        // Insert the showtime combo box
        this.showtimeComboBox = new JComboBox<>();
        this.showtimeComboBox.setEnabled(false);
        this.showtimeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 50, 0);
        searchMoviesPanel.add(this.showtimeComboBox, gbc);

        // Insert the continue button
        this.continueButton = new JButton("Continue");
        this.continueButton.setEnabled(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 75, 0);
        searchMoviesPanel.add(this.continueButton, gbc);
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
		this.movieComboBox.addActionListener(actionListener);
		this.theatreComboBox.addActionListener(actionListener);
		this.showtimeComboBox.addActionListener(actionListener);
		this.continueButton.addActionListener(actionListener);
    }

    // Getters for the input fields
    public JComboBox<String> getMovieComboBox() {
        return movieComboBox;
    }

    public JComboBox<String> getTheatreComboBox() {
        return theatreComboBox;
    }

    public JComboBox<LocalDateTime> getShowtimeComboBox() {
        return showtimeComboBox;
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}