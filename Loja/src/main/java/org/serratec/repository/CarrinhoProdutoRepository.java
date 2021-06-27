package org.serratec.repository;

import org.serratec.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoProdutoRepository extends JpaRepository<Carrinho, Long> {

}
