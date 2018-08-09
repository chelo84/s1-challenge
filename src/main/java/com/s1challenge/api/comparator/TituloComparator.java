package com.s1challenge.api.comparator;

import java.util.Comparator;

import com.s1challenge.api.model.Livro;
import com.s1challenge.api.model.Ordem;

public class TituloComparator implements Comparator<Livro> {
	private Ordem ordem;
	
	public TituloComparator(Ordem ordem) {
		this.ordem = ordem;
	}
	
	public int compare(Livro l1, Livro l2) {
		String tituloL1 = ((Livro) l1).getTitulo();
		String tituloL2 = ((Livro) l2).getTitulo();
		
		switch(ordem) {
		case ASCENDENTE: return tituloL1.compareTo(tituloL2);
		case DESCENDENTE: return tituloL2.compareTo(tituloL1);
		default: return 0;
		}
	}
}
