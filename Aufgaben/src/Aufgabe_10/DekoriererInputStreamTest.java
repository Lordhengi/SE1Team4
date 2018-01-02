package Aufgabe_10;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

public class DekoriererInputStreamTest {

	DekoriererInputStream d;
	InputStream stream;
	String test1 = "h";
	String test2 = "ha";
	String test3 = "Ha";
	String test4 = "lH";
	String test5 = "2H";
	
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	
	@Test
	public void test1GetErgebnis() {
		try {
			stream = new ByteArrayInputStream(test1.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		d = new DekoriererInputStream(stream);
		assertEquals(d.getErgebnis(), "H");
	}
	@Test
	public void test2GetErgebnis() {
		try {
			stream = new ByteArrayInputStream(test2.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		d = new DekoriererInputStream(stream);
		assertEquals(d.getErgebnis(), "HA");
	}
	@Test
	public void test3GetErgebnis() {
		try {
			stream = new ByteArrayInputStream(test3.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		d = new DekoriererInputStream(stream);
		assertEquals(d.getErgebnis(), "HA");
	}
	@Test
	public void test4GetErgebnis() {
		try {
			stream = new ByteArrayInputStream(test4.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		d = new DekoriererInputStream(stream);
		assertEquals(d.getErgebnis(), "LH");
	}
	@Test
	public void test5GetErgebnis() {
		try {
			stream = new ByteArrayInputStream(test5.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		d = new DekoriererInputStream(stream);
		assertEquals(d.getErgebnis(), "2H");
	}

}
