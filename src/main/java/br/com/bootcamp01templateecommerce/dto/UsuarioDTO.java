package br.com.bootcamp01templateecommerce.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.bootcamp01templateecommerce.entity.Usuario;
import org.hibernate.validator.constraints.Length;

public class UsuarioDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 6)
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(@Email @NotBlank String email, @NotBlank @Length(min = 6) String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario toUsuario() {
        return new Usuario(email, new SenhaLimpaDTO(senha));
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
}