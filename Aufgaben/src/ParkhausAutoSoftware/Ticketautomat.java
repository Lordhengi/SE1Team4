package ParkhausAutoSoftware;

import java.util.ArrayList;
import java.util.List;

public class Ticketautomat {

	private List<Ticket> tickets = new ArrayList<Ticket>();
	public static int id = 0;
	
	public Ticketautomat() {
	}
	
	public Ticket create(Parkhaus p) {
		Ticket t = new Ticket(id, p.getManager().getPreis());
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