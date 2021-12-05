
/**
 * CancelTicketController() manages the interaction between the CancelTickerVIew
 * and TheatreDatabase
 * @author Rohinesh Ram
 *
 */
public class CancelTicketController {
	//REQUIRED KNOWLEDGE OF WHICH TYPE OF USE IS USING THE APP
	// query showtime table with ticket id
		// check if show time is within 3 days
	// query theatre Db for ticket => return ticket object
		// remove ticket from db
	// get theatre, movie, auditorium, seat info from ticket
		// update theatre db
	// create credit object with user email and amount of credit
	// add credit object to theatredb
	
	private TheatreService theatreService;
	private CancelTicketView ticketView;
	
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
			
			String email = ticketView.getEmail();
			int id = Integer.parseInt(ticketView.getId());
			
			Ticket ticket = theatreService.validateTicket(email, id);
			
			if(ticket == null) {
				ticketView.displayErrorMessage("Not valid");
			}

//			if(!theatreService.checkShowtime(id)) {
//				ticketView.displayErrorMessage("Tickets cannot be cancelled"
//						+ " less than 72 hours before showtime");
//				return;
//			}
			
		});
	}
	
	
}
