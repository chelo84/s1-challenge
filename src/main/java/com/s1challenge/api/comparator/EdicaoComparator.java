package com.s1challenge.api.comparator;

import java.util.Comparator;

import com.s1challenge.api.model.Livro;
import com.s1challenge.api.model.Ordem;

public class EdicaoComparator implements Comparator<Livro> {
	private Ordem ordem;
	
	public EdicaoComparator(Ordem ordem) {
		this.ordem = ordem;
	}
	
	public int compare(Livro l1, Livro l2) {
		String anoEdicaoL1 = ((Livro) l1).getAnoEdicao();
		String anoEdicaoL2 = ((Livro) l2).getAnoEdicao();
		
		switch(ordem) {
		case ASCENDENTE: return anoEdicaoL1.compareTo(anoEdicaoL2);
		case DESCENDENTE: return anoEdicaoL2.compareTo(anoEdicaoL1);
		default: return 0;
		}
	}
}
