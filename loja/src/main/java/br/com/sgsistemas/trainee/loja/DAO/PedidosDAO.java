package br.com.sgsistemas.trainee.loja.DAO;

import br.com.sgsistemas.trainee.loja.modelo.Pedidos;
import br.com.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidosDAO {

    EntityManager entityManager = JPAUtil.getEntityManager();

    public PedidosDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarPedidos(Pedidos pedidos) {
        this.entityManager.persist(pedidos);
    }

    public void atualizarPedidos(Pedidos pedidos) {
        this.entityManager.merge(pedidos);
    }

    public void removerPedidos(Pedidos pedidos) {
        pedidos = entityManager.merge(pedidos);
        this.entityManager.remove(pedidos);
    }

    public Pedidos buscarPedidoPorID(Integer id) {
        return entityManager.find(Pedidos.class, id);
    }

    public List<Pedidos> listarPedidos() {
        return entityManager.createQuery("SELECT ped FROM Pedidos ped", Pedidos.class).getResultList();
    }
}
