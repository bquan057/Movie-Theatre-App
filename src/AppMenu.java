import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

public class AppMenu {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppMenu window = new AppMenu();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(592, 508);
		shell.setText("SWT Application");
		
		Button btnLogin = new Button(shell, SWT.BORDER);
		btnLogin.setBounds(59, 333, 149, 68);
		btnLogin.setText("Login");
		
		Button btnRegister = new Button(shell, SWT.BORDER);
		btnRegister.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRegister.setBounds(363, 338, 149, 63);
		btnRegister.setText("Register");
		
		Button btnBookTicket = new Button(shell, SWT.BORDER);
		btnBookTicket.setBounds(59, 77, 149, 68);
		btnBookTicket.setText("Book TIcket");
		
		Button btnCancelTicket = new Button(shell, SWT.BORDER);
		btnCancelTicket.setBounds(363, 77, 149, 68);
		btnCancelTicket.setText("Cancel Ticket");
		
		Button btnMovieNews = new Button(shell, SWT.BORDER);
		btnMovieNews.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMovieNews.setBounds(59, 202, 149, 68);
		btnMovieNews.setText("Movie News");
		
		Button btnPaySubscription = new Button(shell, SWT.BORDER);
		btnPaySubscription.setBounds(363, 202, 149, 68);
		btnPaySubscription.setText("Pay Subscription");
		
		Label label = new Label(shell, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(AppMenu.class, "/resources/resized-image-Promo.jpeg"));
		label.setBounds(241, 10, 100, 89);
		formToolkit.adapt(label, true, true);

	}
}
