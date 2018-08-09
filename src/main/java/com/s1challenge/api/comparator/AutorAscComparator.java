package com.s1challenge.api.comparator;

import java.util.Comparator;

import com.s1challenge.api.model.Livro;

public class AutorAscComparator implements Comparator<Livro> {
	
	public int compare(Livro l1, Livro l2) {
        String autorL1 = ((Livro) l1).getAutor();
        String autorL2 = ((Livro) l2).getAutor();
        
        return autorL1.compareTo(autorL2);
	}
}
