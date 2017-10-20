package Aufgabe_02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZeitTest {

  Zeit z01, z02;
//  newZeit z03, z04; 

  @Before
  public void setUp() throws Exception {
    z01   = new Zeit(00.01f);
    z02   = new Zeit(00.02f);
//    z03   = new newZeit(00,61);
//    z04 = new newZeit(00,30);
  }

  @Test
  public void testStunden() {
    assertEquals(0, z01.stunden());
    assertEquals(0, z02.stunden());
//    assertEquals(1, z03.stunden());
  }

  @Test
  public void testMinuten() {
    assertEquals(1, z01.minuten());
    assertEquals(2, z02.minuten());
//    assertEquals(1, z03.minuten());
  }

  @Test
  public void testAdd() {
//	z04.add(new newZeit(00,40)); assertEquals("01:10", z04.toString());
    z01.add(z01); assertEquals(z01, z01);
  }

  @Test
  public void testToString() {
    assertEquals("00:01", z01.toString());
//	  assertEquals("01:01", z03.toString());
  }

}