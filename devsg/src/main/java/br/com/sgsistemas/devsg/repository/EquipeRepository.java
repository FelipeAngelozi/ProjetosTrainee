package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
}
