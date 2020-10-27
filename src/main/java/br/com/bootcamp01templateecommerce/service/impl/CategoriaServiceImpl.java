package br.com.bootcamp01templateecommerce.service.impl;

import br.com.bootcamp01templateecommerce.dto.CategoriaDTO;
import br.com.bootcamp01templateecommerce.entity.Categoria;
import br.com.bootcamp01templateecommerce.repository.CategoriaRepository;
import br.com.bootcamp01templateecommerce.service.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.save(categoriaDTO.toModel(categoriaRepository));
        return new CategoriaDTO(categoria);
    }
}
