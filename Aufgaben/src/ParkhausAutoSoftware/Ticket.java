package ParkhausAutoSoftware;

public class Ticket {

	private int id;
	private boolean entwertet;
	private NewZeit einfahrt;
	private NewZeit ausfahrt = null;
	private float preiseinfahrt;
	
	public Ticket(int id, float preiseinfahrt) {
		this.id = id;
		this.preiseinfahrt = preiseinfahrt;
		einfahrt = NewZeit.aktuelleZeit();
		entwertet = false;
	}
	
	public int getId() {
		return id;
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
		entwertet = true;
		ausfahrt = NewZeit.aktuelleZeit();
		return ausfahrt;
	}
}
