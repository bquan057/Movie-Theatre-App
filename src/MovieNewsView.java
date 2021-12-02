import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JScrollBar;

public class MovieNewsView extends JFrame{

	JPanel displayPanel;
	JPanel titlePanel;
	JLabel newsTitle;
	JPanel movieNewsPanel;
	JLabel movieNewsHeading;
	JTextArea movieNewsContent;
	JPanel movieNewsPanel2;
	JLabel movieNewsHeading2;
	JTextArea movieNewsContent2;
	JScrollBar scrollBar;
	
	public MovieNewsView() {
		
		setSize(654, 400);
		setTitle("Movie News");
		getContentPane().setLayout(null);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBounds(0, 0, 630, 320);
		
		getContentPane().add(displayPanel);
		displayPanel.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(40, 10, 559, 47);
		displayPanel.add(titlePanel);
		
		JLabel newsTitle = new JLabel("MOVIE NEWS");
		titlePanel.add(newsTitle);
		newsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		newsTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel movieNewsPanel = new JPanel();
		movieNewsPanel.setBounds(40, 83, 559, 224);
		displayPanel.add(movieNewsPanel);
		movieNewsPanel.setLayout(null);
		
		JLabel movieNewsHeading = new JLabel("Tickets for Movie 1 Are Now Available!");
		movieNewsHeading.setBounds(108, 5, 342, 25);
		movieNewsHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		movieNewsPanel.add(movieNewsHeading);
		
		JTextArea movieNewsContent = new JTextArea();
		movieNewsContent.setBounds(25, 51, 511, 160);
		movieNewsContent.setText("\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"");
		movieNewsContent.setLineWrap(true);
		movieNewsPanel.add(movieNewsContent);
		
	}
	
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
