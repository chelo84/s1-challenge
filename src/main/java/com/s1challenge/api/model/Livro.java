package com.s1challenge.api.model;

public class Livro {
	private Long id;
	private String titulo;
	private String autor;
	private String anoEdicao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAnoEdicao() {
		return anoEdicao;
	}
	public void setAnoEdicao(String anoEdicao) {
		this.anoEdicao = anoEdicao;
	}
}
