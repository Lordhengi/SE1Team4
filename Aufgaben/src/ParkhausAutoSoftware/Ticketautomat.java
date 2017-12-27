package ParkhausAutoSoftware;

import java.util.ArrayList;
import java.util.List;

public class Ticketautomat {

	private List<Ticket> tickets = new ArrayList<Ticket>();
	int id;
	
	public Ticketautomat() {
		id = 0;
	}
	
	public Ticket create() {
		Ticket t = new Ticket(id, Manager.getPreis());
		tickets.add(t);
		id++;
		return t;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public Ticket getTicket(int id) {
		return tickets.get(id);
	}
	
	public void entwerten(Ticket ticket) {
		ticket.getAusfahrt();
	}
}