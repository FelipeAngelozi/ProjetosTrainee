package br.com.sgsistemas.devsg.repository;

import br.com.sgsistemas.devsg.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
