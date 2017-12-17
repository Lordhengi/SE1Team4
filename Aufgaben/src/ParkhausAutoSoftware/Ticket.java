package ParkhausAutoSoftware;

public class Ticket {

	private int id;
	private boolean entwertet;
	private newZeit einfahrt;
	private newZeit ausfahrt = null;
	private float preiseinfahrt;
	
	public Ticket(int id, float preiseinfahrt) {
		this.id = id;
		this.preiseinfahrt = preiseinfahrt;
		einfahrt = newZeit.aktuelleZeit();
		entwertet = false;
	}
	
	public int getid() {
		return id;
	}
	
	public boolean getentwertet() {
		return entwertet;
	}
	
	public float getpreiseinfahrt() {
		return preiseinfahrt;
	}
	
	public newZeit geteinfahrt() {
		return einfahrt;
	}
	
	public newZeit getausfahrt() {
		if(entwertet) {
			return ausfahrt;
		} else {
			return null;
		}
	}
	
	public void entwerten() {
		entwertet = true;
		ausfahrt = newZeit.aktuelleZeit();
	}
}
