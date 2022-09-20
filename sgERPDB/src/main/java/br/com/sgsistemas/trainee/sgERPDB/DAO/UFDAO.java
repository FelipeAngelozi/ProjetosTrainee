package br.com.sgsistemas.trainee.sgERPDB.DAO;

import br.com.sgsistemas.trainee.sgERPDB.model.UF;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class UFDAO {

    private EntityManager entityManager;

    public UFDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarUF(UF uf) {
        this.entityManager.persist(uf);
    }

    public void atulizarUF(UF uf) {
        this.entityManager.merge(uf);
    }

    public void removerUF(UF uf) {
        uf = entityManager.merge(uf);
        this.entityManager.remove(uf);
    }

    public UF buscarUF (String sigla) {
        return entityManager.find(UF.class, sigla);
    }

    public List<UF> listarUF() {
        return entityManager.createQuery("SELECT u FROM UF u", UF.class).getResultList();
    }

    public String buscarPorDescricaoUF(String sigla) {
        return entityManager.createQuery("SELECT u.descricao FROM UF u WHERE u.sigla = :sigla", String.class).setParameter("sigla", sigla).getSingleResult();
    }


}
