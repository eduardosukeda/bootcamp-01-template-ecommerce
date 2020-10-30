package br.com.bootcamp01templateecommerce.service;

import br.com.bootcamp01templateecommerce.dto.ImagemDTO;
import br.com.bootcamp01templateecommerce.dto.ProdutoDTO;

public interface ProdutoService {

    ProdutoDTO create(ProdutoDTO produtoDTO);

    String addImages(Long id, ImagemDTO request);
}
