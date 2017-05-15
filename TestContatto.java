import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestContatto {

	Contatto contattoTest;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testCreazione() throws FormatException {
		exception.expect(FormatException.class);
		exception.expectMessage("Nome non valido");
		contattoTest = new Contatto("","eMailtest","1234,2468,1357");
		
	}
	
	@Test
	public void testSetGetEMail() throws FormatException {
		contattoTest = new Contatto("nomeTest","eMailtest","1234,2468,1357");
		assertEquals(contattoTest.getEMail(), "eMailtest");
		exception.expect(FormatException.class);
		exception.expectMessage("Email non valida");
		contattoTest.setEMail("");
//		assertEquals(contattoTest.getEMail(), "eMailTest");
	}
	
	@Test
	public void testSetGetTelNum() throws FormatException {
		contattoTest = new Contatto("nomeTest","eMailtest","1234,2468,1357");
		exception.expect(FormatException.class);
		exception.expectMessage("Numero di telefono non valido");
		contattoTest.addTelNum("");
		
	}
	
	@Test
	public void testDelNum() throws FormatException {
		contattoTest = new Contatto("nomeTest","eMailtest","1234,2468,1357");
		exception.expect(FormatException.class);
		exception.expectMessage("Numero di telefono non valido");
		contattoTest.delTelNum("");
	}
	
	@Test
	public void testToString() throws FormatException {
		contattoTest = new Contatto("nomeTest","eMailtest","1234,2468,1357");
		assertEquals(contattoTest.toString(),"nomeTest; eMailtest; 1234, 2468, 1357");
	}

}
