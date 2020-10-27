package br.com.bootcamp01templateecommerce.entity;

import br.com.bootcamp01templateecommerce.dto.SenhaLimpaDTO;
import br.com.bootcamp01templateecommerce.dto.UsuarioDTO;
import io.jsonwebtoken.lang.Assert;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 6)
    private String senha;

    @PastOrPresent
    private LocalDateTime instanteCriacao;

    public Usuario() {
    }

    public Usuario(Long id, @Email @NotBlank String email, @NotBlank @Length(min = 6) String senha, @PastOrPresent LocalDateTime instanteCriacao) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.instanteCriacao = instanteCriacao;
    }

    public Usuario(@Email @NotBlank String email,
                   @Valid @NotNull SenhaLimpaDTO senhaLimpa) {
        Assert.isTrue(StringUtils.hasLength(email), "email não pode ser em branco");
        Assert.notNull(senhaLimpa, "o objeto do tipo senha limpa nao pode ser nulo");

        this.email = email;
        this.senha = senhaLimpa.hash();
        this.instanteCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public void setInstanteCriacao(LocalDateTime instanteCriacao) {
        this.instanteCriacao = instanteCriacao;
    }
}
