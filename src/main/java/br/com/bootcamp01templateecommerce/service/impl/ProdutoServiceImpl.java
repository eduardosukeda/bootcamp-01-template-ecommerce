package br.com.bootcamp01templateecommerce.service.impl;

import br.com.bootcamp01templateecommerce.dto.ImagemDTO;
import br.com.bootcamp01templateecommerce.dto.ProdutoDTO;
import br.com.bootcamp01templateecommerce.entity.Categoria;
import br.com.bootcamp01templateecommerce.entity.Produto;
import br.com.bootcamp01templateecommerce.entity.Usuario;
import br.com.bootcamp01templateecommerce.repository.CategoriaRepository;
import br.com.bootcamp01templateecommerce.repository.ProdutoRepository;
import br.com.bootcamp01templateecommerce.repository.UsuarioRepository;
import br.com.bootcamp01templateecommerce.service.ProdutoService;
import br.com.bootcamp01templateecommerce.service.UploaderService;
import br.com.bootcamp01templateecommerce.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;
    private UsuarioRepository usuarioRepository;
    private CategoriaRepository categoriaRepository;

    private UploaderService uploaderService;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository, CategoriaRepository categoriaRepository, UploaderService uploaderService) {
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
        this.uploaderService = uploaderService;
    }

    @Override
    public ProdutoDTO create(ProdutoDTO produtoDTO) {
        Usuario dono = usuarioRepository.findByEmail("eduardosukeda@live.com").get();
        Categoria categoria = categoriaRepository.getOne(produtoDTO.getIdCategoria());
        Produto produto = produtoDTO.toModel(dono, categoria);

        produtoRepository.save(produto);

        return produtoDTO;
    }

    @Override
    public String addImages(Long id, ImagemDTO request) {

        Optional<Usuario> dono = usuarioRepository.findByEmail("eduardosukeda@live.com");
        Produto produto = produtoRepository.getOne(id);

        if(!produto.pertenceAoUsuario(dono.get())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Set<String> links = uploaderService.submit(request.getImagens());
        produto.associaImagens(links);

        produtoRepository.save(produto);

        return produto.toString();
    }
}
