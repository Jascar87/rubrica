import java.util.ArrayList;
import java.util.HashMap;

public class GestioneRubriche {

	private static HashMap<String, Rubrica> rubriche = new HashMap<String, Rubrica>();
	
	public static int creaRubrica(String nome, int maxDim) {
		Rubrica nuovaRubrica = new Rubrica(nome, maxDim);
		if(rubriche.get(nome) != null) {
			return -1;
		}
		rubriche.put(nome, nuovaRubrica);
		return 1;
	}

	public static int cancellaRubrica(String nome) {
		if(rubriche.remove(nome) != null) {
			return 1;
		}
		return -1;
	}

	public static int aggiungiInRubrica(String nome, String newEl) throws FormatException {
		if(rubriche.get(nome) != null) {
			String[] contatto = newEl.split(",");
			return rubriche.get(nome).aggiungi(contatto[0], contatto[1], contatto[2]);
		}
		return -1;
	}

	public static ArrayList<Contatto> cercaInRubricaPerNome(String nome, String el) {
		if (rubriche.get(nome) != null) {
			return rubriche.get(nome).cercaPerNome(el);
		}
		return null;
	}
	
	public static ArrayList<Contatto> cercaInRubricaPerEMail(String nome, String el) {
		if (rubriche.get(nome) != null) {
			return rubriche.get(nome).cercaPerEMail(el);
		}
		return null;
	}

	public static boolean cancellaInRubricaPerNome(String nome, String el) {
		if (rubriche.get(nome) != null) {
			rubriche.get(nome).eliminaPerNome(el);
			return true;
		}
		return false;
	}
	
	public static boolean cancellaInRubricaPerEMail(String nome, String el) {
		if (rubriche.get(nome) != null) {
			rubriche.get(nome).eliminaPerEMail(el);
			return true;
		}
		return false;
	}

	public static String toString(String nome) {
		if (rubriche.get(nome) != null) {
			return rubriche.get(nome).toString();
		}
		return null;
	}
}
