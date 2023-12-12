package br.com.ada.validCad.chavepix;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ada.validCad.dadosbancarios.DadosBancarios;

public interface ChavePixRepository extends JpaRepository<DadosBancarios, Long> {
}
