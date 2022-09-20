package br.com.sgsistemas.trainee.loja.DAO;

import br.com.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class ItensPedidoDAO {

    EntityManager entityManager = JPAUtil.getEntityManager();

    public ItensPedidoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
