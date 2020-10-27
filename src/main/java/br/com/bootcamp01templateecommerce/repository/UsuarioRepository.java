package br.com.bootcamp01templateecommerce.repository;

import java.util.Optional;

import javax.validation.constraints.Email;

import br.com.bootcamp01templateecommerce.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(@Email String email);
}