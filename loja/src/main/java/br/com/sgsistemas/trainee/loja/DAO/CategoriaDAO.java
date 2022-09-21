package br.com.sgsistemas.trainee.loja.DAO;

import br.com.sgsistemas.trainee.loja.modelo.Categoria;
import br.com.sgsistemas.trainee.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    EntityManager entityManager = JPAUtil.getEntityManager();

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarCategoria(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public void atualizarCategoria(Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void removerCategoria(Categoria categoria) {
        categoria = entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }

    public Categoria buscarCategoriaPorId(Integer id) { return
        this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> listarCategoria() {
        return this.entityManager.createQuery("SELECT cat from Categoria cat", Categoria.class).getResultList();
    }

    public String listarCategoriaNomes(Integer id) {
        return this.entityManager.createQuery("SELECT cat.nome from Categoria cat WHERE id = :id", String.class).setParameter("id", id).getSingleResult();
    }

}
