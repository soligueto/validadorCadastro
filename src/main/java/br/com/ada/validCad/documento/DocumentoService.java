package br.com.ada.validCad.documento;

import org.springframework.stereotype.Service;

import br.com.ada.validCad.exceptions.CnhInvalidoException;
import br.com.ada.validCad.exceptions.CnhVencidaException;

import java.util.Date;

@DocumentoService
public class DocumentoService {

    public void validaDocumento(Documento documento) throws CnhInvalidoException, CnhVencidaException   {
        var documentoNovo = documento.getNumero().toString().replaceAll("ˆ0-9","");
        if(documentoNovo.length() == 11) {
            Date today = new Date();
            if (documento.getDataVencimento().before(today)){
                throw new CnhVencidaException();
            }
        } else {
            throw new CnhInvalidoException();
        }
    }

    public boolean validaDocumentoValidade(Documento documento) {
        Date today = new Date();
        return (documento.getDataVencimento().before(today));
    }

}
