package rubrica;

import java.util.ArrayList;
/**
 * La classe si occupa di gestire le rubriche con il loro nome e gli oggetti contatto con cui sono associati.
 * Si occupa di aggiungere, rimuovere e visionare i contatti.
 * Fornisce anche funzioni per monitorare la dimensione della rubrica e metodi di conversione a stringa.
 * 
 * @author Jacar
 */
public class RubricaContatti {
    private ArrayList<Contatto> contacts;
    public final int maxDim;
    public final String title;
  /**
   * Crea una istanza del oggetto RubricaContatti.
   * 
   * @param title è il nome della rubrica
   * @param maxDim è il numero massimo di contatti che può contenere la rubrica
   */
    public RubricaContatti(String title, int maxDim) {
        contacts = new ArrayList<Contatto>();
        this.maxDim = maxDim;
        this.title = title;
    }
   /**
    *  Creare un contatto ed aggiungero alla rubrica.
    *  
    * @param name è il nome del contatto da creare
    * @param eMail è la email del contatto da creare
    * @param telNums è il numerio di telefono del contato da creare
    * @return aggiunge un ogetto di tipo contatto alla rubrica
    */
    public boolean aggiungi(String name, String eMail, String telNums) {
        if (contacts.size() >= maxDim) return false;
        if (name == null || name == "" || eMail == null || !eMail.matches(".*@.*\\..*"))
        	return false;
        return contacts.add(new Contatto(name, eMail, telNums));
    }
    
    /**
     * Cerca i contatti con il nome che contengano alla stringa passata alla funzione, se ne trova li restituisce.
     * 
     * @param s è la stringa da cercare fra i nomi dei contatti
     * @return la lista di tutti i contatti che soddisfano la ricerca
     */
    public ArrayList<Contatto> cercaPerNome(String s) {
        ArrayList<Contatto> r = new ArrayList<Contatto>();
        for (Contatto contatto : contacts)
            if (contatto.name.startsWith(s))
                r.add(contatto);
        return r;
    }
    
    /**
     * Cerca i contatti con la email che contenga la stringa passata alla funzione, se ne trova li restituisce.
     * 
     * @param s è la stringa da confrontare
     * @return la lista di tutti i contatti che soddisfano la ricerca
     */
    public ArrayList<Contatto> cercaPerMail(String s) {
        ArrayList<Contatto> r = new ArrayList<Contatto>();
        for (Contatto contatto : contacts)
            if (contatto.getEMail().startsWith(s) )
                r.add(contatto);
        return r;
    }
	/**
	 * Rimuovi tutti i contatti che abbiano il nome che contenga la stringa fornita in ingresso.
	 * 
	 * @param s è la stringa da confrontare con il nome dei contatti
	 * @return rimuove gli oggetti che soddisfano la ricerca
	 */
    public boolean eliminaPerNome(String s) {
        return contacts.removeAll(cercaPerNome(s));
    }
    
    /**
     *Rimuovi tutti i contatti che abbiano la email che contenga la stringa fornita in ingresso.
	 * 
	 * @param s è la stringa da confrontare con il nome dei contatti
	 * @return rimuove gli oggetti che soddisfano la ricerca
     */
    public boolean eliminaPerMail(String s) {
        return contacts.removeAll(cercaPerMail(s));
    }
    /**
     * Fornisce il numero di contatti salvati.
     * 
     * @return il numero di elementi
     */
    public int numEl() {
        return contacts.size();
    }
    
    /**
     * Trasforma in stringa il nome della rubrica e tutti i suoi contatti.
     * 
     * @return restituisce una stringa con il nome della rubrica e ogni istanza di contatti
     */
    public String toString() {
    	return title + ":" + contacts.toString();
    }
}
