package ParkhausAutoSoftware;

import java.util.List;
import java.util.ArrayList;

public class Kunde {

	private List<Ticket> tickets;
	private int id;
	private boolean parkt = false;
	
	public boolean getParkt() {
		return parkt;
	}

	public void setParkt(boolean parkt) {
		this.parkt = parkt;
	}

	public Kunde(Ticket t,int id) {
		tickets = new ArrayList<Ticket>();
		addTicketAndSetParktTrue(t);
		this.id = id;
	}
	
	public Kunde(int id) {
		tickets = new ArrayList<Ticket>();
		this.id = id;
	}
	
	public Ticket getTicket() {
		return tickets.get(tickets.size() - 1);
	}
	
	public int getId() {
		return id;
	}
	
	public void addTicketAndSetParktTrue(Ticket t) {
		tickets.add(t);
		setParkt(true);
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
}
