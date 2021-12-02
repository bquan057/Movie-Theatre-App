public class App {

    public static void main(String[] args){
    	LoginView login = new LoginView();
    	UserController controller = new UserController(login);
    	
    	MainMenu window = new MainMenu(login);
		window.frame.setVisible(true);
		
    }
}
