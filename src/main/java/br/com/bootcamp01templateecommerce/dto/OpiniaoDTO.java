package br.com.bootcamp01templateecommerce.dto;

import br.com.bootcamp01templateecommerce.entity.Opiniao;
import br.com.bootcamp01templateecommerce.entity.Produto;
import br.com.bootcamp01templateecommerce.entity.Usuario;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class OpiniaoDTO {

    @Min(1)
    @Max(5)
    private int nota;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String descricao;

    public OpiniaoDTO(@Min(1) @Max(5) int nota, @NotBlank String titulo,
                      @NotBlank @Size(max = 500) String descricao) {
        super();
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public OpiniaoDTO(Opiniao opiniao) {
        this.nota = opiniao.getNota();
        this.titulo = opiniao.getTitulo();
        this.descricao = opiniao.getDescricao();
    }

    public Opiniao toModel(@NotNull @Valid Produto produto, @NotNull @Valid Usuario consumidor) {
        return new Opiniao(nota, titulo, descricao, produto, consumidor);
    }

}
