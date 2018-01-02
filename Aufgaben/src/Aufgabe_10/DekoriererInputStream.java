package Aufgabe_10;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DekoriererInputStream extends FilterInputStream {

	private String ergebnis = "";
	
	protected DekoriererInputStream(InputStream arg0) {
		super(arg0);
		try {
			int j = arg0.available();
			for(int i = 0; i < j; i++)
			{
				ergebnis += (char)arg0.read();
			}
			ergebnis = ergebnis.toUpperCase();
		
		}catch(IOException e)
		{
			
		}
		
	}

	public String getErgebnis() {
		return ergebnis;
	}
	
	

}
