package Controllers;

import javax.swing.JOptionPane;

import DAO.CRUDPedidoDAO;
import Models.Pedido;
import Views.HomeView;
import Views.InfoPedidoView;

public class ControllerInfoPedidoView {

    private static ControllerInfoPedidoView instance;
    private static InfoPedidoView infoPedidoView;
    private static boolean isAlterado =false;
    private ControllerInfoPedidoView(){

    }

    public static ControllerInfoPedidoView getInstance(InfoPedidoView infoPedido){
        if(instance == null){
            instance = new ControllerInfoPedidoView();
        }
        infoPedidoView = infoPedido;
        return instance;
    }
    //reuni�o
    public static void foiAlterado(){
        isAlterado = true;
    }
    public static void voltaEstado(){
        isAlterado = false;
    }
    
    private int messageDialog() {
    	int result = JOptionPane.showConfirmDialog(infoPedidoView.getJANELA(),
    			"Deseja continuar a operação?",
    			"Delivery Manager", JOptionPane.YES_NO_OPTION);
    	if (result == 1) {
    		JOptionPane.showMessageDialog(infoPedidoView.getJANELA(), "Operação cancelada.");
    	}
    	return result;
    }

    public void update(Pedido pedido){
        if(isAlterado){
        	try {
        		if (messageDialog() == 0) {
        			CRUDPedidoDAO crudPedidoDAO = CRUDPedidoDAO.getInstance();
            	    crudPedidoDAO.update(pedido);
            	    this.voltar();
        		}
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
    		
        }
    }
    
    public void delete(long id){
        CRUDPedidoDAO crudPedidoDAO = CRUDPedidoDAO.getInstance();
        try {
        	if (messageDialog() == 0) {
        	    crudPedidoDAO.delete(id);
        	    this.voltar();
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void voltar(){
        infoPedidoView.getJANELA().dispose();
        voltaEstado();
        new HomeView(infoPedidoView.getUser());

    }

}
