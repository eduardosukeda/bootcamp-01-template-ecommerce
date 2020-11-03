package br.com.bootcamp01templateecommerce.controller;

import br.com.bootcamp01templateecommerce.dto.OpiniaoDTO;
import br.com.bootcamp01templateecommerce.dto.ProdutoDTO;
import br.com.bootcamp01templateecommerce.security.model.UsuarioLogado;
import br.com.bootcamp01templateecommerce.service.OpiniaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/opinioes")
public class OpiniaoController {

    private OpiniaoService opiniaoService;

    public OpiniaoController(OpiniaoService opiniaoService) {
        this.opiniaoService = opiniaoService;
    }

    @PostMapping
    public ResponseEntity<OpiniaoDTO> create(@RequestBody @Valid OpiniaoDTO request,
                                             @PathVariable("produtoId") Long produtoId, @AuthenticationPrincipal UsuarioLogado usuarioLogado) {
        return ResponseEntity.ok(opiniaoService.create(request, produtoId, usuarioLogado));
    }
}
