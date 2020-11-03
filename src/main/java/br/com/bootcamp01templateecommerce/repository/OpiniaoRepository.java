package br.com.bootcamp01templateecommerce.repository;

import br.com.bootcamp01templateecommerce.entity.Opiniao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpiniaoRepository extends JpaRepository<Opiniao, Long> {
}
