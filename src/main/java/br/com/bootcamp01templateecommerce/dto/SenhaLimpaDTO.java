package br.com.bootcamp01templateecommerce.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

public class SenhaLimpaDTO {

    private String senha;

    public SenhaLimpaDTO(@NotBlank @Length(min = 6) String senha) {
        Assert.hasLength(senha, "senha nao pode ser em branco");
        Assert.isTrue(senha.length() >= 6, "senha tem que ter no mínimo 6 caracteres");

        this.senha = senha;
    }

    public String hash() {
        return new BCryptPasswordEncoder().encode(senha);
    }
}
	
	