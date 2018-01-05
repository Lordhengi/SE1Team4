package ParkhausAutoSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticketautomat {

	private List<Ticket> tickets = new ArrayList<Ticket>();
	public static int id = 0;
	
	public Ticketautomat() {
	}
	
	public Ticket create(Parkhaus p) {
		Ticket t = new Ticket(p.getManager().getPreis());
		tickets.add(t);
		id++;
		return t;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public Ticket getTicket(UUID id) {
		return tickets.stream().filter(x -> id.toString().equals(x.getId())).findFirst().get();
	}
	
	public void entwerten(Ticket ticket) {
		ticket.getAusfahrt();
	}
}