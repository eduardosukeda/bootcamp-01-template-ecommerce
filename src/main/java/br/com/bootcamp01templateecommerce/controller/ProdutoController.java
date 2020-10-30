package br.com.bootcamp01templateecommerce.controller;

import br.com.bootcamp01templateecommerce.dto.ImagemDTO;
import br.com.bootcamp01templateecommerce.dto.ProdutoDTO;
import br.com.bootcamp01templateecommerce.service.ProdutoService;
import br.com.bootcamp01templateecommerce.service.UsuarioService;
import br.com.bootcamp01templateecommerce.validator.ProibeCaracteristicaComNomeIgualValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService, UsuarioService usuarioService) {
        this.produtoService = produtoService;
    }

    @InitBinder(value = "produtoDTO")
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ProibeCaracteristicaComNomeIgualValidator());
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody @Valid ProdutoDTO request) {
        return ResponseEntity.ok(produtoService.create(request));
    }

    @PostMapping(value = "/{id}/imagens")
    public ResponseEntity<String> addImages(@PathVariable("id") Long id, @Valid ImagemDTO request) {
        return ResponseEntity.ok(produtoService.addImages(id, request));
    }
}