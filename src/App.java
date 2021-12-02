public class App {

    public static void main(String[] args){
    	MovieNewsView movieNews = new MovieNewsView();
    	MovieNewsController movieNewsController = new MovieNewsController(movieNews);
    	
    	MainMenu window = new MainMenu(movieNews);
		window.frame.setVisible(true);
    }
}
