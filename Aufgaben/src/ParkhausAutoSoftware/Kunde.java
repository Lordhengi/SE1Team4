package ParkhausAutoSoftware;

import java.util.List;
import java.util.ArrayList;

public class Kunde {

	private List<Ticket> tickets;
	private int id;
	
	public Kunde(Ticket t,int id) {
		tickets = new ArrayList<Ticket>();
		tickets.add(t);
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
	}
	
	public List<Ticket> gettickets() {
		return tickets;
	}
}
