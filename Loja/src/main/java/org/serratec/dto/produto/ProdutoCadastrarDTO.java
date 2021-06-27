package org.serratec.dto.produto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.apache.tomcat.util.codec.binary.Base64;
import org.serratec.dto.categoria.CategoriaCadastroDTO;
import org.serratec.exceptions.ProdutoException;
import org.serratec.model.Categoria;
import org.serratec.model.Produto;
import org.serratec.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoCadastrarDTO {

	@NotEmpty
	private String codigo;

	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String descricao;
	
	private Double preco;
	
	private Integer estoque;
	private String imagem;
	private String url;
	private Long categoria_id;
	
	
	public Produto toProduto(CategoriaRepository categoriaRepository) throws ProdutoException {
		
		Produto produto = new Produto();
		
		produto.setCodigo(this.codigo);
		produto.setNome(this.nome);
		produto.setDescricao(this.descricao);
		produto.setPreco(this.preco);
		produto.setEstoque(this.estoque);
		produto.setDataCadastro(LocalDate.now());
		produto.setUrl(this.url);
		Optional<Categoria> categoriaProduto = categoriaRepository.findById(this.getCategoria_id());
		
		if(categoriaProduto.isEmpty())
			throw new ProdutoException("categoria invalida ou inexistente");			
			
		produto.setCategoria(categoriaProduto.get());
		
		
//		if (this.imagem != null) {
//			byte[] img = Base64.decodeBase64(this.imagem);
//			String nomeArquivo = "E:\\Documentos\\Spring\\RestfulAPI\\Imagens\\prod_" + produto.getCodigo() + ".jpg";
//			
//			try {
//				OutputStream out = new FileOutputStream(new File(nomeArquivo));
//				out.write(img);
//				out.close();
//				produto.setImagem(nomeArquivo);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		return produto;
	}
	
	
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
	public Long getCategoria_id() {
		return categoria_id;
	}
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
