package ParkhausAutoSoftware;

import java.util.UUID;

public class Ticket {

	private UUID id;
	private boolean entwertet;
	private NewZeit einfahrt;
	private NewZeit ausfahrt = null;
	private float preiseinfahrt;
	
	public Ticket(float preiseinfahrt) {
		id = UUID.randomUUID();
		this.preiseinfahrt = preiseinfahrt;
		einfahrt = NewZeit.aktuelleZeit();
		entwertet = false;
	}
	
	public String getId() {
		return id.toString();
	}
	
	public boolean getEntwertet() {
		return entwertet;
	}
	
	public float getPreiseinfahrt() {
		return preiseinfahrt;
	}
	
	public NewZeit getEinfahrt() {
		return einfahrt;
	}
	
	public NewZeit getAusfahrt() {
		return ausfahrt;
	}
	
	public NewZeit ausfahrt() {
		entwertet = true;
		ausfahrt = NewZeit.aktuelleZeit();
		return ausfahrt;
	}
}
