package ParkhausAutoSoftware;

public class Mitarbeiter {

	private String name;
	private String arbeit;
	
	public Mitarbeiter(String name, String arbeit)
	{
		this.name = name;
		this.arbeit = arbeit;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArbeit() {
		return arbeit;
	}

	public void setArbeit(String arbeit) {
		this.arbeit = arbeit;
	}
	
	
}
