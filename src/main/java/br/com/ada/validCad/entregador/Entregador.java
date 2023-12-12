package br.com.ada.validCad.entregador;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.ada.validCad.dadosbancarios.DadosBancarios;
import br.com.ada.validCad.documento.Documento;
import br.com.ada.validCad.endereco.Endereco;
import br.com.ada.validCad.veiculo.Veiculo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Entregador {
    @Id
    private Long id;
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    private String email;
    private String rg;
    private String tamanhoCamisa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dadosBancarios_id", referencedColumnName = "id")
    private DadosBancarios dadosBancarios;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documento documento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private Veiculo veiculo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;


}
