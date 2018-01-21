package Aufgabe_13;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EuklidTest {

	private Euklid e;
	@Before
	public void setUp() throws Exception {
		e = new Euklid();
	}
	
	@Test
	public void TestNull() {
		//Geht in Zeile 3,4,5,6 und 0 mal in die Schleife
		assertEquals(e.ggT(0, 12), 12);
	}
	
	@Test
	public void TestGroﬂeZahlLinks() {
		//Geht in Zeile 3,4,8,9,10,11,12,13,14,15 und 2 mal in die Schleife
		assertEquals(e.ggT(24, 12), 12);
	}

}
