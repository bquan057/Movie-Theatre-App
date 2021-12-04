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
public class SearchMoviesView extends JFrame {
	
    /**
     * Combo box to select a movie
     */
    JComboBox<String> movieComboBox;

    /**
     * Combo box to select a theatre
     */
    JComboBox<String> theatreComboBox;

    /**
     * Combo box to select a showtime
     */
    JComboBox<String> showtimeComboBox;

    /**
     * Button to continue the booking process
     */
    JButton continueButton;

    /**
     * Constructor to initialize the contents of the book ticket frame
     */
    public SearchMoviesView() {
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
        gbc.insets = new Insets(0, 0, 3,0);
        searchMoviesPanel.add(movieLabel, gbc);

        // Insert the movie combo box
        String[] movies = {"Lethal Weapon", "Lord of the Rings", "Inception", "Fight Club"};
        this.movieComboBox = new JComboBox<>(movies);
        this.movieComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 25,0);
        searchMoviesPanel.add(this.movieComboBox, gbc);

        // Insert the theatre label
        JLabel theatreLabel = new JLabel("Select a theatre:");
        theatreLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 3,0);
        searchMoviesPanel.add(theatreLabel, gbc);

        // Insert the theatre combo box
        String[] theatres = {"Cineplex", "Landmark", "Galaxy", "AMC"};
        this.theatreComboBox = new JComboBox<>(theatres);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' hh:mm a");
        String[] showtimes = {formatter.format(LocalDateTime.of(2017, 2, 13, 15, 56)), formatter.format(LocalDateTime.of(2018, 2, 13, 15, 56))};
        this.showtimeComboBox = new JComboBox<>(showtimes);
        this.showtimeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 50, 0);
        searchMoviesPanel.add(this.showtimeComboBox, gbc);

        // Insert the continue button
        this.continueButton = new JButton("Continue");
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
    public JComboBox getMovieComboBox() {
        return movieComboBox;
    }

    public JComboBox getTheatreComboBox() {
        return theatreComboBox;
    }

    public JComboBox getShowtimeComboBox() {
        return showtimeComboBox;
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}