package rubrica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RubricaContattiTest {
	RubricaContatti rubrica;
	
	@Before
	public void prepara() {
		rubrica = new RubricaContatti("Lavoro", 3);
		assertEquals(rubrica.numEl(), 0);
		assertEquals(rubrica.aggiungi("Tesla", "nykolajj@beograd.srb", "12345, 67891, 98765, 43219"), true);
		assertEquals(rubrica.numEl(), 1);
		assertEquals(rubrica.aggiungi("", null, "ciao"), false); // non valido
        assertEquals(rubrica.numEl(), 1);
		assertEquals(rubrica.aggiungi("Einstein", "einst.albertush@rel.us", "75391, 39712, 64823"), true);
        assertEquals(rubrica.numEl(), 2);
		assertEquals(rubrica.aggiungi("Fermi", "einriko99@bomb.it", "11010"), true);
        assertEquals(rubrica.numEl(), 3);
		assertEquals(rubrica.aggiungi("Archimedes", "arkiarki@magna.gr", "38947, 08008"), false); // rubrica piena
        assertEquals(rubrica.numEl(), 3);
	}

	@Test
	public void testAggiungi() {
		// test prepara()
	}

	@Test
	public void testRicerca() {
		assertEquals(rubrica.cercaPerNome("Archi").size(), 0);
        assertEquals(rubrica.cercaPerNome("Tesla").size(), 1);
		assertEquals(rubrica.cercaPerMail("ein").size(), 2);
		assertEquals(rubrica.cercaPerMail("nyk").size(), 1);
		assertEquals(rubrica.cercaPerMail("ark").size(), 0);
		assertEquals(rubrica.cercaPerNome("").size(), 3);
		assertEquals(rubrica.cercaPerMail("").size(), 3);
	}

	@Test
	public void testElimina() {
		assertFalse(rubrica.eliminaPerNome("Neum"));
		assertEquals(rubrica.numEl(), 3);
		assertTrue(rubrica.eliminaPerNome("Fer"));
		assertEquals(rubrica.numEl(), 2);
		assertFalse(rubrica.eliminaPerMail("einriko"));
		assertEquals(rubrica.numEl(), 2);
		assertTrue(rubrica.eliminaPerMail(""));
		assertEquals(rubrica.numEl(), 0);
		assertFalse(rubrica.eliminaPerNome(""));
		assertEquals(rubrica.numEl(), 0);
	}
	
	@Test
	public void testToString() {
		assertEquals(rubrica.toString(), "Lavoro:[Tesla; nykolajj@beograd.srb; 12345, 67891, 98765, 43219, Einstein; einst.albertush@rel.us; 75391, 39712, 64823, Fermi; einriko99@bomb.it; 11010]");
	}
}
