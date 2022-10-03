package br.com.sgsistemas.cadastroclientes.repository;

import br.com.sgsistemas.cadastroclientes.model.Cliente;
import br.com.sgsistemas.cadastroclientes.model.ClienteDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {

    @Query(value = "SELECT c.nome, c.data_nascimento from cliente c", nativeQuery = true)
    List<ClienteDTO> findClienteNomeENasc();
}
