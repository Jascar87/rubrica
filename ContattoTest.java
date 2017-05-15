package rubrica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContattoTest {
	Contatto contatto;
	
	@Before
	public void prepara(){
		contatto = new Contatto("Lui", "lui@me.com", "12345, 67891, 98765, 43219");
	}

	@Test
	public void testEMail() {
		assertEquals(contatto.getEMail(), "lui@me.com");
		assertFalse(contatto.setEMail("nonsembraunamail"));
		assertEquals(contatto.getEMail(), "lui@me.com");
		assertTrue(contatto.setEMail("nuovo@roba.com"));
		assertEquals(contatto.getEMail(), "nuovo@roba.com");
	}
	
	@Test
	public void testTelNums(){
		assertFalse(contatto.addTelNum("nonsembrauntelefono"));
		assertFalse(contatto.addTelNum("12345"));
		assertTrue(contatto.addTelNum("95817"));
		assertFalse(contatto.delTelNum("11111"));
		assertTrue(contatto.delTelNum("12345"));
	}
	
	@Test
	public void testString(){
		assertEquals(contatto.getTelNums(), "12345, 67891, 98765, 43219");
		assertEquals(contatto.toString(), "Lui; lui@me.com; 12345, 67891, 98765, 43219");
	}
}
