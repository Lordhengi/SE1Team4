package ParkhausAutoSoftware;

import java.util.ArrayList;
import java.util.List;

public class Ticketautomat {

	private List<Ticket> tickets = new ArrayList<Ticket>();
	int id;
	
	public Ticketautomat() {
		id = 0;
	}
	
	public void create() {
		tickets.add(new Ticket(id, Manager.getpreis()));
		id++;
	}
	
	public List<Ticket> gettickets() {
		return tickets;
	}
}