package ParkhausAutoSoftware;

import java.util.List;
import java.util.ArrayList;

public class Kunde {

	private List<Ticket> tickets;
	private int id;
	private boolean parkt = false;
	private Etage parkEtage = null;
	
	
	public Kunde(Ticket t,int id, Etage parkEtage) {
		tickets = new ArrayList<Ticket>();
		addTicketAndSetParktTrue(t);
		this.parkEtage = parkEtage;
		this.id = id;
	}
	
	public Kunde(int id) {
		tickets = new ArrayList<Ticket>();
		this.id = id;
	}
	
	
	public Etage getParkEtage() {
		return parkEtage;
	}

	public void setParkEtage(Etage parkEtage) {
		this.parkEtage = parkEtage;
	}

	public boolean getParkt() {
		return parkt;
	}

	public void setParkt(boolean parkt) {
		this.parkt = parkt;
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
