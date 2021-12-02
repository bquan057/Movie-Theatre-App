import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MovieNewsController implements NewsObserver{

	private MovieNewsView movieNews;
	
	public MovieNewsController(MovieNewsView movieNews) {
		this.movieNews = movieNews;
	}
	
	@Override
	public void update(MovieNews news) {
		JPanel movieNewsPanel = new JPanel();
		movieNewsPanel.setBounds(40, 83, 559, 384);
		movieNewsPanel.setLayout(null);
		
		JLabel movieNewsHeading = new JLabel(news.getNewsHeading());
		movieNewsHeading.setBounds(108, 5, 342, 25);
		movieNewsHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		movieNewsPanel.add(movieNewsHeading);
		
		JTextArea movieNewsContent = new JTextArea();
		movieNewsContent.setBounds(25, 51, 511, 298);
		movieNewsContent.setText(news.getNewsContent());
		movieNewsContent.setLineWrap(true);
		movieNewsPanel.add(movieNewsContent);
		
		movieNews.displayPanel.add(movieNewsPanel);
	}

}
