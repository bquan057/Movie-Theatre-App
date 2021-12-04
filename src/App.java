public class App {

    public static void main(String[] args){
    	
    	TheatreService theatreService = new TheatreService("jdbc:mysql://localhost/theatredb", "USERNAME HERE", "PASSWORD HERE");
    	MovieNewsController movieNewsController = new MovieNewsController(theatreService);
    	MovieNewsView movieNews = new MovieNewsView(movieNewsController);
    	
    	MainMenu window = new MainMenu(movieNews);
		window.frame.setVisible(true);
    }
}
