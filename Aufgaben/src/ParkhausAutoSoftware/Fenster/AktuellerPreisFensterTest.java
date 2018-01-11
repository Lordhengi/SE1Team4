package ParkhausAutoSoftware.Fenster;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ParkhausAutoSoftware.Parkhaus;


public class AktuellerPreisFensterTest {
	
	private Start s;
	private String erg;
	private KundenFenster kf;
	
	@Before
	public void setUp() throws Exception {
		s = new Start();
		s.p = new Parkhaus("Parkhaus", "Freddy", 3600);
		kf = new KundenFenster(s);
		s.p.addTicketautomat();
		s.p.addEtage("Etage 1", 30);
	}
	
	@Test
	public void testParkhaus() {
		assertEquals(s.p.getName(), "Parkhaus");		
	}
	
	@Test
	public void testManagerName() {
		assertEquals(s.p.getManager().getName(), "Freddy");
	}
	
	@Test
	public void testPreis() {
		assertEquals(Float.toString(s.p.getManager().getPreis()), "3600.0");		
	}
	
	@Test
	public void testListeTicketautomaten() {
		assertEquals(s.p.getTicketautomaten().size(), 1);	
	}
	
	@Test
	public void testListeEtagen() {
		assertEquals(s.p.getEtagen().size(), 1);	
	}
	
	@Test
	public void testEtagenName() {
		assertEquals(s.p.getEtagen().get(0).getName(), "Etage 1");	
	}
	
	@Test
	public void testEtagenPlaetze() {
		assertEquals(s.p.getEtagen().get(0).getPlaetze(), 30);		
	}
	
	
	@Test
	public void testAktuallisierterPreis1Sek() {
		s.p.einfahren(0, 0,s.p.getEtage("Etage 1"));
		assertEquals(s.p.getKunden().size(), 1);
		assertEquals(s.p.getKunden().get(0).getId(), 0);
		assertEquals(s.p.getKunden().get(0).getParkEtage().getName(), "Etage 1");
		assertEquals(s.p.getTicketautomat(0).getTickets().size(), 1);
		assertEquals(s.p.getKunden().get(0).getTickets().size(), 1);
		assertTrue(s.p.getKunden().get(0).getParkt());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		erg = kf.Ticketentwerten(s.p.getKunde(0).getTicket());
		assertEquals(erg, "1.00");
	}
	
	@Test
	public void testAktuallisierterPreis2Sek() {
		s.p.einfahren(0, 0,s.p.getEtage("Etage 1"));
		assertEquals(s.p.getKunden().size(), 1);
		assertEquals(s.p.getKunden().get(0).getId(), 0);
		assertEquals(s.p.getKunden().get(0).getParkEtage().getName(), "Etage 1");
		assertEquals(s.p.getTicketautomat(0).getTickets().size(), 1);
		assertEquals(s.p.getKunden().get(0).getTickets().size(), 1);
		assertTrue(s.p.getKunden().get(0).getParkt());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		erg = kf.Ticketentwerten(s.p.getKunde(0).getTicket());
		assertEquals(erg, "2.00");
	}
	
	@Test
	public void testAktuallisierterPreis3Sek() {
		s.p.einfahren(0, 0,s.p.getEtage("Etage 1"));
		assertEquals(s.p.getKunden().size(), 1);
		assertEquals(s.p.getKunden().get(0).getId(), 0);
		assertEquals(s.p.getKunden().get(0).getParkEtage().getName(), "Etage 1");
		assertEquals(s.p.getTicketautomat(0).getTickets().size(), 1);
		assertEquals(s.p.getKunden().get(0).getTickets().size(), 1);
		assertTrue(s.p.getKunden().get(0).getParkt());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		erg = kf.Ticketentwerten(s.p.getKunde(0).getTicket());
		assertEquals(erg, "3.00");
	}

}
