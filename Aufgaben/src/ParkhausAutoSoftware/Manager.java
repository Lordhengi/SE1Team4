package ParkhausAutoSoftware;

public class Manager extends Mitarbeiter{
	
	private static float preis;
	
	public Manager(String name, String arbeit, int ticketpreis) {
		super(name, arbeit);
		preis = ticketpreis;
	}

	

	public static float getPreis() {
		return preis;
	}

	public static void setPreis(float ticketpreis) {
		preis = ticketpreis;
	}
	
	

}
