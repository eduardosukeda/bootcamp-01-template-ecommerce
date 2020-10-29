package br.com.bootcamp01templateecommerce.repository;

import br.com.bootcamp01templateecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
