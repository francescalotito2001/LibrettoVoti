package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {

	private String nomeCorso;
	private int votoEsame;
	private LocalDate dataEsame;
	public Voto(String nomeCorso, int votoEsame, LocalDate dataEsame) {
		super();
		this.nomeCorso = nomeCorso;
		this.votoEsame = votoEsame;
		this.dataEsame = dataEsame;
	}
	
	
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public int getVotoEsame() {
		return votoEsame;
	}
	public void setVotoEsame(int votoEsame) {
		this.votoEsame = votoEsame;
	}
	public LocalDate getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	@Override
	public String toString() {
		return this.nomeCorso+": " + this.votoEsame+ " sostenuto il " + this.dataEsame;
	}
	
	public boolean isDuplicato(Voto altro) {
		return this.getVotoEsame() == altro.getVotoEsame() && this.getNomeCorso().equals(altro.getNomeCorso());
			
	}
	public boolean isConflitto(Voto altro) {
		return this.getVotoEsame() != altro.getVotoEsame() && this.getNomeCorso().equals(altro.getNomeCorso());
		
	}
	
	public void votoMigliorato(Voto votoOriginale) {
		int voto = votoOriginale.getVotoEsame();
		if(votoOriginale.getVotoEsame() >= 18 && votoOriginale.getVotoEsame() <=23 || voto ==29) {
			votoOriginale.setVotoEsame(voto + 1);
		}
		else if(voto >= 24 && voto <= 28) {
			votoOriginale.setVotoEsame(voto+2);
		}
	}
	
	public Voto clone() {
		return new Voto(this.getNomeCorso(), this.getVotoEsame(), this.getDataEsame());
	}
	
	
}
