package Control;
import DataSource.Credit;
import DataSource.TheatreService;
import DataSource.Ticket;
import Presentation.CancelTicketView;
import DataSource.RegisteredUser;

/**
 * CancelTicketController() manages the interaction between the CancelTickerVIew
 * and TheatreDatabase
 * @author Rohinesh Ram
 *
 */
public class CancelTicketController {
	// create credit object with user email and amount of credit
	// add credit object to theatredb
	
	private TheatreService theatreService;
	private CancelTicketView ticketView;
	private RegisteredUser user;
	
	
	public CancelTicketController(CancelTicketView view, TheatreService service) {
		ticketView = view;
		theatreService = service;
		handleCancel();
	}
	
	/*
	 * manages the cancellation of a ticket
	 */
	public void handleCancel() {
		ticketView.addSubmitListener(e -> {
			
			theatreService.initializeConnection();
			
			String email = ticketView.getEmail();
			int id = Integer.parseInt(ticketView.getId());
			
			Ticket ticket = theatreService.validateTicket(email, id);
			
			// is ticket valid
			if(ticket == null) {
				ticketView.displayErrorMessage("Invalid Ticket");
			}
			
			// update ticket status
			ticket.setStatus("available");
			theatreService.updateTicketStatus(ticket);
			
			// ticket must be cancelled at least 72 hours before show time
			if(!theatreService.checkShowtime(ticket.getShowtime())) {
				ticketView.displayErrorMessage("Tickets cannot be cancelled"
						+ " less than 72 hours before showtime");
				return;
			}
			
			// update seat availability
			theatreService.updateSeatAvailability(ticket);
			
			// create credit object
			Credit newCredit = new Credit();
			newCredit.setEmail(email);
			
			// Registered get 10% fee, else 15%
			double refund = 17.5;
			if(user != null) {
				refund = refund * 0.90;
			}else {
				refund = refund * 0.85;
			}
			newCredit.setAmount(refund);
			
			theatreService.addCredit(newCredit);
			ticketView.displayErrorMessage("Ticket Cancelled, credit emailed");
			theatreService.removeTicket(id);
			ticketView.setVisible(false);
			ticketView.clearFields();
		});
	}
	
	public void setUser(RegisteredUser user) {
		this.user = user;
	}
	
	
}
