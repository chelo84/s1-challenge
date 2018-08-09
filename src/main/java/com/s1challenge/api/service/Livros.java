package com.s1challenge.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.s1challenge.api.comparator.AutorAscComparator;
import com.s1challenge.api.comparator.AutorDescComparator;
import com.s1challenge.api.comparator.LivroComparator;
import com.s1challenge.api.comparator.TituloAscComparator;
import com.s1challenge.api.comparator.TituloDescComparator;
import com.s1challenge.api.exception.EmptySortingRulesException;
import com.s1challenge.api.exception.OrderingException;
import com.s1challenge.api.model.Livro;

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
				case "tAsc" : comparators.add(new TituloAscComparator()); break;
				case "tDesc" : comparators.add(new TituloDescComparator()); break;
				case "aAsc" : comparators.add(new AutorAscComparator()); break;
				case "aDesc" : comparators.add(new AutorDescComparator()); break;				
				}
				
				Collections.sort(livros, new LivroComparator(comparators));
			}
		}
		
		if(vazios >= 3) {
			throw new EmptySortingRulesException();
		}
	}
}
