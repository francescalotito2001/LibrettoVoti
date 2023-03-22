package it.polito.tdp.libretto.model;

import java.time.LocalDate;
import java.util.Collections;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libretto lib= new Libretto();
		lib.add(new Voto("Analisi 1", 28, LocalDate.of(2022, 8, 9)));
		lib.add(new Voto("Informatica", 25, LocalDate.of(2023, 10, 29)));
		lib.add(new Voto("Analisi 2", 29, LocalDate.of(2023, 10, 29)));
		lib.add(new Voto("Fisica 1", 23, LocalDate.of(2022, 7, 19)));
		lib.add(new Voto("Fisica 2", 18, LocalDate.of(2023, 11, 7)));
		lib.stampa();
		
		//cerco voti nella lista uguali a 25
		System.out.println("\nIl voto cercato 25 è: ");
		lib.stampaVotoCercato(25);
		
		Voto v = lib.ricercaVotoPerNome("Analisi 1");
		System.out.println("\nI voti di Analisi 1 sono: \n" + v);
		
		Voto a1bis = new Voto("Analisi 1", 28, LocalDate.of(2022, 8, 9));
		try{
			lib.add(a1bis);
		}catch (IllegalArgumentException e) {
			System.out.println("Errore nell'iserimento del voto.");
			System.out.println(e.getMessage());
			
		}
			Voto a1ter = new Voto("Analisi 1", 26, LocalDate.of(2022, 8, 9));
		
		
		//PUNTO SETTE
		System.out.println("\nIl libretto originale è:");
		lib.stampa();
		System.out.println("\nIl libretto migliorato è:");
		lib.librettoMigliorato().stampa();
		
		//PUNTO OTTO
		System.out.println("\nLibretto in ordine alfabetico:");
		lib.librettoOrdinatoAlfabatico().stampa();
		System.out.println("\nLibretto in ordine numerico:");
		lib.librettoOrdinatoNumerico().stampa();

		
		//PUNTO NOVE
		System.out.println("\nIl libretto con numeri inferiori a 24 cancellati: ");
		lib.cancellaVoti(24);
		lib.stampa();
	
	}

}
