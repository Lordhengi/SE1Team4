package Aufgabe_12;

public class Ticket {

	private float parkdauer;
	private float preis;
	private String kunde;
	
	
	public Ticket(float parkdauer, float preis, String kunde) {
		this.parkdauer = parkdauer;
		this.preis = preis;
		this.kunde = kunde;
	}


	public float getParkdauer() {
		return parkdauer;
	}


	public void setParkdauer(float parkdauer) {
		this.parkdauer = parkdauer;
	}


	public float getPreis() {
		return preis;
	}


	public void setPreis(float preis) {
		this.preis = preis;
	}


	public String getKunde() {
		return kunde;
	}


	public void setKunde(String kunde) {
		this.kunde = kunde;
	}
	
	
}
