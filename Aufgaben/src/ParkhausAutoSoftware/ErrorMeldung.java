package ParkhausAutoSoftware;

import java.util.UUID;

public class ErrorMeldung {
	private UUID errorId;
	private String meldungstext;
	
	public ErrorMeldung()
	{
		errorId = UUID.randomUUID();
	}
	
	public ErrorMeldung(String meldungstext)
	{
		this.meldungstext = meldungstext;
		errorId = UUID.randomUUID();
	}
	
	
	
	public String getErrorId() {
		return errorId.toString();
	}
	public void setErrorId(UUID errorId) {
		this.errorId = errorId;
	}
	public String getMeldungstext() {
		return meldungstext;
	}
	public void setMeldungstext(String meldungstext) {
		this.meldungstext = meldungstext;
	}
	
	

}
