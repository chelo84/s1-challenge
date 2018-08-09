package com.s1challenge.api.comparator;

import java.util.Comparator;
import java.util.List;

import com.s1challenge.api.model.Livro;

public class LivroComparator implements Comparator<Livro> {
    private List<Comparator<Livro>> comparators;

    public LivroComparator(List<Comparator<Livro>> comparators) {
        this.comparators = comparators;
    }
	
	public int compare(Livro l1, Livro l2) {
        for (Comparator<Livro> comparator : comparators) {
            int comparacao = comparator.compare(l1, l2);
            if (comparacao != 0) {
            	return comparacao;
            }
        }
        return 0;
	}
}
