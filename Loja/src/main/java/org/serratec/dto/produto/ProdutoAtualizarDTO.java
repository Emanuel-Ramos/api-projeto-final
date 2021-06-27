package org.serratec.dto.produto;

public class ProdutoAtualizarDTO {

	private String codigo;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer estoque;
	private String imagem;
	private Long categoria;
	
	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public String getImagem() {
		return imagem;
	}
	public Long getCategoria() {
		return categoria;
	}
	
}
