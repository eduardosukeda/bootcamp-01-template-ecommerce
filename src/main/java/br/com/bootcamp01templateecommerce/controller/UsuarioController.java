package br.com.bootcamp01templateecommerce.controller;

import br.com.bootcamp01templateecommerce.dto.UsuarioDTO;
import br.com.bootcamp01templateecommerce.service.UsuarioService;
import br.com.bootcamp01templateecommerce.validator.ProibeUsuarioComEmailDuplicadoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    private ProibeUsuarioComEmailDuplicadoValidator proibeUsuarioComEmailDuplicadoValidator;

    public UsuarioController(UsuarioService usuarioService, ProibeUsuarioComEmailDuplicadoValidator proibeUsuarioComEmailDuplicadoValidator) {
        this.usuarioService = usuarioService;
        this.proibeUsuarioComEmailDuplicadoValidator = proibeUsuarioComEmailDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeUsuarioComEmailDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody @Valid UsuarioDTO request) {
        return ResponseEntity.ok(usuarioService.create(request));
    }
}
