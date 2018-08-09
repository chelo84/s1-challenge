package com.s1challenge.api.comparator;

import java.util.Comparator;

import com.s1challenge.api.model.Livro;
import com.s1challenge.api.model.Ordem;

public class AutorComparator implements Comparator<Livro> {
	private Ordem ordem;
	
	public AutorComparator(Ordem ordem) {
		this.ordem = ordem;
	}
	
	public int compare(Livro l1, Livro l2) {
		String autorL1 = ((Livro) l1).getAutor();
		String autorL2 = ((Livro) l2).getAutor();
		
		switch(ordem) {
		case ASCENDENTE: return autorL1.compareTo(autorL2);
		case DESCENDENTE: return autorL2.compareTo(autorL1);
		default: return 0;
		}
	}
}