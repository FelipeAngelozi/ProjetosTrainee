package br.com.sgsistemas.trainee.sgERPDB.DAO;

import br.com.sgsistemas.trainee.sgERPDB.model.Cliente;
import br.com.sgsistemas.trainee.sgERPDB.model.Endereco;
import br.com.sgsistemas.trainee.sgERPDB.model.UF;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }

    public void atulizarCliente(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public void removerCliente(Cliente cliente) {
        cliente = entityManager.merge(cliente);
        this.entityManager.remove(cliente);
    }

    public Cliente buscarCliente (Integer id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> listarCliente() {
        return entityManager.createQuery("SELECT cli FROM Cliente cli", Cliente.class).getResultList();
    }

    public String buscarNomeClientePorId(Integer id) {
        return entityManager.createQuery("SELECT cli.nome FROM Cliente cli WHERE cli.id = :id", String.class).setParameter("id", id).getSingleResult();
    }

    public List<Cliente> buscarPorEndereco(Integer id) {
        return entityManager.createQuery("SELECT cli FROM Cliente cli WHERE cli.endereco.id = :id", Cliente.class).setParameter("id", id).getResultList();
    }


}

