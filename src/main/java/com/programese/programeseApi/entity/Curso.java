package com.programese.programeseApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100)
	@Size(max = 255, message = "Número de caracteres não permitido")
	@NotEmpty(message = "O campo deve ser preenchido")
	private String nome;
	
	@Column(length = 100)
	@Size(max = 500, message = "Número de caracteres não permitido")
	@NotEmpty(message = "O campo deve ser preenchido")
	private String descricao;
	
	@Column(length = 100)
	@Size(max = 10, message = "Número de caracteres não permitido")
	@NotEmpty(message = "O campo deve ser preenchido")
	private String duracao;
	
	@Column(length = 1000)
	@NotEmpty(message = "O campo deve ser preenchido")
	private String urlImagem;
	
	private float preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
