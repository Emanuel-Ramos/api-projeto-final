package org.serratec.dto.categoria;

import org.serratec.model.Categoria;

public class CategoriaDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	
}
