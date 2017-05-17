import java.util.ArrayList;
import java.util.Arrays;

public class Contatto {

	public String name;
	private String eMail;
	private ArrayList<String> telNums;
	
	public Contatto (String name, String eMail, String telNums) throws FormatException {
		if(name == null || name.isEmpty()) {
			throw new FormatException("Nome non valido");
		}
		else if(eMail == null || eMail.isEmpty()) {
			throw new FormatException("Email non valida");
		}
		if(telNums == null || telNums.isEmpty()) {
			throw new FormatException("Numeri di telefono non validi");
		}
		this.name = name;
		this.eMail = eMail;
		this.telNums = new ArrayList<String>(Arrays.asList(telNums.split(",")));
	}
	
	public String getEMail() {
		return this.eMail;
	}
	
	public void setEMail(String eMail) throws FormatException {
		if (eMail == null || eMail.isEmpty()) {
			throw new FormatException("Email non valida");
		}
		this.eMail = eMail;
	}
	
	public void addTelNum(String telNum) throws FormatException {
		if(telNums == null || telNum.isEmpty()) {
			throw new FormatException("Numero di telefono non valido");
		}
		this.telNums.add(telNum);
	}
	
	public void delTelNum(String telNum) throws FormatException {
		
		if(!this.telNums.remove(telNum)) {
			throw new FormatException("Numero di telefono non valido");
		}
	}
	
	public String getTelNums() {
		String string = this.telNums.toString();
		string = string.substring(1, string.length()-1);
		return string;
	}
	
	@Override
	public String toString() {
		return (this.name + "; " + this.eMail + "; " + this.getTelNums());
	}
}
