package br.com.ada.validCad.entregador;

import org.springframework.stereotype.Service;

import br.com.ada.validCad.commonsvalidation.Validador;
import br.com.ada.validCad.documento.DocumentoService;
import br.com.ada.validCad.exceptions.CnhInvalidoException;
import br.com.ada.validCad.exceptions.CnhVencidaException;
import br.com.ada.validCad.exceptions.CpfInvalidoException;
import br.com.ada.validCad.exceptions.RgInvalidoException;
import br.com.ada.validCad.exceptions.UsuarioInvalidoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntregadorService {

    private final EntregadorRepository entregadorRepository;

    private Validador validator = new Validador();

    private final Service documentoService = new Service();

    public Entregador salvar (Entregador entregador) {
        if (entregador == null) {
            throw new UsuarioInvalidoException();
        }
        var isCpfValido = validator.validaCpf(entregador.getCpf());
        if (!isCpfValido) {
            throw new CpfInvalidoException();
        }

        var isRGValido = validator.validaRG(entregador.getRg());
        if (!isRGValido) {
            throw new RgInvalidoException();
        }

        System.out.println(entregador.getDocumento());

        try {
            documentoService.validaDocumento(entregador.getDocumento());
        } catch (CnhInvalidoException e) {
            throw new CnhInvalidoException();
        } catch (CnhVencidaException e1){
            throw new CnhVencidaException();
        }

        return entregadorRepository.save(entregador);

    }
}
