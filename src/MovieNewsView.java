import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JScrollBar;

/**
 * The GUI view for the movie news use case.
 * @author Brandon Quan
 *
 */
public class MovieNewsView extends JFrame{

	MovieNewsController movieNewsController;
	JPanel displayPanel;
	JPanel titlePanel;
	JLabel newsTitle;
	JPanel movieNewsPanel;
	JLabel movieNewsHeading;
	JTextArea movieNewsContent;
	JScrollBar scrollBar;
	
	public MovieNewsView(MovieNewsController movieNewsController) {
		
		this.movieNewsController = movieNewsController;
		
		setSize(654, 600);
		setTitle("Movie News");
		getContentPane().setLayout(null);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBounds(0, 0, 630, 320);
		
		getContentPane().add(displayPanel);
		displayPanel.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(40, 20, 559, 47);
		displayPanel.add(titlePanel);
		
		JLabel newsTitle = new JLabel("MOVIE NEWS");
		titlePanel.add(newsTitle);
		newsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		newsTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel movieNewsPanel = new JPanel();
		movieNewsPanel.setBounds(40, 83, 559, 224);
		displayPanel.add(movieNewsPanel);
		movieNewsPanel.setLayout(null);
		
		JLabel movieNewsHeading = new JLabel("Tickets for " + movieNewsController.getMovieNews().get(0).getNewMovieName() + " Are Now Available!");
		movieNewsHeading.setHorizontalAlignment(SwingConstants.CENTER);
		movieNewsHeading.setBounds(23, 16, 512, 25);
		movieNewsHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		movieNewsPanel.add(movieNewsHeading);
		
		JTextArea movieNewsContent = new JTextArea();
		movieNewsContent.setBounds(23, 51, 512, 160);
		movieNewsContent.setText(movieNewsController.getMovieNews().get(0).getNews());
		movieNewsContent.setLineWrap(true);
		movieNewsContent.setEditable(false);
		movieNewsPanel.add(movieNewsContent);
		
		JPanel movieNewsPanel_1 = new JPanel();
		movieNewsPanel_1.setLayout(null);
		movieNewsPanel_1.setBounds(40, 310, 559, 224);
		getContentPane().add(movieNewsPanel_1);
		
		JLabel movieNewsHeading_1 = new JLabel("Tickets for " + movieNewsController.getMovieNews().get(1).getNewMovieName() + " Are Now Available!");
		movieNewsHeading_1.setHorizontalAlignment(SwingConstants.CENTER);
		movieNewsHeading_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		movieNewsHeading_1.setBounds(23, 16, 512, 25);
		movieNewsPanel_1.add(movieNewsHeading_1);
		
		JTextArea movieNewsContent_1 = new JTextArea();
		movieNewsContent_1.setText(movieNewsController.getMovieNews().get(1).getNews());
		movieNewsContent_1.setLineWrap(true);
		movieNewsContent_1.setBounds(23, 51, 512, 160);
		movieNewsContent_1.setEditable(false);
		movieNewsPanel_1.add(movieNewsContent_1);
		
	}
	
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
