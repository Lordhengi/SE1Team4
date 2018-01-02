package ParkhausAutoSoftware;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class Test_XStream {
	
	String x1;
	Start start;
	XStream xstream;
	Parkhaus p2;
	
	@Before
	  public void setUp() throws Exception {
		start = new Start();
		start.p = new Parkhaus("Test","Test",0);
		xstream = new XStream();
		   x1 = start.save();
	  }
	
	@Test
	  public void testSpeichernManagerName() {
	    p2 = (Parkhaus) xstream.fromXML(x1);
		assertEquals( start.p.getManager().getName(), p2.getManager().getName());
	  }
	
	@Test
	  public void testSpeichernManagerName2() {
		Parkhaus p3 = start.p;
	    assertEquals(start.p, p3);
	  }
	
	@Test
	  public void testLadenSpeichern() {
	    start.load();
	    String x2 = start.save();
		assertEquals(x1, x2);
	  }

	@Test
	  public void testSpeichernName() {
		 p2 = (Parkhaus) xstream.fromXML(x1);
			assertEquals( start.p.getName(), p2.getName());
	  }
	
	@Test
	  public void testSpeichernManagerPreis() {
		 p2 = (Parkhaus) xstream.fromXML(x1);
			assertEquals( start.p.getManager().getPreis(), p2.getManager().getPreis(), 0.000001d);
	  }
}
