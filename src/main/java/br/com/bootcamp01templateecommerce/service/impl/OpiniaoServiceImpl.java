package br.com.bootcamp01templateecommerce.service.impl;

import br.com.bootcamp01templateecommerce.dto.OpiniaoDTO;
import br.com.bootcamp01templateecommerce.entity.Opiniao;
import br.com.bootcamp01templateecommerce.entity.Produto;
import br.com.bootcamp01templateecommerce.repository.OpiniaoRepository;
import br.com.bootcamp01templateecommerce.repository.ProdutoRepository;
import br.com.bootcamp01templateecommerce.security.model.UsuarioLogado;
import br.com.bootcamp01templateecommerce.service.OpiniaoService;
import org.springframework.stereotype.Service;

@Service
public class OpiniaoServiceImpl implements OpiniaoService {

    private OpiniaoRepository opiniaoRepository;
    private ProdutoRepository produtoRepository;

    public OpiniaoServiceImpl(OpiniaoRepository opiniaoRepository, ProdutoRepository produtoRepository) {
        this.opiniaoRepository = opiniaoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public OpiniaoDTO create(OpiniaoDTO opiniaoDTO, Long produtoId, UsuarioLogado usuarioLogado) {

        Produto produto = produtoRepository.getOne(produtoId);
        Opiniao opiniao = opiniaoRepository.save(opiniaoDTO.toModel(produto, usuarioLogado.get()));

        return new OpiniaoDTO(opiniao);
    }
}
