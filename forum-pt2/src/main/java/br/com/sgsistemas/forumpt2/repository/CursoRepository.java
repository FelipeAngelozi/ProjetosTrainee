package br.com.sgsistemas.forumpt2.repository;

import br.com.sgsistemas.forumpt2.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
