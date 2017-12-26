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
		parken(t);
		this.id = id;
	}
	
	public Kunde(int id) {
		tickets = new ArrayList<Ticket>();
		this.id = id;
	}
	
	public Ticket getticket() {
		return tickets.get(tickets.size() - 2);
	}
	
	public int getid() {
		return id;
	}
	
	public void parken(Ticket t) {
		tickets.add(t);
		setParkt(true);
	}
	
	public List<Ticket> gettickets() {
		return tickets;
	}
}
