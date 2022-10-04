package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
