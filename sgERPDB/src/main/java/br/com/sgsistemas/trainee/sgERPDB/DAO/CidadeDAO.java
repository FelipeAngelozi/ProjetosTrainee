package br.com.sgsistemas.trainee.sgERPDB.DAO;

import br.com.sgsistemas.trainee.sgERPDB.model.Cidade;
import br.com.sgsistemas.trainee.sgERPDB.model.UF;

import javax.persistence.EntityManager;
import java.util.List;

public class CidadeDAO {
    private EntityManager entityManager;

    public CidadeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarCidade(Cidade cidade) {
        entityManager.persist(cidade);
    }

    public void atulizarCidade(Cidade cidade) {
        this.entityManager.merge(cidade);
    }

    public void removerCidade(Cidade cidade) {
        cidade = entityManager.merge(cidade);
        this.entityManager.remove(cidade);
    }

    public Cidade buscarCidade (String codigo) {
        return entityManager.find(Cidade.class, codigo);
    }

    public List<Cidade> listarCidade() {
        return entityManager.createQuery("SELECT cid FROM Cidade cid", Cidade.class).getResultList();
    }

    public String buscarNomeCidadePorId(String codigo) {
        return entityManager.createQuery("SELECT cid.nome FROM Cidade cid WHERE cid.codigo = :codigo", String.class).setParameter("codigo", codigo).getSingleResult();
    }

    public List<Cidade> buscarPorEstado(String sigla) {
        return  entityManager.createQuery("SELECT cid FROM Cidade cid WHERE cid.uf.sigla = :sigla", Cidade.class).setParameter("sigla", sigla).getResultList();
    }
}
