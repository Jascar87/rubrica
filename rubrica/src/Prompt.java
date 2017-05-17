import java.util.ArrayList;

import jbook.util.Input;

public class Prompt {
	
	private static final String listaComandi = "\nLista dei comandi:\nc -- Crea una rubrica  (nome della rubrica e max dimensione)\nd -- Cancella una rubrica (nome della rubrica da cancellare)\na -- Aggiungi alla rubrica (nome della rubrica e contato da aggiungere)\nt -- Cerca nella rubrica per nome (nome della rubrica e prefisso stringa da cercare)\ny -- Cerca nella rubrica per email (nome della rubrica e prefisso stringa da cercare)\nr -- Rimuovi dalla rubrica per nome(nome della rubrica e prefisso stringa da cancellare)\nf -- Rimuovi dalla rubrica per email(nome della rubrica e prefisso stringa da cancellare)\ns -- Stampa tutta la rubrica (nome della rubrica da stampare)\ne -- Esci\n";
	
	public static void main(String[] args) {
		
		while(true) {
			char scelta = sceltaComando();
			switch (scelta) {
			case 'h' :
				System.out.println(listaComandi);
				break;
			case 'c' :
				creaRubrica();
				break;
			case 'd' :
				eliminaRubrica();
				break;
			case 'a' :
				aggiungi();
				break;
			case 't' :
				cercaInRubricaPerNome();
				break;
			case 'y' :
				cercaInRubricaPerEMail();
				break;
			case 'r' :
				rimuoviInRubricaPerNome();
				break;
			case 'f' :
				rimuoviInRubricaPerEMail();
				break;
			case 's' :
				stampaRubrica();
				break;
			case 'e' :
				System.out.println("\nEsci\n");
				return;
			default :
				System.out.println("\n" + scelta + " non � un comando valido.");
				break;
			}
		}
	}

	private static void creaRubrica() {
		System.out.println("\n\tCrea una rubrica\n");
		String nome = sceltaNomeRubrica();
		int maxDim = Input.readInt("\tInserire la dimensione massima della rubrica " + nome + ": ");
		int fineOperazione = GestioneRubriche.creaRubrica(nome, maxDim);
		if(fineOperazione != 1) {
			System.out.println("\tCrezione annullata, la rubrica " + nome + " e' gia presente\n");
		}
	}
	
	private static void eliminaRubrica() {
		System.out.println("\n\tCancella una rubrica\n");
		String nome = sceltaNomeRubrica();
		int fineOperazione = GestioneRubriche.cancellaRubrica(nome);
		if(fineOperazione != 1) {
			System.out.println("\tCancellazione annullata, la rubrica " + nome + " non esiste\n");
		}
	}
	
	private static void aggiungi() {
		System.out.println("\n\tAggiungi un contatto alla rubrica\n");
		String nome = sceltaNomeRubrica();
		int fineOperazione = GestioneRubriche.aggiungiInRubrica(nome, Input.readString("\tInserire nome, email e numero di telefono in questo formato -> nome,email,tel" + ": "));
		if(fineOperazione != 1) {
			if(GestioneRubriche.toString(nome) == null) {
				System.out.println("\tAggiunta annullata, la rubrica " + nome + " non esiste\n");
			}
			else {
				System.out.println("\tAggiunta annullata, la rubrica " + nome + " � piena\n");
			}
		}
		
	}
	
	private static void cercaInRubricaPerNome() {
		System.out.println("\n\tCerca nella rubrica\n");
		String nome = sceltaNomeRubrica();
		ArrayList<Contatto> trovati = GestioneRubriche.cercaInRubricaPerNome(nome, Input.readString("\tInserire la voce da cercare nella rubrica " + nome + ": "));
		if(trovati == null) {
			if(GestioneRubriche.toString(nome) == null) {
				System.out.println("\tLa rubrica " + nome + " non esiste\n");
			}
			else {
				System.out.println("\tLa voce cercata non e' presente nella rubrica " + nome + "\n");
			}
		}
		else {
			System.out.println(trovati.toString());
		}
	}
	
	private static void cercaInRubricaPerEMail() {
		System.out.println("\n\tCerca nella rubrica\n");
		String nome = sceltaNomeRubrica();
		ArrayList<Contatto> trovati = GestioneRubriche.cercaInRubricaPerEMail(nome, Input.readString("\tInserire la voce da cercare nella rubrica " + nome + ": "));
		if(trovati == null) {
			if(GestioneRubriche.toString(nome) == null) {
				System.out.println("\tLa rubrica " + nome + " non esiste\n");
			}
			else {
				System.out.println("\tLa voce cercata non e' presente nella rubrica " + nome + "\n");
			}
		}
		else {
			System.out.println(trovati.toString());
		}
	}
	
	private static void rimuoviInRubricaPerNome() {
		System.out.println("\n\tRimuovi dalla rubrica rubrica\n");
		String nome = sceltaNomeRubrica();
		boolean rimossi = GestioneRubriche.cancellaInRubricaPerNome(nome,Input.readString("\tInserire la voce da cercare ed eliminare dalla rubrica " + nome + ": "));
		if (!rimossi) {
			System.out.println("\tLa rubrica " + nome + " o la voce cercata non � presente\n");
		}
	}
	
	private static void rimuoviInRubricaPerEMail() {
		System.out.println("\n\tRimuovi dalla rubrica rubrica\n");
		String nome = sceltaNomeRubrica();
		boolean rimossi = GestioneRubriche.cancellaInRubricaPerEMail(nome,Input.readString("\tInserire la voce da cercare ed eliminare dalla rubrica " + nome + ": "));
		if (!rimossi) {
			System.out.println("\tLa rubrica " + nome + " o la voce cercata non � presente\n");
		}
	}
	
	private static void stampaRubrica() {
		System.out.println("\n\tStampa tutta la rubrica\n");
		String nome = sceltaNomeRubrica();
		String stampato = GestioneRubriche.toString(nome);
		if(stampato == null) {
			System.out.println("\tLa rubrica " + nome + " non � presente\n");
		}
		else if (stampato.length() == 0){
			System.out.println("\tLa rubrica " + nome + " � vuota\n");
		}
		else {
			System.out.println(stampato);
		}
		
	}
	
	private static String sceltaNomeRubrica() {
		String nome = "";
		do {
			nome = Input.readString("\tInserire il nome della rubrica desiderata: ");
		}
		while (nome.isEmpty());
		return nome;
	}

	private static char sceltaComando() {
		return Input.readChar("\nInserire un comando(h per la lista comandi) : ");
	}

}
