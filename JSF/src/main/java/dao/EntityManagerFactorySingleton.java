package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by win10 on 29.10.2016.
 */
public class EntityManagerFactorySingleton {
    private static EntityManagerFactory instance;

    public static EntityManagerFactory getInstance() {
        if (instance == null) {
            instance = Persistence.createEntityManagerFactory("movies");
        }
        return instance;
    }

    private EntityManagerFactorySingleton() {}
}
