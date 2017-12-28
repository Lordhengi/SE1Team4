package ParkhausAutoSoftware;

public class Etage {
	
	private String name;
	private int plaetze;
	private int belegt;
	
	public Etage(String name, int plaetze)
	{
		this.name = name;
		this.plaetze = plaetze;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlaetze() {
		return plaetze;
	}

	public void setPlaetze(int plaetze) {
		this.plaetze = plaetze;
	}

	public int getBelegt() {
		return belegt;
	}

	public void setBelegt(int belegt) {
		this.belegt = belegt;
	}
	
	public boolean parkplatzBelegen()
	{
		if(belegt >= plaetze)
		{
			return false;
		}
		else
		{
			belegt++;
			return true;
		}
	}
	
	public boolean parkplatzEntbelegen()
	{
		if(belegt > 0)
		{
			belegt--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
}
