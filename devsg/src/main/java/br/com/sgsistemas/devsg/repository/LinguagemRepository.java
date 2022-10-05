package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Linguagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguagemRepository extends JpaRepository<Linguagem, Integer> {
}
