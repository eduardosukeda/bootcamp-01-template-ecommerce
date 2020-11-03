package br.com.bootcamp01templateecommerce.repository;

import br.com.bootcamp01templateecommerce.entity.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
