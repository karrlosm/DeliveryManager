package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProject {

    private static EntityManagerProject crudPedido;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public static EntityManagerProject getInstance(){
        if(crudPedido == null){
            crudPedido = new EntityManagerProject();
        }
        return crudPedido;
    }

    private EntityManagerProject(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory(
                "CRUD_PROJECT_BD");
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }
}
