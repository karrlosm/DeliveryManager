package DAO;

import Models.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;

import java.util.List;

public class CRUDPedidoDAO {
    private EntityManager entityManager;

    private static CRUDPedidoDAO crudPedido;
    public static CRUDPedidoDAO getInstance(){
        if(crudPedido == null){
            crudPedido = new CRUDPedidoDAO();
        }
        return crudPedido;
    }


    private CRUDPedidoDAO() {
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

    public void create(Pedido pedido) throws Exception {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(pedido);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Houve um problema");
        }
    }
    public List<Pedido> read(long id) throws Exception {
        try{
            entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery(
"SELECT pedido from Pedido pedido where userpedido = "+id
            );
            List<Pedido> pedidos = consulta.getResultList();
            entityManager.getTransaction().commit();
            return  pedidos;
        }catch (Exception e){
            throw new Exception("Houve um problema");
        }
    }
    public void delete(long id) throws Exception {
        //TODO Operation delete of the system
    	try {
    		entityManager.getTransaction().begin();
        	Pedido pedido = entityManager.find(Pedido.class, id);
        	entityManager.remove(pedido);
        	entityManager.getTransaction().commit();

    	} catch (Exception e) {
            throw new Exception("Houve um problema");

    	}

    }
    public void update(Pedido pedido){
    	//TODO Operation update of the system
    	EntityTransaction transaction = entityManager.getTransaction();
    	transaction.begin();
    	Pedido pedidoatt = pedido;
    	try {
    		pedidoatt = entityManager.merge(pedido);
    		transaction.commit();
    	} catch (Exception e) {
    		
    	}
        
    }

    public void closeConnectionOfDatabase(){

        entityManager.close();
    }
}
