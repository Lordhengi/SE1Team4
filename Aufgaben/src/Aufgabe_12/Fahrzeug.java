package Aufgabe_12;

public class Fahrzeug{
	private String fahrzeugtyp;
	private int quadratmeter;
	
	public Fahrzeug()
	{
	}
	
	public Fahrzeug(String fahrzeugtyp, int quadratmeter)
	{
		this.fahrzeugtyp = fahrzeugtyp;
		this.quadratmeter = quadratmeter;
	}

	public String getFahrzeugtyp() {
		return fahrzeugtyp;
	}

	public void setFahrzeugtyp(String fahrzeugtyp) {
		this.fahrzeugtyp = fahrzeugtyp;
	}

	public int getQuadratmeter() {
		return quadratmeter;
	}

	public void setQuadratmeter(int quadratmeter) {
		this.quadratmeter = quadratmeter;
	}
	
	

}
