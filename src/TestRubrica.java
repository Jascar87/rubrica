import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRubrica {

	Rubrica rubricaTest;
	
	@Before()
	public void prepara() {
		rubricaTest = new Rubrica("NomeTest", 2);
	}
	
	@Test
	public void testCreazione() {
		
		assertEquals(rubricaTest.numEl(), 0);
	}
	
	@Test
	public void testAggiungi() {
		assertEquals(rubricaTest.aggiungi("Pippo 1234"), 1);
		rubricaTest.aggiungi("Paperino 0234");
		assertEquals(rubricaTest.aggiungi("Pluto 2314"), -1);
		assertEquals(rubricaTest.numEl(),2);
	}
	
	@Test
	public void testCerca() {
		rubricaTest.aggiungi("Pippo 1234");
		rubricaTest.aggiungi("Paperino 0234");
		assertTrue(rubricaTest.cerca("Paperino") != null);
		assertTrue(rubricaTest.cerca("Paperino").get(0).contains("Paperino"));
	}
	
	@Test
	public void testRimuovi() {
		rubricaTest.aggiungi("Pippo 1234");
		rubricaTest.aggiungi("Paperino 0234");
		assertTrue(rubricaTest.rimuovi("Pippo"));
		assertEquals(rubricaTest.numEl(),1);
	}
	
	@Test
	public void testToString() {
		rubricaTest.aggiungi("Pippo 1234");
		rubricaTest.aggiungi("Paperino 0234");
		assertTrue(rubricaTest.toString().contains("Pippo 1234"));
		assertTrue(rubricaTest.toString().contains("Paperino 0234"));
	}
}
