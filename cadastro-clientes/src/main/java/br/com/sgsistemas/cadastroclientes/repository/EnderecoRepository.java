package br.com.sgsistemas.cadastroclientes.repository;

import br.com.sgsistemas.cadastroclientes.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, Integer> {
}
