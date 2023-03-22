package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatoreLibrettoAlfa implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Voto v1 = (Voto) o1;
		Voto v2 = (Voto) o2;
		return v1.getNomeCorso().compareTo(v2.getNomeCorso());
	}

}
