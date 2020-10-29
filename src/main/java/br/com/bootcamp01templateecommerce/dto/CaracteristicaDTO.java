package br.com.bootcamp01templateecommerce.dto;

import br.com.bootcamp01templateecommerce.entity.CaracteristicaProduto;
import br.com.bootcamp01templateecommerce.entity.Produto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CaracteristicaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    public CaracteristicaDTO(@NotBlank String nome,
                             @NotBlank String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "CaracteristicaDTO [nome=" + nome + ", descricao="
                + descricao + "]";
    }

    public CaracteristicaProduto toModel(@NotNull @Valid Produto produto) {
        return new CaracteristicaProduto(nome, descricao, produto);
    }
}
