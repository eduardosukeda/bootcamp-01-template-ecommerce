package br.com.bootcamp01templateecommerce.dto;

import br.com.bootcamp01templateecommerce.annotation.ExistsId;
import br.com.bootcamp01templateecommerce.annotation.UniqueValue;
import br.com.bootcamp01templateecommerce.entity.Categoria;
import br.com.bootcamp01templateecommerce.repository.CategoriaRepository;
import io.jsonwebtoken.lang.Assert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Optional;

public class CategoriaDTO {

    private Long id;

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Positive
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoriaMae;

    public CategoriaDTO() {
    }

    public CategoriaDTO(@NotBlank String nome, @Positive Long idCategoriaMae) {
        this.nome = nome;
        this.idCategoriaMae = idCategoriaMae;
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.idCategoriaMae = categoria.getCategoriaMae() == null ? 0 : categoria.getCategoriaMae().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdCategoriaMae() {
        return idCategoriaMae;
    }

    public void setIdCategoriaMae(Long idCategoriaMae) {
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria toModel(CategoriaRepository categoriaRepository) {
        Categoria categoria = new Categoria(nome);
        if (idCategoriaMae != null) {
            Optional<Categoria> categoriaMae = categoriaRepository.findById(idCategoriaMae);
            Assert.notNull(categoriaMae, "O id da categoria mae precisa ser válido");
            if (categoriaMae.isPresent()) {
                categoria.setCategoriaMae(categoriaMae.get());
            }
        }
        return categoria;
    }
}
