package br.com.sgsistemas.trainee.loja.DAO;

import javax.persistence.EntityManager;

import br.com.sgsistemas.trainee.loja.modelo.Produto;
import br.com.sgsistemas.trainee.loja.util.JPAUtil;

import java.util.List;

public class ProdutoDAO {

    EntityManager entityManager = JPAUtil.getEntityManager();

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarProduto(Produto produto){
        this.entityManager.persist(produto);
    }

    public void atualizarProduto(Produto produto){
        this.entityManager.merge(produto);
    }

    public void removerProduto (Produto produto) {
        produto = this.entityManager.merge(produto);
        this.entityManager.remove(produto);
    }

    public Produto buscarProduto (Integer id) {
        return this.entityManager.find(Produto.class, id);
    }

    public List<Produto> listarProduto() {
        return entityManager.createQuery("SELECT prod FROM Produto prod", Produto.class).getResultList();
    }

    public String buscarNomeProdutoPorId(Integer id) {
        return entityManager.createQuery("SELECT prod.nome FROM Produto prod WHERE prod.id = :id", String.class).setParameter("id", id).getSingleResult();
    }

    public List<Produto> buscarPorCategoria(Integer id) {
        return  entityManager.createQuery("SELECT prod FROM Produto prod WHERE prod.categoria.id = :id", Produto.class).setParameter("id", id).getResultList();
    }
}
