package ParkhausAutoSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Parkhaus {

	private String name;
	private List<Ticketautomat> ticketautomaten;
	private List<Etage> etagen;
	private List<Mitarbeiter> mitarbeiter;
	private List<Kunde> kunden;
	private List<ErrorMeldung> errors;
	private Manager manager;
	private float gkohle;
	private float tkohle;
	private float wkohle;
	private NewZeit ende;
	
	
	public ErrorMeldung getError(UUID id)
	{
		return errors.stream().filter(x -> id.toString().equals(x.getErrorId())).findFirst().get();
	}
	
	public List<ErrorMeldung> getErrors()
	{
		return errors;
	}

	public float getTkohle() {
		return tkohle;
	}

	public void setTkohle(float tkohle) {
		this.tkohle = tkohle;
	}

	public float getWkohle() {
		return wkohle;
	}

	public void setWkohle(float wkohle) {
		this.wkohle = wkohle;
	}

	public Parkhaus(String pname, String mname, float preis) {
		name = pname;
		ticketautomaten = new ArrayList<Ticketautomat>();
		etagen = new ArrayList<Etage>();
		mitarbeiter = new ArrayList<Mitarbeiter>();
		errors = new ArrayList<ErrorMeldung>();
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
		if(!ticketautomaten.isEmpty())
		{
			if(ticketautomaten.size() > nr)
			{
				return ticketautomaten.get(nr);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
		
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
	
	public void einfahren(int kid, int nr, Etage parkEtage) {
		if(getKunde(kid) == null) {
			Kunde k = new Kunde(ticketautomaten.get(nr).create(this), kid, parkEtage);
			kunden.add(k);
		} else {
			getKunde(kid).addTicketAndSetParktTrue(ticketautomaten.get(nr).create(this), parkEtage);
		}
	}

	public float getgKohle() {
		return gkohle;
	}

	public void setgKohle(float kohle) {
		this.gkohle = kohle;
	}

	public NewZeit getEnde() {
		return ende;
	}

	public void setEnde(NewZeit ende) {
		this.ende = ende;
	}
	
	
}
