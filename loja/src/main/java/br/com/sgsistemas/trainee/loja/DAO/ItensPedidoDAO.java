package br.com.sgsistemas.trainee.loja.DAO;

import br.com.sgsistemas.trainee.loja.modelo.ItensPedido;
import br.com.sgsistemas.trainee.loja.modelo.Pedidos;
import br.com.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ItensPedidoDAO {

    EntityManager entityManager = JPAUtil.getEntityManager();

    public ItensPedidoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void adicionarItemPedido(ItensPedido itensPedido) {
        this.entityManager.persist(itensPedido);
    }

    public void atualizarItemPedido(ItensPedido itensPedido){
        this.entityManager.merge(itensPedido);
    }

    public void removerItemPedido(ItensPedido itensPedido) {
        itensPedido = this.entityManager.merge(itensPedido);
        this.entityManager.remove(itensPedido);
    }

    public ItensPedido buscarItemPedidoPorID (Integer id) {
        return this.entityManager.find(ItensPedido.class, id);
    }

    public List<ItensPedido> listarItensPedido () {
        return this.entityManager.createQuery("SELECT itpe FROM ItensPedido", ItensPedido.class).getResultList();
    }
}

