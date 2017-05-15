import java.util.ArrayList;

public class Rubrica {
	
	private ArrayList<Contatto> contacts;
	private final int maxDim;
	private final String name;

	
	
	public Rubrica(String name, int dim) {
		this.name = name;
		this.maxDim = dim;
		if(!this.name.isEmpty()){
			this.contacts = new ArrayList<Contatto>();
		}
	}
	
	public int numEl() {
		return this.contacts.size();
	}

	public int aggiungi(String name, String email, String telNums) throws FormatException {
		if(contacts.size() < maxDim && !name.isEmpty() && !email.isEmpty() && !telNums.isEmpty()){
			this.contacts.add(new Contatto(name,email,telNums));
			return 1;
		}
		else if(name.isEmpty() || email.isEmpty() || telNums.isEmpty()) {
			return 0;
		}
		else 
			return -1;	
	}

	public ArrayList<Contatto> cercaPerNome(String name) {
		ArrayList<Contatto> trovati = new ArrayList<Contatto>();
		for (final Contatto el : contacts) {
			if(el.name.contains(name)) {
			trovati.add(el);
			}
		}
		return trovati;
	}
	
	public ArrayList<Contatto> cercaPerEMail(String eMail) {
		ArrayList<Contatto> trovati = new ArrayList<Contatto>();
		for (final Contatto el : contacts) {
			if(el.getEMail().contains(eMail)) {
			trovati.add(el);
			}
		}
		return trovati;
	}

	public void eliminaPerNome(String string) {
		contacts.removeAll(cercaPerNome(string));
	}
	
	public void eliminaPerEMail(String string) {
		contacts.removeAll(cercaPerEMail(string));
	}
	
	@Override
	public String toString() {
		String string = this.contacts.toString();
		string = string.substring(1, string.length()-1);
		return string;
	}

}
