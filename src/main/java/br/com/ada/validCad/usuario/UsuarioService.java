package br.com.ada.validCad.usuario;

import br.com.ada.validCad.commonsvalidation.Validador;
import br.com.ada.validCad.exceptions.CpfInvalidoException;
import br.com.ada.validCad.exceptions.UsuarioInvalidoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private Validador validator = new Validador();

    public Usuario salvar(Usuario usuario) {
        if (usuario == null) {
            throw new UsuarioInvalidoException();
        }
        var isCpfValido = validator.validaCpf(usuario.getCpf());
        if (!isCpfValido) {
            throw new CpfInvalidoException();
        }
        return usuarioRepository.save(usuario);
    }
}
