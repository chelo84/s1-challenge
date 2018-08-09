package com.s1challenge.api.comparator;

import java.util.Comparator;
import com.s1challenge.api.model.Livro;

public class TituloDescComparator implements Comparator<Livro> {

	public int compare(Livro l1, Livro l2) {
        String tituloL1 = ((Livro) l1).getTitulo();
        String tituloL2 = ((Livro) l2).getTitulo();
        
        return tituloL2.compareTo(tituloL1);
	}
}
