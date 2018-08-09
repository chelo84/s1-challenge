package com.s1challenge.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.s1challenge.api.comparator.TituloComparator;
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
	
	public void ordernar(List<String> regrasOrdenacao) throws OrderingException {
		for(String regra : regrasOrdenacao) {
			if(regra == null) {
				throw new OrderingException();
			}else {
				switch(regra) {
				case "tAsc" : Collections.sort(livros, new TituloComparator()); break;
				case "tDesc" : Collections.sort(livros, new TituloComparator().reversed()); break;
				}
			}
		}
	}
}
