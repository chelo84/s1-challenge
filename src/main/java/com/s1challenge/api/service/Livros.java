package com.s1challenge.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
			
			System.err.println(livro.getId());
			
			livros.add(livro);
		}
	}
	
	public List<Livro> getLivros() {
		return this.livros;
	}
}
