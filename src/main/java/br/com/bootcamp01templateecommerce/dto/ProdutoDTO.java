package br.com.bootcamp01templateecommerce.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.bootcamp01templateecommerce.annotation.ExistsId;
import br.com.bootcamp01templateecommerce.annotation.UniqueValue;
import br.com.bootcamp01templateecommerce.entity.Categoria;
import br.com.bootcamp01templateecommerce.entity.Produto;
import br.com.bootcamp01templateecommerce.entity.Usuario;
import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.Length;

public class ProdutoDTO {

    @NotBlank
    @UniqueValue(domainClass = Produto.class, fieldName = "nome")
    private String nome;

    @Positive
    @NotNull
    private Integer quantidade;

    @NotBlank
    @Length(max = 1000)
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @Size(min = 3)
    @Valid
    private List<CaracteristicaDTO> caracteristicas = new ArrayList<>();

    public ProdutoDTO(@NotBlank String nome, @Positive int quantidade,
                      @NotBlank @Length(max = 1000) String descricao,
                      @NotNull @Positive BigDecimal valor, @NotNull Long idCategoria,
                      List<CaracteristicaDTO> caracteristicas) {
        super();
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valor = valor;
        this.idCategoria = idCategoria;
        this.caracteristicas.addAll(caracteristicas);
    }

    public List<CaracteristicaDTO> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(
            List<CaracteristicaDTO> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "ProdutoDTO [nome=" + nome + ", quantidade=" + quantidade
                + ", descricao=" + descricao + ", valor=" + valor
                + ", idCategoria=" + idCategoria + ", caracteristicas="
                + caracteristicas + "]";
    }

    public Produto toModel(Usuario dono, Categoria categoria) {
        return new Produto(nome, quantidade, descricao, valor, categoria, dono,
                caracteristicas);
    }

    public Set<String> buscaCaracteristicasIguais() {
        HashSet<String> nomesIguais = new HashSet<>();
        HashSet<String> resultados = new HashSet<>();
        for (CaracteristicaDTO caracteristica : caracteristicas) {
            String nome = caracteristica.getNome();
            if (!nomesIguais.add(nome)) {
                resultados.add(nome);
            }
        }
        return resultados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
