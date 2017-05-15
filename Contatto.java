package rubrica;

import java.util.ArrayList;
/**
 * La classe contiene il campo name con cui viene salvato il contato, il campo eMail dove contiene una eMail del contatto
 * e contiene il campo telNum dove sono salvati tutti i numeri di telefono.
 * La classe si occupa di mantenere lo stato del contatto aggiungendo e rimuovendo numeri di telefono, sostituendo la eMail.
 * 
 * @author Jacar
 */
public class Contatto {
	public final String name;
	private String eMail;
	private ArrayList<String> telNums;
	
	/**
	 * Costruttore del oggetto Contatto.
	 * 
	 * @param name � il nome con cui viene salvato il contatto
	 * @param eMail � l'indirizzo email
	 * @param telNums � la ArrayList dei numeri di telefono
	 */
	public Contatto(String name, String eMail, String telNums){
		this.name = name;
		this.eMail = eMail;
		this.telNums = new ArrayList<String>();
		String[] Nums = telNums.split(", ");
		for (String temp : Nums){
			this.telNums.add(temp);
		}
	}
	/**
	 * Fornisce la email del contatto.
	 * 
	 * @return la email del contato sottoforma di stringa
	 */
	public String getEMail(){
		return eMail;
	}
	
	/**
	 * Imposta la email del contatto con la stringa fornita.
	 * 
	 * @param eMail stringa da inseire nel campo email 
	 * @return valore booleano per indicare se l'operazione � andata a buon fine
	 */
	public boolean setEMail(String eMail){
		if (eMail != null && eMail.matches(".*@.*\\..*")) {
			this.eMail = eMail;
			return true;
		}
		return false;
	}
	
	/**
	 * Aggiunge alla lista dei numeri di telefono del contatto il numero fornito.
	 *  
	 * @param telNum � il numero da inserire 
	 * @return valore booleano per indicare se l'operazione � andata a buon fine
	 */
	public boolean addTelNum(String telNum){
		if (telNum != null && telNum.matches("[0-9]+") && !telNums.contains(telNum))
			return this.telNums.add(telNum);
		return false;
	}
	
	/**
	 * Rimuove dalla lista dei numeri di telefono del contatto il numero fornito.
	 *  
	 * @param telNum � il numero da rimuovere 
	 * @return valore booleano per indicare se l'operazione � andata a buon fine
	 */
	public boolean delTelNum(String telNum){
       return this.telNums.remove(telNum);
    }
         
	/**
	 * Fornisce una stringa con il primo numero di telefono.
	 *  
	 * @return la stringa del primo numero di telefono
	 */
	public String getTelNums(){
		String temp = telNums.toString();
		return temp.substring(1, temp.length()-1);
	}
	
	/**
	 * Fornisce una stringa con nome, email e telefono.
	 * 
	 * @return i valori di name, eMail, e il primo numero di telefono sottoforma di stringa
	 */
	public String toString(){
		return name + "; " + eMail + "; " + getTelNums();
	}
}