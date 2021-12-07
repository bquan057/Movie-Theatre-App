
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
			
			// TODO get user information based on login or not
			String userType = "Registered";
			double refund = 0.0;
			if(userType.equals("Registered")) {
				refund = refund * 0.90;
			}else {
				refund = refund * 0.85;
			}
			newCredit.setAmount(refund);
			
			theatreService.addCredit(newCredit);
		});
	}
	
	
}
