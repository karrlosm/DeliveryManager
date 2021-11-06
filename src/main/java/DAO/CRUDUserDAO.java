package DAO;

import Models.Pedido;
import Models.UserPedido;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;
import java.util.List;

public class CRUDUserDAO {
    private EntityManager entityManager;

    private static CRUDUserDAO crudPedido;
    public static CRUDUserDAO getInstance(){
        if(crudPedido == null){
            crudPedido = new CRUDUserDAO();
        }
        return crudPedido;
    }


    private CRUDUserDAO() {
        try{
            EntityManagerProject entityManagerProject = EntityManagerProject.getInstance();
            this.entityManager = entityManagerProject.getEntityManager();
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    null,
                    "Houve um problema",
                    "Problema",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void create(UserPedido user) throws Exception {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Houve um problema");
        }
    }

    public UserPedido getByEmail(String email) throws Exception {
        try{
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM UserPedido UserPedido WHERE UserPedido.email ='"+email+"'");
            List<UserPedido> user = query.getResultList();
            entityManager.getTransaction().commit();
            return  user.get(0);
        }catch (Exception e){
            throw new Exception("Houve um problema");
        }
    }

    public void closeConnectionOfDatabase(){

        entityManager.close();
    }
}
