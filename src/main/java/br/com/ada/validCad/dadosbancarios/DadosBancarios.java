package br.com.ada.validCad.dadosbancarios;

import lombok.Data;

import javax.persistence.*;

import br.com.ada.validCad.chavepix.ChavePix;

@Entity
@Data
public class DadosBancarios {
    @Id
    @GeneratedValue
    private Long id;
    private String numeroConta;
    private int digitoConta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chave_id", referencedColumnName = "id")
    private ChavePix chavePix;
}
