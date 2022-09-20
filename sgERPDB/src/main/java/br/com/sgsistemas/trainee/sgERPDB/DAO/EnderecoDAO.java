package br.com.sgsistemas.trainee.sgERPDB.DAO;

import br.com.sgsistemas.trainee.sgERPDB.model.Cidade;
import br.com.sgsistemas.trainee.sgERPDB.model.Endereco;
import br.com.sgsistemas.trainee.sgERPDB.model.UF;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDAO {

    private EntityManager entityManager;

    public EnderecoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarEndereco(Endereco endereco) {
        entityManager.persist(endereco);
    }

    public void atulizarEndereco(Endereco endereco) {
        this.entityManager.merge(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        endereco = entityManager.merge(endereco);
        this.entityManager.remove(endereco);
    }


    public Endereco buscarEndereco (Integer id) {
        return entityManager.find(Endereco.class, id);
    }

    public List<Endereco> listarEndereco() {
        return entityManager.createQuery("SELECT ende FROM Endereco ende", Endereco.class).getResultList();
    }

    public String buscarLogradouroEnderecoPorId(Integer id) {
        return entityManager.createQuery("SELECT ende.logradouro FROM Endereco ende WHERE ende.id = :id", String.class).setParameter("id", id).getSingleResult();
    }

    public List<Endereco> buscarPorCidade(Integer id) {
        return entityManager.createQuery("SELECT ende FROM Endereco ende WHERE ende.cidade.id = :id", Endereco.class).setParameter("id", id).getResultList();
    }

}
