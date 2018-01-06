package ParkhausAutoSoftware.Fenster;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ParkhausAutoSoftware.Kunde;
import ParkhausAutoSoftware.Parkhaus;


public class AktuellerPreisFensterTest {
	
	private Parkhaus p = null;
	private Kunde k;
	private String erg;
	private KundenFenster kf;
	
	@Before
	public void setUp() throws Exception {
		p = new Parkhaus("Parkhaus", "Freddy", 3600);
		kf = new KundenFenster(p);
		p.addTicketautomat();
		p.addEtage("Etage 1", 30);
	}
	
	@Test
	public void testParkhaus() {
		assertEquals(p.getName(), "Parkhaus");		
	}
	
	@Test
	public void testManagerName() {
		assertEquals(p.getManager().getName(), "Freddy");
	}
	
	@Test
	public void testPreis() {
		assertEquals(Float.toString(p.getManager().getPreis()), "3600.0");		
	}
	
	@Test
	public void testListeTicketautomaten() {
		assertEquals(p.getTicketautomaten().size(), 1);	
	}
	
	@Test
	public void testListeEtagen() {
		assertEquals(p.getEtagen().size(), 1);	
	}
	
	@Test
	public void testEtagenName() {
		assertEquals(p.getEtagen().get(0).getName(), "Etage 1");	
	}
	
	@Test
	public void testEtagenPlaetze() {
		assertEquals(p.getEtagen().get(0).getPlaetze(), 30);		
	}
	
	
	@Test
	public void testAktuallisierterPreis1Sek() {
		p.einfahren(0, 0,p.getEtage("Etage 1"));
		assertEquals(p.getKunden().size(), 1);
		assertEquals(p.getKunden().get(0).getId(), 0);
		assertEquals(p.getKunden().get(0).getParkEtage().getName(), "Etage 1");
		assertEquals(p.getTicketautomat(0).getTickets().size(), 1);
		assertEquals(p.getKunden().get(0).getTickets().size(), 1);
		assertTrue(p.getKunden().get(0).getParkt());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		erg = kf.Ticketentwerten(p.getKunde(0).getTicket());
		assertEquals(erg, "1.00");
	}
	
	@Test
	public void testAktuallisierterPreis2Sek() {
		p.einfahren(0, 0,p.getEtage("Etage 1"));
		assertEquals(p.getKunden().size(), 1);
		assertEquals(p.getKunden().get(0).getId(), 0);
		assertEquals(p.getKunden().get(0).getParkEtage().getName(), "Etage 1");
		assertEquals(p.getTicketautomat(0).getTickets().size(), 1);
		assertEquals(p.getKunden().get(0).getTickets().size(), 1);
		assertTrue(p.getKunden().get(0).getParkt());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		erg = kf.Ticketentwerten(p.getKunde(0).getTicket());
		assertEquals(erg, "2.00");
	}
	
	@Test
	public void testAktuallisierterPreis3Sek() {
		p.einfahren(0, 0,p.getEtage("Etage 1"));
		assertEquals(p.getKunden().size(), 1);
		assertEquals(p.getKunden().get(0).getId(), 0);
		assertEquals(p.getKunden().get(0).getParkEtage().getName(), "Etage 1");
		assertEquals(p.getTicketautomat(0).getTickets().size(), 1);
		assertEquals(p.getKunden().get(0).getTickets().size(), 1);
		assertTrue(p.getKunden().get(0).getParkt());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		erg = kf.Ticketentwerten(p.getKunde(0).getTicket());
		assertEquals(erg, "3.00");
	}

}
