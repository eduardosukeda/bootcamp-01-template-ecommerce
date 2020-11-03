package br.com.bootcamp01templateecommerce.service;


import br.com.bootcamp01templateecommerce.dto.OpiniaoDTO;
import br.com.bootcamp01templateecommerce.security.model.UsuarioLogado;

public interface OpiniaoService {

    OpiniaoDTO create(OpiniaoDTO opiniaoDTO, Long produtoId, UsuarioLogado usuarioLogado);
}
