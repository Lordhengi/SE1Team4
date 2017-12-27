package ParkhausAutoSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parkhaus {

	private String name;
	private List<Ticketautomat> ticketautomaten;
	private List<Etage> etagen;
	private List<Mitarbeiter> mitarbeiter;
	private List<Kunde> kunden;
	private Manager manager;
	
	public Parkhaus(String pname, String mname, float preis) {
		name = pname;
		ticketautomaten = new ArrayList<Ticketautomat>();
		etagen = new ArrayList<Etage>();
		mitarbeiter = new ArrayList<Mitarbeiter>();
		kunden = new ArrayList<Kunde>();
		manager = new Manager(mname, "Manager", preis);
	}
	
	public void addTicketautomat() {
		ticketautomaten.add(new Ticketautomat());
	}
	
	public void addEtage(String ename, int plaetze) {
		if(getEtage(ename) == null) {
			etagen.add(new Etage(ename, plaetze));
		} else {
			
		}
	}
	
	public void addMitarbeiter(String mname, String arbeit) {
		if(getMitarbeiter(mname).equals(null)) {
			mitarbeiter.add(new Mitarbeiter(mname, arbeit));
		} else {
			
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public List<Ticketautomat> getTicketautomaten() {
		return ticketautomaten;
	}
	
	public List<Etage> getEtagen() {
		return etagen;
	}

	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}
	
	public List<Kunde> getKunden() {
		return kunden;
	}

	public Ticketautomat getTicketautomat(int nr) {
		return ticketautomaten.get(nr);
	}
	
	public Kunde getKunde(int id) {
		List<Kunde> karren = kunden.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
		if(karren.size() > 0) {
			return karren.get(0);
		} else return null;
	}
	
	public Kunde getKunde(Ticket ticket) {
		List<Kunde> karren = kunden.stream().filter(item -> item.getTicket().equals(ticket)).collect(Collectors.toList());
		if(karren.size() > 0) {
			return karren.get(0);
		} else return null;
	}
	
	public Etage getEtage(String gname) {
		List<Etage> stockwerke = etagen.stream().filter(item -> item.getName().equals(gname)).collect(Collectors.toList());
		if(stockwerke.size() > 0) {
			return stockwerke.get(0);
		} else return null;
	}
	
	public Mitarbeiter getMitarbeiter(String aname) {
		List<Mitarbeiter> kollegen = mitarbeiter.stream().filter(item -> item.getName().equals(aname)).collect(Collectors.toList());
		if(kollegen.size() > 0) {
			return kollegen.get(0);
		} else return null;
	}
	
	public void einfahren(int kid, int nr) {
		if(getKunde(kid) == null) {
			Kunde k = new Kunde(ticketautomaten.get(nr).create(), kid);
			kunden.add(k);
		} else {
			getKunde(kid).addTicketAndSetParktTrue(ticketautomaten.get(nr).create());
		}
	}
	
	
}
