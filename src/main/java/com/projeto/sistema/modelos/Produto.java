package com.projeto.sistema.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String autor;
	private String editora;
	private String codigoBarras;
	private String unidadeMedida;
	private Double numeroPaginas = 0.00;	
	private Double estoque = 0.00;
	private Double precoCusto = 0.00;
	private Double precoVenda = 0.00;
	private Double lucro = 0.00;
	private Double margemLucro = 0.00;
	
	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Double getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Double numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Double getEstoque() {
		return estoque;
	}

	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getLucro() {
		return lucro;
	}

	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}

	public Double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(Double margemLucro) {
		this.margemLucro = margemLucro;
	}

	// Métodos de Cálculo Automático
	public void calcularLucro() {
		if (precoVenda != null && precoCusto != null) {
			this.lucro = precoVenda - precoCusto;
		}
	}

	public void calcularMargemLucro() {
		if (precoCusto != null && precoCusto > 0) {
			this.margemLucro = (lucro / precoCusto) * 100;
		}
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", autor=" + autor + ", editora=" + editora 
				+ ", codigoBarras=" + codigoBarras + ", unidadeMedida=" + unidadeMedida 
				+ ", numeroPaginas=" + numeroPaginas + ", estoque=" + estoque + ", precoCusto=" 
				+ precoCusto + ", precoVenda=" + precoVenda + ", lucro=" + lucro 
				+ ", margemLucro=" + margemLucro + "]";
	}
}
