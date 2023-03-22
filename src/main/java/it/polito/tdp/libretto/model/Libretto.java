package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.libretto.db.VotoDAO;

public class Libretto {

	private List<Voto> listaVoti;

	public Libretto() {
		VotoDAO dao = new VotoDAO();
		this.listaVoti = dao.listaVotiMetodo(); //this.listaVoti = new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		
		if(esisteEsame(v) == true) {
			System.out.println("Il voto che si è cercato di aggiungere è lo stesso esame ma ha voto diverso.");	
			throw new IllegalArgumentException("Il voto è errato: " + v);
		}
		else if(esisteVoto(v)== true) {
			System.out.println("Il voto che si è cercato di aggiungere è già presente.");	
			throw new IllegalArgumentException("Il voto è errato: " + v);
		}
		else {
			this.listaVoti.add(v);
			}
		
		VotoDAO dao = new VotoDAO();
		dao.createVoto(v);
	}
	
	public void stampa() {
		for(Voto v : this.listaVoti) {
			System.out.println(v);
		}
	}
	
	/**
	 * Stampa tutti i voti uguali al parametro cercato
	 * @param votoDaTrovare
	 */
	
	public void stampaVotoCercato(int votoDaTrovare) {
		for(Voto v : this.listaVoti) {
			if(v.getVotoEsame() == votoDaTrovare) {
				System.out.println(v);
			}
		}
	}
	
	public Voto ricercaVotoPerNome(String nomeCorso) {
		//Voto voto = null;
		for(Voto v: this.listaVoti) {
			if(v.getNomeCorso().compareTo(nomeCorso)==0) {	//equals restituisce T o F 
				return v;									// compareTo presuppone che i due oggetti siano comparabili
			}
		}
		//return voto;
		
		throw new RuntimeException("Voto non trovato!");
	}
	
	public boolean esisteVoto(Voto daAggiungere) {
		for(Voto v: this.listaVoti) {
			if(v.isDuplicato(daAggiungere) ) {
				return true;
			}
		}
		return false;
	}

	
	public boolean esisteEsame(Voto daAggiungere) {
		for(Voto v: this.listaVoti) {
			if(v.isConflitto(daAggiungere) ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo FACTORY per creare un nuovo libretto
	 * con valori migliorati.
	 * @return
	 */
	
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		migliore.listaVoti = new ArrayList<Voto>();	//lista separata
		for(Voto voto: this.listaVoti) {
			migliore.listaVoti.add(voto.clone());
		}
		for(Voto v : migliore.listaVoti) {
			v.votoMigliorato(v);
			
		}
		
		return migliore;
	}
	
	public Libretto librettoOrdinatoAlfabatico() {
		Libretto ordinatoAlfa = new Libretto();
		ordinatoAlfa.listaVoti = new ArrayList(this.listaVoti);
		Collections.sort(ordinatoAlfa.listaVoti, new ComparatoreLibrettoAlfa());
		return ordinatoAlfa;
	}
	
	public Libretto librettoOrdinatoNumerico() {
		Libretto ordinatoDigit = new Libretto();
		ordinatoDigit.listaVoti = new ArrayList(this.listaVoti);
		Collections.sort(ordinatoDigit.listaVoti, new ComparatoreLibrettoDigit());
		return ordinatoDigit;
	}
	
	/**
	 * Cancella i voi inferiori a quelli inseriti
	 * @param voto
	 */
	//non si modifica mai la lista su cui si sta iterando
	
	public void cancellaVoti(int voto) {
		ArrayList<Voto> copiaListaVoti = new ArrayList<Voto>(this.listaVoti);
		for(Voto v: copiaListaVoti) {
			if(v.getVotoEsame() < voto) {
				this.listaVoti.remove(v);
			}
		}
	}

	@Override
	public String toString() {
		String txt = "";
		for (Voto v: this.listaVoti) {
			txt = txt + v.toString() + "\n";
			
		}
		return txt;
	}
	
	
	
}
