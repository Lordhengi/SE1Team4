package ParkhausAutoSoftware;

public class Manager extends Mitarbeiter{
	
	private float preis;
	
	public Manager(String name, String arbeit, float ticketpreis) {
		super(name, arbeit);
		preis = ticketpreis;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float ticketpreis) {
		preis = ticketpreis;
	}
	
	

}
