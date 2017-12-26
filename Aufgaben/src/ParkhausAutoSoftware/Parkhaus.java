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
	private int kundenid;
	
	public Parkhaus(String pname, String mname, float preis) {
		name = pname;
		ticketautomaten = new ArrayList<Ticketautomat>();
		etagen = new ArrayList<Etage>();
		mitarbeiter = new ArrayList<Mitarbeiter>();
		kunden = new ArrayList<Kunde>();
		manager = new Manager(mname, "Manager", preis);
		kundenid = 0;
	}
	
	public void addTicketautomaten() {
		ticketautomaten.add(new Ticketautomat());
	}
	
	public void bauen(String ename, int plaetze) {
		if(geschoss(ename).equals(null)) {
			etagen.add(new Etage(ename, plaetze));
		} else {
			
		}
	}
	
	public void einstellen(String mname, String arbeit) {
		if(arbeiter(mname).equals(null)) {
			mitarbeiter.add(new Mitarbeiter(mname, arbeit));
		} else {
			
		}
	}
	
	public String getname() {
		return name;
	}
	
	public Manager getmanager() {
		return manager;
	}
	
	public List<Ticketautomat> getticketautomaten() {
		return ticketautomaten;
	}
	
	public List<Etage> getetage() {
		return etagen;
	}

	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}
	
	public List<Kunde> getKunden() {
		return kunden;
	}

	public Ticketautomat geraet(int nr) {
		return ticketautomaten.get(nr);
	}
	
	public Kunde getKunde(int id) {
		List<Kunde> karren = kunden.stream().filter(item -> item.getid() == id).collect(Collectors.toList());
		if(karren.size() > 0) {
			return karren.get(0);
		} else return null;
	}
	
	public Kunde getKunde(Ticket ticket) {
		List<Kunde> karren = kunden.stream().filter(item -> item.getticket().equals(ticket)).collect(Collectors.toList());
		if(karren.size() > 0) {
			return karren.get(0);
		} else return null;
	}
	
	public Etage geschoss(String gname) {
		List<Etage> stockwerke = etagen.stream().filter(item -> item.getName().equals(gname)).collect(Collectors.toList());
		if(stockwerke.size() > 0) {
			return stockwerke.get(0);
		} else return null;
	}
	
	public Mitarbeiter arbeiter(String aname) {
		List<Mitarbeiter> kollegen = mitarbeiter.stream().filter(item -> item.getName().equals(aname)).collect(Collectors.toList());
		if(kollegen.size() > 0) {
			return kollegen.get(0);
		} else return null;
	}
	
	public void einfahren(int kid, int nr) {
		if(getKunde(kid) == null) {
			Kunde k = new Kunde(ticketautomaten.get(nr).create(), kundenid);
			kunden.add(k);
			kundenid++;
		} else {
			getKunde(kid).parken(ticketautomaten.get(nr).create());
		}
	}
	
	
}
