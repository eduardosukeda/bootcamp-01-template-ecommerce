package br.com.bootcamp01templateecommerce.service.impl;

import br.com.bootcamp01templateecommerce.dto.UsuarioDTO;
import br.com.bootcamp01templateecommerce.entity.Usuario;
import br.com.bootcamp01templateecommerce.repository.UsuarioRepository;
import br.com.bootcamp01templateecommerce.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(usuarioDTO.toUsuario());
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        return new UsuarioDTO(Optional.ofNullable(getUsuarioByEmail(email)));
    }

    private Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
