package br.com.bootcamp01templateecommerce.validator;

import java.util.Optional;

import br.com.bootcamp01templateecommerce.dto.UsuarioDTO;
import br.com.bootcamp01templateecommerce.entity.Usuario;
import br.com.bootcamp01templateecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeUsuarioComEmailDuplicadoValidator implements Validator {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        UsuarioDTO request = (UsuarioDTO) target;

        Optional<Usuario> possivelUsuario = usuarioRepository.findByEmail(request.getEmail());

        if (possivelUsuario.isPresent()) {
            errors.rejectValue("email", null, "ja existe este email no sistema");
        }
    }
}