package br.com.sgsistemas.trainee.loja.DAO;

import br.com.sgsistemas.trainee.loja.modelo.Clientes;
import br.com.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientesDAO {

    EntityManager entityManager = JPAUtil.getEntityManager();

    public ClientesDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarCliente(Clientes clientes) {
        this.entityManager.persist(clientes);
    }

    public void atualizarCliente(Clientes clientes) {
        this.entityManager.merge(clientes);
    }

    public void removerCliente(Clientes clientes) {
        clientes = this.entityManager.merge(clientes);
        this.entityManager.remove(clientes);
    }

    public void buscarCliente(Integer id) {
        this.entityManager.find(Clientes.class, id);
    }

    public List<Clientes> listarCliente() {
        return entityManager.createQuery("SELECT cli FROM Clientes cli", Clientes.class).getResultList();
    }

    public String buscarNomeClientePorId(Integer id) {
        return entityManager.createQuery("SELECT cli.nome FROM Clientes cli WHERE id = :id", String.class).setParameter("id", id).getSingleResult();
    }

}

