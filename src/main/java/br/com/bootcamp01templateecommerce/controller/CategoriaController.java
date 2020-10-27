package br.com.bootcamp01templateecommerce.controller;

import br.com.bootcamp01templateecommerce.dto.CategoriaDTO;
import br.com.bootcamp01templateecommerce.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody @Valid CategoriaDTO request) {
        return ResponseEntity.ok(categoriaService.create(request));
    }
}
