package br.com.bootcamp01templateecommerce.service.impl;

import br.com.bootcamp01templateecommerce.dto.ProdutoDTO;
import br.com.bootcamp01templateecommerce.entity.Categoria;
import br.com.bootcamp01templateecommerce.entity.Produto;
import br.com.bootcamp01templateecommerce.entity.Usuario;
import br.com.bootcamp01templateecommerce.repository.CategoriaRepository;
import br.com.bootcamp01templateecommerce.repository.ProdutoRepository;
import br.com.bootcamp01templateecommerce.repository.UsuarioRepository;
import br.com.bootcamp01templateecommerce.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;
    private UsuarioRepository usuarioRepository;
    private CategoriaRepository categoriaRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ProdutoDTO create(ProdutoDTO produtoDTO) {
        Usuario dono = usuarioRepository.findByEmail("eduardosukeda@live.com").get();
        Categoria categoria = categoriaRepository.getOne(produtoDTO.getIdCategoria());
        Produto produto = produtoDTO.toModel(dono, categoria);

        produtoRepository.save(produto);

        return produtoDTO;
    }
}
