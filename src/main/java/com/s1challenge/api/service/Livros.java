package com.s1challenge.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.s1challenge.api.comparator.AutorComparator;
import com.s1challenge.api.comparator.LivroComparator;
import com.s1challenge.api.comparator.TituloComparator;
import com.s1challenge.api.exception.EmptySortingRulesException;
import com.s1challenge.api.exception.OrderingException;
import com.s1challenge.api.model.Livro;
import com.s1challenge.api.model.Ordem;

public class Livros {
	List<Livro> livros;
	
	public Livros() {
		this.livros = new ArrayList<>();
	}
	
	public Livros(List<Long> ids, List<String> titulos, List<String> autores, List<String> anosEdicoes) {
		livros = new ArrayList<>();
		
		for(int i = 0; i < ids.size(); i++) {
			Livro livro = new Livro();
			
			livro.setId(ids.get(i));
			livro.setTitulo(titulos.get(i));
			livro.setAutor(autores.get(i));
			livro.setAnoEdicao(anosEdicoes.get(i));
			
			livros.add(livro);
		}
	}
	
	public List<Livro> getLivros() {
		return this.livros;
	}
	
	public void ordernar(List<String> regrasOrdenacao) throws OrderingException, EmptySortingRulesException {
		int vazios = 0;
		List<Comparator<Livro>> comparators = new ArrayList<>();
		for(String regra : regrasOrdenacao) {
			if(regra == null) {
				throw new OrderingException();
				
			}else {
				switch(regra) {
				case "vazio" : vazios++; break;
				
				case "tAsc" : comparators.add(new TituloComparator(Ordem.ASCENDENTE)); break;
				case "tDesc" : comparators.add(new TituloComparator(Ordem.DESCENDENTE)); break;
				
				case "aAsc" : comparators.add(new AutorComparator(Ordem.ASCENDENTE)); break;
				case "aDesc" : comparators.add(new AutorComparator(Ordem.DESCENDENTE)); break;	
				}
				
				Collections.sort(livros, new LivroComparator(comparators));
			}
		}
		
		if(vazios >= 3) {
			throw new EmptySortingRulesException();
		}
	}
}
