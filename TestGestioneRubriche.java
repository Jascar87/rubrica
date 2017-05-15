import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGestioneRubriche {

	@Before
	public void prepara() {
		GestioneRubriche.creaRubrica("Rubrica1", 2);
	}
	
	@Test
	public void testCreaRubrica() {
		assertEquals(GestioneRubriche.creaRubrica("Rubrica2", 1), 1);
		assertEquals(GestioneRubriche.creaRubrica("Rubrica1", 2), -1);
	}
	
	@Test
	public void testCancellaRubrica() {
		assertEquals(GestioneRubriche.cancellaRubrica("Rubrica1"), 1);
	}
	
	@Test
	public void testAggiungiInRubrica() {
		assertEquals(GestioneRubriche.aggiungiInRubrica("Rubrica1", "Pippo 1234"), 1);
		assertEquals(GestioneRubriche.aggiungiInRubrica("Rubrica1", "Paperino 2468"), 1);
		assertEquals(GestioneRubriche.aggiungiInRubrica("Rubrica1", "Topolino 1357"), -1);
		assertEquals(GestioneRubriche.aggiungiInRubrica("Rubrica2", "Pippo 1234"), -1);
		
	}
	
	@Test
	public void testCercaInRubrica() {
		GestioneRubriche.aggiungiInRubrica("Rubrica1", "Pippo 1234");
		GestioneRubriche.aggiungiInRubrica("Rubrica1", "Paperino 2468");
		assertTrue(GestioneRubriche.cercaInRubrica("Rubrica1", "Pippo") != null);
		assertTrue(GestioneRubriche.cercaInRubrica("Rubrica1", "Pippo").get(0).equals("Pippo 1234"));
	}
	
	@Test
	public void testCancellaInRubrica() {
		GestioneRubriche.aggiungiInRubrica("Rubrica1", "Pippo 1234");
		GestioneRubriche.aggiungiInRubrica("Rubrica1", "Paperino 2468");
		assertTrue(GestioneRubriche.cancellaInRubrica("Rubrica1", "Pippo"));
		assertFalse(GestioneRubriche.cancellaInRubrica("Rubrica1", "Pippo"));
	}

	@Test
	public void testToString() {
		GestioneRubriche.aggiungiInRubrica("Rubrica1", "Pippo 1234");
		GestioneRubriche.aggiungiInRubrica("Rubrica1", "Paperino 2468");
		assertTrue(GestioneRubriche.toString("Rubrica1").contains("Pippo 1234"));
		assertTrue(GestioneRubriche.toString("Rubrica1").contains("Paperino 2468"));
	}

}
