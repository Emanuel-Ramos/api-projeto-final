package org.serratec.dto.carrinho;

import java.util.ArrayList;
import java.util.List;

import org.serratec.model.Carrinho;
import org.serratec.model.CarrinhoProduto;

public class CarrinhoDTO {
	private Long id;
	private String cliente;
	private String codigo;
	private Double valor;
	private List<String> produtos = new ArrayList<>();
	

	public CarrinhoDTO(Carrinho carrinho) {
		this.id = carrinho.getId();
		this.cliente = carrinho.getCliente().getNome();
		this.codigo = carrinho.getCodigo();
		
		this.valor = carrinho.getValorTotal();

		for (CarrinhoProduto p : carrinho.getProdutos()) {
			produtos.add(p.getProduto().getNome());
		}
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}

}
