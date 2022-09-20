package br.com.sgsistemas.trainee.sgERPDB.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("sgERPDB");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
