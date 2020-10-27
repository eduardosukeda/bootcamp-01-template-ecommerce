package br.com.bootcamp01templateecommerce.service.impl;

import br.com.bootcamp01templateecommerce.dto.UsuarioDTO;
import br.com.bootcamp01templateecommerce.repository.UsuarioRepository;
import br.com.bootcamp01templateecommerce.service.UsuarioService;
import org.springframework.stereotype.Service;

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
}
