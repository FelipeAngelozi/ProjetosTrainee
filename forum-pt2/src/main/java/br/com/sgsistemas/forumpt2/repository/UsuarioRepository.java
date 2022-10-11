package br.com.sgsistemas.forumpt2.repository;

import br.com.sgsistemas.forumpt2.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail (String email);
}
